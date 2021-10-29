package hw8.sections;

import com.epam.jdi.light.elements.complex.WebList;
import com.epam.jdi.light.elements.composite.Section;
import hw8.entities.MetalsColors;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class Result extends Section {

    @FindBy(className = "results")
    public WebList result;

    public void checkResult(MetalsColors params) {
        List<String> resultContent = new ArrayList<>();
        for (WebElement element : result) {
            resultContent.add(element.getText());
        }

        assertTrue(resultContent.contains("Summary: " + params.getSummary().stream().mapToInt(Integer::new).sum()));
        assertTrue(resultContent.contains("Elements: " + String.join(", ", params.getElements())));
        assertTrue(resultContent.contains("Color: " + params.getColor()));
        assertTrue(resultContent.contains("Metal: " + params.getMetals()));
        assertTrue(resultContent.contains("Vegetables: " + String.join(", ", params.getVegetables())));
    }
    public void demonstrationScreenshots(MetalsColors params){
        List<String> resultContent = new ArrayList<>();
        for (WebElement element : result) {
            resultContent.add(element.getText());
        }
        assertFalse(resultContent.isEmpty());
    }
}

