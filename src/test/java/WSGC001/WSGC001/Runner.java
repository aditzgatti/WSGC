package WSGC001.WSGC001;


import org.junit.runner.RunWith;	
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;;

@RunWith(Cucumber.class)
@CucumberOptions(
features={"src/test/java/search.features","src/test/java/StoreLocator.feature"},
format={"pretty","html:target/Reports"}
)


public class Runner {

}