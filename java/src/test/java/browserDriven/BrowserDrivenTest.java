package browserDriven;

import browser.BrowserFactoryAdvanced;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.TopToolbar;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class BrowserDrivenTest extends TestShopScenarioBrowserDriven{

//    private String PASSWORD = "Test1234!";
//    private String EMAIL = "sander.martens+webshop1@polteq.com";

    @Parameters({"email", "password"})
    @Test
    public void correctLogin(String email, String passwword){
        TopToolbar topToolbar = new TopToolbar(driver);
        LoginPage loginPage = new LoginPage(driver);

        topToolbar.goToLoginPage().login(email, passwword);
    }
}
