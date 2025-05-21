import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class Contract {
	
	
	
	public static void ContractSigning (WebDriver driver) throws InterruptedException {
		Thread.sleep(2000);
		driver.findElement(By.partialLinkText("M/MAN/24-25/")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@id='simple-tab-1']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@value='false']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//label[normalize-space()='Digital Agreement and Questionnaire']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[normalize-space()='Next']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[normalize-space()='Fill Responses']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//textarea[@placeholder='Enter your answer']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//textarea[@placeholder='Enter your answer']")).sendKeys("My name is ABCXYZ");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[5]//div[2]//button[1]//*[name()='svg']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@value='Awesome']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[normalize-space()='Next']")).click();
		Thread.sleep(4000);
		WebElement canvas = driver.findElement(By.className("c21LGjHQTNdasu0JdupM"));
		Thread.sleep(3000);
		Actions actions = new Actions(driver);
		actions.moveToElement(canvas, -90, -90).clickAndHold().moveByOffset(20, 80).moveByOffset(80, 30).moveByOffset(20, 90).release().build().perform();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[normalize-space()='Generate OTP']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@id='otp-field-0']")).sendKeys("9999");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[@id='agree']")).click();
		Thread.sleep(7000);
		driver.findElement(By.xpath("//button[normalize-space()='Apply']")).click();
		Thread.sleep(2000);		
		driver.findElement(By.xpath("//button[normalize-space()='Apply']")).click();
		Thread.sleep(2000);
	}

}
