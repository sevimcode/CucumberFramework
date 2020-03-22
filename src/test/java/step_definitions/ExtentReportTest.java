package step_definitions;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class ExtentReportTest{


    public static void main( String[] args ) {

        //formatting - configuring  our report
        ExtentHtmlReporter configs = new ExtentHtmlReporter ("./extentReport/report.html");
     //  configs.config ().setTheme (Theme.DARK); //showing dark html report

        ExtentReports reports = new ExtentReports ();
        reports.attachReporter (configs);

        System.out.println ("Start test");

        ExtentTest extentTest = reports.createTest ("Google Search");
        extentTest.pass ("it is passing");
        extentTest.fail ("didn't match FAIL!");

        reports.flush ();
        System.out.println ("Completed");


    }
}