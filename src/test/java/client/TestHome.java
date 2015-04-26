package client;

import static org.junit.Assert.fail;

import java.net.URL;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class TestHome {
	
	  @Test
	   public void testHomePage() throws Exception {
		  URL local = new URL("http://localhost:9515");
			WebDriver driver = new RemoteWebDriver(local, DesiredCapabilities.chrome());
			// open the browser and go to home page of the application
			driver.get("http://localhost:18080/mywebapp/");
			System.out.println(driver.getPageSource().length());
			// wait 5 seconds and close the browser
			Thread.sleep(5000);
			if(driver.getPageSource().length()!=1856)
				fail("Incorrect version of Software deployed");
			driver.quit();
	   }
	  
	  @Test
	  public void testHomeContent() throws Exception{
		  URL local = new URL("http://localhost:9515");
			WebDriver driver = new RemoteWebDriver(local, DesiredCapabilities.chrome());
			// open the browser and go to home page of the application
			driver.get("http://localhost:18080/mywebapp/");
			String text = "Spring is light weight java application development framework ";
			if(driver.getPageSource().contains("Spring is light weight java application development framework"))
				System.out.println("Correct version of software deployed");
			else
				fail("Incorrect version of Software deployed");
			
	  }
	  
}
