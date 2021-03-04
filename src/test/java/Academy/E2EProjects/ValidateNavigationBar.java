package Academy.E2EProjects;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.Landingpage;
import resources.BaseClass;

public class ValidateNavigationBar extends BaseClass

{
	public WebDriver driver;
	private static Logger log =LogManager.getLogger(BaseClass.class.getName());
@BeforeTest
	public void Initialize() throws IOException
{
	driver=IntializeDriver();
	driver.get(prop.getProperty("url"));
}
	
	
@Test	
	public void NavigateBarValidation() throws IOException
	{
		Landingpage lp=new Landingpage(driver);
		Assert.assertTrue(lp.getNav().isDisplayed());
		log.info("Successfully Validated the Navigation Bar");
	}
	
@AfterTest

public void TearDown()
{
	driver.close();
}
	

}
