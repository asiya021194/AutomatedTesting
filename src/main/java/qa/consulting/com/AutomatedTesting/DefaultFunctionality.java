package qa.consulting.com.AutomatedTesting;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DefaultFunctionality {
	
	@FindBy(css = "#draggable")
	private WebElement drag;
	
	public WebElement dragItem() {
		return drag;
	}

}
