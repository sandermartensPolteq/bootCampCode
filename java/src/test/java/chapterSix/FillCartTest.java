package chapterSix;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FillCartTest extends TestShopScenario{

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

        //Validate that cart is empty
        WebElement shoppingCart = driver.findElement(By.xpath("//div[@class='shopping_cart']"));
        Assertions.assertThat(shoppingCart.getText()).as("Shopping cart is not empty").isEqualTo("Cart (empty)");

        //Ipod tag
        //WebElement ipodButton = driver.findElement(By.cssSelector("a[class='tag_level3 first_item']"));
        WebElement ipodButton = driver.findElement(By.xpath("//div[@class='block tags_block']//a[text()=' ipod ']"));
        ipodButton.click();

        //Click on the Ipod shuffle
        WebElement ipodShuffle = driver.findElement(By.xpath("//a[text()=' iPod shuffle ']"));
        System.out.println(ipodShuffle.getText());
        ipodShuffle.click();

        //Add Ipod to cart
        WebElement addToCardButton = driver.findElement(By.xpath("//div[@class='box-cart-bottom']//Button[@name='Submit']"));
        addToCardButton.click();

        //Click the button continue to shopping
        (new WebDriverWait(driver, 10)).until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='button-container']/span[@title='Continue shopping']"))).click();

        //Validate that the item is added to cart
        shoppingCart = driver.findElement(By.xpath("//div[@class='shopping_cart']"));
        Assertions.assertThat(shoppingCart.getText()).as("Shopping cart is not empty").isEqualTo("Cart 1 Product");
    }

    @AfterMethod
    @Override
    public void tearDown() {
        super.tearDown();
    }
}
