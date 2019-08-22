package Services;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class Report_Manager {

    private static ExtentReports extentReports = null;
    private static ExtentTest extentTest = null;

    public Report_Manager(){
        extentReports = new ExtentReports();
        ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("./src/main/resources/Reports/API_Automation.html");
        htmlReporter.setAppendExisting(false);
        extentReports.attachReporter(htmlReporter);
    }


    public void Set_Environment(){
        extentReports.setSystemInfo("User", System.getProperty("user.name"));
        extentReports.setSystemInfo("OS", System.getProperty("os.name"));
        extentReports.setSystemInfo("JDK", System.getProperty("java.version"));
    }

    public void Init_Test(String TestName, String TestDescription){
        extentTest = extentReports.createTest(TestName, TestDescription);
    }

    public void LogTestStep(boolean bStatus, String strTestStep)
    {
        if(bStatus)
        {
            extentTest.log(Status.PASS, strTestStep);
            System.out.println("Pass : " + strTestStep);
        }else
        {
            extentTest.log(Status.FAIL, strTestStep);
            System.out.println("Fail : " + strTestStep);
        }
    }
    public void LogStepInfo(String strTestStep)
    {
        if( extentTest !=null)
        {
            extentTest.log(Status.INFO, strTestStep);
            System.out.println(strTestStep);
        }
    }
    public void EndReport(){
        if(extentTest != null){
            extentReports.flush();
        }
    }


}
