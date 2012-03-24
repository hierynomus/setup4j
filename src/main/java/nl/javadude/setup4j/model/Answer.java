package nl.javadude.setup4j.model;

import nl.javadude.setup4j.Setting;
import nl.javadude.setup4j.utils.Reflection;

import java.lang.reflect.Field;

import static java.lang.String.format;

public abstract class Answer<T> {
	protected Field field;
	private T defaultAnswer;

	protected Answer(Field field) {
		this.field = field;
		getDefault(field);
	}

	private void getDefault(Field field) {
		String s = field.getAnnotation(Setting.class).defaultValue();
		
		if (s == null || s.trim().isEmpty()) {
			defaultAnswer = defaultAnswer();
		} else {
			try {
				defaultAnswer = convertToCorrectType(s);
			} catch (AnswerFailedException afe) {
				throw new IllegalStateException(format("Could not convert default answer [%s] to required type for field [%s]", s, field), afe);
			}
		}
	}

	public void answer(String answer, Object instance) throws AnswerFailedException {
		T theAnswer = defaultAnswer;
		if (answer != null && !answer.trim().isEmpty()) {
			theAnswer = convertToCorrectType(answer);
		}

		Reflection.set(field, instance, theAnswer);
	}
	
	
	protected abstract T defaultAnswer();
	protected abstract T convertToCorrectType(String answer) throws AnswerFailedException;
}
