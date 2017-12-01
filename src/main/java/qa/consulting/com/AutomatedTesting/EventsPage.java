package qa.consulting.com.AutomatedTesting;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EventsPage {
	
	@FindBy(css = "#dragevent > p")
	private WebElement dragItemMultipleTimes;
	
	public WebElement multipleDrag() {
		return dragItemMultipleTimes;
	}

}
