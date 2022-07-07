package pageobjects;

import static org.junit.Assert.assertTrue;

import org.openqa.selenium.By;

import common.WebpageCommon;
import junit.framework.Assert;
import utils.TestBase;

public class FileUpload extends TestBase {
	
	WebpageCommon wb = new WebpageCommon();
	public static String fileupload = "//a[text()='File Upload']";
	public static String choosefile = "//input[@id='file-upload']";
	public static String uploadfilebutton = "//input[@id='file-submit']";
	public static String successfullMessage = "//div[@id='uploaded-files']";
	String fileuploaded = "test.txt";
	
	public void userclicksonlink(String brokenimage)
	{
		driver.findElement(By.xpath("//a[text()='"+brokenimage+"']")).click();
		Assert.assertTrue("user land to correct webpage",wb.getpagetitle().equalsIgnoreCase("File Uploader") );
	}
	
	public void validateandclickonlink()
	{
		if(driver.findElement(By.xpath(choosefile)).isDisplayed())
		{
			driver.findElement(By.xpath(choosefile)).isEnabled();
		}
	}
	
	public void verify_choosefile_button_availability()
	{
		if(driver.findElement(By.xpath(uploadfilebutton)).isDisplayed())
		{
			
			//driver.findElement(By.xpath(choosefile)).click();
				driver.findElement(By.xpath(choosefile)).sendKeys("C:\\Users\\Ashwini Raut\\eclipse-workspace\\com.interviewTest\\src\\test\\resources\\data\\test.txt");
				driver.findElement(By.xpath(uploadfilebutton)).click();
				assertTrue("file uploaded successfully", fileuploaded.equalsIgnoreCase(driver.findElement(By.xpath(successfullMessage)).getText()));
			
		}
		
	}

}
