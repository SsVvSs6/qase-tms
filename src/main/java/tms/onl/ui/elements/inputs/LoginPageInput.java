package tms.onl.ui.elements.inputs;

public class LoginPageInput extends BaseInput {

    private String id;
    private static final String INPUT_XPATH = "//input[@id='%s']";

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
