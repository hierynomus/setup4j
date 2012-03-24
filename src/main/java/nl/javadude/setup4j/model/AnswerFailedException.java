package nl.javadude.setup4j.model;

public class AnswerFailedException extends Exception {

	public AnswerFailedException(String message, Object... params) {
		super(String.format(message, params));
	}

	public AnswerFailedException(Exception e) {
		super(e);
	}
}
