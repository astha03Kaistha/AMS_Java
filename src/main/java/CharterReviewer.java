import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CharterReviewer {

    public static void TopicApproval(WebDriver driver) throws InterruptedException {
    	Thread.sleep(3000);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        // Wait for and click the "Charter" element
        WebElement charterElement = wait.until(ExpectedConditions.elementToBeClickable(By.id("Charter")));
        charterElement.click();
        
        Thread.sleep(4000);
        // Wait for the checkbox to be clickable and click it
        driver.findElement(By.xpath("(//input[@id='topic__checkbox'])[2]")).click();
        
        // Wait for the "Approve" button to be clickable and click it
        WebElement approveButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//button[normalize-space()='Approve'])[1]")));
        approveButton.click();

        // Optional: wait for some condition after clicking Approve (if needed)
        // For example, wait until some confirmation appears or button gets disabled.
    }
}
