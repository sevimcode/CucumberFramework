package step_definitions;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import utilities.Driver;
import utilities.ExtentReport;
import utilities.Log;
import utilities.TemporaryStorage;

public class Hooks{  // hooks work on cucumber

    public static WebDriver driver;

    @Before   // before junit it runs before every test but before in cucumber before runs before scenario
    public void setup(Scenario scenario){

        TemporaryStorage.clearData (); // it is coming from util to clear up the previous data
        // anything that you want to run before every scenario

        Log.start(scenario.getName()); // we get our starting scenario name in the log

        ExtentReport.startTest(scenario.getName()); //starts the test
    }

    @After   // after in junit it runs after every test but after in cucumber before runs after scenario
    public void tearDown( Scenario scenario ){ // takes Scenario object

        System.out.println (scenario.getName ());  // it prints the scenario name
        System.out.println (scenario.getStatus ()); // prints PASSES or FAILED

        if (driver != null && scenario.isFailed ()){
            byte [] screenshot = (( TakesScreenshot ) Driver.getDriver ()).getScreenshotAs (OutputType.BYTES);
            scenario.embed (screenshot, "image/png");
            //you can get the screenshot as a file not a byte
        //   File file =  (( TakesScreenshot ) Driver.getDriver ()).getScreenshotAs (OutputType.FILE);
        // you can add file to the path and you can attach this file in the extentreport util
        //to see screenshot in the extent report

        }else{
            ExtentReport.pass();
        }

        Driver.quitDriver ();

    }


}
