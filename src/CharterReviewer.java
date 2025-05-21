import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CharterReviewer {

	public static void TopicApproval(WebDriver driver) throws InterruptedException {
		Thread.sleep(2000);
		driver.findElement(By.id("Charter")).click();
		Thread.sleep(4000);
		driver.findElement(By.xpath("(//input[@id='topic__checkbox'])[2]")).click();
	    driver.findElement(By.xpath("(//button[normalize-space()='Approve'])[1]")).click();
	    Thread.sleep(2000);
}

}