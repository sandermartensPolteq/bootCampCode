package chapterNine;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import pages.ContactPage;
import pages.TopToolbar;

public class NOK_ContactFormEmailFormatTest {

    @Test
    public void fillContactForm() {
        ChromeDriverManager.getInstance().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://techblog.polteq.com/testshop/index.php");

        //Maximize browser window
        driver.manage().window().maximize();

        TopToolbar topToolBar = new TopToolbar(driver);
        ContactPage contactPage = new ContactPage(driver);

        //Check if user is logged in
        Boolean isUserLoggedIn = topToolBar.isUserLoggedIn();
        Assertions.assertThat(isUserLoggedIn.booleanValue()).as("User is logged in").isFalse();

        // 1. Click on the 'Contact us' link
        topToolBar.goToContactPage();

        //invalid email
        contactPage.submitForm("Customer service", "nope", "4321234", "Help!");

        //Change the email
        contactPage.fillEmailField("nope@correct.com");
        contactPage.fillOrderReference("test");
        Assertions.assertThat(contactPage.checkIfEmailIsCorrect()).as("Emailfield not valid").isEqualTo("form-group form-ok");
    }
}
