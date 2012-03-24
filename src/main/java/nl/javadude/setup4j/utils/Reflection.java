package nl.javadude.setup4j.utils;

import java.lang.reflect.Field;
import java.lang.reflect.TypeVariable;

import static java.lang.String.format;

public class Reflection {
	
	public static void set(Field f, Object instance, Object value) {
		boolean accessible = f.isAccessible();
		try {
			// Make it accessible if it wasn't
			f.setAccessible(true);
			f.set(instance, value);
			// Reset the accessibility
			f.setAccessible(accessible);
		} catch (IllegalAccessException e) {
			throw new IllegalStateException(format("Could not set the value [%s] on field [%s] on [%s]", value, f, instance), e);
		}
	}
}
