package homework;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.apache.http.util.Asserts;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class DeleteItemFromWishlist {

    String url = "https://techblog.polteq.com/testshop/index.php";
    String mail = "sander.martens+webshop1@polteq.com";
    String password = "Test1234!";
    String columnName = "Delete";
    String rowName = "feel the pain";
    WebDriver driver;

    @Test
    public void wishlist(){

        ChromeDriverManager.getInstance().setup();
        driver = new ChromeDriver();
        driver.get(url);

        //Maximize browser window
        driver.manage().window().maximize();

        //Log in
        login(mail, password);

        //Click on the wishlist button
        driver.findElement(By.xpath("//li[@class='lnk_wishlist']")).click();

        //Remove item from wishlist
        removeItemFromWish(rowName,columnName);

        //Loop through table & check if item is deleted
        WebElement cells = driver.findElement(By.xpath("//table/tbody"));
        List<WebElement> cel = cells.findElements(By.cssSelector("tr"));
        for( WebElement i : cel){
            System.out.println(i.getText());
            //Assertions.assertThat(i.getText()).as("Row still contains"+rowName).doesNotContain(rowName);
        }

        //Add item to wishlist
        addItemToWishlist(rowName);
    }

    public void login(String mail, String password){
        driver.findElement(By.className("login")).click();
        driver.findElement(By.id("email")).sendKeys(mail);
        driver.findElement(By.id("passwd")).sendKeys(password);
        driver.findElement(By.id("SubmitLogin")).click();
    }

    public void removeItemFromWish(String rowName, String columnName){
        WebElement cells = driver.findElement(By.xpath("//table/tbody"));
        List<WebElement> cel = cells.findElements(By.cssSelector("tr"));
        WebElement rows = driver.findElement(By.xpath("//table/thead/tr"));
        List<WebElement> row = rows.findElements(By.cssSelector("th"));
        int i=1;
        for( WebElement celIterate : cel ){
            if( celIterate.getText().contains(rowName)){
                int j=1;
                for( WebElement rowIterate : row ){
                    if( rowIterate.getText().equals(columnName)){
                        driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td["+j+"]/a")).click();
                        driver.switchTo().alert().accept();
                        break;
                    }
                    j++;
                }
                break;
            }
            i++;
        }
    }

    public void addItemToWishlist(String itemName){
        WebElement newItemField = driver.findElement(By.xpath("//input[@id='name']"));
        newItemField.sendKeys(itemName);
        WebElement submitItem = driver.findElement(By.xpath("//button[@id='submitWishlist']"));
        submitItem.click();
    }
}
