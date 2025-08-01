import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import Utility.StepUtils;

import java.time.Duration;

public class LoginLogout {

    //static String ModuleName = "LoginLogout";

    @Test
    public static void PageLaunch(WebDriver driver, String url) {
    	StepUtils.moduleName = "LoginLogout";
    	 

        StepUtils.runStep(driver, "<b>PageLaunch</b> - Verify page launch", "Page did not launch successfully", () -> {
            Thread.sleep(2000);
            driver.manage().window().maximize();
            driver.get(url);

            System.out.println(driver.getTitle());
            System.out.println(driver.getCurrentUrl());

            new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(webDriver -> ((String) ((org.openqa.selenium.JavascriptExecutor) webDriver)
                    .executeScript("return document.readyState")).equals("complete"));
        });
    }

    @Test
    public static void Login(WebDriver driver, String userId, String password) {
    	
    	StepUtils.moduleName = "LoginLogout"; 

        StepUtils.runStep(driver, "<b>Login</b> - Verify the Login", "Login button not clicked or login failed", () -> {
            Thread.sleep(3000);
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

            wait.until(ExpectedConditions.elementToBeClickable(By.className("MuiButtonBase-root"))).click();
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("username"))).sendKeys(userId);
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@type='submit']"))).click();
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("password"))).sendKeys(password);
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@type='submit']"))).click();
            Thread.sleep(2000);
        });
    }

    @Test
    public static void LogoutwithSearch(WebDriver driver) {
    	StepUtils.moduleName = "LoginLogout"; 

        StepUtils.runStep(driver, "<b>Logout</b> - Verify the Logout", "Logout failed", () -> {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
            Actions actions = new Actions(driver);

            Thread.sleep(1000);
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//p[@id='Events']"))).click();
            Thread.sleep(1000);
            driver.findElement(By.cssSelector("svg[xmlns='http://www.w3.org/2000/svg'][width='20']")).click();
            Thread.sleep(500);
            wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//p[@class='MuiTypography-root MuiTypography-body1 css-whuzxp']"))).click();

            actions.sendKeys(Keys.TAB).perform();
            wait.until(ExpectedConditions.elementToBeClickable(By.tagName("body"))); // stabilize
            actions.sendKeys(Keys.TAB).perform();
            actions.sendKeys(Keys.ENTER).perform();

            Thread.sleep(3000);
        });
    }
}
