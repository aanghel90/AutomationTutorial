package loggerUtility;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LoggerUtility {
    private static Logger logger = LogManager.getLogger();

    // Start Test
    public static void startTest(String testName){
        logger.info(Thread.currentThread().getName() + " ===== Execution started: " + testName + " =====");
    }

    // Info Step
    public static void infoLog(String message){
        logger.info(Thread.currentThread().getName() + " " + message);
    }

    // Error Step
    public static void errorLog(String message){
        logger.error(Thread.currentThread().getName() + " " + message);
    }

    // Finish Test
    public static void finishTest(String testName){
        logger.info(Thread.currentThread().getName() + " ===== Execution finished: " + testName + " =====");
    }


}
