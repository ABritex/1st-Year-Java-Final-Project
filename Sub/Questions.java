package Sub;

public class Questions {
    public String Answer;
    public String Choice;
    public String Choice1;
    public String Prompt;
    String Answer1;

    public Questions(String Answer, String Choice, String Choice1, String Prompt) {
        this.Answer = Answer;
        this.Choice = Choice;
        this.Choice1 = Choice1;
        this.Prompt = Prompt;
    }

    Questions(String Answer1) {
        this.Answer1 = Answer1;
    }
}
