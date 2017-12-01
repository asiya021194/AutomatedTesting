package qa.consulting.com.AutomatedTesting;

import static org.junit.Assert.*;

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
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class DraggableTest {
	
	private static ExtentReports report;
	private SpreadSheetReader spreadSheetReader;
	private WebDriver webDriver;
	private ScreenShot screenShot;
	private Actions builder;
	
	@BeforeClass
	public static void init() {
		report = new ExtentReports();
		String fileName = "MyReportDemoqa" + ".html";
		String filePath = System.getProperty("user.dir") + File.separatorChar + fileName;
		report.attachReporter(new ExtentHtmlReporter(filePath));
	}
	
	@Before
	public void setUp() {
		webDriver = new ChromeDriver();
		spreadSheetReader = new SpreadSheetReader("demoqa.xlsx");
		screenShot = new ScreenShot();
		builder = new Actions(webDriver);
	}
	
	@After
	public void tearDown() {
		webDriver.quit();
	}
	
	@AfterClass
	public static void cleanUp() {
		report.flush();
	}
	
	
	@Test
	public void defaultFunctionalityTest() {
		ExtentTest test = report.createTest("DefaultFunctionalityTest");
		test.log(Status.INFO, "My test for Default Functionality tab is starting.");
		List<String> webList = new ArrayList<String>();
		
		webList = spreadSheetReader.readRow(0, "webLinks");
		webDriver.navigate().to(webList.get(1));
		webDriver.manage().window().fullscreen();
		test.log(Status.INFO, "Opening up the website");
		
		HomePageDemoqa homepage = PageFactory.initElements(webDriver, HomePageDemoqa.class);
		homepage.toDraggable();
		test.log(Status.INFO, "To Draggable page");
		
		DefaultFunctionality draggable = PageFactory.initElements(webDriver, DefaultFunctionality.class);
		draggable.dragItem();
		
		try{
			screenShot.take(webDriver, "Before Drag(DF)");
		}catch (IOException e) {
			e.printStackTrace();
		}
		
		Integer initialXPosition = draggable.dragItem().getLocation().x;
		test.log(Status.DEBUG, "Initial x position: " + initialXPosition);
		Integer initialYPosition = draggable.dragItem().getLocation().y;
		test.log(Status.DEBUG, "Initial y position: " + initialYPosition);
		
		builder.dragAndDropBy(draggable.dragItem(), 300, 200).perform();
		test.log(Status.INFO, "Drag item");
		try{
			screenShot.take(webDriver, "Drag");
		}catch (IOException e) {
			e.printStackTrace();
		}
		
		assertTrue("Drag has failed", initialXPosition != draggable.dragItem().getLocation().x);
	}
	

	@Test
	public void constraintMovementTest() {
		ExtentTest test = report.createTest("ConstraintMovementTest");
		test.log(Status.INFO, "My test for Constraint Movement tab is starting.");
		List<String> webList = new ArrayList<String>();
		
		webList = spreadSheetReader.readRow(0, "webLinks");
		webDriver.navigate().to(webList.get(1));
		webDriver.manage().window().fullscreen();
		test.log(Status.INFO, "Opening up the website");
		
		HomePageDemoqa homepage = PageFactory.initElements(webDriver, HomePageDemoqa.class);
		homepage.toDraggable();
		test.log(Status.INFO, "To Draggable page");
		
		DraggablePage draggablePage = PageFactory.initElements(webDriver, DraggablePage.class);
		draggablePage.toConstraintTab();
		test.log(Status.INFO, "To Constraint Movement Tab");
		
		ConstraintMovement constraintMove = PageFactory.initElements(webDriver, ConstraintMovement.class);
		
		try{
			screenShot.take(webDriver, "Before Drag(CM)");
		}catch (IOException e) {
			e.printStackTrace();
		}	
		
		Integer initialXPositionV = constraintMove.dragVerticallyOnly().getLocation().x;
		test.log(Status.DEBUG, "Initial x position: " + initialXPositionV);
		Integer initialYPositionV = constraintMove.dragVerticallyOnly().getLocation().y;
		test.log(Status.DEBUG, "Initial y position: " + initialYPositionV);
		builder.moveByOffset(0,200).clickAndHold(constraintMove.dragVerticallyOnly()).moveByOffset(0, 200).release(constraintMove.dragVerticallyOnly()).perform();
		test.log(Status.INFO, "Item dragged vertically");
		try{
			screenShot.take(webDriver, "DragVertical");
		}catch (IOException e) {
			e.printStackTrace();
		}
		assertTrue("Drag has failed", !initialYPositionV.equals(constraintMove.dragVerticallyOnly().getLocation().y));
		
		constraintMove.dragHorizontallyOnly();
		Integer initialXPositionH = constraintMove.dragHorizontallyOnly().getLocation().x;
		test.log(Status.DEBUG, "Initial x position: " + initialXPositionH);
		Integer initialYPositionH = constraintMove.dragHorizontallyOnly().getLocation().y;
		test.log(Status.DEBUG, "Initial y position: " + initialYPositionH);
		builder.moveByOffset(500,0).clickAndHold(constraintMove.dragHorizontallyOnly()).moveByOffset(500, 0).release(constraintMove.dragHorizontallyOnly()).perform();
		test.log(Status.INFO, "Item dragged horizontally");
		try{
			screenShot.take(webDriver, "DragHorizontal");
		}catch (IOException e) {
			e.printStackTrace();
		}
		assertTrue("Drag has failed", !initialXPositionH.equals(constraintMove.dragHorizontallyOnly().getLocation().x));
		
		Integer initialXPositionB = constraintMove.dragWithinBoxOnly().getLocation().x;
		test.log(Status.DEBUG, "Initial x position: " + initialXPositionB);
		Integer initialYPositionB = constraintMove.dragWithinBoxOnly().getLocation().y;
		test.log(Status.DEBUG, "Initial y position: " + initialYPositionB);
		builder.moveByOffset(600, 20).clickAndHold(constraintMove.dragWithinBoxOnly()).moveByOffset(600, 20).release(constraintMove.dragWithinBoxOnly()).perform();
		test.log(Status.INFO, "Item dragged within the box");
		try{
			screenShot.take(webDriver, "DragWithinBox");
		}catch (IOException e) {
			e.printStackTrace();
		}
		assertTrue("Drag has failed", !initialXPositionB.equals(constraintMove.dragWithinBoxOnly().getLocation().x));
		
		
		Integer initialXPositionP = constraintMove.dragWithinBoxOnly().getLocation().x;
		test.log(Status.DEBUG, "Initial x position: " + initialXPositionP);
		Integer initialYPositionP = constraintMove.dragWithinBoxOnly().getLocation().y;
		test.log(Status.DEBUG, "Initial y position: " + initialYPositionP);
		builder.moveByOffset(0, -10).clickAndHold(constraintMove.withinParentBoxOnly()).moveByOffset(0, -10).release(constraintMove.withinParentBoxOnly()).perform();
		test.log(Status.INFO, "Item dragged within the parent box");
		try{
			screenShot.take(webDriver, "DragWithinParentBox");
		}catch (IOException e) {
			e.printStackTrace();
		}
		assertTrue("Drag has failed", !initialYPositionB.equals(constraintMove.dragWithinBoxOnly().getLocation().y));
		
	}
	
	@Test
	public void cursorStyleTest() {
		ExtentTest test = report.createTest("CursorStyleTest");
		test.log(Status.INFO, "My test for Cursor Style tab is starting.");
		List<String> webList = new ArrayList<String>();
		
		webList = spreadSheetReader.readRow(0, "webLinks");
		webDriver.navigate().to(webList.get(1));
		webDriver.manage().window().fullscreen();
		test.log(Status.INFO, "Opening up the website");
		
		HomePageDemoqa homepage = PageFactory.initElements(webDriver, HomePageDemoqa.class);
		homepage.toDraggable();
		test.log(Status.INFO, "To Draggable page");
		
		DraggablePage draggablePage = PageFactory.initElements(webDriver, DraggablePage.class);
		draggablePage.toCursorTab();
		test.log(Status.INFO, "To Cursor Style Tab");
		
		CursorStylePage cursorStyle = PageFactory.initElements(webDriver, CursorStylePage.class);
		
		try{
			screenShot.take(webDriver, "Before Drag(CS)");
		}catch (IOException e) {
			e.printStackTrace();
		}	
		
		Integer initialXPosition = cursorStyle.cursorStaysCentre().getLocation().x;
		test.log(Status.DEBUG, "Initial x position: " + initialXPosition);
		Integer initialYPosition = cursorStyle.cursorStaysCentre().getLocation().y;
		test.log(Status.DEBUG, "Initial y position: " + initialYPosition);
		
		
		Integer xPostitonExpect = cursorStyle.cursorStaysCentre().getLocation().x + 50 + 43;
		test.log(Status.DEBUG, "Expected x position: " + xPostitonExpect.toString());
		Integer yPositionExpect = cursorStyle.cursorStaysCentre().getLocation().y + 50 + 75;
		test.log(Status.DEBUG, "Expected y position: " + yPositionExpect.toString());
		
		
		builder.dragAndDropBy(cursorStyle.cursorStaysCentre(), 50, 50).perform();
		test.log(Status.INFO, "Drag with cursor at the centre");
		try{
			screenShot.take(webDriver, "CursorCentre");
		}catch (IOException e) {
			e.printStackTrace();
		}
		
		Integer currentX = cursorStyle.cursorStaysCentre().getLocation().x + 50;
		test.log(Status.DEBUG, "Current x position: " + currentX);
		Integer currentY = cursorStyle.cursorStaysCentre().getLocation().y + 50;
		test.log(Status.DEBUG, "Current y position: " + currentY);
		
		if(!xPostitonExpect.equals(currentX) && !yPositionExpect.equals(currentY)) {
			test.log(Status.FAIL, "Drag has failed");
		}
		
		Integer initialXPositionTL = cursorStyle.cursorStaysTopLeft().getLocation().x;
		test.log(Status.DEBUG, "initial x position (TL): " + initialXPositionTL);
		Integer initialYPositionTL = cursorStyle.cursorStaysTopLeft().getLocation().y;
		test.log(Status.DEBUG, "initial y position (TL): " + initialYPositionTL);
		
		Integer xPostitonExpectTL = cursorStyle.cursorStaysTopLeft().getLocation().x + 50 + 104;
		test.log(Status.DEBUG, "Expected x position (TL): " + xPostitonExpectTL.toString());
		Integer yPositionExpectTL = cursorStyle.cursorStaysTopLeft().getLocation().y + 50 + 105;
		test.log(Status.DEBUG, "Expected y position (TL): " + yPositionExpectTL.toString());
		
		builder.dragAndDropBy(cursorStyle.cursorStaysTopLeft(), 50, 50).perform();
		test.log(Status.INFO, "Drag with cursor at top left corner");
		try{
			screenShot.take(webDriver, "CursorTopLeft");
		}catch (IOException e) {
			e.printStackTrace();
		}
		
		Integer currentXTL = cursorStyle.cursorStaysTopLeft().getLocation().x + 50;
		test.log(Status.DEBUG, "Current x position (TL): " + currentXTL);
		Integer currentYTL = cursorStyle.cursorStaysTopLeft().getLocation().y + 50;
		test.log(Status.DEBUG, "Current y position (TL): " + currentYTL);
		
		if(!xPostitonExpectTL.equals(currentXTL) && !yPositionExpectTL.equals(currentYTL)) {
			test.log(Status.FAIL, "Drag has failed");
		}
		
		Integer initialXPositionB = cursorStyle.cursorStaysBottom().getLocation().x;
		test.log(Status.DEBUG, "initial x position (B): " + initialXPositionB);
		Integer initialYPositionB = cursorStyle.cursorStaysBottom().getLocation().y;
		test.log(Status.DEBUG, "initial y position (B): " + initialYPositionB);
		
		Integer xPostitonExpectB = cursorStyle.cursorStaysBottom().getLocation().x + 100;
		test.log(Status.DEBUG, "Expected x position (B): " + xPostitonExpectB.toString());
		Integer yPositionExpectB = cursorStyle.cursorStaysBottom().getLocation().y + 100;
		test.log(Status.DEBUG, "Expected y position (B): " + yPositionExpectB.toString());
		
		builder.dragAndDropBy(cursorStyle.cursorStaysBottom(), 100, 100).perform();
		test.log(Status.INFO, "Drag with cursor at bottom corner");
		try{
			screenShot.take(webDriver, "CursorBottom");
		}catch (IOException e) {
			e.printStackTrace();
		}
		
		Integer currentXB = cursorStyle.cursorStaysBottom().getLocation().x + 100;
		test.log(Status.DEBUG, "Current x position (B): " + currentXB);
		Integer currentYB = cursorStyle.cursorStaysBottom().getLocation().y + 100;
		test.log(Status.DEBUG, "Current y position (B): " + currentYB);
		
		if(!xPostitonExpectB.equals(currentXB) && !yPositionExpectB.equals(currentYB)) {
			test.log(Status.FAIL, "Drag has failed");
		}
		
	}
	
	
	@Test
	public void eventsTest() {
		ExtentTest test = report.createTest("EventsTest");
		test.log(Status.INFO, "My test for Events tab is starting.");
		List<String> webList = new ArrayList<String>();
		
		webList = spreadSheetReader.readRow(0, "webLinks");
		webDriver.navigate().to(webList.get(1));
		webDriver.manage().window().fullscreen();
		test.log(Status.INFO, "Opening up the website");
		
		HomePageDemoqa homepage = PageFactory.initElements(webDriver, HomePageDemoqa.class);
		homepage.toDraggable();
		test.log(Status.INFO, "To Draggable page");
		
		DraggablePage draggablePage = PageFactory.initElements(webDriver, DraggablePage.class);
		draggablePage.toEventTab();
		test.log(Status.INFO, "To Events Tab");
		
		EventsPage eventsPage = PageFactory.initElements(webDriver, EventsPage.class);
		try{
			screenShot.take(webDriver, "Before Drag (Events)");
		}catch (IOException e) {
			e.printStackTrace();
		}
		
		Integer initialXPosition = eventsPage.multipleDrag().getLocation().x;
		test.log(Status.DEBUG, "Initial x position: " + initialXPosition);
		Integer initialYPosition = eventsPage.multipleDrag().getLocation().y;
		test.log(Status.DEBUG, "Initial y position: " + initialYPosition);
		
		for(int i=0; i < 5; i++) {
			try{
				screenShot.take(webDriver, "Drag" + i);
				builder.dragAndDropBy(eventsPage.multipleDrag(), 50, 50).perform();
				test.log(Status.INFO, "Drag item");
			}catch (IOException e) {
				e.printStackTrace();
			}
		}
		test.log(Status.INFO, "Drag item");
		
		assertTrue("Drag has failed", initialXPosition != eventsPage.multipleDrag().getLocation().x);
	}
	
	@Test
	public void draggablesortableTest() {
		ExtentTest test = report.createTest("DraggableSortableTest");
		test.log(Status.INFO, "My test for Draggable and Sortable tab is starting.");
		List<String> webList = new ArrayList<String>();
		
		webList = spreadSheetReader.readRow(0, "webLinks");
		webDriver.navigate().to(webList.get(1));
		webDriver.manage().window().fullscreen();
		test.log(Status.INFO, "Opening up the website");
		
		HomePageDemoqa homepage = PageFactory.initElements(webDriver, HomePageDemoqa.class);
		homepage.toDraggable();
		test.log(Status.INFO, "To Draggable page");
		
		DraggablePage draggablePage = PageFactory.initElements(webDriver, DraggablePage.class);
		draggablePage.toDragSortTab();
		test.log(Status.INFO, "To Drag and Sort Tab");
		
		DragAndSortPage dragsortPage = PageFactory.initElements(webDriver, DragAndSortPage.class);
		try{
			screenShot.take(webDriver, "Before Drag (Drag and Sort)");
		}catch (IOException e) {
			e.printStackTrace();
		}
		
		Integer initialXPosition = dragsortPage.dragSortItem1().getLocation().x;
		test.log(Status.DEBUG, "Initial x position: " + initialXPosition);
		Integer initialYPosition = dragsortPage.dragSortItem1().getLocation().y;
		test.log(Status.DEBUG, "Initial y position: " + initialYPosition);
		
		builder.dragAndDropBy(dragsortPage.dragSortItem1(), 0, 30).perform();
			try{
				screenShot.take(webDriver, "Drag" );
				test.log(Status.INFO, "Drag item");
			}catch (IOException e) {
				e.printStackTrace();
			}
		
		builder.dragAndDropBy(dragsortPage.dragSortItem1(), 0, 30).perform();
			try{
				screenShot.take(webDriver, "Drag 2" );
				test.log(Status.INFO, "Drag item");
			}catch (IOException e) {
				e.printStackTrace();
			}
	}

}

