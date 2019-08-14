package com.test;

import org.testng.annotations.Test;

public class TestNGFeatures {
	@Test
	public void loginTest() {
		System.out.println("login test");
		int i=9/0;
		
	}
	@Test(dependsOnMethods="loginTest")
	public void HomePageTest() {
		System.out.println("Home page login test");
		
	}
	@Test(dependsOnMethods="HomePageTest")
	public void searchPageTest() {
		System.out.println("search page test");
		
	}

}
