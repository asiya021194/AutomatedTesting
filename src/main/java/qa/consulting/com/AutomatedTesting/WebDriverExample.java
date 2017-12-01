package qa.consulting.com.AutomatedTesting;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverExample {

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
		searchBar.sendKeys("github \n");
		WebElement githubLink = webDriver
				.findElement(By.cssSelector("#rso > div:nth-child(1) > div > div > div > div > h3 > a"));
		githubLink.click();

		WebElement signIn = webDriver.findElement(By.cssSelector(
				"body > div.position-relative.js-header-wrapper > header > div > div.HeaderMenu.HeaderMenu--bright.d-lg-flex.flex-justify-between.flex-auto > div > span > div > a:nth-child(1)"));
		signIn.click();

		WebElement userName = webDriver.findElement(By.cssSelector("#login_field"));
		userName.sendKeys("asiya021194");
		WebElement passWord = webDriver.findElement(By.cssSelector("#password"));
		passWord.sendKeys("White6696+" + "\n");

		String currentUrl = webDriver.getCurrentUrl();
		String expectedUrl = "https://github.com/";
		assertEquals("Not on the right Url", expectedUrl, currentUrl);
	}

}
