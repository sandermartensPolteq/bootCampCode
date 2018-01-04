package chapterSix;

import browser.BrowserFactory;
import browser.BrowserFactoryAdvanced;
import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestShopScenario {

    protected WebDriver driver;

    @Test
    public void setUp(){
        driver = BrowserFactoryAdvanced.getDriver(BrowserFactoryAdvanced.Browser.CHROME);
        this.driver = driver;
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
