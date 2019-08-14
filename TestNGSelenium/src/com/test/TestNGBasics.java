package com.test;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNGBasics {
	@BeforeSuite
	public void beforeSuite() {
		System.out.println("Before Suite");
	}
	@BeforeClass
	public void launchBrowser() {
		System.out.println("before class");
	}
	@BeforeMethod
	public void beforeMethod() {
		System.out.println("before method");
	}
	@BeforeTest
	public void beforeTest() {
		System.out.println("before test");
	}
	
	@Test
	public void test() {
		System.out.println("running test case ");
	}
	
	@AfterTest
	public void afterTest() {
		System.out.println("after test");
	}
		
	@AfterMethod
	public void afterMethod() {
		System.out.println("after method");
	}
	
	@AfterClass
	public void afterClass() {
		System.out.println("afterclass");
	}
	
	@AfterSuite
	public void afterSuite() {
		System.out.println("after Suite");
	}
	

}
