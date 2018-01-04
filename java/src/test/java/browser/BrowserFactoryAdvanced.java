package browser;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import io.github.bonigarcia.wdm.FirefoxDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class BrowserFactoryAdvanced {
    static WebDriver driver;

    public enum Browser{
        CHROME,
        FIREFOX;
    }

    public static WebDriver getDriver (Browser browser){
        switch(browser){
            case FIREFOX:
                return  getFirefoxDriver();
            case CHROME: default:
                return getChromeDriver();
        }
    }

    private static WebDriver getFirefoxDriver() {
        FirefoxOptions options = new FirefoxOptions();
        options.addArguments("--start-maximized");
        options.addArguments("ignore-certificate-errors");
        FirefoxDriverManager.getInstance().setup();
        return driver = new FirefoxDriver(options);
    }

    private static WebDriver getChromeDriver(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        options.addArguments("ignore-certificate-errors");
        options.addArguments("--enable-logging --v");
        ChromeDriverManager.getInstance().setup();
        return driver = new ChromeDriver(options);
    }
}
