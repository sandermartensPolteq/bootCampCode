package chapterNine;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.TopToolbar;

public class LoginTest_multipleScenarios {

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
        toptoolbar.goToLoginPage();

        // 1. empty email
        loginpage.login("", "1qazxsw2");
        Assertions.assertThat(loginpage.getAlertMessage()).as("User not logged in").contains("An email address required.");

        // 2. empty password
        loginpage.login("bootcamper@feelthepain.com", "");
        Assertions.assertThat(loginpage.getAlertMessage()).as("User not logged in").contains("Password is required.");

        // 3. invalid email
        loginpage.login("bootcamper@fe", "1qazxsw2");
        Assertions.assertThat(loginpage.getAlertMessage()).as("User not logged in").contains("Invalid email address.");

        // 4. invalid password
        loginpage.login("bootcamper@feelthepain.com", "fsfqdfqfsdfsqfsq");
        Assertions.assertThat(loginpage.getAlertMessage()).as("User not logged in").contains("Authentication failed.");


        //Close browser
        driver.quit();
    }
}
