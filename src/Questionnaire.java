import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class Questionnaire {

	
	public static void CreateQuestionnaire (WebDriver driver) throws InterruptedException {

		Thread.sleep(2000);
		driver.findElement(By.id("Charter")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//p[normalize-space()='Approved']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//body/div[@id='app']/div[@id='homePageTest']/div[@class='MuiStack-root css-1147ok6']/div[@class='MuiBox-root css-15i1vgz']/div[@class='MuiBox-root css-zntkl0']/div[@class='MuiBox-root css-1rr4qq7']/div[@class='MuiStack-root css-p9xda']/div[@class='MuiStack-root css-1ydnuod']/div[1]/div[2]/button[1]//*[name()='svg']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@class='MuiCollapse-root MuiCollapse-vertical MuiCollapse-entered css-c4sutr']//div[@class='MuiStack-root css-1cu163h']//*[name()='svg']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//button[normalize-space()='Save'])[1]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[normalize-space()='Add New Question']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[normalize-space()='Select Question Type']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//span[normalize-space()='Short answer'])[1]")).click();
		Thread.sleep(2000);
		Actions actions = new Actions(driver);
		Thread.sleep(1000);
		actions.sendKeys(Keys.TAB).perform();
		Thread.sleep(1000);
		actions.sendKeys("What is your name?").perform();
		driver.findElement(By.xpath("//p[normalize-space()='Save']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[normalize-space()='Add New Question']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[normalize-space()='Select Question Type']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[normalize-space()='Multiple selection']")).click();
		Thread.sleep(2000);
		actions.sendKeys(Keys.TAB).perform();
		Thread.sleep(1000);
		actions.sendKeys("How is the demo going so far?").perform();
		Thread.sleep(2000);
		actions.sendKeys(Keys.TAB).perform();
		Thread.sleep(1000);
		actions.sendKeys("Amazing").perform();
		Thread.sleep(1000);
		actions.sendKeys(Keys.TAB).perform();
		Thread.sleep(1000);
		actions.sendKeys("Awesome").perform();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//button[@type='button'])[13]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[normalize-space()='Publish']")).click();
		Thread.sleep(1000);
		actions.sendKeys(Keys.TAB).perform();
		Thread.sleep(500);
		actions.sendKeys(Keys.TAB).perform();
		Thread.sleep(500);
		actions.sendKeys(Keys.ENTER).perform();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@class='MuiButtonBase-root MuiIconButton-root MuiIconButton-colorPrimary MuiIconButton-sizeMedium css-vxw6j8']")).click();
		Thread.sleep(5000);
		}
}
