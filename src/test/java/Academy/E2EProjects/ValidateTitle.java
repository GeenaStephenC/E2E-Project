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

public class ValidateTitle extends BaseClass
{
public WebDriver driver;
private static Logger log =LogManager.getLogger(BaseClass.class.getName());


	@BeforeTest
	public void Initialize() throws IOException
	{
	driver=IntializeDriver();
	log.info("Driver is Initialized");
	
	
	driver.get(prop.getProperty("url"));
	log.info("Navigated to Homepage");
	}
	
	@Test
	public void TitleValidation() throws IOException
	
	{
	driver=IntializeDriver();
	driver.get(prop.getProperty("url"));
	
	Landingpage lp=new Landingpage(driver);
	Assert.assertEquals(lp.getTitle().getText(), "FEATURED COURSES");
	log.info("Successfully Validated the text message");
	}
	@AfterTest

	public void TearDown()
	{
		driver.close();
	}	
	
}
