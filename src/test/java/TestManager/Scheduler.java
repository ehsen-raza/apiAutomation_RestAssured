package TestManager;

import Services.Report_Manager;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;


public class Scheduler {
    public static Report_Manager report_manager = new Report_Manager();

    @BeforeClass
    public void Project_Config(){
        report_manager.Set_Environment();


    }

    @AfterSuite
    public void Project_End(){
        report_manager.EndReport();
    }
}
