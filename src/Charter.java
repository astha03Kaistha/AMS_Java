import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class Charter{

	public static void TopicCreation(WebDriver driver) throws InterruptedException {
	
		Thread.sleep(2000);
		driver.findElement(By.id("Charter")).click();
		Thread.sleep(4000);
		driver.findElement(By.xpath("//div[@class='MuiBox-root css-1x66lww']//button[@id='add__icon']")).click();
		Thread.sleep(3000);
		
		//Select Event Type
		driver.findElement(By.xpath("(//div[@id='select__event__type'])[2]")).click();
		Thread.sleep(2000);

		WebElement type = driver.findElement(By.xpath("//li[normalize-space(text())='Market Research']"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].value='Market Research'", type);
		Thread.sleep(1000);
		type.click();
		
		//Enter Topic name
		driver.findElement(By.xpath("(//textarea[@id='charter_text_area'])[2]")).sendKeys(Constants.TopicName);
		Thread.sleep(1500);
		//Enter HCP number
		driver.findElement(By.xpath("(//input[@id='hcp_number'])[2]")).sendKeys("10");
		Thread.sleep(1500);
		
		//Select Division
		driver.findElement(By.xpath("(//div[@id='select__division'])[2]")).click();
		Thread.sleep(2000);
		
		//Select Mankind Division
		WebElement divi = driver.findElement(By.xpath("(//span[normalize-space()='mankind'])[1]"));
		js.executeScript("arguments[0].value='mankind'", divi);
		Thread.sleep(3000);
		divi.click();
		
		//Select Specialty
		driver.findElement(By.xpath("(//div[@id='select__specialities'])[2]")).click();
		Thread.sleep(2000);
		WebElement spec = driver.findElement(By.xpath("//span[normalize-space()='All']"));
		js.executeScript("//span[normalize-space()='All']", spec);
		Thread.sleep(2000);
		spec.click();
	    
		WebElement button = driver.findElement(By.xpath("(//button[@id='save_btn'])"));
	        
	    // Create an Actions object
	    Actions actions = new Actions(driver);
	        
	    // Perform a click action
	    actions.click(button).perform();
	    Thread.sleep(2000);    
	    actions.click(button).perform();
	    Thread.sleep(3000);
		//driver.findElement(By.xpath("(//button[@id='save_btn'])")).click();
		//driver.findElement(By.xpath("(//button[@id='save_btn'])")).click();
	}
	
	
	
	public static void TopicSubmit(WebDriver driver) throws InterruptedException {
	    
		Thread.sleep(2000);	
	    driver.findElement(By.xpath("(//input[@id='topic__checkbox'])[2]")).click();
	    Thread.sleep(2000);
	    driver.findElement(By.xpath("(//button[normalize-space()='Submit for Approval'])[1]")).click();
	    Thread.sleep(3000);
	    
	        
	}
}
