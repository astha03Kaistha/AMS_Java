import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import Utility.StepUtils;

import java.time.Duration;
import java.util.List;

public class Questionnaire {

    private static WebDriverWait getWait(WebDriver driver) {
        return new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    @Test
    public static void CreateQuestionnaire(WebDriver driver) throws Exception {
        StepUtils.moduleName = "Questionnaire";
        WebDriverWait wait = getWait(driver);
        Actions actions = new Actions(driver);

        StepUtils.runStep(driver, "<b>Questionnaire_ClickCharter</b> - Click Charter menu",
            "Charter menu not clicked",
            () -> wait.until(ExpectedConditions.elementToBeClickable(By.id("Charter"))).click());

        StepUtils.runStep(driver, "<b>Questionnaire_ClickApproved</b> - Click Approved status",
            "Approved status not clicked",
            () -> {
                Thread.sleep(1000);
                driver.findElement(By.xpath("//p[normalize-space()='Approved']")).click();
            });

//        StepUtils.runStep(driver, "<b>Questionnaire_ExpandSection</b> - Expand section icons",
//            "Section expand icons not clickable",
//            () -> {
//                wait.until(ExpectedConditions.elementToBeClickable(
//                    By.xpath("//body/div[@id='app']/div[@id='homePageTest']/div[@class='MuiStack-root css-1147ok6']/div[@class='MuiBox-root css-15i1vgz']/div[@class='MuiBox-root css-zntkl0']/div[@class='MuiBox-root css-1rr4qq7']/div[@class='MuiStack-root css-p9xda']/div[@class='MuiStack-root css-1ydnuod']/div[1]/div[2]/button[1]//*[name()='svg']"))).click();
//                wait.until(ExpectedConditions.elementToBeClickable(
//                    By.xpath("//div[@class='MuiCollapse-root MuiCollapse-vertical MuiCollapse-entered css-c4sutr']//div[@class='MuiStack-root css-1cu163h']//*[name()='svg']"))).click();
//            });
        
        StepUtils.runStep(driver, "<b>Questionnaire_ExpandSection</b> - Expand section icons",
        	    "Section expand icons not clickable",
        	    () -> {
        	        By firstIconXPath = By.xpath("//body/div[@id='app']/div[@id='homePageTest']/div[@class='MuiStack-root css-1147ok6']/div[@class='MuiBox-root css-15i1vgz']/div[@class='MuiBox-root css-zntkl0']/div[@class='MuiBox-root css-1rr4qq7']/div[@class='MuiStack-root css-p9xda']/div[@class='MuiStack-root css-1ydnuod']/div[1]/div[2]/button[1]//*[name()='svg']");
        	        By secondIconXPath = By.xpath("//div[@class='MuiCollapse-root MuiCollapse-vertical MuiCollapse-entered css-c4sutr']//div[@class='MuiStack-root css-1cu163h']//*[name()='svg']");

        	        wait.until(ExpectedConditions.elementToBeClickable(firstIconXPath)).click();

        	        // Slight delay to allow UI to update
        	        Thread.sleep(1000);

        	        wait.until(ExpectedConditions.elementToBeClickable(secondIconXPath)).click();
        	    });


        StepUtils.runStep(driver, "<b>Questionnaire_ClickSaveIfPresent</b> - Click Save button if present",
            "'Save' button not clicked",
            () -> {
                List<WebElement> saveButtons = driver.findElements(By.xpath("(//button[normalize-space()='Save'])[1]"));
                if (!saveButtons.isEmpty()) {
                    WebDriverWait shortWait = new WebDriverWait(driver, Duration.ofSeconds(5));
                    shortWait.until(ExpectedConditions.elementToBeClickable(saveButtons.get(0))).click();
                    System.out.println("'Save' button clicked.");
                } else {
                    System.out.println("'Save' button not present, skipping click.");
                }
            });

        StepUtils.runStep(driver, "<b>Questionnaire_OptForShortAnswer</b> - Add new short question",
            "Failed to add short answer question",
            () -> {
                wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[normalize-space()='Add New Question']"))).click();
                wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[normalize-space()='Select Question Type']"))).click();
                wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//span[normalize-space()='Short answer'])[1]"))).click();

                actions.sendKeys(Keys.TAB).perform();
                actions.sendKeys("What is your name?").perform();
            });

        StepUtils.runStep(driver, "<b>Questionnaire_AddMultipleSelectionQuestion</b> - Add multiple selection question",
            "Failed to add multiple selection question",
            () -> {
                wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[normalize-space()='Add New Question']"))).click();
                wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[normalize-space()='Select Question Type']"))).click();
                wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[normalize-space()='Multiple selection']"))).click();

                actions.sendKeys(Keys.TAB).perform();
                actions.sendKeys("How is the demo going so far?").perform();
                actions.sendKeys(Keys.TAB).perform();
                actions.sendKeys("Amazing").perform();
                actions.sendKeys(Keys.TAB).perform();
                actions.sendKeys("Awesome").perform();

                // Click the "+" icon to add another option
                driver.findElement(By.xpath("(//button[@type='button'])[13]")).click();
                Thread.sleep(1000);
            });

        StepUtils.runStep(driver, "<b>Questionnaire_PublishForm</b> - Click Publish button",
            "Failed to publish questionnaire",
            () -> {
                wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[normalize-space()='Publish']"))).click();
                actions.sendKeys(Keys.TAB).perform();
                actions.sendKeys(Keys.TAB).perform();
                actions.sendKeys(Keys.ENTER).perform();
                Thread.sleep(1000);
            });

        StepUtils.runStep(driver, "<b>Questionnaire_CloseDrawer</b> - Close questionnaire drawer",
            "Failed to close questionnaire drawer",
            () -> wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//button[@class='MuiButtonBase-root MuiIconButton-root MuiIconButton-colorPrimary MuiIconButton-sizeMedium css-vxw6j8']"))).click());
    }
}
