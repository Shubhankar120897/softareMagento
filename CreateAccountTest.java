package test;

import base.Base;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.CreateAccount;

public class CreateAccountTest {
	private CreateAccount createAccountPage;

	@BeforeClass
	public void setUp() throws Exception {
		Base.initializeDriver();
		Base.driver.get(Base.prop.getProperty("baseUrl"));
		createAccountPage = new CreateAccount(Base.driver);
	}

	@DataProvider(name = "accountDataProvider")
	public Object[][] accountDataProvider() {
		return new Object[][] { { "John", "Doe", "john.doe@example.com", "password123", "password123" },
				{ "Jane", "Smith", "jane.smith@example.com", "pass456", "pass456" },
				{ "Alice", "Johnson", "alice.johnson@example.com", "pass789", "pass789" } };
	}

	@Test(dataProvider = "accountDataProvider")
	public void testCreateNewAccount(String firstName, String lastName, String email, String password,
			String confirmPassword) {

		createAccountPage.applicationLogin(firstName, lastName, email, password, confirmPassword);

	}

	@AfterClass
	public void tearDown() {
		Base.closeDriver();
	}
}
