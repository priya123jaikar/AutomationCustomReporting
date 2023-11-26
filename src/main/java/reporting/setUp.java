package reporting;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import org.testng.ITestListener;

//here we will setup our base configuration when I start executing my test cases
//this setup will implement one interface given by testNg  called ITestListener
public class setUp implements ITestListener {
    private  static  ExtentReports extentReports;

    //Actually when we run the test cases so we need to append the test case  , so that report will show me okay these are the test cases we have executed
    //so for that we have extent test class which  represents one test class. When we are running the test case in parallel or may be we are using two threads so
    //that two threads will be executing two test cases and that will be run in parallel. So we need to ensure that the data or both the test cases should not be overlapped.
    //so have some mechanism to separate or distinguish like which thread is running which test cases. so for that case we can use thread local because it help us to keep the execution separately for two different threads.


    public  static  ThreadLocal<ExtentTest> extentTest = new ThreadLocal<>();
    public void onStart(org.testng.ITestContext context) {
        String fileName = ExtentReportManager.getReportNameWithTimeStamp();
        String fullReportPath = System.getProperty("user.dir") + "\\reports\\" + fileName;
        extentReports =  ExtentReportManager.createInstance(fullReportPath, "Test API Automation Report" , "Test ExecutionReport");
    }

    public void onFinish(org.testng.ITestContext context) {
        if(extentReports != null)
            extentReports.flush();
    }

    public void onTestStart(org.testng.ITestResult result) {
        ExtentTest test = extentReports.createTest("Test Name" + result.getTestClass().getName() + " -" + result.getMethod().getMethodName()); //this will give automatic package/method name
        extentTest.set(test);

    }
}
