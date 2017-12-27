package exercises;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;

import java.util.logging.Logger;

public class AboutMethods {

    @Test
    public void printProduct(){
        System.out.println(multiply(10,20));
        Reporter.log(Integer.toString(multiply(10,10)));
    }

    private int multiply(int number1, int number2){
        return number1 * number2;
    }
}