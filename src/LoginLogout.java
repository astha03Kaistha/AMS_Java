import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class LoginLogout {

	public static void PageLaunch(WebDriver driver, String url) throws InterruptedException {
		
		Thread.sleep(1000);
		driver.manage().window().maximize();
		driver.get((url));
		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());
		Thread.sleep(2000);
	}
	
	public static void Login(WebDriver driver, String userId, String password) throws InterruptedException{
		//driver.findElement(By.className("MuiButtonBase-root")).click();
		
		Thread.sleep(2000);
		driver.findElement(By.className("MuiButtonBase-root")).click();
		Thread.sleep(3000);
		driver.findElement(By.id("username")).sendKeys(userId);
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(3000);
		driver.findElement(By.id("password")).sendKeys(password);
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(10000);
	}
	
//	public static void Logout(WebDriver driver) throws InterruptedException{
//		Thread.sleep(2000);
//		driver.findElement(By.xpath("(//button[@class='MuiButtonBase-root MuiIconButton-root MuiIconButton-sizeMedium css-1yxmbwk'])[1]")).click();
//		Thread.sleep(1000);
//		driver.findElement(By.xpath("//p[@class='MuiTypography-root MuiTypography-body1 css-whuzxp']")).click();
//		Thread.sleep(2000);
//		
//		// Wait for the alert to appear
//	    Actions actions = new Actions(driver);
//	    //actions.click().perform();
//		actions.sendKeys(Keys.TAB ).perform();
//		Thread.sleep(1000);
//		actions.sendKeys(Keys.TAB).perform();
//		Thread.sleep(3000);
//	    actions.sendKeys(Keys.ENTER).perform();
//	    Thread.sleep(2000);
//	}
	    
	public static void LogoutwithSearch(WebDriver driver) throws InterruptedException{
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("svg[xmlns='http://www.w3.org/2000/svg'][width='20']")).click();
//		driver.findElement(By.xpath("//button[@type='button'])[2]")).click();
//		driver.findElement(By.className("MuiButtonBase-root MuiIconButton-root MuiIconButton-sizeMedium css-1yxmbwk")).click();
//		driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[2]/div[8]/main[1]/div[1]/div[1]/div[2]/div[1]/button[2]/*[name()='svg'][1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//p[@class='MuiTypography-root MuiTypography-body1 css-whuzxp']")).click();	
		Thread.sleep(2000);
		
		// Wait for the alert to appear
	    Actions actions = new Actions(driver);
		    //actions.click().perform();
		actions.sendKeys(Keys.TAB ).perform();
		Thread.sleep(1000);
		actions.sendKeys(Keys.TAB).perform();			
		Thread.sleep(3000);
		actions.sendKeys(Keys.ENTER).perform();
		Thread.sleep(2000);


	}
	}
