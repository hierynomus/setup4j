package nl.javadude.setup4j.reader;

import nl.javadude.setup4j.SampleConfig;
import nl.javadude.setup4j.model.Question;
import org.testng.annotations.Test;

import java.lang.reflect.Field;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasSize;

public class QuestionReaderTest {

	@Test
	public void shouldReadAllQuestions() throws Exception {
		List<Question> read = QuestionReader.read(new SampleConfig());
		assertThat(read, hasSize(2));
	}
	
    @Test
    public void shouldReadStringQuestion() throws NoSuchFieldException {
        Field aQuestion = SampleConfig.class.getDeclaredField("aQuestion");
        Question q = QuestionReader.read(aQuestion);
        assertThat(q, instanceOf(Question.class));
        assertThat(q.getQuestion(), equalTo("This is a question"));
        assertThat(q.getDefaultValue(), equalTo("a-default"));
        assertThat(q.toQuestion(), equalTo("This is a question? [a-default]"));
    }

    @Test
    public void shouldReadIntegerQuestion() throws NoSuchFieldException {
        Field aQuestion = SampleConfig.class.getDeclaredField("iQuestion");
        Question q = QuestionReader.read(aQuestion);
        assertThat(q, instanceOf(Question.class));
        assertThat(q.getQuestion(), equalTo("This is an int question"));
        assertThat(q.getDefaultValue(), equalTo("1"));
        assertThat(q.toQuestion(), equalTo("This is an int question? [1]"));
    }


}
