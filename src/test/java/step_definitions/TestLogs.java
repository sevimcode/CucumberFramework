package step_definitions;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import utilities.Log;

public class TestLogs{

    public static void main( String[] args ) {

        Logger logger = LogManager.getLogger (TestLogs.class); //put the class itself
        System.out.println ("Some test execution start");
        System.out.println ("going to dzone.com");
        logger.info ("on dzone.com"); //it is stored in the file
        System.out.println ("click on login button");
        logger.warn ("login into application "); // it is stored in file

//in Logs package under project you can see you log file mylogs.log
// if you log everything you will see your actions of your code execution

       Log.info ("Test finished"); // this is out utility method we don't want to create logger object
        //everytime we need to log

        // we need to give what specific scenario starting your message need to be proper message

    }

}
