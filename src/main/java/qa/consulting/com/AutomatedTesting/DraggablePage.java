package qa.consulting.com.AutomatedTesting;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DraggablePage {
	
	@FindBy(css = "#ui-id-2")
	private WebElement toConstraintMovementTab;
	
	public void toConstraintTab() {
		toConstraintMovementTab.click();
	}
	
	@FindBy(css = "#ui-id-3")
	private WebElement toCursorStyletTab;
	
	public void toCursorTab() {
		toCursorStyletTab.click();
	}
	
	@FindBy(css = "#ui-id-4")
	private WebElement toEventsTab;
	
	public void toEventTab() {
		toEventsTab.click();
	}
	
	@FindBy(css = "#ui-id-5")
	private WebElement toDragAndSortTab;
	
	public void toDragSortTab() {
		toDragAndSortTab.click();
	}

}
