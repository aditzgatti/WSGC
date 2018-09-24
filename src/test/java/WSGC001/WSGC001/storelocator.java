package WSGC001.WSGC001;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import junit.framework.Assert;

import org.openqa.selenium.chrome.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import java.util.concurrent.TimeUnit;

public class storelocator {
	public static WebDriver obj = null;
	String url = "https:\\www.westelm.com";	
	String mapurl="https://www.westelm.com/customer-service/store-locator.html?cm_sp=SuperNav-_-Stores#";
	String storeurl = "https://www.westelm.com/customer-service/store-locator.html?cm_sp=SuperNav-_-Stores#viewStoreList";
String shit;	
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
	
	@Then("^I select a store to check the number of stores$")
	public void I_select_a_store_to_check_the_number_of_stores() throws InterruptedException {
		System.out.println(obj.getCurrentUrl());
		if(obj.getCurrentUrl().equals(storeurl)){
		WebDriverWait wait = new WebDriverWait(obj, 60);
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//SELECT[@id='state-list-selector']")));
		obj.findElement(By.xpath("//SELECT[@id='state-list-selector']")).click();
		}else if 
		(obj.getCurrentUrl().equals(mapurl)){
							WebDriverWait wait1 = new WebDriverWait(obj, 60);
							wait1.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//A[@href='#viewStoreList'][text()='View All Stores ▸']")));
							obj.findElement(By.xpath("//A[@href='#viewStoreList'][text()='View All Stores ▸']")).click();
							 obj.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
							Select USstate = new Select(obj.findElement(By.xpath("//SELECT[@id='state-list-selector']")));
						    USstate.selectByValue("Arizona");
						    assertTrue(isTextPresent("We have 2 stores in Arizona"));
						    
						    USstate.selectByValue("Texas");
						    assertTrue(isTextPresent("We have 8 stores in Texas"));						    
						     						}
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
	@Then("^I quit the browser$")
	public void i_quit_the_browser() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    obj.quit();
	}
}
