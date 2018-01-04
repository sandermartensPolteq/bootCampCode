package chapterNine;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.MyAccountPage;
import pages.TopToolbar;

public class LoginTest {

    @Test
    public void login(){
        ChromeDriverManager.getInstance().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://techblog.polteq.com/testshop/index.php");

        //Maximize browser window
        driver.manage().window().maximize();

        //Get the pages
        TopToolbar toptoolbar = new TopToolbar(driver);
        LoginPage loginpage = new LoginPage(driver);

        //Validate that there is no user logged in
        Assertions.assertThat(toptoolbar.getSignInText()).as("There is a user logged in").isEqualTo("Sign in");

        //Click sign in button
        toptoolbar.clickSignInButton();

        //Fill in the form to log in
        loginpage.login("bootcamper@feelthepain.com", "1qazxsw2");

        //Validation on the user login name
        Assertions.assertThat(toptoolbar.getLoggedInUserName()).as("User not logged in").isEqualTo("Seargeant Slaughter");

        //Close browser
        driver.quit();
    }
}
