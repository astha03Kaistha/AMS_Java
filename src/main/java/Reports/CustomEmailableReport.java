package Reports;

import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.testng.IReporter;

//import com.aventstack.extentreports.ExtentTest;

import Utility.ConfigValues;

public class CustomEmailableReport implements IReporter {

    private StringBuilder report;
    private static int passedTests = 0;
    private static int failedTests = 0;
    private static int skippedTests = 0;
    private long totalDuration = 0;
    //ExtentTest test;
    WebDriver driver;

    private static final Map<String, String> descriptionMap = new HashMap<>();
    static {
    	descriptionMap.put("ApplicationLogin", "<b>Superman_Application_Login</b> - Verify that the login screen accepts valid credentials and successfully landed to home tab after master data Download.");
        descriptionMap.put("LandingHomePage", "<b>Superman_Home_Page_Validation</b> - Verify the visibility of the 'Upcoming Event' text to ensure that we have landed on homepage successfully.");
//        descriptionMap.put("", "<b>Superman_Home_Page_Upcoming_Event_Validation</b> - Verifies that the Upcoming Events section is visible and shows events like birthdays and anniversaries.");
        descriptionMap.put("LoadingHomePage", "<b>Superman_Home_Page_Loading</b> - Verify the visibility of the 'Home' label to ensure that homepage is loaded successfully.");
        descriptionMap.put("UserDetails", "<b>Superman_Homepage_User_Details_Validation</b> - Verify the User Name is appearing on the screen.");
        descriptionMap.put("UserDetails", "<b>Superman_Homepage_User_Details_Validation</b> - Verify the Division is appearing on the screen.");
        descriptionMap.put("UserDetails", "<b>Superman_Homepage_User_Details_Validation</b> - Verify the Staff Position ID is appearing on the screen.");
//        descriptionMap.put("VerifyKPIDashboar", "<b>Superman_Homepage_KPI LeaderBoard</b> - Verify the KPI LeaderBoard is appearing on the screen for Delhi based division.");
        descriptionMap.put("Notifications", "<b>Superman_Homepage_Notifications_Validations</b> - Verify that the notifications panel loads properly and also read-unread notifications are separated.");
        descriptionMap.put("Sync", "<b>Superman_Homepage_Sync_Validation</b> -  Verify that the sync button triggers and “Sync Successful”  message is visible after successfully syncing data.");
        descriptionMap.put("PNMClick", "<b>Superman_Plan_and_Meet_Click</b> - Verifies that the Plan and Meet module tab is clickable from the navigation menu.");
        descriptionMap.put("DailyPlan", "<b>Superman_Daily_Planner_Verification</b> - Verify that daily plan call entries should be visible.");
 //       descriptionMap.put(""               , "<b>Add_to_Today's_Plan</b> - Verify that user clicks on Add to today’s plan and he is redirected to Directory Module missed call section.");
 //       descriptionMap.put(""               , "<b>Superman_Tour_Plan_Verification</b> - Verify the STP status");
 //       descriptionMap.put(""               , "<b>Superman_Tour_Plan_Verification</b> - Verify the MTP status");
        descriptionMap.put("DCDCard", "<b>Superman_DCD_Card_Click</b> - Verifiy that Doctor, Chemist and Dispensary cards are clickable.");
 //       descriptionMap.put(""               , "<b>Superman_Review_DCR</b> - Verify that the Review DCR button is clickable and list of doctors and Chemist with Status like completed");
 //       descriptionMap.put(""               , "<b>Superman_Calendar_Click</b> - Verify that the calendar icon opens the date selector and navigates accordingly.");
  //      descriptionMap.put(""               , "<b>Superman_Legend_Verification</b> - Verify all the legend should be visible.");
    //    descriptionMap.put(""               , "<b>Superman_Pending_DCR_Date</b> - Verify user is able to click on pending DCR date and user landed to Daily call Reporting page.");
        descriptionMap.put("EDetailingClick", "<b>EDetailing_Click</b> - Verify that the E-Detailing button is clickable and successfully launches the products presentation.");
        descriptionMap.put("DocFeedbackFill", "<b>Doctor_Feedback_Submission</b> - Verify the feedback form for doctor interactions can be filled and submitted successfully.");
        descriptionMap.put("ChemistFeedbackFill", "<b>Chemist_Feedback_Submission</b> - Verify that chemist feedback forms like POB can be filled and submitted correctly.");
  //      descriptionMap.put("", "<b>Chemist_Feedback_Submission</b> - Verify that chemist fill the POB flow.");
   //     descriptionMap.put("", "<b>Chemist_Feedback_Submission</b> - Verify that chemist fill the NMNE flow.");
  //      descriptionMap.put("DispensaryFeedbackFill", "<b>Self_dispensing_Feedback_Submission</b> - Verify that self-dispensing doctor feedback forms like RCPA can be filled and submitted correctly.");
  //      descriptionMap.put("", "<b>Self_dispensing_Feedback_Submission</b> - Verify that self-dispensing fill the POB flow.");
  //      descriptionMap.put("", "<b>Self_dispensing_Feedback_Submission</b> - Verify that self-dispensing fill the NMNE flow.");
        descriptionMap.put("DocDCRStatus", "<b>Doctor_DCR_Status</b> - Confirms that doctor visit status is updated correctly and reflected in the UI.");
        descriptionMap.put("ChemistDCRStatus", "<b>Chemist_DCR_Status</b> - Confirms that doctor visit status is updated correctly and reflected in the UI.");
        descriptionMap.put("AdhocParty", "<b>Adhoc_Party_Visit</b> - Verify to add and manage an ad-hoc party visit.");
        descriptionMap.put("AdhocParty", "<b>Adhoc_NFA_Visit</b> - Verify to add and manage an ad-hoc NFA visit.");
        descriptionMap.put("Doctor Submit DCR", "<b>DCR_Submission_Summary</b> - Verify the DCR for doctor, Chemist visits is recorded successfully and user getting the summary popup.");
  //      descriptionMap.put(""               , "<b>Submit_DCR</b> - Verify the Completed Doctor,Chemist,NFA and Missed calls details.");
  //      descriptionMap.put(""               , "<b>Calculate_Expense </b> - Verify the TA ,DA amount based on completed calls for the day.");
  //      descriptionMap.put(""               , "<b>Daily_Call_Report</b> - Verify the View expense button is visible.");
  //      descriptionMap.put(""               , "<b>Item_and_Sample_Validation</b> - Verify the Sample and Item quantity validate from inventory tab.");
  //      descriptionMap.put(""               , "<b>Missed_Call_Validation</b> - Verify the Missed call doctor validation based on current day missed calls.");
  //      descriptionMap.put(""               , "<b>6_Doctor_Call_Validation </b> - Verify the 6 doctor call feedback submission and DA Amount validation.");
        descriptionMap.put("PerformanceTab", "<b>Performance_Tab_Click</b> - Verify that the Performance tab opens and displays work habits,sales and detail report as expected.");
      //  descriptionMap.put("AllTabsOnPerformance", "<b>Performance_All_Tabs_Click</b> - Verify that each tab under Performance is functional and loads respective data.");
      //  descriptionMap.put("ClickDirectorytab", "<b>Directory_Tab_Click</b> - Verify that the user can click on the Directory module.");
        descriptionMap.put("LandedMissedCallTab", "<b>Directory_Missed_Calls_Tab_Click</b> - Verifies that missed calls tab is clickable and logs the data under the appropriate tab.");
        descriptionMap.put("ClickDoctorTab", "<b>Directory_Doctor_Tab_Click</b> - Verify that the Doctor tab in the directory is clickable and lists associated records.");
        descriptionMap.put("ClickChemistTab", "<b>Directory_Chemist_Tab_Click</b> - Verify that clicking the Chemist tab shows chemist contacts and related information.");
        descriptionMap.put("ClickMissedCallTab", "<b>Missed_Call_Tab_Data_Validation</b> - Verify the Missed Call tab is clickable and displays data.");
 //       descriptionMap.put(""               , "<b>Directory_Stockist_Tab_Click </b> - Verify the Stockist tab is clickable and displays data.");
 //       descriptionMap.put(""               , "<b>Directory_HO_Tab_Click </b> - Verify the HO tab is clickable and displays data.");
 //       descriptionMap.put(""               , "<b>Directory_Price_Tab_Click </b> - Verify the Price tab is clickable and displays data.");
 //       descriptionMap.put(""               , "<b>Directory_SFC_Tab_Click </b> - Verify the SFC tab is clickable and displays data.");
        descriptionMap.put("GSPTabClick", "<b>GSP_Module_Click</b> - Verifies that the GSP module is clickable from the navigation menu.");
        descriptionMap.put("RedirectToBrandCustomerPlan", "<b>GSP_Brand-Customer_Plan_Redirect</b> - Verify redirection from GSP to the Brand-Customer Plan screen.");
        descriptionMap.put("ReviewPlanClick", "<b>GSP_Review_Plan_Click</b> - Verify that the Review Plan button is clickable and displays records accordingly.");
        descriptionMap.put("OthersTabClick", "<b>GSP_Others_Section_Click</b> - Verify that Others section under GSP is clickable and displayed.");
        descriptionMap.put("PriorityTabClick", "<b>GSP_Priority_Section_Click</b> - Verify that Priority section under GSP is clickable and displayed.");
        descriptionMap.put("CalculateBtnClick", "<b>GSP_Calculate_Button_Click</b> - Verify that clicking the Calculate button performs required calculations and updates values.");
     //   descriptionMap.put("AdminTabClick", "<b>Admin_Module_Navigation</b> - Verifies that the Admin module tab is clickable from the navigation menu.");
     //   descriptionMap.put("RedirectToAdmin", "<b>Admin_Redirection</b> - Verifies redirection from any screen to the Admin module.");
   //     descriptionMap.put(""               , "<b>Inventory_Tab</b> - Verify the In-Transit Challan flow.");
   //     descriptionMap.put(""               , "<b>Inventory_Tab</b> - Verify the Pending Sample list is visible.");
   //     descriptionMap.put(""               , "<b>Inventory_Tab</b> - Verify the Pending Item list is visible.");
   //     descriptionMap.put(""               , "<b>Inventory_Tab</b> - Verify the Return Item list is visible.");
   //     descriptionMap.put(""               , "<b>Inventory_Tab</b> - Verify the Receive Item list is visible.");
        descriptionMap.put("ClickLeaveTab", "<b>Leave_Tab</b> - Verify the Leave Balances and Leave detail is visible.");
        descriptionMap.put("ClickHolidayTab", "<b>Holiday_Tab</b> - Verify the selected Holiday detail is visible.");
        //descriptionMap.put("HoliayValidate", "<b>Holiday_Validate_from_DB</b> - Holiday count from Db is "+ConfigValues.totalHoldayFromDB +" and holiday count from UI is  "+ConfigValues.totalHoldayFromUI+" are equal");
        descriptionMap.put("ClickZHOTab", "<b>ZHO_Tile</b> - Verify the ZHO tiles is clickable");
        descriptionMap.put("Click_ZHO_Order_Tab", "<b>ZHO_Order_Tile</b> - Verify the ZHO order tile is clickable.");
        descriptionMap.put("Click_ZHO_Summary_Tab", "<b>ZHO_Order_Summary_Tile</b> - Verify the ZHO order summary tile is clickable");
        descriptionMap.put("ClickExpensesTab", "<b>Expense_Tile</b> - Verify the Expense tab is clickable.");
        descriptionMap.put("Click_SubmitExpenses", "<b>Submit_Expense</b> - Verify the Submit Expense tile is clickable");
        descriptionMap.put("ClickExpenseApprovedByAdminTab", "<b>Expense_Approved_By_Admin</b> - Verify the Expense Approved By Admin tile is clickable");
        descriptionMap.put("Click_Compaingn_Management_Tab", "<b>Campaign_Tile</b> - Verify the Campaign tiles is visible.");
        descriptionMap.put("Click_CDC_Tab", "<b>CDC_Tile</b> - Verify the CDC tiles is visible.");
        descriptionMap.put("Click_Training_Tab", "<b>Training_Tile</b> - Verify the Training tiles is visible.");
        descriptionMap.put("Click_Query_Managment_Tab", "<b>Query_Management_Tile</b> - Verify the Query Management tiles is visible.");
        descriptionMap.put("ClickIncentiveCalculatorTab", "<b>MR_Incentive_Calculator_Tile</b> - Verify the Incentive Calculator tiles is visible.");
        descriptionMap.put("ClickGuidelinesTab", "<b>Guideline_Tile</b> - Verify the Guideline tab is clickable.");
        descriptionMap.put("ClickIncentiveTab", "<b>Incentive_Tab</b> - Verify the Incentive tab is clickable.");
        descriptionMap.put("ClickBrandGuideTab", "<b>BrandGuide_Tab</b> - Verify the Brand Guide tab is clickable.");
        descriptionMap.put("SettingsTab", "<b>Settings_Module_Navigation</b> - Verify Settings module is clickable and visibility of configurable options.");
        descriptionMap.put("SyncNow", "<b>Manual_Sync_Validation</b> - Verify that clicking 'Sync Now' immediately starts data sync and provides success feedback.");
        descriptionMap.put("CMSTab", "<b>CMS_Tab_Click</b> - Verify the CMS tab is functional and opens with all necessary content.");
        descriptionMap.put("ResetTab", "<b>Reset_Option_Click</b> - Verify that the Reset option is clickable.");
        descriptionMap.put("DataUploadTab", "<b>Data_Upload_Click</b> - Verify that the Data Upload tab is clickable.");
        descriptionMap.put("InternetSpeedTestTab", "<b>Internet_Speed_Test</b> - Verify that the Internet Speed Test tab is clickable.");

    }

    public CustomEmailableReport() {
        this.report = new StringBuilder();
        String currentDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());

        report.append("<html><head><title>Test Report</title>");
        report.append("<script src='https://cdn.jsdelivr.net/npm/chart.js'></script></head><body>");
        report.append("<h1 style=\"background-color:#D3D3D3; color:Black\">SUPERMAN TEST RESULT</h1>");
        report.append("<p>Hi</p>");
        report.append("<p>Below is the Automation Testing Report of Superman smoke test result on the latest Build.</p>");
        report.append("<p>Report generated on: ").append(currentDate).append("</p>");
    }

    public void addTestCaseRow(String moduleName, String method, String startTime, String endTime, String TC_failedReason) {
        if (report.indexOf("<table") == -1) {
        	report.append("<h3>Test Summary</h3>");
//        	report.append("<p><b>Total Tests:</b> <span id='total'></span><br>");
//        	report.append("<b>Passed:</b> <span id='passed'></span><br>");
//        	report.append("<b>Failed:</b> <span id='failed'></span><br>");
//        	report.append("<b>Skipped:</b> <span id='skipped'></span><br>");
//        	report.append("<b>Total Execution Time:</b> <span id='executionTime'>" + totalDuration + " sec</span></p>");
            report.append("<div style='width: 300px; height: 200px; margin-bottom: 20px;'>");
            report.append("<canvas id='testChart' style='width: 100%; height: 100%;'></canvas>");
            report.append("</div>");
           // report.append("<table border='2'><tr bgcolor=\"#DCDCDC\"><th>Module Name</th><th>Description</th><th>Status</th><th>Start Time</th><th>End Time</th><th>Execution Time</th></tr>");
        
            report.append("<table border='2'><tr bgcolor=\"#DCDCDC\">"
            	    + "<th>Module Name</th>"
            	    + "<th>Description</th>"
            	    + "<th>Status</th>"
            	    + "<th>Start Time</th>"
            	    + "<th>End Time</th>"
            	    + "<th>Execution Time</th>"
            	    + "<th>Screenshot</th>"
            	    + "<th>Reason For failure</th>"
            	    + "</tr>");
        }

        String status = (endTime == null || endTime.isEmpty()) ? "Failed" : "Passed";

        report.append("<tr");
        report.append(" style=\"background-color: ").append("Failed".equals(status) ? "red; color: white;" : "#FFFFC5;").append("\">");

        String description = descriptionMap.getOrDefault(method, method);

        long duration = 0;
        if (startTime != null && endTime != null && !startTime.isEmpty() && !endTime.isEmpty()) {
            try {
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                Date start = sdf.parse(startTime);
                Date end = sdf.parse(endTime);
                duration = (end.getTime() - start.getTime()) / 1000;
                if (duration <= 0 && "Passed".equals(status)) duration = 1;
            } catch (Exception e) {
                if ("Passed".equals(status)) duration = 1;
            }
        } else {
            if ("Passed".equals(status)) duration = 1;
        }

        totalDuration += duration;

        report.append("<td>").append(moduleName).append("</td>");
        report.append("<td>").append(description).append("</td>");
        report.append("<td>").append(status).append("</td>");
        report.append("<td>").append(startTime != null ? startTime : "").append("</td>");
        report.append("<td>").append(endTime != null ? endTime : "").append("</td>");
        report.append("<td>").append(duration).append(" sec</td>");
        report.append("<td>");
        if ("Failed".equals(status)) {
            String screenshotUrl = ConfigValues.failedTestScreenshots.getOrDefault(method, "Not Captured");
            if (!"Not Captured".equals(screenshotUrl)) {
                report.append("<a href='").append(screenshotUrl).append("' target='_blank'>View</a>");
            } else {
                report.append("Not Captured");
            }
        }
        report.append("</td>");

        report.append("<td>").append(TC_failedReason).append("</td>");
        report.append("</tr>");

        if (moduleName != null && !moduleName.trim().isEmpty()) {
            if ("Passed".equals(status)) passedTests++;
            else if ("Failed".equals(status)) failedTests++;
        }
    }


    
    public void finalizeReport(String outputDirectory) {
        if (report.indexOf("<table") != -1) {
            report.append("</table><br>");
        }

        // Now append summary + chart here (after all test cases are logged)
//        StringBuilder userDetail = new StringBuilder();
//        userDetail.append("<h3>Execution Details</h3>");
//        userDetail.append("<p>");
//        userDetail.append("<b>Executed By:</b> ").append(ConfigValues.Username).append("<br>");
//        userDetail.append("<b>Staff Position ID:</b> ").append(ConfigValues.staffpostionID).append("<br>");
//        userDetail.append("<b>Environment:</b> ").append("QA").append("<br>"); // you can replace this with another variable if needed
//        userDetail.append("</p>");
        
        
        StringBuilder summary = new StringBuilder();
        summary.append("<p><b>Total Tests:</b> ").append(passedTests + failedTests + skippedTests).append("<br>");
        summary.append("<b>Passed:</b> ").append(passedTests).append("<br>");
        summary.append("<b>Failed:</b> ").append(failedTests).append("<br>");
        summary.append("<b>Skipped:</b> ").append(skippedTests).append("<br>");
        summary.append("<b>Total Execution Time:</b> ").append(totalDuration).append(" sec</p>");

       // summary.append("<div style='width: 300px; height: 200px; margin-bottom: 20px;'>");
       // summary.append("<canvas id='testChart' style='width: 100%; height: 100%;'></canvas>");
      //  summary.append("</div>");

        // Insert summary just before the <table> tag
        int insertPos = report.indexOf("<table");
       // report.insert(insertPos, userDetail.toString());
        report.insert(insertPos, summary.toString());

        // Add chart logic
        report.append("<script>");
        report.append("document.addEventListener('DOMContentLoaded', function() {");
        report.append("var ctx = document.getElementById('testChart').getContext('2d');");
        report.append("new Chart(ctx, { type: 'pie', data: { labels: ['Passed', 'Failed', 'Skipped'], datasets: [{ data: [")
              .append(passedTests).append(", ").append(failedTests).append(", ").append(skippedTests).append("],")
              .append("backgroundColor: ['#28a745', '#dc3545', '#ffc107'] }] }, options: { responsive: true } });");
        report.append("});");
        report.append("</script>");
        report.append("</body></html>");

        try (FileWriter writer = new FileWriter(outputDirectory + "/custom-emailable-report.html")) {
            writer.write(report.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


//    public static String captureScreenshot(WebDriver driver, String screenshotName) {
//        try {
//            File source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
//            String destination = "screenshots/" + screenshotName + ".png";
//            FileHandler.copy(source, new File(destination));
//            return destination;
//        } catch (IOException e) {
//            e.printStackTrace();
//            return null;
//        }
//    }

    public static int getPassedTests() {
        return passedTests;
    }

    public static int getFailedTests() {
        return failedTests;
    }

    public static int getSkippedTests() {
        return skippedTests;
    }
}
