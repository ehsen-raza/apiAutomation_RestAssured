package TestSpecs.TrelloAPI;

import TestManager.Listener_Management;
import TestManager.Scheduler;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.io.File;
import java.io.PrintStream;
import java.io.StringWriter;

import static io.restassured.RestAssured.given;


@Listeners(Listener_Management.class)
public class Cards_Verification extends Scheduler {

    /**
     * This test case is getting trello card with id
     */
    @Test(priority = 0)
    public void Get_Cards_With_Id(){
        File file = new File("./src/test/resources/Schemas/Get_Cards_With_Id.json");

        report_manager.Init_Test("Get_Cards_With_Id", "This test case is getting trello board card with id");
        Response response =
                given()
                        .header("Content-type","application/json")
                        .param("key","3d1717ceaa784c50b3c10c5f96169e0e")
                        .param("token","5ec3fdc3b4c7f040c8434583d73d3342fb7e81e233dc38a33d7ce91a95f8d197")
                        .when()
                        //.get("/1/cards/548ab02392d848481f61f6f4")
                        .get("/1/cards/54b629fe6ec02c5340f46823")
                        .then()
                        .assertThat()
                        .contentType(ContentType.JSON)
                        .and()
                        .statusCode(200)
                        .extract()
                        .response();

        report_manager.LogStepInfo(response.body().asString());

        response.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(file));

    }

    /**
    @Test
    public void extractSingleValue_findSingleTeamName_responseAsString() {
        String responseAsString = get("teams/66").asString();
        String teamName = JsonPath.from(responseAsString).get("name");
        System.out.println(teamName);
    }*/
}
