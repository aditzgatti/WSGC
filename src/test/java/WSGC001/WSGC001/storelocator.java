package WSGC001.WSGC001;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import java.util.concurrent.TimeUnit;

public class storelocator {
	public static WebDriver obj = null;
	String url = "https:\\www.westelm.com";	
	
	
	@Given("^I am on the westelm homepage$")
	public void i_am_on_the_westelm_homepage() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		System.setProperty("webdriver.chrome.driver","C:\\Users\\rithu\\Desktop\\eclipse\\Maven\\chromedriver.exe");
	    obj = new ChromeDriver();
	    obj.get(url);
	}

	@Then("^I click Stores link to go to Store Locator page$")
	public void i_click_Stores_link_to_go_to_Store_Locator_page() throws InterruptedException {
	    // Write code here that turns the phrase above into concrete actions
	    
		obj.findElement(By.xpath("//*[@id='stores-link']")).click();
		
	    	}

	
	//check for text view all stores
	protected boolean isvasPresent(String text){
		try{
			boolean d = obj.getPageSource().contains(text);
			return d;
		} catch (Exception e) {
			return false;
		}
		
	}
	
				@Then("^I select View All Stores link$")
	public void i_select_View_All_Stores_link() throws InterruptedException {
		//obj.manage().window().maximize();
		Thread.sleep(6000);
		assertTrue(isvasPresent("View All Stores"));
		
obj.findElement(By.xpath("//*[@id='store-locator']/main/div[3]/div[2]/section[1]/section[1]/div[3]/a"));
	//obj.findElement(By.xpath("//*[@id='store-locator']/main/div[3]/div[2]/section[2]/div[1]/div[2]/a]")).click();
	
	}
				
	@Then("^I select Arizona from the Select Your State drop down$")
	public void i_select_Arizona_from_the_Select_Your_State_drop_down() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    obj.findElement(By.xpath("//*[@id='state-list-selector']"));
	    Select USstate = new Select(obj.findElement(By.xpath("//*[@id='state-list-selector']")));
	    USstate.selectByVisibleText("Arizona");
	    }

	
	private void assertTrue(boolean textPresent) {
		// TODO Auto-generated method stub
		
	}
	protected boolean isTextPresent(String text){
		try{
			boolean b = obj.getPageSource().contains(text);
			return b;
		} catch (Exception e) {
			return false;
		}
		
	}
	
	@Then("^I validate the number of stores returned$")
	public void i_validate_the_number_of_stores_returned() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		//We have 2 stores in Arizona :
		assertTrue(isTextPresent("We have 2 stores in Arizona"));
	}

	

	@Then("^I select Texas from the Select Your State drop down$")
	public void i_select_Texas_from_the_Select_Your_State_drop_down() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		obj.findElement(By.xpath("//*[@id='state-list-selector']"));
	    Select USstate = new Select(obj.findElement(By.xpath("//*[@id='state-list-selector']")));
	    USstate.selectByVisibleText("Texas");
	}
	
	@And("^I validate the number of stores returned1$")
	public void i_validate_the_number_of_stores_returned1() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
			assertTrue(isTextPresent("We have 8 stores in Texas"));
	}

	@Then("^I quit the browser$")
	public void i_quit_the_browser() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}


	
	
	

}
