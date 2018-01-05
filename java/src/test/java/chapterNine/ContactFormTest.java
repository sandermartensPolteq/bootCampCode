package chapterNine;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import pages.ContactPage;
import pages.HomePage;
import pages.TopToolbar;

public class ContactFormTest {

    @Test
    public void fillInContactForm(){
        ChromeDriverManager.getInstance().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://techblog.polteq.com/testshop/index.php");

        //Maximize browser window
        driver.manage().window().maximize();

        //get page objects
        TopToolbar toptoolbar = new TopToolbar(driver);
        ContactPage contactPage = new ContactPage(driver);

        //Click on contact
        toptoolbar.goToContactPage();

        //Fill in the form
        contactPage.submitForm("Customer service", "bootcamper@feelthepain.com","4321234", "Ipod defect while lifting, need new one");

        //Validate
        Assertions.assertThat(contactPage.getSuccessfulAlertMessge()).as("Alert was nog successful").isEqualTo("Your message has been successfully sent to our team.");

        //Quit browser
        driver.quit();
    }
}
