package nl.javadude.setup4j.model;

import nl.javadude.setup4j.Setting;

import java.lang.reflect.Field;

public class Question {

    private String question;
    private String defaultValue;
	private Field field;

	public Question(Field field, Setting annotation) {
		this.field = field;
		this.question = annotation.question();
        this.defaultValue = annotation.defaultValue();
    }

    public String getQuestion() {
        return question;
    }

    public String getDefaultValue() {
        return defaultValue;
    }

	public Field getField() {
		return field;
	}

	public String toQuestion() {
        return String.format("%s? [%s]", question, defaultValue);
    }
}
