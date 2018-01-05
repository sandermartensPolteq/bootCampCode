package api;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

public class opdracht2 {

    private int season = 2016;
    private String driver = "verstappen";

    @Test
    public void getApi(){
        when().get("http://ergast.com/api/f1/current/last/results.json")
                .then().statusCode(200);
    }

    @Test
    public void compareBody(){
        when().get("http://ergast.com/api/f1/2016/drivers/verstappen/results.json")
                .then().assertThat().body("MRData.RaceTable.driverId", equalTo("verstappen"));
    }

    @Test
    public void fixedPathParam(){
        given().pathParam("season",2016).when().get("http://ergast.com/api/f1/{season}/drivers/verstappen/results.json")
                .then().statusCode(200);
    }

    @Test
    public void variablePathParams(){
        given().when().get("http://ergast.com/api/f1/{season}/drivers/{driver}/results.json",season, driver)
                .then().statusCode(200);
    }
}
