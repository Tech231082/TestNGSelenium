package com.test;

import org.testng.annotations.Test;

public class GroupsTest {

	@Test(groups="Maths")
	public void sum() {
		int a=1;
		int b=8;
		int c=9;
		int d=a+b+c;
		
		System.out.println("sum is = "+d);
	}
	
	@Test(groups="Maths---multi")
	public void multiply() {
		int a=1;
		int b=8;
		int c=9;
		int d=a*b*c;
		
		System.out.println("multiplication is = "+d);
	}
	
	@Test(invocationCount=5)
	public void divide() {
		int a=1;
		int b=8;
		int c=9;
		int d=a+b/c;
		
		System.out.println("division is = "+d);
	}
}
