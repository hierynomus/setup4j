package nl.javadude.setup4j.model;

import java.lang.reflect.Field;

public class StringAnswer extends Answer {
	public StringAnswer(Field field) {
		super(field);
	}

	@Override
	protected Object defaultAnswer() {
		return "";
	}

	@Override
	protected Object convertToCorrectType(String answer) {
		return answer;
	}

}
