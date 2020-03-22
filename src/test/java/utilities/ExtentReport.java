package utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import java.io.IOException;

public class ExtentReport{

    private static ExtentHtmlReporter configs;
    private static ExtentReports reports;
    private static ExtentTest extentTest;

    static{

        configs = new ExtentHtmlReporter ("./extentReport/report.html");
      //  configs.config ().setTheme (Theme.DARK);
        configs.config ().setDocumentTitle ("b14 Extent Report");
        reports = new ExtentReports ();
        reports.attachReporter (configs);
        reports.setSystemInfo ("username : ","B14" );
        reports.setSystemInfo ("environment :", "QA");
    }
public static void startTest (String testName){
        extentTest = reports.createTest (testName);
}
    public static void pass(){
        extentTest.pass ("PASS");
    }
    public static void fail() throws IOException {
        extentTest.fail("FAIL");
//        extentTest.fail ("message", MediaEntityBuilder
//                .createScreenCaptureFromPath ("path").build ()) ;
        //for adding screenshot to the extent report
        //put file path to hooks
    }
    public static void endReport(){
        reports.flush ();
    }
}
//We need to flush it in the very end not in the hooks
//we need to flush it to get report in the cukes runner @AfterClass is very end