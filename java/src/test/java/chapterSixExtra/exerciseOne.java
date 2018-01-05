package chapterSixExtra;

import browser.BrowserFactoryAdvanced;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.MyAccountPage;
import pages.PersonalInformationPage;
import pages.TopToolbar;

public class exerciseOne {

    private String FIRSTNAME = "firstName";
    private String LASTNAME = "lastName";
    private String CURRENTPASSWORD = "Test1234!";
    private String NEWPASSWORD = "Test1234!";
    private String EMAIL = "sander.martens+webshop1@polteq.com";
    private WebDriver driver;

    @BeforeMethod
    public void setup(){
        driver = BrowserFactoryAdvanced.getDriver(BrowserFactoryAdvanced.Browser.CHROME);
        driver.get("https://techblog.polteq.com/testshop/index.php");
    }

    @Test
    public void changePersonalInfo(){
        PersonalInformationPage personalInforamtionPage = new PersonalInformationPage(driver);
        TopToolbar topToolbar = new TopToolbar(driver);
        topToolbar.goToLoginPage().login(EMAIL, CURRENTPASSWORD)
                .goToMyPersonalInformationPage().clearFirstNameField().clearLastNameField()
                .fillFirstName(FIRSTNAME).fillLastName(LASTNAME).fillCurrentPassword(CURRENTPASSWORD).fillNewPassword(NEWPASSWORD).fillConfirmation(NEWPASSWORD).saveForm();
        Assertions.assertThat(personalInforamtionPage.successfulUpdateMessage()).as("Wrong").isEqualTo("Your personal information has been successfully updated.");
    }
}
