package scripts;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pageClass.pageView;

import com.testng.SonnetTestNGBase;

public class DriverScript extends SonnetTestNGBase {
	
	pageView tc = new pageView();
	
	@BeforeClass(groups={"Smoke","Regression","Functional"})
	public void data() throws Exception{
		tc.dataInitialeze();
		
	}
	@BeforeMethod(groups={"Smoke","Regression","Functional"})
	public void test_start () throws Exception{
		tc.setup();
	}
	
	@AfterMethod(groups={"Smoke","Regression","Functional"})
	public void exit(){
		tc.closeBrowser();
	}

	@Test(priority=1,groups={"Regression"},description="Bug Reporting",enabled=true)
	public void reportAbug() throws Exception{

		tc.navigateToNewsTab();
		tc.reportABug();
	}
	
	@Test(priority=2,groups={"Regression"},description="Bug Reporting",enabled=true)
	public void feature() throws Exception{        
		tc.navigateToFeaturetTab();
	}
}
