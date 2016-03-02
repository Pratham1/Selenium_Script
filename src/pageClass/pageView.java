package pageClass;

import org.openqa.selenium.By;

import com.base.AssertType;
import com.lib.TestDataSource;
import com.lib.data.DataFormat;

import test.webdriver.SonnetElement;

public class pageView extends SonnetElement{

	TestDataSource data_sample = new TestDataSource();
	
	public void dataInitialeze() throws Exception {
		String csvpath = _properties.getValue("data");
		data_sample.open(DataFormat.CSV, csvpath);
	}

	public void setup() throws Exception {
		invokeBrowser(_properties.getValue("browser_name"));
		navigateTo(_properties.getValue("url"));
		_wait.waitForPageLoad();
	}

	public void browserClose() {
		_Driver.quit();
	}
	
	public void navigateToNewsTab() throws Exception{
		
		findElement(By.linkText("News")).click();
		
		_assert.contains(getTitle(),"News","News Tab is open", false);
		
		
		_wait.waitForPageLoad();
	}
	
	public void reportABug() throws Exception{
		findElement(By.linkText("Report a Bug")).click();
		
		
		_assert.contains(getTitle(),"Reporting","Bug Reporting page is open", false);
		
		findElement(By.cssSelector("input#q")).sendKeys("Firefox");
		findElement(By.cssSelector("input#submit")).click();
		
	}
	
	public void navigateToFeaturetTab() throws Exception{
		findElement(By.linkText("Docs")).click();
		
		findElement(By.cssSelector("select[name='restrict']")).selectByVisibleText("4.4.11");
		findElement(By.cssSelector("select[name='method']")).selectByVisibleText("Any");
		findElement(By.cssSelector("select[name='sort']")).selectByVisibleText("Title");

		
		findElement(By.cssSelector("input[name='words']")).sendKeys("bugzilla");
		
		
		findElement(By.linkText("Features")).click();
		
		_assert.contains(getTitle(),"Feature","Feature page is open", false);
		
		findElement(By.cssSelector("input#q")).sendKeys("features");
		
		findElement(By.xpath(".//*[@id='mainContent']/h1")).validate(AssertType.EQUAL_TEXT,"News","Feature header is present ");
	}
}
