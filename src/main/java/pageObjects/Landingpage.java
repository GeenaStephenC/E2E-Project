package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Landingpage

{
public WebDriver driver;

By Login=By.linkText("Login");
By Title=By.xpath("//h2[text()='Featured Courses']");
By Nav=By.xpath("//ul[@class='nav navbar-nav navbar-right']");

public Landingpage(WebDriver driver) 
{
	this.driver=driver;
}

public WebElement getLogin()
{
	return driver.findElement(Login);
}

public WebElement getTitle()
{
	return driver.findElement(Title);
}


public WebElement getNav()
{
	return driver.findElement(Nav);
}

}
