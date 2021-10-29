package hw8.forms;

import com.epam.jdi.light.elements.complex.Droplist;
import com.epam.jdi.light.elements.complex.WebList;
import com.epam.jdi.light.elements.composite.Form;
import com.epam.jdi.light.elements.pageobjects.annotations.FindBy;
import com.epam.jdi.light.elements.pageobjects.annotations.objects.JDropdown;
import hw8.entities.MetalsColors;
import hw8.sections.Summary;

public class MetalAndColorsForm extends Form<MetalsColors> {

    @JDropdown(root = "div[ui=dropdown]",
            value = ".filter-option",
            list = "li",
            expand = ".caret")
    public static Droplist colors;

    @JDropdown(root = "div[ui=combobox]",
            value = "input",
            list = "li",
            expand = ".caret")
    public static Droplist metal;

    @JDropdown(root = "#salad-dropdown",
            value = ".dropdown-toggle",
            list = "li",
            expand = ".caret")
    public static Droplist vegetables;

    @FindBy(css = "#elements-checklist > p")
    public WebList natureElements;
    Summary summaryblock;

    public void fill(MetalsColors mc) {

        summaryblock.odds.select(mc.getSummary().get(0).toString());
        summaryblock.even.select(mc.getSummary().get(1).toString());
        mc.getElements().forEach(natureElements::select);
        colors.select(mc.getColor());
        metal.select(mc.getMetals());
        vegetables.select(vegetables.getSelected());
        mc.getVegetables()
                .forEach(s -> vegetables.select(s));
        summaryblock.calculate.click();
    }
}
