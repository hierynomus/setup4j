package nl.javadude.setup4j.model;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class BooleanAnswer extends Answer<Boolean> {
	private static final List<String> trueValues = Arrays.asList("y", "yes", "true");
	private static final List<String> falseValues = Arrays.asList("n", "no", "false");
	private static final List<String> allValues = new ArrayList<String>(trueValues);
	
	static {
		allValues.addAll(falseValues);
	}

	protected BooleanAnswer(Field field) {
		super(field);
	}

	@Override
	protected Boolean defaultAnswer() {
		return false;
	}

	@Override
	protected Boolean convertToCorrectType(String answer) throws AnswerFailedException {
		if (trueValues.contains(answer.toLowerCase())) {
			return true;
		} else if (falseValues.contains(answer.toLowerCase())) {
			return false;
		}

		throw new AnswerFailedException("Could not convert [%s] to boolean value, possible values are: %s", answer, allValues);
	}
}
