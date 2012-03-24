package nl.javadude.setup4j.model;

import java.lang.reflect.Field;

public class IntegerAnswer extends Answer<Integer> {
	public IntegerAnswer(Field field) {
		super(field);
	}

	@Override
	protected Integer defaultAnswer() {
		return 0;
	}

	@Override
	protected Integer convertToCorrectType(String answer) throws AnswerFailedException {
		try {
			return Integer.valueOf(answer);
		} catch (NumberFormatException nfe) {
			throw new AnswerFailedException(nfe);
		}
	}
}
