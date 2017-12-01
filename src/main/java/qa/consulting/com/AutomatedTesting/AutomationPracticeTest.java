package qa.consulting.com.AutomatedTesting;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Ignore;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class AutomationPracticeTest {

	private static ExtentReports report;
	private SpreadSheetReader spreadSheetReader;
	private ScreenShot screenShot;
	private WebDriver webDriver;
	private Actions builder;

	
	@BeforeTest
	@Parameters("browser")
	public void driver(String browser) throws Exception{
		if(browser.equalsIgnoreCase("Firefox")) {
			System.setProperty("webDriver.gecko.driver", "C:\\Users\\Admin\\eclipse-workspace\\AutomatedTesting\\geckodriver.exe");
			webDriver = new FirefoxDriver();
		}else if(browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webDriver.chrome.driver", "C:\\Users\\Admin\\eclipse-workspace\\AutomatedTesting\\chromedriver.exe");
			webDriver = new ChromeDriver();
		}else {
			throw new Exception("Browser incorrect");
		}
		spreadSheetReader = new SpreadSheetReader("automation.xlsx");
		screenShot = new ScreenShot();
		builder = new Actions(webDriver);
	}
	
	@BeforeClass
	public static void init() {
		report = new ExtentReports();
		String fileName = "Automation" + ".html";
		String filePath = System.getProperty("user.dir") + File.separatorChar + fileName;
		report.attachReporter(new ExtentHtmlReporter(filePath));
	}
	
	@AfterTest
	public void tearDown() {
		webDriver.quit(); // close a browser
	}
	
	@AfterClass
	public static void cleanUp() {
		report.flush();
	}
	
	@Test
	public void testOverlay() {
		
		ExtentTest test = report.createTest("ItemOverlayTest");
		test.log(Status.INFO, "My test to open an overlay is starting.");
		List<String> propertyList = new ArrayList<String>();
		
		propertyList = spreadSheetReader.readRow(0, "autoPractice");
		webDriver.navigate().to(propertyList.get(1));
		webDriver.manage().window().fullscreen();
		test.log(Status.INFO, "Opening up the website");
		
		HomePageAP homepage = PageFactory.initElements(webDriver, HomePageAP.class);
		homepage.womenPage();
		test.log(Status.INFO, "To women page");
		
		Women womenPage = PageFactory.initElements(webDriver, Women.class);
		
		try{
			screenShot.take(webDriver, "Before going to the blouse page");
		}catch (IOException e) {
			e.printStackTrace();
		}
		

		Integer initialX = womenPage.blouse().getLocation().x;
		test.log(Status.DEBUG, "Initial x position: " + initialX);
		Integer initialY = womenPage.blouse().getLocation().y;
		test.log(Status.DEBUG, "Initial y position: " + initialY);

		builder.moveByOffset(initialX, initialY).click(womenPage.blouse()).moveByOffset(initialX, initialY).perform();
		test.log(Status.INFO, "To blouse overlay");
		
		try{
			screenShot.take(webDriver, "Blouse");
		}catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	@Ignore
	@Test
	public void signIn() {
		
		ExtentTest test = report.createTest("SignInTest");
		test.log(Status.INFO, "My test to sign in is starting.");
		List<String> propertyList = new ArrayList<String>();
		
		propertyList = spreadSheetReader.readRow(0, "autoPractice");
		webDriver.navigate().to(propertyList.get(1));
		webDriver.manage().window().fullscreen();
		test.log(Status.INFO, "Opening up the website");
		
		HomePageAP homepage = PageFactory.initElements(webDriver, HomePageAP.class);
		homepage.signInPage();
		test.log(Status.INFO, "To sign in page");
		
		propertyList = spreadSheetReader.readRow(1, "autoPractice");
		String email = propertyList.get(1);
		test.log(Status.DEBUG, "Email: " + email);
		
		SignInPage signIn = PageFactory.initElements(webDriver, SignInPage.class);
		signIn.createEmail(email);
		try{
			screenShot.take(webDriver, "Enter email");
			test.log(Status.INFO, "Enter your email");
		}catch (IOException e) {
			e.printStackTrace();
		}	
		signIn.create();
		test.log(Status.INFO, "Fill in form page");
		
		
		SignInForm signInForm = PageFactory.initElements(webDriver, SignInForm.class);
		
		
		try {
			TimeUnit.SECONDS.sleep(5);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		propertyList = spreadSheetReader.readRow(2, "autoPractice");
		String firstName = propertyList.get(1);
		test.log(Status.DEBUG, "First name: " + firstName);
		signInForm.createName().sendKeys(firstName);
		
		propertyList = spreadSheetReader.readRow(3, "autoPractice");
		String lastName = propertyList.get(1);
		test.log(Status.DEBUG, "Last name: " + lastName);
		signInForm.createLastName().sendKeys(lastName);
		
		propertyList = spreadSheetReader.readRow(4, "autoPractice");
		String password = propertyList.get(1);
		test.log(Status.DEBUG, "Password: " + password);
		signInForm.createPassword().sendKeys(password);
		
		propertyList = spreadSheetReader.readRow(5, "autoPractice");
		String company = propertyList.get(1);
		test.log(Status.DEBUG, "Company: " + company);
		signInForm.createCompany().sendKeys(company);
		
		propertyList = spreadSheetReader.readRow(6, "autoPractice");
		String address = propertyList.get(1);
		test.log(Status.DEBUG, "Address: " + address);
		signInForm.createAddress1().sendKeys(address);
		
		propertyList = spreadSheetReader.readRow(7, "autoPractice");
		String address2 = propertyList.get(1);
		test.log(Status.DEBUG, "Address Line 2: " + address2);
		signInForm.createAddress2().sendKeys(address2);
		
		propertyList = spreadSheetReader.readRow(8, "autoPractice");
		String city = propertyList.get(1);
		test.log(Status.DEBUG, "City: " + city);
		signInForm.createCity().sendKeys(city);
		
		propertyList = spreadSheetReader.readRow(9, "autoPractice");
		String state = propertyList.get(1);
		test.log(Status.DEBUG, "State: " + state);
		signInForm.createState().sendKeys(state);
		
		propertyList = spreadSheetReader.readRow(10, "autoPractice");
		String code = propertyList.get(1);
		test.log(Status.DEBUG, "Postal code: " + code);
		signInForm.createCode().sendKeys(code);
		
		propertyList = spreadSheetReader.readRow(11, "autoPractice");
		String country = propertyList.get(1);
		test.log(Status.DEBUG, "Country: " + country);
		signInForm.selectCountry().sendKeys(country);
		
		try {
			TimeUnit.SECONDS.sleep(3);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		propertyList = spreadSheetReader.readRow(12, "autoPractice");
		String number = propertyList.get(1);
		test.log(Status.DEBUG, "Mobile: " + number);
		signInForm.createNumber().sendKeys(number);
		
		try {
			TimeUnit.SECONDS.sleep(3);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		signInForm.registerButton();
		test.log(Status.INFO, "Register");
		
		try {
			TimeUnit.SECONDS.sleep(3);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		try{
			screenShot.take(webDriver, "Successful account");
		}catch (IOException e) {
			e.printStackTrace();
		}	
	}
	
	
	@Test
	public void logIn() {
		
		ExtentTest test = report.createTest("LogInTest");
		test.log(Status.INFO, "My test to log in is starting.");
		List<String> propertyList = new ArrayList<String>();
		
		propertyList = spreadSheetReader.readRow(0, "autoPractice");
		webDriver.navigate().to(propertyList.get(1));
		webDriver.manage().window().fullscreen();
		test.log(Status.INFO, "Opening up the website");
		
		HomePageAP homepage = PageFactory.initElements(webDriver, HomePageAP.class);
		homepage.signInPage();
		test.log(Status.INFO, "To log in page");
		
		SignInPage signIn = PageFactory.initElements(webDriver, SignInPage.class);
		
		propertyList = spreadSheetReader.readRow(1, "autoPractice");
		String email = propertyList.get(1);
		test.log(Status.DEBUG, "Email: " + email);
		signIn.insertEmail(email);
		
		propertyList = spreadSheetReader.readRow(4, "autoPractice");
		String password = propertyList.get(1);
		test.log(Status.DEBUG, "Password: " + password);
		signIn.insertPassword(password);
		
		signIn.signIn();
		
		try {
			TimeUnit.SECONDS.sleep(5);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
}
