import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PaymentAck {

	
public static void PaymentSign(WebDriver driver) throws InterruptedException {
    	
    	Thread.sleep(1000);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        Actions actions = new Actions(driver);

        // Click the contract link
        wait.until(ExpectedConditions.elementToBeClickable(By.partialLinkText("M/MAN/25-26/"))).click();

        // Click tab
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@id='simple-tab-1']"))).click();
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//label[normalize-space()='Payment Acknowledgement']"))).click();
        Thread.sleep(1500);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[normalize-space()='Signature']"))).click();
        Thread.sleep(500);
        WebElement canvas = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//canvas[@class='c21LGjHQTNdasu0JdupM']")));
        actions.moveToElement(canvas, -20, -40)
        .clickAndHold()
        .moveByOffset(30, 15)
        .moveByOffset(20, -10)
        .moveByOffset(-15, 20)
        .moveByOffset(-20, -15)
        .release()
        .build()
        .perform();
        
        
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[normalize-space()='Submit']"))).click();
        Thread.sleep(2000);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[normalize-space()='Apply']"))).click();
        System.out.println("Event has been successfully closed");
}	
}
