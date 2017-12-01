package qa.consulting.com.AutomatedTesting;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignInPage {
	
	@FindBy(css = "#email_create")
	private WebElement addEmail;
	
	public void createEmail(String email) {
		addEmail.sendKeys(email);
	}
	
	@FindBy(css = "#SubmitCreate > span")
	private WebElement createButton;
	
	public void create() {
		createButton.click();
	}
	
	@FindBy(css = "#email")
	private WebElement logInEmail;
	
	public void insertEmail(String email) {
		logInEmail.sendKeys(email);
	}
	
	@FindBy(css = "#passwd")
	private WebElement logInPassword;
	
	public void insertPassword(String password) {
		logInPassword.sendKeys(password);
	}
	
	@FindBy(css = "#SubmitLogin > span")
	private WebElement signInButton;
	
	public void signIn() {
		signInButton.click();
	}
	
}
