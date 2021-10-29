package hw8.pages;

import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.ui.html.common.Button;
import hw8.entities.MetalsColors;
import hw8.forms.MetalAndColorsForm;
import hw8.sections.Result;
import org.openqa.selenium.support.FindBy;


public class MetalAndColorsPage extends WebPage {

    @FindBy(id = "submit-button")
    public Button submit;

    MetalAndColorsForm form;
    Result result;

    public void fillForm(MetalsColors parameters) {
        form.fill(parameters);
    }

    public void submitForm() {
        submit.click();
    }

    public void checkForm(MetalsColors parameters) {
        result.checkResult(parameters);
    }

    public void demoScreens(MetalsColors parameters) {result.demonstrationScreenshots(parameters);}
}
