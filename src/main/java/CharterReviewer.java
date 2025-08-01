import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import Utility.StepUtils;

import java.time.Duration;

public class CharterReviewer {

	private static WebDriverWait getWait(WebDriver driver) {
		return new WebDriverWait(driver, Duration.ofSeconds(15));
	}

	@Test
	public static void TopicApproval(WebDriver driver) throws Exception {
		StepUtils.moduleName = "CharterReviewer"; // Set module name

		WebDriverWait wait = getWait(driver);

		StepUtils.runStep(driver, "<b>CharterReviewer_Click</b> - Click Charter menu", "Charter menu not clicked",
				() -> wait.until(ExpectedConditions.elementToBeClickable(By.id("Charter"))).click());

		StepUtils.runStep(driver, "<b>CharterReviewer_Checkbox</b> - Select Topic checkbox",
				"Topic checkbox not selected", () -> {
					Thread.sleep(2000); // brief wait for table to load
					driver.findElement(By.xpath("(//input[@id='topic__checkbox'])[2]")).click();
				});

		StepUtils.runStep(driver, "<b>CharterReviewer_Approve</b> - Click Approve button", "Approve button not clicked",
				() -> {
					WebElement approveButton = wait.until(ExpectedConditions
							.elementToBeClickable(By.xpath("(//button[normalize-space()='Approve'])[1]")));
					approveButton.click();
					Thread.sleep(2000); // Optional: wait for approval to process
				});
	}
}
