package loggerUtility;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LoggerUtility {
    private static Logger logger = LogManager.getLogger();

    // Start Test
    public static void startTest(String testName){
        logger.info("===== Execution started: " + testName + " =====");
    }

    // Info Step
    public static void infoLog(String message){
        logger.info(message);
    }

    // Error Step

    // Finish Test
    public static void finishTest(String testName){
        logger.info("===== Execution finished: " + testName + " =====");
    }


}
