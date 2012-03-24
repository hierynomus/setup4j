package nl.javadude.setup4j;

@Configuration(configFile = "conf/sample.conf")
public class SampleConfig {

    @Setting(question = "This is a question", defaultValue = "a-default")
    private String aQuestion;
    
    @Setting(question = "This is an int question", defaultValue = "1")
    private int iQuestion;

    @Setting(question = "This is an integer question", defaultValue = "2")
    private int iObjQuestion;

	@Setting(question = "This is a boolean question", defaultValue = "false")
	private boolean bQuestion;

	public String getaQuestion() {
		return aQuestion;
	}

	public int getiQuestion() {
		return iQuestion;
	}

	public int getiObjQuestion() {
		return iObjQuestion;
	}

	public boolean getbQuestion() {
		return bQuestion;
	}
}
