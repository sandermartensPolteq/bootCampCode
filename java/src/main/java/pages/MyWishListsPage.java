package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class MyWishListsPage {

    WebDriver driver;

    public MyWishListsPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}
