package qa.consulting.com.AutomatedTesting;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class WebDriverDemosite2 {

	private static ExtentReports report;
	private SpreadSheetReader spreadSheetReader;
	private WebDriver webDriver;
	private ScreenShot screenShot;
	
	@BeforeClass
	public static void init() {
		report = new ExtentReports();
		String fileName = "MyReport" + ".html";
		String filePath = System.getProperty("user.dir") + File.separatorChar + fileName;
		report.attachReporter(new ExtentHtmlReporter(filePath));
	}

	@Before
	public void setUp(){
		webDriver = new ChromeDriver();
		spreadSheetReader = new SpreadSheetReader("demosite.xlsx");
		screenShot = new ScreenShot();
	}
	
	@After
	public void tearDown() {
		webDriver.quit(); // close a browser
	}
	
	@AfterClass
	public static void cleanUp() {
		report.flush();
	}
	
	@Test
	public void qaTest() {
		ExtentTest test = report.createTest("MyFirstTest");
		test.log(Status.INFO, "My First Test is starting.");
		List<String> accountList = new ArrayList<String>();
		
		accountList = spreadSheetReader.readRow(2, "demosite");
		webDriver.navigate().to(accountList.get(1));
		test.log(Status.INFO, "Opening up the website");
		
		accountList = spreadSheetReader.readRow(0, "demosite");
		String username = accountList.get(1).substring(0, accountList.get(1).length() - 2);
		test.log(Status.DEBUG, "Username: " + username);
		
		accountList = spreadSheetReader.readRow(1, "demosite");
		String password = accountList.get(1).substring(0, accountList.get(1).length() - 2);
		test.log(Status.DEBUG, "Password: " + password);
		
		HomePage homepage = PageFactory.initElements(webDriver, HomePage.class);
		homepage.toAddUser();
		
		AddUser addUserPage = PageFactory.initElements(webDriver, AddUser.class);
		addUserPage.setUsername(username);
		try{
			screenShot.take(webDriver, "Enter username");
			test.log(Status.INFO, "Enter your username");
		}catch (IOException e) {
			e.printStackTrace();
		}	
		
		addUserPage.setPassword(password);
		try{
			screenShot.take(webDriver, "Enter password");
			test.log(Status.INFO, "Enter your password");
		}catch (IOException e) {
			e.printStackTrace();
		}	
		
		addUserPage.createAccount();
		test.log(Status.INFO, "A button to create username and password");
		addUserPage.toLoginPage();
		test.log(Status.INFO, "A button to the log in page");
		
		LoginPage loginPage = PageFactory.initElements(webDriver, LoginPage.class);
		loginPage.addUsername(username);
		test.log(Status.INFO, "Enter your username");
		loginPage.addPassword(password);
		test.log(Status.INFO, "Enter your username");
		loginPage.testLogin();
		test.log(Status.INFO, "A button to test username and password");
		
		accountList = spreadSheetReader.readRow(3, "demosite");
		String success = accountList.get(1);
		try{
			screenShot.take(webDriver, "Success");
			test.log(Status.DEBUG, "Successful: " + success);
		}catch (IOException e) {
			e.printStackTrace();
		}	
		
		assertEquals("Not on the right Url", success, loginPage.success());			
	}

}
