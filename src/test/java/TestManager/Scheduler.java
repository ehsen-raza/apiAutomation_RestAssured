package TestManager;

import Services.Report_Manager;
import io.restassured.RestAssured;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;


public class Scheduler {
    public static Report_Manager report_manager = new Report_Manager();

    @BeforeClass
    public void Project_Config(){
        report_manager.Set_Environment();
        RestAssured.baseURI = "https://api.trello.com";

    }

    @AfterSuite
    public void Project_End(){
        report_manager.EndReport();
    }
}
