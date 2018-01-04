package app;

public class AutoAdvanced {

    private String brand;
    private int force, engineRpm;

    public AutoAdvanced(String brand, int force, int engineRpm) {
        this.brand = brand;
        this.force = force;
        this.engineRpm = engineRpm;
        printTorque();
    }

    public  void printBrand(){
        System.out.println("Car brand " + brand);
    }

    public void printTorque(){
        int torque = (force * 5252)/engineRpm;
        System.out.println("The torque is " + torque);
    }

}
