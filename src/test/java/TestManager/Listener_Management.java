package TestManager;

import org.testng.*;

public class Listener_Management implements ITestListener, IInvokedMethodListener, ISuiteListener {

    /**-- Test Listeners--**/
    public void onTestStart(ITestResult iTestResult) {

        //System.out.println("A");
    }

    public void onTestSuccess(ITestResult iTestResult) {
        //System.out.println("B");
        System.out.println("----> " + iTestResult.getMethod().getMethodName() + " passed");
    }

    public void onTestFailure(ITestResult iTestResult) {
        //System.out.println("C");
        System.out.println("----> " + iTestResult.getMethod().getMethodName() + " failed");
    }

    public void onTestSkipped(ITestResult iTestResult) {

        //System.out.println("D");
    }

    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {

        //System.out.println("E");
    }

    public void onStart(ITestContext iTestContext) {
        //System.out.println("F");
    }

    public void onFinish(ITestContext iTestContext) {

        //System.out.println("G");
    }

    /**-- Methods Listeners--**/

    public void beforeInvocation(IInvokedMethod iInvokedMethod, ITestResult iTestResult) {
        //System.out.println("H");
        if(!iInvokedMethod.isConfigurationMethod()) {
            System.out.println("----> " + iInvokedMethod.getTestMethod().getMethodName() + " started");
        }
    }

    public void afterInvocation(IInvokedMethod iInvokedMethod, ITestResult iTestResult) {
        //System.out.println("I");
        if(!iInvokedMethod.isConfigurationMethod()) {
            System.out.println("----> " + iInvokedMethod.getTestMethod().getMethodName() + " completed");
        }
    }

    /**-- Suite Listeners--**/
    public void onStart(ISuite iSuite) {

        //System.out.println("J");
    }

    public void onFinish(ISuite iSuite) {

        //System.out.println("K");
    }
}
