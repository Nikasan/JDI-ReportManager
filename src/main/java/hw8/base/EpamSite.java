package hw8.base;

import com.epam.jdi.light.elements.pageobjects.annotations.JSite;
import com.epam.jdi.light.elements.pageobjects.annotations.Url;
import hw8.pages.IndexPageJdi;
import hw8.pages.MetalAndColorsPage;

@JSite("https://epam.github.io/JDI/")
public class EpamSite {

    @Url("index.html")
    public static IndexPageJdi indexPageJdi;

    @Url("metals-colors.html")
    public static MetalAndColorsPage metalsColorsPage;
}
