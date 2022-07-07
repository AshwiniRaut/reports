package stepdef;


import org.junit.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageobjects.FileUpload;

public class FileUploadstepdef {

	FileUpload fileupload = new FileUpload();
	
	@When("^User clicks on \"([^\"]*)\" link of webpage$")
	public void user_clicks_on_link(String brokenimage)
	{
		fileupload.userclicksonlink(brokenimage);
	}
	
	@Then("^Verify that file is uploaded successfully$")
	public void verify_that_file_is_uploaded_successfully()
	{
		fileupload.validateandclickonlink();
		fileupload.verify_choosefile_button_availability();
	}
}

