package chapterSix;

import org.testng.annotations.Test;

import java.lang.reflect.Array;
import java.util.List;

public class conditionExercises {

    @Test
    public void execute(){
        int[] ages = {19,21,64,65};
        for( int i=0; i<ages.length; i++){
            bootcampAgeChecker(ages[i]);
        }
    }

    public void bootcampAgeChecker(int age){
        if( age < 21 ){
            System.out.println("Deelnemer met de leeftijd van "+age+ " is te jong");
        } else if( age >= 65 ){
            System.out.println("Deelnemer met de leeftijd van "+age+ " is niet toegelaten, check bij de manager");
        } else if( age >= 21 ){
            System.out.println("Deelnemer met de leeftijd van "+age+ " is toegelaten");
        }
    }
}
