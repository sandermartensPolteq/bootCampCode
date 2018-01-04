package chapterNine;

import com.beust.jcommander.internal.Console;

public class Auto {

    String brand, model, year;

    public void printBrand(String brand){
        System.out.println("Brand name is "+ brand);
    }

    public void printDoors(String door){
        System.out.println("Amount of doors is "+ door);
    }

    public void printMotorType(String motorType){
        System.out.println("Motor type is " + motorType);
    }

    public void printTorque(int force, int engineRpm){
        int torque = (force * 5252)/engineRpm;
        System.out.println("The torque is " + torque);
    }
}
