package chapterSix;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.Mouse;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.security.Key;
import java.util.concurrent.TimeUnit;

public class EmptyCartTest extends TestShopScenario{

    String url = "https://techblog.polteq.com/testshop/index.php";
    String mail = "sander.martens+webshop1@polteq.com";
    String password = "Test1234!";

    @BeforeMethod
    @Override
    public void setUp() {
        super.setUp();
    }

    @Test
    public void fillCartTest() {

        //Maximize browser window
        driver.manage().window().maximize();

        //Log in
        driver.findElement(By.className("login")).click();
        driver.findElement(By.id("email")).sendKeys(mail);
        driver.findElement(By.id("passwd")).sendKeys(password);
        driver.findElement(By.id("SubmitLogin")).click();

        //Validate that user is logged in
        WebElement loginName = driver.findElement(By.className("account"));
        Assertions.assertThat(loginName.getText()).as("User is not logged in").isEqualTo("Sander Martens");

        //Validate that cart is empty. If empty, add a product and delete again, else log of
        WebElement shoppingCart = driver.findElement(By.xpath("//div[@class='shopping_cart']"));
        if( shoppingCart.getText().equals("Cart (empty)")){

            //Ipod tag
            //WebElement ipodButton = driver.findElement(By.cssSelector("a[class='tag_level3 first_item']"));
            WebElement ipodButton = driver.findElement(By.xpath("//div[@class='block tags_block']//a[text()=' ipod ']"));
            ipodButton.click();

            //Click on the Ipod shuffle
            WebElement ipodShuffle = driver.findElement(By.xpath("//a[text()=' iPod shuffle ']"));
            ipodShuffle.click();

            //Add Ipod to cart
            WebElement addToCardButton = driver.findElement(By.xpath("//div[@class='box-cart-bottom']//Button[@name='Submit']"));
            addToCardButton.click();

            //Click the button continue to shopping
            (new WebDriverWait(driver, 10)).until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='button-container']/span[@title='Continue shopping']"))).click();

            //Validate that the item is added to cart
            shoppingCart = driver.findElement(By.xpath("//div[@class='shopping_cart']"));
            Assertions.assertThat(shoppingCart.getText()).as("Shopping cart is not empty").isEqualTo("Cart 1 Product");

            WebElement aa = driver.findElement(By.xpath(("//header[@id='header']/div[2]/div/div/div[3]/div/a")));
            aa.click();
        } else{

            //Log out
            WebElement logOut = driver.findElement(By.className("logout"));
            logOut.click();
        }
    }

//    @AfterMethod
//    @Override
//    public void tearDown() {
//        super.tearDown();
//    }
}
