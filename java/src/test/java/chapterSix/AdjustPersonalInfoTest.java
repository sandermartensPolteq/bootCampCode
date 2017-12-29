package chapterSix;

import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AdjustPersonalInfoTest extends TestShopScenario {

    String url = "https://techblog.polteq.com/testshop/index.php";
    String mail = "sander.martens+webshop1@polteq.com";
    String password = "Test1234!";

    @BeforeMethod
    @Override
    public void setUp() {
        super.setUp();
    }

    @Test
    public void personalInfo(){

        //Maximize browser window
        driver.manage().window().maximize();

        //Log in
        driver.findElement(By.className("login")).click();
        driver.findElement(By.id("email")).sendKeys(mail);
        driver.findElement(By.id("passwd")).sendKeys(password);
        driver.findElement(By.id("SubmitLogin")).click();

        //Names from creation account
        String first = "Sander";
        String last = "Martens";

        //Go to persional info
        WebElement loginName = driver.findElement(By.className("account"));
        loginName.click();
        WebElement myPersonalInfoButton = driver.findElement(By.xpath("//span[text()='My personal information']"));
        myPersonalInfoButton.click();

        //Check & switch
        switchName(first, last);

        //Fill in the password
        WebElement password = driver.findElement(By.xpath("//input[@id='old_passwd']"));
        password.sendKeys("Test1234!");

        //Save button
        WebElement saveButton = driver.findElement(By.name("submitIdentity"));
        saveButton.click();
    }

    public void switchName(String name1, String name2){
        WebElement firstname = driver.findElement(By.xpath("//input[@id='firstname']"));
        WebElement lastname = driver.findElement(By.xpath("//input[@id='lastname']"));

        if( firstname.getAttribute("value").equals(name1)){
            firstname.clear();
            firstname.sendKeys(name2);
        }else if( firstname.getAttribute("value").equals(name2)){
            firstname.clear();
            firstname.sendKeys(name1);
        }
    }
}
