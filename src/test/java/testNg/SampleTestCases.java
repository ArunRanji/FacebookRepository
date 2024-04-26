package testNg;

import org.testng.Assert;
import org.testng.annotations.Test;

import listenersDemo.MyRetryAnalyzer;

public class SampleTestCases {
	
	@Test
	public void sampleMethod1() {
		
		Assert.assertTrue(true);
	}
	@Test
	public void sampleMethod2() {
		
		Assert.assertTrue(false);
	}

	@Test
	public void sampleMethod3() {
		
		Assert.assertTrue(false);
	}
}
