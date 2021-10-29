package hw8.pages;

import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.ui.html.common.Button;
import com.epam.jdi.light.ui.html.common.Icon;
import com.epam.jdi.light.ui.html.common.Image;
import hw8.enums.Navigation;
import hw8.forms.LoginForm;
import hw8.sections.Header;
import org.openqa.selenium.support.FindBy;

import static hw8.base.EpamSite.metalsColorsPage;
import static hw8.entities.User.PETER;

public class IndexPageJdi extends WebPage {
    LoginForm loginForm;
    public Header header;

    @FindBy(css = "[id='user-icon']")
    private Icon loginIcon;

    @FindBy(css = "[id='user-icon']")
    private Image profilePhoto;

    @FindBy(css = ".fa-sign-out")
    private Button signOut;

    public void login() {
        loginIcon.click();
        loginForm.loginAs(PETER);
    }

    public void openMenuItem(Navigation item){
        header.navigationBar.select(item.toString());
        metalsColorsPage.shouldBeOpened();
    }

    public void logout() {
        if (!signOut.isDisplayed())
            profilePhoto.click();
        signOut.click();
    }
}
