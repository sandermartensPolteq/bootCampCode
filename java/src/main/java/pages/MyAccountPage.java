package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyAccountPage {

    WebDriver driver;

    @FindBy( xpath = "//ul[@class='myaccount-link-list']//a[@title='My wishlists']")
    WebElement btnMyWishLists;

    @FindBy( xpath = "//ul[@class='myaccount-link-list']//a[@title='Information']")
    WebElement btnMyPersonalInformation;


    public MyAccountPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public MyWishListsPage goToMyWishLists(){
        btnMyWishLists.click();
        return new MyWishListsPage(driver);
    }

    public PersonalInformationPage goToMyPersonalInformationPage(){
        btnMyPersonalInformation.click();
        return new PersonalInformationPage(driver);
    }






}
