package chapterSix;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

public class SignOutTest {

    String url = "https://techblog.polteq.com/testshop/index.php";
    String mail = "sander.martens+webshop1@polteq.com";
    String password = "Test1234!";

    @Test
    public void logInSuccesFull() {
        ChromeDriverManager.getInstance().setup();
        WebDriver driver = new ChromeDriver();
        driver.get(url);

        //Maximize browser window
        driver.manage().window().maximize();


        //Log in
        driver.findElement(By.className("login")).click();
        driver.findElement(By.id("email")).sendKeys(mail);
        driver.findElement(By.id("passwd")).sendKeys(password);
        driver.findElement(By.id("SubmitLogin")).click();

        //Validate that user is logged in
        WebElement loginName = driver.findElement(By.className("account"));
        Assertions.assertThat(loginName.getText()).as("login naam").isEqualTo("Sander Martens");

        //Log out
        WebElement logOut = driver.findElement(By.className("logout"));
        logOut.click();


        //Validate that user is logged out
        WebElement loginButton = driver.findElement(By.className("login"));
        Assertions.assertThat(loginButton.getText()).as("User is not logged out").isEqualTo("Sign in");

        //Close the browser
        driver.quit();
    }
}
