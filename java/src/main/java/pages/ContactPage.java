package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class ContactPage {

    private WebDriver driver;

    @FindBy(xpath="//input[@id='email']")
    private WebElement emailField;

    @FindBy(xpath = "//input[@id='id_order']")
    private WebElement orderReferenceField;

    @FindBy(xpath="//button[@id='submitMessage']")
    private WebElement submitButton;

    @FindBy(xpath="//textarea[@id='message']")
    private WebElement messageField;

    @FindBy(xpath="//select[@id='id_contact']")
    private WebElement subJectHeading;

    @FindBy(xpath="//p[@class='alert alert-success']")
    private WebElement successfulAlertMessage;

    //Constructor
    public ContactPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    //Fill in the fields of the form & click submit
    public void submitForm(String subject, String email, String orderReference, String message){
        new Select(subJectHeading).selectByVisibleText(subject);
        emailField.sendKeys(email);
        orderReferenceField.sendKeys(orderReference);
        messageField.sendKeys(message);
        submitButton.click();
    }

    //Get the message of the alert
    public String getSuccessfulAlertMessge(){
        return successfulAlertMessage.getText();
    }
}
