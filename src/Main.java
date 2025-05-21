import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Main {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "C:\\eclipse-java-2022\\chromedriver-win64\\chromedriver.exe");
		//WebDriver driver = new ChromeDriver(); 
		ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        WebDriver driver = new ChromeDriver(options);
        
		//Launch AMS url for Charter
		LoginLogout.PageLaunch(driver, "https://amsqatest.9321f2e8c52d45138d09.centralindia.aksapp.io/");
			//Logging in with Charter Initiator
		LoginLogout.Login(driver, "akshay.gupta@mankindpharma.com","Test@123");
			//Creation of Topic
		Charter.TopicCreation(driver);
			//Submitting topic for Approval
		Charter.TopicSubmit(driver);
			//Logout from Charter Initiator
		LoginLogout.LogoutwithSearch(driver);

			//Logging in with Charter Reviewer
		LoginLogout.Login(driver,"chandni.wadhwa@mankindpharma.com","Test@123");
			//Approval of Topic by Charter Reviewer/Manager
		CharterReviewer.TopicApproval(driver);
			//Logout from Charter Reviewer
		LoginLogout.LogoutwithSearch(driver);
			//Login with Initiator
		LoginLogout.Login(driver, "akshay.gupta@mankindpharma.com","Test@123");
			//Creation of Questionnaire
		Questionnaire.CreateQuestionnaire(driver);
			//Creation of Event
		Event.EventCreation(driver);
		LoginLogout.LogoutwithSearch(driver);
			//Logging in with Charter Reviewer
		LoginLogout.Login(driver,"chandni.wadhwa@mankindpharma.com","Test@123");
			//Event Search
		Event.EventSearch(driver);
		//Event Approval
		Event.EventApproval(driver);
			//Logout from Charter Reviewer
		LoginLogout.LogoutwithSearch(driver);
			//Logging in with FC
		LoginLogout.Login(driver,"samit.jain_tpr@mankindpharma.com","Test@123");
			//Event Search
		Event.EventSearch(driver);
			//Event Claim
		Event.EventClaim(driver);
			//Event Approval
		Event.EventApproval(driver);
		
		LoginLogout.LogoutwithSearch(driver);
		
			//Logging in with Initiator for Contract Signing
		LoginLogout.Login(driver, "akshay.gupta@mankindpharma.com","Test@123");
			//Event Search
		Event.EventSearch(driver);
			//Contract Signing
		Contract.ContractSigning(driver);
		LoginLogout.LogoutwithSearch(driver);
			//Event Date Pending & PED Submission state is skipped
			
			//Logging in with BECO user
		LoginLogout.Login(driver,"Himanshu.raghav_tpr@mankindpharma.com","Test@1234");
			//Event Filter
		Event.Filter(driver);
			//Event Search
		Event.EventSearch(driver);
			//Event Claim
		Event.EventClaim(driver);
			//Event Approval
		Event.EventApproval(driver);
			//Logout
		LoginLogout.LogoutwithSearch(driver);
		
			//Login with Finance user
		LoginLogout.Login(driver,"Ravi.sharma4@mankindpharma.com","Test@123");
		
		Event.Filter(driver);
			//Event Search
		Event.EventSearch(driver);
			//Event Approval
		Event.EventApproval(driver);
			//Logout
		LoginLogout.LogoutwithSearch(driver);

		LoginLogout.Login(driver, "akshay.gupta@mankindpharma.com","Test@123");
		Event.EventSearch(driver);
		
	}

}
