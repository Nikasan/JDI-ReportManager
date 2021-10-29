package hw8.sections;

import com.epam.jdi.light.elements.composite.Section;
import com.epam.jdi.light.elements.pageobjects.annotations.FindBy;
import com.epam.jdi.light.ui.html.base.HtmlRadioGroup;
import com.epam.jdi.light.ui.html.common.Button;

public class Summary extends Section {

    @FindBy(id = "odds-selector")
    public HtmlRadioGroup odds;

    @FindBy(id = "even-selector")
    public HtmlRadioGroup even;

    @FindBy(id = "calculate-button")
    public Button calculate;
}

