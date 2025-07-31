import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import Utility.ConfigValues;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Main {

	public static void main(String[] args) throws InterruptedException {
		 WebDriver driver = null;
		try {

			// Load the properties file (adjust path as needed)
			ConfigReader.loadProperties("credentials.properties");

			// Set environment (default to "qa")
			String env = System.getProperty("env", "qa");

			// Automatically download and use the correct ChromeDriver version
			WebDriverManager.chromedriver().setup();

			// Set Chrome options
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--incognito");

			// Launch Chrome with options
			 driver = new ChromeDriver(options);

			// Get base URL and user credentials based on environment
			String baseUrl = ConfigReader.get(env + ".url");
			String initiatorUsername = ConfigReader.get(env + ".initiator.username");
			String initiatorPassword = ConfigReader.get(env + ".initiator.password");

			String reviewerUsername = ConfigReader.get(env + ".reviewer.username");
			String reviewerPassword = ConfigReader.get(env + ".reviewer.password");

			String fcUsername = ConfigReader.get(env + ".fc.username");
			String fcPassword = ConfigReader.get(env + ".fc.password");

			String becoUsername = ConfigReader.get(env + ".beco.username");
			String becoPassword = ConfigReader.get(env + ".beco.password");

			String financeUsername = ConfigReader.get(env + ".finance.username");
			String financePassword = ConfigReader.get(env + ".finance.password");

			// Launch AMS url for Charter
			try {
				LoginLogout.PageLaunch(driver, baseUrl);
			} catch (Exception e) {
				System.out.println("PageLaunch has failed");
			}

			// Logging in with Charter Initiator
			try {
				LoginLogout.Login(driver, initiatorUsername, initiatorPassword);
			} catch (Exception e) {
				System.out.println("Login has failed");
			}
			// Creation of Topic
			try {
				Charter.TopicCreation(driver);
			} catch (Exception e) {
				System.out.println("TopicCreation has failed");
			}
			// Submitting topic for Approval
			try {
				Charter.TopicSubmit(driver);
			} catch (Exception e) {
				System.out.println("TopicSubmit has failed");
			}
			// Logout from Charter Initiator
			try {
				LoginLogout.LogoutwithSearch(driver);
			} catch (Exception e) {
				System.out.println("Logout has failed");
			}

			 //Logging in with Charter Reviewer
			try {
				LoginLogout.Login(driver, reviewerUsername, reviewerPassword);
			} catch (Exception e) {
				System.out.println("CharterReviewer login has failed");
			}
			// Approval of Topic by Charter Reviewer/Manager
			try {
				CharterReviewer.TopicApproval(driver);
			} catch (Exception e) {
				System.out.println("Approval of Topic by Charter Reviewer/Manager has failed");
			}
			// Logout from Charter Reviewer
			try {
				LoginLogout.LogoutwithSearch(driver);
			} catch (Exception e) {
				System.out.println("Logout from Charter Reviewer has failed");
			}
			// Login with Initiator
			try {
				LoginLogout.Login(driver, initiatorUsername, initiatorPassword);
			} catch (Exception e) {
				System.out.println("Login with Initiator has failed");
			}
			// Creation of Questionnaire
			try {
				Questionnaire.CreateQuestionnaire(driver);
			} catch (Exception e) {
				System.out.println("Creation of Questionnaire has failed");
			}
			// Creation of Event
			try {
				Event.EventCreation(driver);
				LoginLogout.LogoutwithSearch(driver);
			} catch (Exception e) {
				System.out.println("Event creation has failed");
			}
			// Logging in with Charter Reviewer
			try {
				LoginLogout.Login(driver, reviewerUsername, reviewerPassword);
			} catch (Exception e) {
				System.out.println("Logging in with Charter Reviewer has failed");
			}
			// Event Search
			try {
				Event.EventSearch(driver);
			} catch (Exception e) {
				System.out.println("Event Search has failed for Charter Reviewer");
			}
			// Event Approval
			try {
				Event.EventApproval(driver);
			} catch (Exception e) {
				System.out.println("Event Approval has failed");
			}
			// Logout from Charter Reviewer
			try {
				LoginLogout.LogoutwithSearch(driver);
			} catch (Exception e) {
				System.out.println("Logout from Charter Reviewer has failed");
			}
			// Logging in with FC
			try {
				LoginLogout.Login(driver, fcUsername, fcPassword);
			} catch (Exception e) {
				System.out.println("Logging in with FC has failed");
			}
			// Event Search
			try {
				Event.EventSearch(driver);
			} catch (Exception e) {
				System.out.println("Event Search has failed for FC");
			}
			// Event Claim
			try {
				Event.EventClaim(driver);
			} catch (Exception e) {
				System.out.println("Event Claim has failed for FC");
			}
			// Event Approval
			try {
				Event.EventApproval(driver);
			} catch (Exception e) {
				System.out.println("Event Approval has failed for FC");
			}

			try {
				LoginLogout.LogoutwithSearch(driver);
			} catch (Exception e) {
				System.out.println("Logout has failed for FC");
			}

			// Logging in with Initiator for Contract Signing
			try {
				LoginLogout.Login(driver, initiatorUsername, initiatorPassword);
			} catch (Exception e) {
				System.out.println("InitiatorLogin has failed for Contract Signing");
			}
			// Event Search
			try {
				Event.EventSearch(driver);
			} catch (Exception e) {
				System.out.println("EventSearch by Initiator has failed for Contract Signing");
			}
			// Contract Signing
			try {
				Contract.contractSigning(driver);
			} catch (Exception e) {
				System.out.println("Contract Signing has failed for Initiator");
			}
			try {
				LoginLogout.LogoutwithSearch(driver);
			} catch (Exception e) {
				System.out.println("InitiatorLogout has failed for Contract Signing");
			}
			// Event Date Pending & PED Submission state is skipped

			// Logging in with BECO user
			try {
				LoginLogout.Login(driver, becoUsername, becoPassword);
			} catch (Exception e) {
				System.out.println("Login has failed for BECO user");
			}
			// Event Filter
			try {
				Event.Filter(driver);
			} catch (Exception e) {
				System.out.println("Event filter has failed for BECO user");
			}
			// Event Search
			try {
				Event.EventSearch(driver);
			} catch (Exception e) {
				System.out.println("Event Search has failed for BECO user");
			}
			// Event Claim
			try {
				Event.EventClaim(driver);
			} catch (Exception e) {
				System.out.println("Event Claim has failed for BECO user");
			}
			// Event Approval
			try {
				Event.EventApproval(driver);
			} catch (Exception e) {
				System.out.println("Event Approval has failed for BECO user");
			}

			// Logout
			try {
				LoginLogout.LogoutwithSearch(driver);
			} catch (Exception e) {
				System.out.println("Logout has failed for BECO user");
			}

			// Login with Finance user
			try {
				LoginLogout.Login(driver, financeUsername, financePassword);
			} catch (Exception e) {
				System.out.println("Login has failed for Finance user");
			}

			try {
				Event.Filter(driver);
			} catch (Exception e) {
				System.out.println("Event filter has failed for Finance user");
			}
			// Event Search
			try {
				Event.EventSearch(driver);
			} catch (Exception e) {
				System.out.println("Event Search has failed for Finance user");
			}
			// Event Approval
			try {
				Event.EventApproval(driver);
			} catch (Exception e) {
				System.out.println("EventApproval has failed for Finance user");
			}
			// Logout
			try {
				LoginLogout.LogoutwithSearch(driver);
			} catch (Exception e) {
				System.out.println("Logout has failed for Finance user");
			}

			try {
				LoginLogout.Login(driver, initiatorUsername, initiatorPassword);
			} catch (Exception e) {
				System.out.println("Login has failed for Event Initiator");
			}
			try {
				Event.EventSearch(driver);
			} catch (Exception e) {
				System.out.println("Event Search has failed for Event Initiator");
			}
			try {
				PaymentAck.PaymentSign(driver);
			} catch (Exception e) {
				System.out.println("Payment Acknowledgement has  failed");
			}
		} catch (Exception e) {
			System.out.println("Unexpected error: " + e.getMessage());
		} finally {
			// Close the browser
            if (driver != null) {
                driver.quit();
            }
         // Finalize report 
			ConfigValues.generator.finalizeReport("C:\\WorkspaceAMS_Himanshu\\AMS\\test-output");
		}

	}

}
