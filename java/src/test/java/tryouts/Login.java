package tryouts;

import browser.BrowserFactoryAdvanced;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.TopToolbar;

public class Login {

    WebDriver driver;
    private String PASSWORD = "Test1234!";
    private String EMAIL = "sander.martens+webshop1@polteq.com";

    @BeforeMethod
    public void setup(){
        driver = BrowserFactoryAdvanced.getDriver(BrowserFactoryAdvanced.Browser.CHROME);
        driver.get("https://techblog.polteq.com/testshop/index.php");
    }

    @Test
    public void loginWithoutEmail(){
        TopToolbar topToolbar = new TopToolbar(driver);
        LoginPage loginPage = new LoginPage(driver);

        topToolbar.goToLoginPage().login("", PASSWORD);
        Assertions.assertThat(loginPage.getAlertMessage()).as("Wrong alert message when email is blank").contains("An email address required.");
    }

    @Test
    public void loginWithInvalidEmail(){
        TopToolbar topToolbar = new TopToolbar(driver);
        LoginPage loginPage = new LoginPage(driver);

        topToolbar.goToLoginPage().login("email@e", PASSWORD);
        Assertions.assertThat(loginPage.getAlertMessage()).as("Wrong alert message when email is invalid").contains("Invalid email address");
    }
}
