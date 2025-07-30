import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class Questionnaire {

    public static void CreateQuestionnaire(WebDriver driver) throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        Actions actions = new Actions(driver);

        wait.until(ExpectedConditions.elementToBeClickable(By.id("Charter"))).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//p[normalize-space()='Approved']")).click();
        Thread.sleep(1000);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//body/div[@id='app']/div[@id='homePageTest']/div[@class='MuiStack-root css-1147ok6']/div[@class='MuiBox-root css-15i1vgz']/div[@class='MuiBox-root css-zntkl0']/div[@class='MuiBox-root css-1rr4qq7']/div[@class='MuiStack-root css-p9xda']/div[@class='MuiStack-root css-1ydnuod']/div[1]/div[2]/button[1]//*[name()='svg']"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='MuiCollapse-root MuiCollapse-vertical MuiCollapse-entered css-c4sutr']//div[@class='MuiStack-root css-1cu163h']//*[name()='svg']"))).click();
        List<WebElement> saveButtons = driver.findElements(By.xpath("(//button[normalize-space()='Save'])[1]"));

        if (!saveButtons.isEmpty()) {
            // Optional: wait explicitly before clicking
            WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(5));
            wait1.until(ExpectedConditions.elementToBeClickable(saveButtons.get(0))).click();
            System.out.println("'Save' button clicked.");
        } else {
            System.out.println("'Save' button not present, skipping click.");
        }

        
        // wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//button[normalize-space()='Save'])[1]"))).click();

        // Add short answer question
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[normalize-space()='Add New Question']"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[normalize-space()='Select Question Type']"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//span[normalize-space()='Short answer'])[1]"))).click();

        actions.sendKeys(Keys.TAB).perform();
        actions.sendKeys("What is your name?").perform();
//		driver.findElement(By.xpath("//p[normalize-space()='Save']")).click();

        // Add multiple selection question
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[normalize-space()='Add New Question']"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[normalize-space()='Select Question Type']"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[normalize-space()='Multiple selection']"))).click();

        actions.sendKeys(Keys.TAB).perform();
        actions.sendKeys("How is the demo going so far?").perform();
        actions.sendKeys(Keys.TAB).perform();
        actions.sendKeys("Amazing").perform();
        actions.sendKeys(Keys.TAB).perform();
        actions.sendKeys("Awesome").perform();

        driver.findElement(By.xpath("(//button[@type='button'])[13]")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//button[normalize-space()='Publish']")).click();

        actions.sendKeys(Keys.TAB).perform();
        actions.sendKeys(Keys.TAB).perform();
        actions.sendKeys(Keys.ENTER).perform();

        Thread.sleep(1000);
        // Wait and close questionnaire drawer
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='MuiButtonBase-root MuiIconButton-root MuiIconButton-colorPrimary MuiIconButton-sizeMedium css-vxw6j8']"))).click();
    }
}
