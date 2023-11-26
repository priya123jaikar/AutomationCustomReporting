package reporting;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.markuputils.CodeLanguage;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ExtentReportManager {

    //we did two things here , we added dependency and we have initialized here extentSparkReporter and did some configuration
    //and in the extent report we need to attach that report and that extentReports we are returning it here so we can use it in our another code

    public  static  ExtentReports extentReports;
    public  static  ExtentReports  createInstance(String fileName , String reportName , String documentTitle){
        ExtentSparkReporter extentSparkReporter = new ExtentSparkReporter(fileName);
        extentSparkReporter.config().setReportName(reportName);
        extentSparkReporter.config().setDocumentTitle(documentTitle);
        extentSparkReporter.config().setTheme(Theme.DARK);
        extentSparkReporter.config().setEncoding("utf-8");
        extentReports = new ExtentReports();
        extentReports.attachReporter(extentSparkReporter);
        return extentReports;
    }

    public  static  String getReportNameWithTimeStamp(){
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy_MM_dd_HH_mm_ss");
        LocalDateTime localDateTime = LocalDateTime.now();
        String formattedTime = dateTimeFormatter.format(localDateTime);
        String reportName = "TestReport" + formattedTime + ".html";
        return  reportName;
    }

    public  static  void  logPassDetails(String log){
        setUp.extentTest.get().pass(MarkupHelper.createLabel(log, ExtentColor.GREEN));
    }
    public  static  void  logFailureDetails(String log){
        setUp.extentTest.get().fail(MarkupHelper.createLabel(log, ExtentColor.RED));
    }
    public  static  void  logInfoDetails(String log){
        setUp.extentTest.get().info(MarkupHelper.createLabel(log, ExtentColor.GREY));
    }
    public  static  void  logWarningDetails(String log){
        setUp.extentTest.get().warning(MarkupHelper.createLabel(log, ExtentColor.YELLOW));
    }

    public  static  void  logJson(String json){
        setUp.extentTest.get().info(MarkupHelper.createCodeBlock(json, CodeLanguage.JSON));
    }

}


//Now we need to think how can we actually use this feature so that my test case , when I run my test cases then extent report should be generated
//So there are actually multiple way we can do we can use some before annotation  or different base class where you are loading all these prerequisites.
//but one of the good way of implementing this is using testNg listeners
//testNg listeners is  an interface which have already some methods