package nl.javadude.setup4j;

import nl.javadude.setup4j.model.Answer;
import nl.javadude.setup4j.model.IntegerAnswer;
import nl.javadude.setup4j.model.Question;
import nl.javadude.setup4j.model.StringAnswer;

import static java.lang.String.format;

public class AnswerFactory {

	private AnswerFactory() {
	}

	public static Answer getAnswer(Question q) {
		Class<?> type = q.getField().getType();
		if (type.equals(String.class)) {
			return new StringAnswer(q.getField());
		} else if (type.equals(Integer.class) || type.equals(int.class)) {
			return new IntegerAnswer(q.getField());
		}
		throw new IllegalArgumentException(format("Could not determine the answer type for [%s]", type));
	}
}
