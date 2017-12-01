package qa.consulting.com.AutomatedTesting;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class Testing {

	@BeforeClass
	public static void init() {
		System.out.println("Init");
	}
	
	@Before
	public void setUp() {
		System.out.println("Set up");
	}
	
	
	@Test
	public void test1(){
		System.out.println("Hello World!");
	}
	
	@After
	public void tearDown() {
		System.out.println("Tear Down");
	}
	
	@AfterClass
	public static void destroy() {
		System.out.println("Destroy");
	}
	
	
}
