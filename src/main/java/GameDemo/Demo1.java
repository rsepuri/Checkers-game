package GameDemo;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class Demo1 {

	public static	WebDriver driver ;
	@BeforeTest
	public void LaunchBrowser()
	{
		System.setProperty( 
	            "webdriver.chrome.driver", 
	            "C:\\Users\\rakes\\OneDrive\\Desktop\\Checkers-Game\\chromedriver.exe"
	            );
	  
	         driver = new ChromeDriver(); 
	  
	        // Maximize the browser 
	        // using maximize() method 
	        driver.manage().window().maximize(); 
	  
	        // Launching website 
	        driver.get("https://www.gamesforthebrain.com/game/checkers/"); 
	}

	@Test
	public void Verify_Checkers_Game() throws InterruptedException
	{
		  String  message=driver.findElement(By.xpath("//p[@id='message']")).getText();
		  if (message.contains("Select an orange piece to move.")) {
			  Reporter.log("Page loaded succesfully");
		  }
		  driver.findElement(By.xpath("//div[@id='board']/div[6]/img[6]")).click();
		  driver.findElement(By.xpath("//div[@id='board']/div[5]/img[7]")).click();
		  Thread.sleep(2000);
		  String  message1=driver.findElement(By.xpath("//p[@id='message']")).getText();
		  if (message1.contains("Make a move.")) {
			  Reporter.log("It's your move");
		  }
		  driver.findElement(By.xpath("//div[@id='board']/div[6]/img[4]")).click();
		  Thread.sleep(2000);
		  driver.findElement(By.xpath("//div[@id='board']/div[5]/img[5]")).click();
		  Thread.sleep(2000);
		  driver.findElement(By.xpath("//div[@id='board']/div[7]/img[3]")).click();
		  Thread.sleep(2000);
		  driver.findElement(By.xpath("//div[@id='board']/div[5]/img[5]")).click();
		  Thread.sleep(2000);
		  driver.findElement(By.xpath("//div[@id='board']/div[6]/img[2]")).click();
		  Thread.sleep(2000);
		  driver.findElement(By.xpath("//div[@id='board']/div[5]/img[3]")).click();
		  Thread.sleep(2000);
		  driver.findElement(By.xpath("//div[@id='board']/div[7]/img[7]")).click();
		  Thread.sleep(2000);
		  driver.findElement(By.xpath("//div[@id='board']/div[5]/img[5]")).click();
		  Thread.sleep(2000);
		  
		  driver.findElement(By.xpath("//p[@class='footnote']/a[1]")).click();
		  Thread.sleep(2000);
		  driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[1]/div[1]/p[2]/a[1]")).click();
		  Thread.sleep(2000);
		  String  message2=driver.findElement(By.xpath("//p[@id='message']")).getText();
		  if (message2.contains("Select an orange piece to move.")) {
			  Reporter.log("Game Restarted succesfully");
		  }
	}
	
	@AfterTest
	public void cleanup()
	{
		driver.quit();
	}

}
