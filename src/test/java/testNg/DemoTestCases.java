package testNg;

import org.testng.Assert;
import org.testng.annotations.Test;

public class DemoTestCases {
	
	@Test
	public void testCase1() {
		
		Assert.assertTrue(true);
	}
	
	@Test
	public void testCase2() {
		
		Assert.assertEquals(false, true);
	}

	@Test(dependsOnMethods ="testCase2" )
	public void testCase3() {
		
		Assert.assertTrue(true);
	}
}
