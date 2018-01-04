package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TopToolbar {

    WebDriver driver;

    @FindBy(xpath = "//a[@class='account']")
    WebElement loggedInUsername;

    @FindBy(xpath = "//div[@id='contact-link']")
    WebElement contactButton;

    @FindBy(className = "login")
    WebElement loginButton;

    public TopToolbar(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickContactUs(){
        contactButton.click();
    }

    public String getSignInText(){
        return loginButton.getText();
    }

    public void clickSignInButton(){
        loginButton.click();
    }

    public String getLoggedInUserName(){
        return loggedInUsername.getText();
    }
}
