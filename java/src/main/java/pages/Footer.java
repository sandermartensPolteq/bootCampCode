package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Footer {

    @FindBy( xpath="//footer[@id='footer']//h4[text()='Categories']")
    WebElement Categories;
    @FindBy( xpath="//footer[@id='footer']//a[contains(text(),'iPods')]")
    WebElement iPods;
    @FindBy( xpath="//footer[@id='footer']//a[contains(text(),'Accessories')]")
    WebElement accessories;
    @FindBy( xpath="//footer[@id='footer']//a[contains(text(),'Laptops')]")
    WebElement laptops;
    @FindBy( xpath="//footer[@id='footer']//a[contains(text(),'Tablets')]")
    WebElement tablets;
    @FindBy( xpath="//footer[@id='footer']//h4[text()='Information']")
    WebElement information;
    @FindBy( xpath="//footer[@id='footer']//a[contains(text(),'Our stores')]")
    WebElement ourStores;
    @FindBy( xpath="//footer[@id='footer']//a[contains(text(),'Terms and conditions of use')]")
    WebElement termsAndConditionsOfUse;
    @FindBy( xpath="//footer[@id='footer']//a[contains(text(),'About us')]")
    WebElement aboutUs;
    @FindBy( xpath="//footer[@id='footer']//a[text()='My account']")
    WebElement myaccount;
    @FindBy( xpath="//footer[@id='footer']//a[contains(text(),'My orders')]")
    WebElement myOrders;
    @FindBy( xpath="//footer[@id='footer']//a[contains(text(),'My credit slips')]")
    WebElement myCreditSlips;
    @FindBy( xpath="//footer[@id='footer']//a[contains(text(),'My addresses')]")
    WebElement myAddresses;
    @FindBy( xpath="//footer[@id='footer']//a[contains(text(),'My personal info')]")
    WebElement myPersonalInfo;
    @FindBy( xpath="//footer[@id='footer']//a[contains(text(),'Sign out')]")
    WebElement signout;

    WebDriver driver;

    public Footer(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public void clickCategories(){
        Categories.click();
    }
    public void clickIpods(){
        iPods.click();
    }
    public void clickAccessories(){
        accessories.click();
    }
    public void clickLaptops(){
        laptops.click();
    }
    public void clickTablets(){
        tablets.click();
    }
    public void clickInformation(){
        information.click();
    }
    public void clickOurStore(){
        ourStores.click();
    }
    public void clickTermsAndConditions(){
        termsAndConditionsOfUse.click();
    }
    public void clickAboutUs(){
        aboutUs.click();
    }
    public void clickMyAccount(){
        myaccount.click();
    }
    public void clickMyOrders(){
        myOrders.click();
    }
    public void clickMyCreditSlips(){
        myCreditSlips.click();
    }
    public void clickMyAddresses(){
        myAddresses.click();
    }
    public void clickMyPersonalInfo(){
        myPersonalInfo.click();
    }
    public void clickSignOut(){
        signout.click();
    }
}
