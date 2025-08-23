package advTestNg;

import org.testng.annotations.Test;

public class GroupingDemo {
	@Test(groups={"smoke"})
	public void test1(){
		System.out.println("Testcase execution!!!");
		
	}
	@Test(groups={"sanity"})
	public void test2(){
		System.out.println("Testcase execution!!!");
		
	}
	@Test(groups={"Regression"})
	public void test3(){
		System.out.println("Testcase execution!!!");
	
	}
	@Test(groups={"smoke","Regression"})
	public void test4(){
		System.out.println("Testcase execution!!!");
	
	}

}
