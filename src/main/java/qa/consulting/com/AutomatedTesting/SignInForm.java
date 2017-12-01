package qa.consulting.com.AutomatedTesting;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignInForm {
	
	@FindBy(css = "#customer_firstname")
	private WebElement addName;
	
	public WebElement createName() {
		return addName;
	}
	
	@FindBy(css = "#customer_lastname")
	private WebElement addLastName;
	
	public WebElement createLastName() {
		return addLastName;
	}
	
	@FindBy(css = "#passwd")
	private WebElement addPassword;
	
	public WebElement createPassword() {
		return addPassword;
	}
	
	@FindBy(css = "#company")
	private WebElement addCompany;
	
	public WebElement createCompany() {
		return addCompany;
	}
	
	@FindBy(css = "#address1")
	private WebElement addAddress1;
	
	public WebElement createAddress1() {
		return addAddress1;
	}
	
	@FindBy(css = "#address2")
	private WebElement addAddress2;
	
	public WebElement createAddress2() {
		return addAddress2;
	}
	
	@FindBy(css = "#city")
	private WebElement addCity;
	
	public WebElement createCity() {
		return addCity;
	}
	
	@FindBy(css = "#id_state")
	private WebElement addState;
	
	public WebElement createState() {
		return addState;
	}
	
	@FindBy(css = "#postcode")
	private WebElement code;
	
	public WebElement createCode() {
		return code;
	}
	
	@FindBy(css = "#id_country")
	private WebElement country;
	
	public WebElement selectCountry() {
		return country;
	}
	
	@FindBy(css = "#phone_mobile")
	private WebElement addNumber;
	
	public WebElement createNumber() {
		return addNumber;
	}
	
	@FindBy(css = "#submitAccount > span")
	private WebElement register;
	
	public void registerButton() {
		register.click();
	}

}
