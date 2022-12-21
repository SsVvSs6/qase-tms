package tms.onl.ui.elements.inputs;

public class SuiteModalWindowInput extends BaseInput {

    private String id;
    private static final String INPUT_XPATH = "//input[@id='%s']";

    public SuiteModalWindowInput(String id) {
        this.id = id;
    }

    public SuiteModalWindowInput clearField() {
        clearField(String.format(INPUT_XPATH, this.id));
        return this;
    }
    public void fillInField(String text) {
        writeText(text, String.format(INPUT_XPATH, this.id));
    }
}
