package nl.javadude.setup4j.model;

import nl.javadude.setup4j.SampleConfig;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class AnswersTest {

	private SampleConfig subject;

	@BeforeMethod
	public void setup() {
		subject = new SampleConfig();
	}

	@Test
	public void shouldAnswerString() throws NoSuchFieldException, AnswerFailedException {
		StringAnswer aQuestion = new StringAnswer(SampleConfig.class.getDeclaredField("aQuestion"));
		aQuestion.answer("string", subject);
		assertThat(subject.getaQuestion(), equalTo("string"));
	}

	@Test
	public void shouldAnswerInt() throws NoSuchFieldException, AnswerFailedException {
		IntegerAnswer iQuestion = new IntegerAnswer(SampleConfig.class.getDeclaredField("iQuestion"));
		iQuestion.answer("666", subject);
		assertThat(subject.getiQuestion(), equalTo(666));
	}

	@Test
	public void shouldAnswerInteger() throws NoSuchFieldException, AnswerFailedException {
		IntegerAnswer iObjQuestion = new IntegerAnswer(SampleConfig.class.getDeclaredField("iObjQuestion"));
		iObjQuestion.answer("666", subject);
		assertThat(subject.getiObjQuestion(), equalTo(Integer.valueOf(666)));
	}

	@Test(expectedExceptions = AnswerFailedException.class)
	public void shouldThrowWhenNonIntForIntQuestion() throws NoSuchFieldException, AnswerFailedException {
		IntegerAnswer iQuestion = new IntegerAnswer(SampleConfig.class.getDeclaredField("iQuestion"));
		iQuestion.answer("foo", subject);
	}

	@Test
	public void shouldAnswerBooleanTrue() throws NoSuchFieldException, AnswerFailedException {
		BooleanAnswer bQuestion = new BooleanAnswer(SampleConfig.class.getDeclaredField("bQuestion"));
		bQuestion.answer("y", subject);
		assertThat(subject.getbQuestion(), equalTo(true));
	}

	@Test
	public void shouldAnswerBooleanFalse() throws NoSuchFieldException, AnswerFailedException {
		BooleanAnswer bQuestion = new BooleanAnswer(SampleConfig.class.getDeclaredField("bQuestion"));
		bQuestion.answer("n", subject);
		assertThat(subject.getbQuestion(), equalTo(false));
	}

	@Test
	public void shouldBeDefaultWhenNoAnswerGiven() throws NoSuchFieldException, AnswerFailedException {
		StringAnswer aQuestion = new StringAnswer(SampleConfig.class.getDeclaredField("aQuestion"));
		aQuestion.answer("", subject);
		assertThat(subject.getaQuestion(), equalTo("a-default"));
	}
}
