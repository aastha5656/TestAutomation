package StepDefinition;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class GoogleSearchSteps {
	WebDriver driver = null;
	
	@SuppressWarnings("deprecation")
	@Given("browser is open")
	public void browser_is_open() {
		
		System.out.println("Inside Step - browser is open");
		
		String projectPath = System.getProperty("user.dir");
		System.out.println("Project path is :"+projectPath);
		
		System.getProperty("webdriver.chrome.driver", projectPath+"/src/test/resources/drivers/chromedriver_win32/chromedriver.exe");
	
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(40,TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		
		//driver.manage().window.maximize();
	}

	@And("user is on google search page")
	public void user_is_on_google_search_page() {
		System.out.println("Inside Step - user is on google search page");
		
		driver.navigate().to("https://google.com");
		
	}

	@When("user enters a text in searchbox")
	public void user_enters_a_text_in_searchbox() throws InterruptedException {
		System.out.println("Inside Step- user enters a text in search box");
		
		driver.findElement(By.name("q")).sendKeys("nihilent");
		Thread.sleep(4000);
	}

	@And("hits enter")
	public void hits_enter() throws InterruptedException {
		System.out.println("Inside Step - hits Enter");
		driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
		Thread.sleep(4000);
		
		
	}

	@Then("user is navigated to search results")
	public void user_is_navigated_to_search_results() throws InterruptedException {
		System.out.println("Inside Step- user is navigated to search results");
		
		driver.getPageSource().contains("nihilent in india");
		Thread.sleep(4000);
		
		driver.close();
		driver.quit();
		
	}


}
