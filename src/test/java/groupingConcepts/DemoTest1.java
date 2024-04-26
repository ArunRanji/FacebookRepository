package groupingConcepts;

import org.testng.annotations.Test;

public class DemoTest1 {
	@Test(groups = {"regression", "sanity"})
	public void sample1() {
		
		System.out.println("sample 1");
	}
	@Test(groups = "smoke")
	public void sample2() {
		
		System.out.println("sample 2");
		System.out.println("Edited from github remote repository");
	}

}
