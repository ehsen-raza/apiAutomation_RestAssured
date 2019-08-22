package TestSpecs.TrelloAPI;

import TestManager.Scheduler;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;

public class Boards_Verification extends Scheduler{

    /**
     * This is configuration method and always run before class execution
     */
    @BeforeClass
    public void Test_Configuration(){
        RestAssured.baseURI = "https://api.trello.com";
    }

    /**
     * This test case is getting trello board with name & id
     */
    @Test (priority = 1, enabled = true )
    public void Get_Board_With_Name(){
    report_manager.Init_Test("Get_Board_With_Name", "This test case is getting trello board with name & id");
    Response response =
        given()
                    .header("Content-type","application/json")
                    .param("fields","name")
                    .param("key","3d1717ceaa784c50b3c10c5f96169e0e")
                    .param("token","5ec3fdc3b4c7f040c8434583d73d3342fb7e81e233dc38a33d7ce91a95f8d197")
            .when()
                    .get("/1/boards/5c9c6666ec341c09aea1ac97")
            .then()
                    .assertThat()
                    .contentType(ContentType.JSON)
                    .and()
                    .statusCode(200)
                    .extract()
                    .response();
        System.out.println(response.body().asString());
        report_manager.LogStepInfo(response.body().asString());
        assert response.body().jsonPath().getString("id").equalsIgnoreCase("5c9c6666ec341c09aea1ac97") : "Board ID mismatch";
        assert response.body().jsonPath().getString("name").equalsIgnoreCase("Automation Training Courses") : "Name mismatch";
    }

    /**
     * This test case is getting trello board complete details
     */
    @Test (priority = 0)
    public void Get_Board_With_All(){
        report_manager.Init_Test("Get_Board_With_All", "This test case is getting trello board complete details");
        Response response =
                given()
                        .header("Content-type","application/json")
                        .param("fields","all")
                        .param("key","3d1717ceaa784c50b3c10c5f96169e0e")
                        .param("token","5ec3fdc3b4c7f040c8434583d73d3342fb7e81e233dc38a33d7ce91a95f8d197")
                        .when()
                        .get("/1/boards/5c9c6666ec341c09aea1ac97")
                        .then()
                        .assertThat()
                        .contentType(ContentType.JSON)
                        .and()
                        .statusCode(200)
                        .extract()
                        .response();
        System.out.println(response.body().asString());
        report_manager.LogStepInfo(response.body().asString());
        //assert response.body().jsonPath().getString("id").equalsIgnoreCase("5c9c6666ec341c09aea1ac97") : "Board ID mismatch";
        //assert response.body().jsonPath().getString("name").equalsIgnoreCase("Automation Training Courses") : "Name mismatch";
    }
}
