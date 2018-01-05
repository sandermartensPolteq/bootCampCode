package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    WebDriver driver;

    @FindBy(id="email")
    WebElement emailField;

    @FindBy(id="passwd")
    WebElement passwordField;

    @FindBy(id="SubmitLogin")
    WebElement submitButton;

    @FindBy(xpath = "//div[@class='alert alert-danger']")
    private WebElement alert;

    public LoginPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public LoginPage fillEmail(String email){
        emailField.sendKeys(email);
        return this;
    }

    public LoginPage fillPassword(String password){
        passwordField.sendKeys(password);
        return this;
    }

    public LoginPage signIn(){
        submitButton.click();
        return this;
    }

    public LoginPage clearEmailField(){
        emailField.clear();
        return this;
    }

    public LoginPage clearPasswordField(){
        passwordField.clear();
        return this;
    }

    public MyAccountPage login(String email, String password){
        emailField.sendKeys(email);
        passwordField.sendKeys(password);
        submitButton.click();
        return new MyAccountPage(driver);
    }

    public String getAlertMessage(){
        return alert.getText();
    }

}
