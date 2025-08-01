import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import Utility.StepUtils;

import java.time.Duration;

public class Contract {

	@Test
	public static void contractSigning(WebDriver driver) throws InterruptedException {

		StepUtils.moduleName = "Contract";

		Thread.sleep(1000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		Actions actions = new Actions(driver);

		// Click the contract link
		StepUtils.runStep(driver, "<b>Event_Click</b> - Click Event", "Event not clicked",
				() -> wait.until(ExpectedConditions.elementToBeClickable(By.partialLinkText("M/MAN/25-26/"))).click());

		// Click tab
		StepUtils.runStep(driver, "<b>Tab_Click</b> - Click Documentation Tab", "Documentation Tab not clicked",
				() -> wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@id='simple-tab-1']")))
						.click());

		Thread.sleep(2000);

		StepUtils.runStep(driver, "<b>Agreement_SelectAndLabelClick</b> - Select agreement checkbox and click label",
				"Failed to select agreement and click label", () -> {
					driver.findElement(By.xpath("//input[@value='false']")).click();
					wait.until(ExpectedConditions.elementToBeClickable(
							By.xpath("//label[normalize-space()='Digital Agreement and Questionnaire']"))).click();
				});

		// Click 'Next'
		StepUtils.runStep(driver, "<b>Next_Click</b> - Click Next Button", "Next Button not clicked",
				() -> wait
						.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[normalize-space()='Next']")))
						.click());

		StepUtils.runStep(driver, "<b>Fill_ResponseFlow</b> - Fill response textarea and select option",
				"Failed to fill response and select answer", () -> {
					// Click 'Fill Responses' button
					wait.until(ExpectedConditions
							.elementToBeClickable(By.xpath("//button[normalize-space()='Fill Responses']"))).click();

					// Fill the textarea
					WebElement answerBox = wait.until(ExpectedConditions
							.elementToBeClickable(By.xpath("//textarea[@placeholder='Enter your answer']")));
					answerBox.click();
					answerBox.sendKeys("My name is ABCXYZ");
					Thread.sleep(500);

					// Click the icon (expand/next)
					Thread.sleep(2000);
					driver.findElement(By.xpath("//div[5]//div[2]//button[1]//*[name()='svg']")).click();

					// Select 'Awesome' option
					Thread.sleep(2000);
					driver.findElement(By.xpath("//input[@value='Awesome']")).click();
				});

		StepUtils.runStep(driver, "<b>Next_And_Esign</b> - Click Next and perform E-Signature",
				"Failed to click Next and perform E-Sign", () -> {
					// Click 'Next' button
					wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[normalize-space()='Next']")))
							.click();
					Thread.sleep(1500);

					// Perform E-Signature
					WebElement canvas = wait
							.until(ExpectedConditions.visibilityOfElementLocated(By.className("c21LGjHQTNdasu0JdupM")));
					actions.moveToElement(canvas, -90, -90).clickAndHold().moveByOffset(20, 80).moveByOffset(80, 30)
							.moveByOffset(20, 90).release().build().perform();
				});

		// Generate OTP
		StepUtils.runStep(driver, "<b>Generate_OTP</b> - OTP Generate", "OTP not Generated",
				() -> wait.until(
						ExpectedConditions.elementToBeClickable(By.xpath("//button[normalize-space()='Generate OTP']")))
						.click());

		// Enter OTP
		StepUtils.runStep(driver, "<b>Enter_OTP-OTP Authentication</b> - OTP Entered", "OTP not entered",
				() -> wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='otp-field-0']")))
						.sendKeys("9999"));

		StepUtils.runStep(driver, "<b>Submit_And_Apply</b> - Click Submit and Apply buttons",
				"Failed to click Submit and Apply buttons", () -> {
					// Click 'Submit' button
					wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@id='agree']"))).click();

					// Click 'Apply' button first time
					wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[normalize-space()='Apply']")))
							.click();

					// Wait before clicking 'Apply' second time
					Thread.sleep(1000);

					// Click 'Apply' button second time
					wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[normalize-space()='Apply']")))
							.click();
				});

	}
}
