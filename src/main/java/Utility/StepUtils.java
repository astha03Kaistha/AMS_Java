package Utility;

import org.openqa.selenium.WebDriver;
import java.text.SimpleDateFormat;
import java.util.Date;

public class StepUtils {

    public static String moduleName = "";

//    public static void setModuleName(String name) {
//        moduleName = name;
//    }

    @FunctionalInterface
    public interface Step {
        void execute() throws Exception;
    }

    public static void runStep(WebDriver driver, String testCaseName, String failureMessage, Step step) {
        try {
            ConfigValues.TestCase = testCaseName;
            ConfigValues.TestStartTime = getCurrentTimestamp();
            step.execute();
            ConfigValues.TestEndTime = getCurrentTimestamp();
        } catch (Exception e) {
            ConfigValues.takeScreenshot(driver, moduleName);
            ConfigValues.FailureReason = failureMessage;
            System.out.println("Step failed: " + testCaseName);
            e.printStackTrace();
        } finally {
            recordTestCase();
        }
    }

    private static String getCurrentTimestamp() {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
    }

    private static void recordTestCase() {
        ConfigValues.generator.addTestCaseRow(moduleName, ConfigValues.TestCase, ConfigValues.TestStartTime,
                ConfigValues.TestEndTime, ConfigValues.FailureReason);
        ConfigValues.TestCase = "";
        ConfigValues.TestStartTime = "";
        ConfigValues.TestEndTime = "";
        ConfigValues.FailureReason = "";
    }
}
