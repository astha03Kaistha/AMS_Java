import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Utility.StepUtils;

import java.time.Duration;

public class Event {

	private static WebDriverWait getWait(WebDriver driver) {
		return new WebDriverWait(driver, Duration.ofSeconds(20));
	}

	private static void waitForLoaderToDisappear(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("div[data-testid='loading']")));
	}

	public static void EventCreation(WebDriver driver) throws Exception {
		StepUtils.moduleName = "Event";
		WebDriverWait wait = getWait(driver);
		Actions actions = new Actions(driver);

		StepUtils.runStep(driver, "<b>Event_NewEvents</b> - Click New Events tab", "Unable to click New Events tab",
				() -> wait.until(
						ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(text(),'New Events')]")))
						.click());

		StepUtils.runStep(driver, "<b>Event_TopicInput</b> - Search By Topic Name", "Unable to search topic name",
				() -> {
					Thread.sleep(1000);
					WebElement topicInput = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
							"//input[contains(@class, 'MuiInputBase-input') and contains(@class, 'MuiOutlinedInput-input')]")));
					topicInput.click();
					topicInput.sendKeys(Constants.TopicName);
				});

		StepUtils.runStep(driver, "<b>Event_ApplyFilter</b> - Click Apply button", "Unable to click Apply button",
				() -> wait.until(
						ExpectedConditions.elementToBeClickable(By.xpath("(//button[normalize-space()='Apply'])[1]")))
						.click());

		StepUtils.runStep(driver, "<b>Event_AddHCP</b> - Click Add HCP button", "Unable to click Add HCP button",
				() -> wait.until(
						ExpectedConditions.elementToBeClickable(By.xpath("(//button[normalize-space()='Add HCP'])[1]")))
						.click());

		StepUtils.runStep(driver, "<b>Event_HCPInput</b> - Enter HCP Number", "Unable to enter HCP number", () -> {
			WebElement hcpInput = wait
					.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@id='hcp'])[1]")));
			hcpInput.click();
			hcpInput.sendKeys("295075");
			wait.until(ExpectedConditions.elementToBeClickable(By.id("hcp-option-0"))).click();
		});

		StepUtils.runStep(driver, "<b>Event_SelectTentativeDate</b> - Select Tentative Date",
				"Unable to select tentative date", () -> {
					wait.until(ExpectedConditions.elementToBeClickable(By.name("tentativeDate"))).click();
					Thread.sleep(1000);
					driver.findElement(By.xpath("//button[@class='rdrNextPrevButton rdrNextButton']")).click();
					driver.findElement(By.xpath("(//span[@class='rdrDayNumber'])[15]")).click();
				});

		StepUtils.runStep(driver, "<b>Event_HonorariumInput</b> - Enter Honorarium Amount",
				"Unable to enter honorarium", () -> {
					WebElement honorariumInput = wait
							.until(ExpectedConditions.elementToBeClickable(By.name("honorarium")));
					honorariumInput.click();
					honorariumInput.sendKeys("323");
				});
		StepUtils.runStep(driver,
				"<b>Event_AddHCPWithScrollAndLoader</b> - Scroll, wait for loader, click Add HCP and wait again",
				"Unable to complete combined Add HCP flow", () -> {
					actions.sendKeys(Keys.PAGE_DOWN).perform();
					waitForLoaderToDisappear(driver);
					wait.until(
							ExpectedConditions.elementToBeClickable(By.xpath("//button[normalize-space()='Add HCP']")))
							.click();
					waitForLoaderToDisappear(driver);
				});

		StepUtils
				.runStep(driver, "<b>Event_SubmitForApproval</b> - Click Submit for Approval",
						"Unable to submit for approval",
						() -> wait.until(ExpectedConditions
								.elementToBeClickable(By.xpath("//button[normalize-space()='Submit for Approval']")))
								.click());

		StepUtils.runStep(driver, "<b>Event_ConfirmSubmission</b> - Confirm submission popup",
				"Unable to confirm submission", () -> {
					actions.sendKeys(Keys.TAB).perform();
					actions.sendKeys(Keys.TAB).perform();
					actions.sendKeys(Keys.ENTER).perform();
					Thread.sleep(1000);
				});
	}

	public static void EventSearch(WebDriver driver) throws Exception {
		StepUtils.moduleName = "Event";
		WebDriverWait wait = getWait(driver);
		Actions actions = new Actions(driver);

		StepUtils.runStep(driver, "<b>Event_clickSearchByFilterDropdown</b> - Open search filter dropdown and select option",
			    "Unable to open and select search filter option",
			    () -> {
			        wait.until(ExpectedConditions
			            .elementToBeClickable(By.xpath("//div[@id='mui-component-select-searchByHcp']"))).click();
			        actions.sendKeys(Keys.ARROW_UP).perform();
			        actions.sendKeys(Keys.ENTER).perform();
			    });


		StepUtils.runStep(driver, "<b>Event_SearchByTopic</b> - Enter search term", "Unable to enter search term",
				() -> {
					actions.sendKeys(Keys.TAB).perform();
					//need to implement apply instead of enter perform - pending task
					actions.sendKeys(Constants.TopicName).perform();
					Thread.sleep(2000);
					actions.sendKeys(Keys.ENTER).perform();
				});
	}

	public static void EventApproval(WebDriver driver) throws Exception {
		StepUtils.moduleName = "Event";
		Actions actions = new Actions(driver);

		StepUtils.runStep(driver, "<b>Event_OpenApprovalLink</b> - Click approval link",
				"Unable to click approval link", () -> driver.findElement(By.partialLinkText("M/MAN/25-26/")).click());

		StepUtils.runStep(driver, "<b>Event_ApproveEvent</b> - Scroll, click Approve and wait",
			    "Failed to approve event after scrolling",
			    () -> {
			        actions.sendKeys(Keys.PAGE_DOWN).perform();
			        driver.findElement(By.xpath("//button[normalize-space()='Approve']")).click();
			        Thread.sleep(2000);
			    });

	}

	public static void EventClaim(WebDriver driver) throws Exception {
		StepUtils.moduleName = "Event";
		WebDriverWait wait = getWait(driver);
		Actions actions = new Actions(driver);

		StepUtils.runStep(driver, "<b>Event_ClickClaim</b> - Click Claim button", "Unable to click Claim button",
				() -> wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Claim']")))
						.click());

		StepUtils.runStep(driver, "<b>Event_ConfirmClaim</b> - Confirm claim via keyboard", "Unable to confirm claim",
				() -> {
					actions.sendKeys(Keys.TAB).perform();
					actions.sendKeys(Keys.TAB).perform();
					actions.sendKeys(Keys.ENTER).perform();
				});
	}

	public static void Filter(WebDriver driver) throws Exception {
		StepUtils.moduleName = "Event";
		WebDriverWait wait = getWait(driver);
		Actions actions = new Actions(driver);

		StepUtils.runStep(driver, "<b>Filter_OpenStatusMenuDropdown</b> - Open status dropdown",
				"Unable to open status dropdown",
				() -> wait.until(
						ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='mui-component-select-status']")))
						.click());

		StepUtils.runStep(driver, "<b>Filter_SelectAllAndClose</b> - Select 'All' status and close dropdown",
			    "Unable to select 'All' status and close dropdown",
			    () -> {
			        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[normalize-space()='All']"))).click();
			        actions.sendKeys(Keys.ESCAPE).perform();
			    });


		StepUtils.runStep(driver, "<b>Filter_ApplyFilters</b> - Click Apply button", "Unable to click Apply button",
				() -> wait
						.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[normalize-space()='Apply']")))
						.click());
	}
}
