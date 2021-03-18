package steps;

import cucumber.api.java.After;
import cucumber.api.java.Before;

public class hooks {

	@Before
	public void beforeTest() {
		System.out.println("<-------------------------Start of Test Case-------------------------->");
	}

	@After
	public void afterTest() {
		System.out.println("<-------------------------End of Test Case---------------------------->");
	}

}
