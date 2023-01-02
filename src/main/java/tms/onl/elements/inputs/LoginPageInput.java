package tms.onl.elements.inputs;

public class LoginPageInput extends BaseInput {

    private static final String INPUT_XPATH = "//input[@id='%s']";
    private String id;

    public LoginPageInput(String id) {
        this.id = id;
    }

    public LoginPageInput clearField() {
        clearField(String.format(INPUT_XPATH, this.id));
        return this;
    }
    public void fillInField(String text) {
        writeText(text, String.format(INPUT_XPATH, this.id));
    }
}
