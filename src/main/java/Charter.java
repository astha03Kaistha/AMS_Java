import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import Utility.StepUtils;

import java.time.Duration;

public class Charter {
	
	//static String ModuleName = "Charter";
    private static WebDriverWait getWait(WebDriver driver) {
        return new WebDriverWait(driver, Duration.ofSeconds(20));
    }
    

    private static void waitForLoaderToDisappear(WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("div[data-testid='loading']")));
    }

    @Test
    public static void TopicCreation(WebDriver driver) throws Exception {
    	
    	StepUtils.moduleName = "Charter";   // Set module name once per test

        WebDriverWait wait = getWait(driver);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        Actions actions = new Actions(driver);

        StepUtils.runStep(driver, "<b>Charter_Click</b> - Click Charter menu", "Charter button not clicked",
            () -> wait.until(ExpectedConditions.elementToBeClickable(By.id("Charter"))).click());

        StepUtils.runStep(driver, "<b>Charter_Add</b> - Click Add icon", "Add icon not clickable",
            () -> wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//div[@class='MuiBox-root css-1x66lww']//button[@id='add__icon']"))).click());

        StepUtils.runStep(driver, "<b>Charter_EventType</b> - Select Event Type: Market Research",
            "Event type dropdown or Market Research option failed", () -> {
                wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[@id='select__event__type'])[2]"))).click();
                WebElement type = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//li[normalize-space(text())='Market Research']")));
                js.executeScript("arguments[0].value='Market Research'", type);
                type.click();
            });

        StepUtils.runStep(driver, "<b>Charter_Topic</b> - Enter Topic Name", "Unable to enter topic name", () -> {
            WebElement topicArea = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("(//textarea[@id='charter_text_area'])[2]")));
            topicArea.sendKeys(Constants.TopicName);
        });

        StepUtils.runStep(driver, "<b>Charter_HCP</b> - Enter HCP Number", "Unable to enter HCP number", () -> {
            WebElement hcpNumber = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("(//input[@id='hcp_number'])[2]")));
            hcpNumber.sendKeys("10");
        });

        StepUtils.runStep(driver, "<b>Charter_Division</b> - Select Division: Mankind", "Unable to select Division Mankind",
            () -> {
                wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[@id='select__division'])[2]"))).click();
                WebElement divi = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("(//span[normalize-space()='mankind'])[1]")));
                js.executeScript("arguments[0].value='mankind'", divi);
                divi.click();
                Thread.sleep(2000);
                waitForLoaderToDisappear(driver);
            });

        StepUtils.runStep(driver, "<b>Charter_Specialty</b> - Select Specialty: All", "Unable to select Specialty All", () -> {
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[@id='select__specialities'])[2]"))).click();
            waitForLoaderToDisappear(driver);
            WebElement spec = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//span[normalize-space()='All']")));
            js.executeScript("arguments[0].value='All'", spec);
            spec.click();
        });

        StepUtils.runStep(driver, "<b>Charter_Save</b> - Click Save button", "Unable to save topic form", () -> {
            WebElement button = driver.findElement(By.xpath("(//button[@id='save_btn'])"));
            actions.click(button).perform();
            Thread.sleep(2000);
            actions.click(button).perform();
            Thread.sleep(3000);
        });
    }

    @Test
    public static void TopicSubmit(WebDriver driver) throws Exception {
    	StepUtils.moduleName = "Charter"; 

        StepUtils.runStep(driver, "<b>Charter_Submit</b> - Sending Topic for Approval",
            "Issue with checkbox or Submit for Approval button", () -> {
                Thread.sleep(2000);
                driver.findElement(By.xpath("(//input[@id='topic__checkbox'])[2]")).click();
                Thread.sleep(2000);
                driver.findElement(By.xpath("(//button[normalize-space()='Submit for Approval'])[1]")).click();
                Thread.sleep(3000);
            });
    }
}
