package runbot;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TwitchBot {

	WebDriver driver;
	@Given("On Twitch")
	public void On_Twitch() throws Exception{
		System.setProperty("webdriver.chrome.driver", "FILE_PATH\\chromedriver.exe");
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setAcceptInsecureCerts(true);
		ChromeOptions options = new ChromeOptions();
//		options.addArguments("--disable--extensions");
		options.addArguments("--user-data-dir=USER_PATH/User Data");
		options.addArguments("--profile-directory=default");
//		options.merge(caps);
		Thread.sleep(2000);
		driver = new ChromeDriver(options);

		driver.get("https://www.twitch.tv/");
		
	}
	
	@When("Signed In")
	public void Signed_In() throws Exception{
	boolean active = true;
	Thread.sleep(2000);
	int clicked = 0;
	while(active) {
		List<WebElement> elems = driver.findElements(By.xpath("//*[@id=\"live-page-chat\"]/div/div/div/div/div/section/div/div[6]/div[2]/div[2]/div[1]/div/div/div/div[2]/div/div/div/button/div"));
		//*[@id="live-page-chat"]/div/div/div/div/div[2]/section/div/div[6]/div[2]/div[2]/div[1]/div/div/div/div[2]/div/div/div/button/div
		if(elems.size() ==1) {
			driver.findElement(By.xpath("//*[@id=\"live-page-chat\"]/div/div/div/div/div/section/div/div[6]/div[2]/div[2]/div[1]/div/div/div/div[2]/div/div/div/button/div")).click();
			clicked++;
			System.out.println("Button Clicked times" + clicked);
			Thread.sleep(2000);
		}
		else {
			System.out.println("Claim Button not present searching again in 10 seconds current clicked amount" + clicked);
			Thread.sleep(10000);
		}
		
				
	}
	
	}

}
