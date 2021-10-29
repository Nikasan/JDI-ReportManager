package hw8.sections;

import com.epam.jdi.light.elements.composite.Section;
import com.epam.jdi.light.elements.pageobjects.annotations.simple.XPath;
import com.epam.jdi.light.ui.html.complex.Menu;

public class Header extends Section {
    @XPath("//a[text()='%s']")
    public Menu navigationBar;
}
