package hw8;

import com.epam.jdi.light.driver.WebDriverFactory;
import com.epam.jdi.light.ui.html.PageFactory;
import hw8.Utils.ScreenshotListener;
import hw8.Utils.SetUpDriver;
import hw8.base.EpamSite;
import hw8.entities.MetalsColors;
import org.apache.log4j.Level;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.annotations.*;

import java.io.FileNotFoundException;
import java.util.Map;

import static com.epam.jdi.light.driver.WebDriverFactory.useDriver;
import static hw8.base.EpamSite.indexPageJdi;
import static hw8.base.EpamSite.metalsColorsPage;
import static hw8.enums.Navigation.METALS_COLORS;

//https://rp.epam.com/ui/#veranika_pekhtserava_personal/launches/all?page.page=1&page.size=50
@Listeners ({ScreenshotListener.class})

public class JdiSimpleExample {

    private static final Logger LOGGER = LogManager.getLogger(JdiSimpleExample.class);
    @BeforeSuite(alwaysRun = true)
    public void beforeSuite() {
        useDriver(SetUpDriver::CreateWebDriver);
        PageFactory.initSite(EpamSite.class);
       // LOGGER.setLevel(Level.ALL);
    }

    @BeforeMethod(alwaysRun = true)
    public void beforeMethod(){
        indexPageJdi.open();
        indexPageJdi.login();
        indexPageJdi.openMenuItem(METALS_COLORS);
    }

    @AfterMethod(alwaysRun = true)
    public void afterMethod() {
        indexPageJdi.logout();
        indexPageJdi.refresh();
    }

    @DataProvider
    public Object[][] getDataFromLoader()throws FileNotFoundException {
        Map<String, MetalsColors> map = Parser.getData();

        Object[] keys = map.keySet().toArray();
        Object[] values = map.values().toArray();
        Object[][] result = new Object[map.size()][2];
        for (int i = 0; i < map.size(); i++) {
            result[i][0] = keys[i];
            result[i][1] = values[i];
        }
        return result;
    }

    @Test(dataProvider = "getDataFromLoader")
    public void simpleJdiTest(String key, MetalsColors parameters)  {
        //DEMO logging levels
        LOGGER.trace("Trace Message!");
        LOGGER.debug("Debug Message!");
        LOGGER.info("Info Message!");
        LOGGER.warn("Warn Message!");
        LOGGER.error("Error Message!");
        LOGGER.fatal("Fatal Message!");

     metalsColorsPage.fillForm(parameters);
     metalsColorsPage.submitForm();
     metalsColorsPage.checkForm(parameters);
    }

    @Test(dataProvider = "getDataFromLoader")
    public void simpleFailedtest(String key, MetalsColors parameters){
        metalsColorsPage.demoScreens(parameters);
    }

    @AfterSuite(alwaysRun = true)
    public void afterSuite() {
        WebDriverFactory.close();
    }
}
