package qa.consulting.com.AutomatedTesting;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverDemosite {
	
	private String url = "http://www.google.co.uk";
	private WebDriver webDriver;

	@Before
	public void setUp() {
		webDriver = new ChromeDriver(); // open a browser
	}

	@After
	public void tearDown() {
		webDriver.quit(); // close a browser
	}
	
	@Test
	public void qaTest() {
		webDriver.navigate().to(url);
		webDriver.manage().window().fullscreen();
		WebElement searchBar = webDriver.findElement(By.cssSelector("#lst-ib"));
		searchBar.sendKeys("the demosite \n");
		WebElement demositeLink = webDriver
				.findElement(By.cssSelector("#rso > div:nth-child(2) > div > div:nth-child(1) > div > div > h3 > a"));
		demositeLink.click();

		WebElement addUser = webDriver.findElement(By.cssSelector("body > div > center > table > tbody > tr:nth-child(2) > td > div > center > table > tbody > tr > td:nth-child(2) > p > small > a:nth-child(6)"));
		addUser.click();

		WebElement addUserName = webDriver.findElement(By.cssSelector("body > table > tbody > tr > td.auto-style1 > form > div > center > table > tbody > tr > td:nth-child(1) > div > center > table > tbody > tr:nth-child(1) > td:nth-child(2) > p > input"));
		addUserName.sendKeys("1194");
		WebElement addPassword = webDriver.findElement(By.cssSelector("body > table > tbody > tr > td.auto-style1 > form > div > center > table > tbody > tr > td:nth-child(1) > div > center > table > tbody > tr:nth-child(2) > td:nth-child(2) > p > input[type=\"password\"]"));
		addPassword.sendKeys("1194");
		
		WebElement save = webDriver.findElement(By.cssSelector("body > table > tbody > tr > td.auto-style1 > form > div > center > table > tbody > tr > td:nth-child(1) > div > center > table > tbody > tr:nth-child(3) > td:nth-child(2) > p > input[type=\"button\"]"));
		save.click();
		
		WebElement logIn = webDriver.findElement(By.cssSelector("body > table > tbody > tr > td.auto-style1 > form > div > center > table > tbody > tr > td:nth-child(2) > small > a"));
		logIn.click();

		WebElement userName = webDriver.findElement(By.cssSelector("body > table > tbody > tr > td.auto-style1 > form > div > center > table > tbody > tr > td:nth-child(1) > table > tbody > tr:nth-child(1) > td:nth-child(2) > p > input"));
		userName.sendKeys("1194");
		WebElement password = webDriver.findElement(By.cssSelector("body > table > tbody > tr > td.auto-style1 > form > div > center > table > tbody > tr > td:nth-child(1) > table > tbody > tr:nth-child(2) > td:nth-child(2) > p > input[type=\"password\"]"));
		password.sendKeys("1194");
		WebElement testLogin = webDriver.findElement(By.cssSelector("body > table > tbody > tr > td.auto-style1 > form > div > center > table > tbody > tr > td:nth-child(1) > table > tbody > tr:nth-child(3) > td:nth-child(2) > p > input[type=\"button\"]"));
		testLogin.click();
		
		WebElement text = webDriver.findElement(By.cssSelector("body > table > tbody > tr > td.auto-style1 > big > blockquote > blockquote > font > center > b"));
		String success = "**Successful Login**";
		assertEquals("Not on the right Url", success, text.getText().toString());
	}


}
