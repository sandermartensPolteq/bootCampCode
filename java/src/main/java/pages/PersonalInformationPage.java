package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PersonalInformationPage {

    private WebDriver driver;

    @FindBy( id = "id_gender1")
    WebElement radioButtonMr;

    @FindBy( id = "id_gender2")
    WebElement radioButtonMs;

    @FindBy( id = "id_gender3")
    WebElement radioButtonMiss;

    @FindBy( id = "firstname")
    WebElement txtFirstName;

    @FindBy( id = "lastname")
    WebElement txtLastName;

    @FindBy( id = "email")
    WebElement txtEmail;

    @FindBy( id = "days")
    WebElement selectDay;

    @FindBy( id = "months")
    WebElement selectMonth;

    @FindBy( id = "years")
    WebElement selectYear;

    @FindBy( id = "old_passwd")
    WebElement txtCurrentPassword;

    @FindBy( id = "passwd")
    WebElement txtNewPassword;

    @FindBy( id = "confirmation")
    WebElement txtConfirmation;

    @FindBy( id = "newsletter")
    WebElement checkBoxNewsLetter;

    @FindBy( id = "optin")
    WebElement checkBoxOffers;

    @FindBy( xpath = "//button[@name='submitIdentity']")
    WebElement btnSave;

    @FindBy( xpath = "//p[@class='alert alert-success']")
    WebElement alertSuccessful;

    public PersonalInformationPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public PersonalInformationPage clickRadioButtonMr(){
        radioButtonMr.click();
        return this;
    }

    public PersonalInformationPage clickRadioButtonMs(){
        radioButtonMs.click();
        return this;
    }

    public PersonalInformationPage clickRadioButtonMiss(){
        radioButtonMiss.click();
        return this;
    }

    public PersonalInformationPage fillFirstName(String firstName){
        txtFirstName.sendKeys(firstName);
        return this;
    }

    public PersonalInformationPage fillLastName(String lastName){
        txtLastName.sendKeys(lastName);
        return this;
    }

    public PersonalInformationPage fillEmail(String email){
        txtEmail.sendKeys(email);
        return this;
    }

    public PersonalInformationPage fillCurrentPassword(String currentPassword){
        txtCurrentPassword.sendKeys(currentPassword);
        return this;
    }

    public PersonalInformationPage fillNewPassword(String newPassword){
        txtNewPassword.sendKeys(newPassword);
        return this;
    }

    public PersonalInformationPage fillConfirmation(String confirmation){
        txtConfirmation.sendKeys(confirmation);
        return this;
    }

    public PersonalInformationPage checkNewsLetter() {
        checkBoxNewsLetter.click();
        return this;
    }

    public PersonalInformationPage checkSpecialOffers() {
        checkBoxOffers.click();
        return this;
    }

    public PersonalInformationPage saveForm() {
        btnSave.click();
        return this;
    }

    public PersonalInformationPage clearFirstNameField(){
        txtFirstName.clear();
        return this;
    }

    public PersonalInformationPage clearLastNameField(){
        txtLastName.clear();
        return this;
    }

    public String successfulUpdateMessage(){
        return alertSuccessful.getText();
    }
}
