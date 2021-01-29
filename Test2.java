package MavenPractise.MavenPractise;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class Test2 
{
	public static WebDriver driver;
	//@Test
	public void testgoogle()
	{
		driver = invokebrowser("chrome","https://www.google.com/");
		click(driver.findElement(By.xpath("//div[@class='FPdoLc tfB0Bf']//input[@name='btnI']")));
  
		List<WebElement> list = driver.findElements(By.tagName("a"));
    
    for(WebElement link : list)
    {	
    System.out.println(link.getAttribute("href"));
    break;
    }
	}
	
	@Test
	public void testfacebook() throws InterruptedException
	{
		driver = invokebrowser("chrome","https://www.facebook.com/");
	   click(driver.findElement(By.xpath("//a[@role='button']")));
	   sendtext(driver.findElement(By.xpath("//input[@name='firstname']")),"kumar");
	   sendtext(driver.findElement(By.xpath("//input[@name='lastname']")),"kiran");
	   sendtext(driver.findElement(By.xpath("//input[@name='reg_email__']")),"bharatamkiran@gmail.com");
	   sendtext(driver.findElement(By.xpath("//input[@id='password_step_input']")),"bharatamkiran@gmail.com");
	   List<WebElement> gender = driver.findElements(By.xpath("//span[@class='_5k_2 _5dba'] //label"));
	   for(int i=0;i<gender.size();i++)
	   {
		   String genders = driver.findElements(By.xpath("//span[@class='_5k_2 _5dba'] //label")).get(i).getText();
		   if(genders.contains("Male"))
		   {
			   driver.findElements(By.xpath("//input[@type='radio']")).get(i).click();
		   }
	   }
	   dropdown(driver.findElement(By.xpath("//select[@name='birthday_year']")),"1989");
	   Thread.sleep(1000);
	   dropdown(driver.findElement(By.xpath("//select[@id='month']")),"Mar");
	   Thread.sleep(1000);
	   dropdown(driver.findElement(By.xpath("//select[@name='birthday_day']")),"22");
	   
	}
	
	public static  WebDriver invokebrowser(String browser,String Url)
	{
		if(browser.contains("chrome"))
		{
			System.setProperty("webdriver.chrome.driver","C:\\work\\chromedriver.exe");
	    	driver = new ChromeDriver();
		}
	    driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	    driver.get(Url);
	    return driver;
	}
	
	public static void sendtext(WebElement element,String value)
	{
		element.sendKeys(value);
	}
	
	public static void click(WebElement element)
	{
		element.click();
	}
	
	public static void dropdown(WebElement element,String value)
	{
		Select dropdown = new Select(element);
		try
		{
		dropdown.selectByValue(value);
		}
		catch(Exception e)
		{
		 dropdown.selectByVisibleText(value);
		}
	}
}
