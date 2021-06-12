package logger;


import io.qameta.allure.Step;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestLogger {
    private static final Logger logger = LoggerFactory.getLogger(TestLogger.class);
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";


    public static Object[] getParametersByNewObject(Object[] parameters) {
        Object[] newObject = new Object[parameters.length];
        String temp;
        for (int i = 0; i < parameters.length; i++) {
            temp = ANSI_YELLOW + parameters[i] + ANSI_BLUE;
            newObject[i] = temp;
        }
        return newObject;
    }

    public static void reportDebugStep(String debugStepMessage, Object... parameters) {
        String message = String.format(new TestLogger() + " - " + debugStepMessage, parameters);
        logger.debug(String.format(debugStepMessage, getParametersByNewObject(parameters)));
        reportAllureStep(message);
    }

    public static void reportInfoStep(String debugStepMessage, Object... parameters) {
        String message = String.format(new TestLogger() + " - " + debugStepMessage, parameters);
        logger.info(String.format(debugStepMessage, getParametersByNewObject(parameters)));
        reportAllureStep(message);
    }

    public static void reportWarningStep(String debugStepMessage, Object... parameters) {
        String message = String.format(new TestLogger() + " - " + debugStepMessage, parameters);
        logger.warn(String.format(debugStepMessage, getParametersByNewObject(parameters)));
        reportAllureStep(message);
    }

    public static void reportErrorStep(String debugStepMessage, Object... parameters) {
        String message = String.format(new TestLogger() + " - " + debugStepMessage, parameters);
        logger.error(String.format(debugStepMessage, getParametersByNewObject(parameters)));
        reportAllureStep(message);
    }

    @Step("{0}")
    private static void reportAllureStep(String stepMessage) {
    }
}
