import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class Contract {

    public static void contractSigning(WebDriver driver) throws InterruptedException {
    	
    	Thread.sleep(1000);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        Actions actions = new Actions(driver);

        // Click the contract link
        wait.until(ExpectedConditions.elementToBeClickable(By.partialLinkText("M/MAN/25-26/"))).click();

        // Click tab
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@id='simple-tab-1']"))).click();

        Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@value='false']")).click();
        // Select checkbox/input
//        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@value='false']"))).click();

        // Click on agreement label
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//label[normalize-space()='Digital Agreement and Questionnaire']"))).click();

        // Click 'Next'
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[normalize-space()='Next']"))).click();

        // Click 'Fill Responses'
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[normalize-space()='Fill Responses']"))).click();

        // Click and fill textarea
        WebElement answerBox = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//textarea[@placeholder='Enter your answer']")));
        answerBox.click();
        answerBox.sendKeys("My name is ABCXYZ");
        Thread.sleep(500);

        Thread.sleep(2000);
		driver.findElement(By.xpath("//div[5]//div[2]//button[1]//*[name()='svg']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@value='Awesome']")).click();
		
        // Click 'Next'
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[normalize-space()='Next']"))).click();
        Thread.sleep(1500);
        // Wait for canvas and perform drawing
        WebElement canvas = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("c21LGjHQTNdasu0JdupM")));
        actions.moveToElement(canvas, -90, -90)
               .clickAndHold()
               .moveByOffset(20, 80)
               .moveByOffset(80, 30)
               .moveByOffset(20, 90)
               .release()
               .build()
               .perform();

        // Generate OTP
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[normalize-space()='Generate OTP']"))).click();

        // Enter OTP
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='otp-field-0']"))).sendKeys("9999");

        // Click 'Agree'
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@id='agree']"))).click();

        // Click 'Apply' twice
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[normalize-space()='Apply']"))).click();
        Thread.sleep(1000);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[normalize-space()='Apply']"))).click();
    }
}
