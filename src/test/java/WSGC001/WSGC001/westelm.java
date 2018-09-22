package WSGC001.WSGC001;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;

public class westelm {
public static WebDriver obj = null;
String url = "https:\\www.westelm.com";
String sku = "2613243";
	@Given("^I am at the westelm homepage$")
	public void i_am_at_the_westelm_homepage() throws Throwable {
	    // Launch the website in chrome
		System.setProperty("webdriver.chrome.driver","C:\\Users\\rithu\\Desktop\\eclipse\\Maven\\chromedriver.exe");
	    obj = new ChromeDriver();
	    obj.get(url);
	    }
	
	
	@Then("^I enter the sku number in the search box$")
	public void i_enter_the_sku_number_in_the_search_box() throws InterruptedException {
	    // Write code here that turns the phrase above into concrete actions
	    //obj.findElement(By.xpath("//*[@id='search']")).sendKeys("2613243");
	    Actions actions = new Actions(obj);
	    actions.moveToElement(obj.findElement(By.xpath("//*[@id='search']")));
	    actions.click();
	    Thread.sleep(5000);
	    actions.sendKeys(sku);
	    Thread.sleep(5000);
	}

	@Then("^I click the search icon$")
	public void i_click_the_search_icon() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    obj.findElement(By.xpath("//*[@id='btnSearch']"));
	    Thread.sleep(5000);
	}
	
	protected boolean isTextPresent(String text){
		try{
			boolean b = obj.getPageSource().contains(text);
			return b;
		} catch (Exception e) {
			return false;
		}
		
	}

	@Then("^I navigate to the result page$")
	public void i_navigate_to_the_result_page() {
	    // Write code here that turns the phrase above into concrete actions
	    //Andes Extra Deep Depth Armless 1 Seater, Twill, Regal Blue, Blackened Brass
		assertTrue(isTextPresent("Andes Extra Deep Depth Armless 1 Seater, Twill, Regal Blue, Blackened Brass"));
		
	}


	private void assertTrue(boolean textPresent) {
		// TODO Auto-generated method stub
		
	}
	
	
	protected boolean isSearchResults(String text){
		try{
			boolean c = obj.getPageSource().contains(text);
			return c;
		} catch (Exception e) {
			return false;
		}
		
	}
	
	@Then("^I get a search result message$")
	public void i_get_a_search_result_message() {
		assertTrue(isSearchResults("We are unable to recognize the catalog quick shop number you entered. Please check your product number and re-enter. Example: 89-9169715."));	
	}
		
	@And("^I close the browser$")
	public void i_close_the_browser() {
			obj.quit();
	}


}
