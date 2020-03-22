package utilities;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Log{

   private static Logger logger = LogManager.getLogger (Log.class);

    public static void start(String testName){ // it will give the scanario name in the log we configured it in hooks

        logger.info ("Scenario start point : " + testName);

    }


   public static void info(String message){

       logger.info (message);

   }

    public static void warn(String message){

        logger.warn (message);

    }

    public static void error(String message){

        logger.error(message);

    }
}
