package exercises;

import app.AutoAdvanced;
import chapterNine.Auto;
import org.testng.annotations.Test;

public class CarGame {

    @Test
    public void checkCar(){
        Auto auto = new Auto();
        auto.printBrand("BMW");
        auto.printDoors("4");
        auto.printMotorType("Diesel");
        auto.printTorque(2,5);
    }

    @Test
    public void checkBetterCar(){
        AutoAdvanced autoAdvanced = new AutoAdvanced("BMW", 5, 2);
        autoAdvanced.printBrand();
    }

}
