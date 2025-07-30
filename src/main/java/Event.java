import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class Event {

	// 🔁 Reusable method to wait for any loading overlay to disappear
    private static void waitForLoaderToDisappear(WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(
            By.cssSelector("div[data-testid='loading']")));
    }
    
    public static void EventCreation(WebDriver driver) throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        Actions actions = new Actions(driver);

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(text(),'New Events')]"))).click();

        Thread.sleep(1000);
        WebElement topicInput = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[contains(@class, 'MuiInputBase-input') and contains(@class, 'MuiOutlinedInput-input')]")));
        topicInput.click();
        topicInput.sendKeys(Constants.TopicName);

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//button[normalize-space()='Apply'])[1]"))).click();

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//button[normalize-space()='Add HCP'])[1]"))).click();

        WebElement hcpInput = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@id='hcp'])[1]")));
        hcpInput.click();
        hcpInput.sendKeys("295075");

        // Wait until dropdown option appears and click
        wait.until(ExpectedConditions.elementToBeClickable(By.id("hcp-option-0"))).click();

        wait.until(ExpectedConditions.elementToBeClickable(By.name("tentativeDate"))).click();
        Thread.sleep(1000);
		driver.findElement(By.xpath("(//span[@class='rdrDayNumber'])[31]")).click();
//        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//span[@class='rdrDayNumber'])[33]"))).click();

        WebElement honorariumInput = wait.until(ExpectedConditions.elementToBeClickable(By.name("honorarium")));
        honorariumInput.click();
        honorariumInput.sendKeys("323");

        actions.sendKeys(Keys.PAGE_DOWN).perform();

        waitForLoaderToDisappear(driver);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[normalize-space()='Add HCP']"))).click();
        waitForLoaderToDisappear(driver);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[normalize-space()='Submit for Approval']"))).click();

        actions.sendKeys(Keys.TAB).perform();
        actions.sendKeys(Keys.TAB).perform();
        actions.sendKeys(Keys.ENTER).perform();
        Thread.sleep(1000);
    }

    public static void EventSearch(WebDriver driver) throws InterruptedException {
    	
    	Thread.sleep(2000);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        Actions actions = new Actions(driver);

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='mui-component-select-searchByHcp']"))).click();
        actions.sendKeys(Keys.ARROW_UP).perform();
        actions.sendKeys(Keys.ENTER).perform();
        actions.sendKeys(Keys.TAB).perform();
        actions.sendKeys(Constants.TopicName).perform();
        Thread.sleep(2000);
        actions.sendKeys(Keys.ENTER).perform();
        
    }

    public static void EventApproval(WebDriver driver) throws InterruptedException {
        Actions actions = new Actions(driver);
        Thread.sleep(1000);
        driver.findElement(By.partialLinkText("M/MAN/25-26/")).click();
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//button[normalize-space()='Approve']")).click();
        Thread.sleep(2000);
    }

    public static void EventClaim(WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        Actions actions = new Actions(driver);

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Claim']"))).click();

        actions.sendKeys(Keys.TAB).perform();
        actions.sendKeys(Keys.TAB).perform();
        actions.sendKeys(Keys.ENTER).perform();
    }

    public static void Filter(WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        Actions actions = new Actions(driver);

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='mui-component-select-status']"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[normalize-space()='All']"))).click();

        actions.sendKeys(Keys.ESCAPE).perform();

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[normalize-space()='Apply']"))).click();
    }
}
