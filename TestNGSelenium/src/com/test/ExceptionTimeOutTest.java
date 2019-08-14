package com.test;

import org.testng.annotations.Test;

public class ExceptionTimeOutTest {
	//@Test(invocationTimeOut=2)
	//public void InfiniteLoop() {
	//	int i=1;
	//	while(i==1) {
	//		System.out.println(i);
	//	}
		
	//}
	
	//(expectedExceptions=NumberFormatException.class)
	
	@Test(expectedExceptions=NumberFormatException.class)
	public void expectedExcep() {
		String x="100A";
		int a=Integer.parseInt(x);
		
	}

}
