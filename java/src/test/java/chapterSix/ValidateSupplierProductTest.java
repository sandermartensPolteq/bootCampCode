package chapterSix;

import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class ValidateSupplierProductTest extends TestShopScenario{

    String url = "https://techblog.polteq.com/testshop/index.php";
    String mail = "sander.martens+webshop1@polteq.com";
    String password = "Test1234!";

    @BeforeMethod
    @Override
    public void setUp() {
        super.setUp();
    }

    @Test
    public void personalInfo() {

        //Maximize browser window
        driver.manage().window().maximize();

        //Find all products
        List<WebElement> buttons = driver.findElements(By.xpath("//div[@id='center_column']//ul[@id='homefeatured']//li/div[@class='product-container']//a[@class='product-name']"));
        System.out.println("List size is: " + buttons.size());

        //Create list for adding the titles of the products
        List products = new ArrayList();

        //Add products to the list
        for( int i=0; i<buttons.size(); i++){
            products.add(buttons.get(i).getText());
        }

        //Print out the list
        System.out.println(products);

        //Create assertion

    }
}
