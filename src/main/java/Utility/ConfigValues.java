package Utility;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import Reports.CustomEmailableReport;

public class ConfigValues {
	public static CustomEmailableReport generator = new CustomEmailableReport();
	public static String TestCase = "";
	public static String TestStartTime = "";
	public static String TestEndTime = "";
	public static String FailureReason = "";
	
	public String moduleName = "";
	
	public static Map<String, String> failedTestScreenshots = new HashMap<>();
	
	public static void takeScreenshot(WebDriver driver, String testName) {
	    String folderPath = "E:\\AMS\\test-output\\Screenshots";
	    
 
	    File folder = new File(folderPath);
	    if (!folder.exists()) {
	        folder.mkdirs();
	    }
 
	    String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
	    String fileName = testName + "_" + timeStamp + ".png";
 
	    File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	    try {
	        File destination = new File(folderPath + File.separator + fileName);
	        Files.copy(srcFile.toPath(), destination.toPath());
	        System.out.println("📸 Screenshot saved: " + destination.getAbsolutePath());
 
	        // 🔥 Save the path in a map for report
	        ConfigValues.failedTestScreenshots.put(ConfigValues.TestCase, destination.getAbsolutePath());
	    } catch (IOException e) {
	        System.out.println("❌ Failed to save screenshot: " + e.getMessage());
	    }
	  
	}
}
