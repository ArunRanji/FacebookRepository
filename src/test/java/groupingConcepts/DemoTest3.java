package groupingConcepts;

import org.testng.annotations.Test;

public class DemoTest3 {
	
	@Test(groups = "sanity")
	public void sample5() {
		
		System.out.println("sample 4");
	}
	@Test(groups = "smoke")
	public void sample6() {
		
		System.out.println("sample 5");
	}

}
