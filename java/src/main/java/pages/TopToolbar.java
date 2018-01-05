package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class TopToolbar {

    WebDriver driver;

    @FindBy(xpath = "//a[@class='account']")
    WebElement loggedInUsername;

    @FindBy(xpath = "//div[@id='contact-link']")
    WebElement contactButton;

    @FindBy(className = "login")
    WebElement loginButton;

    @FindBy(xpath = "//div[@class='header_user_info']/a[@title='Log me out']")
    WebElement logoutButton;

    public TopToolbar(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public LoginPage goToLoginPage(){
        loginButton.click();
        return new LoginPage(driver);
    }

    public ContactPage goToContactPage(){
        contactButton.click();
        return new ContactPage(driver);
    }

    public void logout(){
        logoutButton.click();
    }

    public String getUserName(){
        return loggedInUsername.getText();
    }

    public String getSignInText(){
        return loginButton.getText();
    }

    public Boolean isUserLoggedIn(){
        if( loginButton.isDisplayed()){
            return false;
        } else{
            return true;
        }
    }
}
