package chapterNine;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import pages.ContactPage;
import pages.TopToolbar;

public class NOK_FillInContactFormTest {

    @Test
    public void fillContactForm(){
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

        //Click on the 'Contact us' link
        topToolBar.goToContactPage();

        //Fill in the form
        contactPage.submitForm("Customer service", "nope", "4321234", "Help!");
        Assertions.assertThat(contactPage.getAlertMessage()).as("No validation on e-mail").contains("Invalid email address.");
    }

}
