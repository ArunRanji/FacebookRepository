package groupingConcepts;

import org.testng.annotations.Test;

public class DemoTest2 {

	@Test(groups = "regression")
	public void sample3() {
		
		System.out.println("sample 3");
	}
	@Test(groups = "sanity")
	public void sample4() {
		
		System.out.println("sample 4");
	}
}
