import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import Utility.ConfigValues;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

public class OldCharterCode1 {

	
	static String ModuleName = "Charter";

	// Utility method to create WebDriverWait
	private static WebDriverWait getWait(WebDriver driver) {
		return new WebDriverWait(driver, Duration.ofSeconds(20));
	}

	
	// 🔁 Reusable method to wait for any loading overlay to disappear
	private static void waitForLoaderToDisappear(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("div[data-testid='loading']")));
	}
@Test

	public static void TopicCreation(WebDriver driver) throws InterruptedException {


		WebDriverWait wait = getWait(driver);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		Actions actions = new Actions(driver);
		try {

			ConfigValues.TestCase = "<b>Charter_Click</b> - Verify the click on Charter text";
			ConfigValues.TestStartTime = getCurrentTimestamp();
			wait.until(ExpectedConditions.elementToBeClickable(By.id("Charter"))).click();
			ConfigValues.TestEndTime = getCurrentTimestamp();
		} catch (Exception e) {
			ConfigValues.takeScreenshot(driver, ModuleName);
		} finally {
			if (ConfigValues.TestEndTime == "") {
				ConfigValues.FailureReason = "Charter button not clicked";
			}
			recordTestCase();
		}

		try {
			ConfigValues.TestCase = "<b>Charter_Fill</b> - Verify the submission of Request_Unlock";
			ConfigValues.TestStartTime = getCurrentTimestamp();
			// Wait and click 'add__icon' button
			wait.until(ExpectedConditions
					.elementToBeClickable(By.xpath("//div[@class='MuiBox-root css-1x66lww']//button[@id='add__icon']")))
					.click();
			ConfigValues.TestEndTime = getCurrentTimestamp();

			System.out.println("pass");
			// Select Event Type dropdown
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[@id='select__event__type'])[2]")))
					.click();

			// Select 'Market Research' option
			WebElement type = wait.until(ExpectedConditions
					.elementToBeClickable(By.xpath("//li[normalize-space(text())='Market Research']")));
			js.executeScript("arguments[0].value='Market Research'", type);
			type.click();

			// Enter Topic name
			WebElement topicArea = wait.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("(//textarea[@id='charter_text_area'])[2]")));
			topicArea.sendKeys(Constants.TopicName);

			// Enter HCP number
			WebElement hcpNumber = wait
					.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@id='hcp_number'])[2]")));
			hcpNumber.sendKeys("10");

			// Select Division dropdown
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[@id='select__division'])[2]"))).click();

			// Select 'mankind' division
			WebElement divi = wait.until(
					ExpectedConditions.elementToBeClickable(By.xpath("(//span[normalize-space()='mankind'])[1]")));
			js.executeScript("arguments[0].value='mankind'", divi);
			divi.click();
			Thread.sleep(3000);
			waitForLoaderToDisappear(driver);

			// Select Specialty dropdown
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[@id='select__specialities'])[2]")))
					.click();

			waitForLoaderToDisappear(driver);
			// Select 'All' specialty
			WebElement spec = wait
					.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[normalize-space()='All']")));
			js.executeScript("arguments[0].value='All'", spec);
			spec.click();

			Thread.sleep(1000);
			WebElement button = driver.findElement(By.xpath("(//button[@id='save_btn'])"));

			// Create an Actions object
			// Perform a click action
			actions.click(button).perform();
			Thread.sleep(2000);
			actions.click(button).perform();
			Thread.sleep(3000);
		} catch (Exception e) {
			ConfigValues.takeScreenshot(driver, ModuleName);
		} finally {
			if (ConfigValues.TestEndTime == "") {
				ConfigValues.FailureReason = "Unable to create the topic while fetching data.";
			}
			recordTestCase();
		}

//		actions.sendKeys(Keys.TAB ).perform();
//		Thread.sleep(2000);
//        // Find Save button
//		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".MuiBackdrop-root")));
//		WebElement saveButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("save_btn")));
//		saveButton.click();
//
//		wait.until(ExpectedConditions.elementToBeClickable(By.id("save_btn"))).click();
//        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//button[@id='save_btn'])"))).click();
//        WebElement button1 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//button[@id='save_btn'])")));
//
//        // Click Save button twice using Actions
//        actions.click(button).perform();
//        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//button[@id='save_btn'])")));  // Wait for any possible processing
//        actions.click(button).perform();
	}
@Test
	public static void TopicSubmit(WebDriver driver) throws InterruptedException {
		try {
			ConfigValues.TestCase = "<b>Charter_Submit</b> - Verify Submit for Approval button";
			ConfigValues.TestStartTime = getCurrentTimestamp();
			Thread.sleep(2000);
			driver.findElement(By.xpath("(//input[@id='topic__checkbox'])[2]")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("(//button[normalize-space()='Submit for Approval'])[1]")).click();
			Thread.sleep(3000);
			ConfigValues.TestEndTime = getCurrentTimestamp();
		} catch (Exception e) {
			ConfigValues.takeScreenshot(driver, ModuleName);
		} finally {
			if (ConfigValues.TestEndTime == "") {
				ConfigValues.FailureReason = "Issue with checkbox related to created topic. ";
			}
			recordTestCase();
		}

	}

	private static String getCurrentTimestamp() {
		return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
	}

	private static void recordTestCase() {
		// ConfigValues.TestEndTime = getCurrentTimestamp();
		ConfigValues.generator.addTestCaseRow(ModuleName, ConfigValues.TestCase, ConfigValues.TestStartTime,
				ConfigValues.TestEndTime, ConfigValues.FailureReason);
		ConfigValues.TestCase = "";
		ConfigValues.TestStartTime = "";
		ConfigValues.TestEndTime = "";
		ConfigValues.FailureReason = "";

	}

//    public static void TopicSubmit(WebDriver driver) throws InterruptedException {
//        
//    	Thread.sleep(2000);
//    	
//    	WebDriverWait wait = getWait(driver);
//        try {
//            // First attempt
//            System.out.println("First attempt: trying to click the checkbox...");
//            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@id='topic__checkbox'])[2]"))).click();
//            System.out.println("Checkbox clicked successfully on first attempt!");
//        } catch (Exception e) {
//            System.out.println("First attempt failed: " + e.getMessage());
//            System.out.println("Retrying after 5 seconds...");
//            Thread.sleep(5000);
//
//            // Retry once after wait
//            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@id='topic__checkbox'])[2]"))).click();
//            System.out.println("Checkbox clicked successfully on retry!");
//            
//        // Click 'Submit for Approval' button
//        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//button[normalize-space()='Submit for Approval'])[1]"))).click();

}
