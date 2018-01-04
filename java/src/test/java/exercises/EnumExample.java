package exercises;

public class EnumExample {

    public enum BootCampDays{
        DAYONE,
        DAYTWO;
    }

    public static String checkBootCampDaysInfo(BootCampDays bootCampDays){
        switch(bootCampDays){
            case DAYONE: default:
                return "This is day one";
            case DAYTWO:
                return "This is day two";
        }
    }
}
