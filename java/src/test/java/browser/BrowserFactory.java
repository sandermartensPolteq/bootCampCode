package browser;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import io.github.bonigarcia.wdm.FirefoxDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

public class BrowserFactory {

    static WebDriver driver;

     public static WebDriver getDriver (String browser){
        switch(browser.toLowerCase()){
            case "firefox":
                return  getFirefoxDriver();
            case "chrome": default:
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
