package Testcase;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import candidatepages.Delete;
import candidatepages.Features;
import candidatepages.Fetch;
import candidatepages.Forward;
import candidatepages.Listing;
import candidatepages.Login;
import candidatepages.Logout;
import candidatepages.ReplaceDoc;
import candidatepages.Update;
import testbase.TestBase;

public class TestCases extends TestBase {

	@BeforeMethod
	public void a() throws Exception {

		testbase.TestBase.loadPropertiesFile();
		testbase.TestBase.getBrowser("chrome");

	}

	@Test
	public void Replacedoc() throws Exception { // replacedoc
		System.out.println("replacedoc");
		Login.run();
		ReplaceDoc.load();
		Logout.out();

	}

	@Test
	public void forward() throws Exception { // Forward
		System.out.println("Profile actions");
		Login.run();
		Forward.forw();
		Logout.out();

	}

	@Test
	public void delete() throws Exception { // delete
		System.out.println("delete");
		Login.run();
		Delete.remove();
		Logout.out();

	}

	@Test
	public void fetch() throws Exception { // fetch
		System.out.println("My jobs-fetch");
		Login.run();
		Fetch.fet();
		Logout.out();

	}

	@Test
	public void listing() throws Exception { // listing
		System.out.println("Job-Alert");
		Login.run();
		Listing.list();
		Logout.out();

	}

	@Test
	public void features() throws Exception { // features
		System.out.println("Features-Demand Index");
		Login.run();
		Features.feature();
		Logout.out();

	}

}
