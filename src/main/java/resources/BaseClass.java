package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class BaseClass
{
	public WebDriver driver;
	public Properties prop;

	public WebDriver IntializeDriver() throws IOException 
	{
		prop=new Properties();
		FileInputStream fis=new FileInputStream("C:\\Users\\geena\\eclipse-workspace\\E2EProjects\\src\\test\\java\\resources\\E2EProjects\\data.properties");
		prop.load(fis);
		String BrowserName=prop.getProperty("browser");
		
		if(BrowserName.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\geena\\eclipse-workspace\\E2EProjects\\Drivers\\chromedriver.exe");
			driver=new ChromeDriver();
			
		}
		
		else if(BrowserName=="firefox")
		{
			driver=new FirefoxDriver();
		}
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;
	}
		
		public String getScreenShotPath(String testCaseName,WebDriver driver) throws IOException
		{
			TakesScreenshot ts=(TakesScreenshot) driver;
			File source =ts.getScreenshotAs(OutputType.FILE);
			String destinationFile = System.getProperty("user.dir")+"\\reports\\"+testCaseName+".png";
			FileUtils.copyFile(source,new File(destinationFile));
			return destinationFile;
		}
		
	}


