package Academy.E2EProjects;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


import pageObjects.Landingpage;
import pageObjects.LoginPage;
import resources.BaseClass;

public class HomePage extends BaseClass


{
	private static Logger log =LogManager.getLogger(BaseClass.class.getName());
	public WebDriver driver;
	@BeforeTest
	public void Initialize() throws IOException
	{
	driver=IntializeDriver();
	
	}
	
	@Test(dataProvider="getData")
	
	public void BasePageNavigation(String username,String password) throws IOException
	{	
		driver.get(prop.getProperty("url"));
		Landingpage lp=new Landingpage(driver);
		lp.getLogin().click();
		
		LoginPage loginp=new LoginPage(driver);
		loginp.getEmail().sendKeys(username);
		loginp.getPassword().sendKeys(password);
		loginp.getsignIn().click();
		log.info("Successfully Login");
		
	}
	
	@AfterTest

	public void TearDown()
	{
		driver.close();
	}
	
	@DataProvider
	
	public  Object getData()
	{
		Object[][] data=new Object[2][2];
		data[0][0]="abc@xyz.com";
		data[0][1]="123455";
		
		data[1][0]="becc@yuf.com";
		data[1][1]="147889";
		
		return data;
		
		
		
		
	}
	

}
