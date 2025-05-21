import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class Event {

	public static void EventCreation(WebDriver driver) throws InterruptedException {
		
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[contains(text(),'New Events')]")).click();
		Thread.sleep(3000);
		driver.findElement(By.id(":r4g:")).click();
		driver.findElement(By.id(":r4g:")).sendKeys(Constants.TopicName);
//		driver.findElement(By.xpath("(//input[@id=':r2g:'])[1]")).click();
//		Thread.sleep(3000);
//		driver.findElement(By.xpath("(//input[@id=':r2g:'])[1]")).sendKeys(Constants.TopicName);
//		Thread.sleep(2000);
		driver.findElement(By.xpath("(//button[normalize-space()='Apply'])[1]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//button[normalize-space()='Add HCP'])[1]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//input[@id='hcp'])[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//input[@id='hcp'])[1]")).sendKeys("295075");
		Thread.sleep(7000);
		// Hold the debugger for disappearing element, write in console:
		//setTimeout(()=>{debugger;}, 2000)
		//OR CTRL+SHFT+P > FOCUS > Rendering Emulate
		driver.findElement(By.id("hcp-option-0")).click();
		Thread.sleep(4000);
		driver.findElement(By.name("tentativeDate")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//span[@class='rdrDayNumber'])[33]")).click();
		Thread.sleep(1000);
		driver.findElement(By.name("honorarium")).click();
		driver.findElement(By.name("honorarium")).sendKeys("1000");
		Thread.sleep(1000);
		Actions actions = new Actions(driver);
		actions.sendKeys(Keys.PAGE_DOWN).perform();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[normalize-space()='Add HCP']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[normalize-space()='Submit for Approval']")).click();
		Thread.sleep(1000);
		actions.sendKeys(Keys.TAB).perform();
		actions.sendKeys(Keys.TAB).perform();
		actions.sendKeys(Keys.ENTER).perform();
		Thread.sleep(3000);
	}
	
	public static void EventSearch(WebDriver driver) throws InterruptedException {
		
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@id='mui-component-select-searchByHcp']")).click();
		Thread.sleep(2000);
		Actions actions = new Actions(driver);
		actions.sendKeys(Keys.ARROW_UP).perform();
		Thread.sleep(1000);
		actions.sendKeys(Keys.ENTER).perform();
		Thread.sleep(1000);
		actions.sendKeys(Keys.TAB).perform();
		Thread.sleep(1000);
		actions.sendKeys(Constants.TopicName).perform();
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(3000);
	}
		
	public static void EventApproval(WebDriver driver) throws InterruptedException {	
		Thread.sleep(2000);
		driver.findElement(By.partialLinkText("M/MAN/24-25/")).click();
		Thread.sleep(2000);
		Actions actions = new Actions(driver);
		actions.sendKeys(Keys.PAGE_DOWN).perform();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[normalize-space()='Approve']")).click();
		Thread.sleep(5000);
				
	}
	
	public static void EventClaim(WebDriver driver) throws InterruptedException {
		
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[text()='Claim']")).click();
		Thread.sleep(1000);
		Actions actions = new Actions(driver);
		    //actions.click().perform();
		actions.sendKeys(Keys.TAB ).perform();
		Thread.sleep(1000);
		actions.sendKeys(Keys.TAB).perform();
		Thread.sleep(3000);
	    actions.sendKeys(Keys.ENTER).perform();
		Thread.sleep(2000);
	}
	
	public static void Filter(WebDriver driver) throws InterruptedException {
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@id='mui-component-select-status']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//span[normalize-space()='All']")).click();
//		driver.findElement(By.xpath("(//input[@type='checkbox'])[1]")).click();
		Actions actions = new Actions(driver);
	    	//actions.click().perform();
		actions.sendKeys(Keys.ESCAPE ).perform();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[normalize-space()='Apply']")).click();
		Thread.sleep(2000);


		
		
	}
}
