package src.demo;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DemoGit {
@BeforeMethod
public void setUp() {
	System.out.println("setUp method");
}

@Test
public void test() {
	System.out.println("test method");
}

@AfterMethod
public void tearDown() {
	System.out.println("tear down method");
}
}
