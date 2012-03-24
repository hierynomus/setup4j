package nl.javadude.setup4j.reader;

import nl.javadude.setup4j.Setting;
import nl.javadude.setup4j.model.Question;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import static java.lang.String.format;

public class QuestionReader {

	public static List<Question> read(Object instance) {
		Class<?> clazz = instance.getClass();
		List<Question> questions = new ArrayList<Question>();
		for (Field field : clazz.getDeclaredFields()) {
			Question read = read(field);
			questions.add(read);
		}
		return questions;
	}

    public static Question read(Field field) {
        Setting setting = field.getAnnotation(Setting.class);
        return new Question(field, setting);
    }
}
