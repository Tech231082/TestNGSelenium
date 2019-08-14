package com.test;

import org.testng.annotations.Test;

public class ExpectedExceptionDemo {
	
	
	//
	@Test(expectedExceptions=ArithmeticException.class)
	public void test() {
		int a=3;
		int b=0;
		int c=a/b;
		
	}

}
