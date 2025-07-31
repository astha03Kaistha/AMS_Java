import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import Utility.ConfigValues;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

public class OldLoginLogout {

	static String ModuleName = "LoginLogout";

	@Test
	public static void PageLaunch(WebDriver driver, String url) {
		try {
			ConfigValues.TestCase = "<b>PageLaunch</b> - Verify page launch";
			ConfigValues.TestStartTime = getCurrentTimestamp();
			Thread.sleep(2000);
			driver.manage().window().maximize();
			driver.get(url);

			System.out.println(driver.getTitle());
			System.out.println(driver.getCurrentUrl());

			// Wait until page is fully loaded - you can add a better condition if needed
			new WebDriverWait(driver, Duration.ofSeconds(10))
					.until(webDriver -> ((String) ((org.openqa.selenium.JavascriptExecutor) webDriver)
							.executeScript("return document.readyState")).equals("complete"));
			ConfigValues.TestEndTime = getCurrentTimestamp();
		} catch (Exception e) {
			ConfigValues.takeScreenshot(driver, ModuleName);
		} finally {
			if (ConfigValues.TestEndTime == "") {
				ConfigValues.FailureReason = "page is not launched successfully.";
			}
			recordTestCase();
		}
	}

	@Test
	public static void Login(WebDriver driver, String userId, String password) throws InterruptedException {
		try {

			ConfigValues.TestCase = "<b>Login</b> - Verify the Login";
			ConfigValues.TestStartTime = getCurrentTimestamp();
			Thread.sleep(3000);
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

			wait.until(ExpectedConditions.elementToBeClickable(By.className("MuiButtonBase-root"))).click();

			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("username"))).sendKeys(userId);

			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@type='submit']"))).click();

			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("password"))).sendKeys(password);

			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@type='submit']"))).click();

			Thread.sleep(2000);
			ConfigValues.TestEndTime = getCurrentTimestamp();
			// Wait for some element or condition that shows login is successful, adjust as
			// per app
			// wait.until(ExpectedConditions.urlContains("events")); // Example: URL
			// contains 'dashboard' after login
		} catch (Exception e) {
			ConfigValues.takeScreenshot(driver, ModuleName);
		} finally {
			if (ConfigValues.TestEndTime == "") {
				ConfigValues.FailureReason = "Login button not clicked";
			}
			recordTestCase();
		}
	}

	/*
	 * // Uncomment and update this if you want to use Logout method with waits as
	 * well public static void Logout(WebDriver driver) { WebDriverWait wait = new
	 * WebDriverWait(driver, Duration.ofSeconds(15)); Actions actions = new
	 * Actions(driver);
	 * 
	 * wait.until(ExpectedConditions.elementToBeClickable(By.
	 * xpath("(//button[@class='MuiButtonBase-root MuiIconButton-root MuiIconButton-sizeMedium css-1yxmbwk'])[1]"
	 * ))).click(); wait.until(ExpectedConditions.elementToBeClickable(By.
	 * xpath("//p[@class='MuiTypography-root MuiTypography-body1 css-whuzxp']"))).
	 * click();
	 * 
	 * actions.sendKeys(Keys.TAB).perform();
	 * wait.until(ExpectedConditions.elementToBeClickable(By.tagName("body"))); //
	 * wait a bit to stabilize actions.sendKeys(Keys.TAB).perform();
	 * actions.sendKeys(Keys.ENTER).perform(); }
	 */
	@Test
	public static void LogoutwithSearch(WebDriver driver) throws InterruptedException {

		try {

			ConfigValues.TestCase = "<b>Logout</b> - Verify the Logout";
			ConfigValues.TestStartTime = getCurrentTimestamp();
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
			Actions actions = new Actions(driver);
			Thread.sleep(1000);
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//p[@id='Events']"))).click();
			Thread.sleep(1000);
			driver.findElement(By.cssSelector("svg[xmlns='http://www.w3.org/2000/svg'][width='20']")).click();
			Thread.sleep(500);
			wait.until(ExpectedConditions
					.elementToBeClickable(By.xpath("//p[@class='MuiTypography-root MuiTypography-body1 css-whuzxp']")))
					.click();

			actions.sendKeys(Keys.TAB).perform();
			wait.until(ExpectedConditions.elementToBeClickable(By.tagName("body"))); // brief wait to stabilize
			actions.sendKeys(Keys.TAB).perform();

			actions.sendKeys(Keys.ENTER).perform();
			Thread.sleep(3000);
			ConfigValues.TestEndTime = getCurrentTimestamp();
		} catch (Exception e) {
			ConfigValues.takeScreenshot(driver, ModuleName);
		} finally {
			if (ConfigValues.TestEndTime == "") {
				ConfigValues.FailureReason = "Logout failed";
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

}
