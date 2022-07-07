package stepdef;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageobjects.AddAndRemove;

public class AddAndRemovestepdefs {
	
	AddAndRemove addandremove = new AddAndRemove();
	@Given("^User is on herokuapp webpage$")
	public void user_is_on_herokuapp_webpage() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		addandremove.validatewebpage();
	  
	}

	@When("^User clicks on Add And Remove button$")
	public void user_clicks_on_Add_And_Remove_button() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		addandremove.validateandclickonlink();
	    
	}

	@Then("^User navigates to the Add And Remove webpage$")
	public void user_navigates_to_the_Add_And_Remove_webpage() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		
		addandremove.validateElementPresent();
	    
	}

	@Then("^User clicks on add button$")
	public void user_clicks_on_add_button() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    addandremove.addButtonFunctionality();
	}

	@Then("^User clicks on Remove button$")
	public void user_clicks_on_Remove_button() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    addandremove.removeButtonFunctionality();
	}

}
