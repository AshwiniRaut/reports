package pageobjects;

import org.junit.Assert;
import org.openqa.selenium.By;
import utils.TestBase;


public class AddAndRemove extends TestBase {
	
	public static String  addButton = "//button[text()='Add Element']";
	public static String  deleteButton ="//button[text()='Delete']";
	public static String addandremovelink ="//a[text()='Add/Remove Elements']";
	

	public void validatewebpage()
	{
		String title = driver.getTitle();
		Assert.assertEquals("The Internet", title);
	}
	
	public void validateandclickonlink()
	{
		if(driver.findElement(By.xpath(addandremovelink)).isDisplayed())
		{
			driver.findElement(By.xpath(addandremovelink)).click();
		}
	}
	
	public void validateElementPresent()
	{
		if(driver.findElement(By.xpath(addButton)).isDisplayed())
		{
			Assert.assertTrue(driver.findElement(By.xpath(addButton)).isEnabled());
		}
	}
	
	public void addButtonFunctionality()
	{
		driver.findElement(By.xpath(addButton)).click();
		if(driver.findElement(By.xpath(deleteButton)).isDisplayed())
		{
			if(driver.findElement(By.xpath(deleteButton)).isEnabled())
			{
				Assert.assertTrue(driver.findElement(By.xpath(deleteButton)).isEnabled());
			}
		}
	}
	
	public void removeButtonFunctionality()
	{
		driver.findElement(By.xpath(deleteButton)).click();
		Assert.assertTrue(driver.findElement(By.xpath(addButton)).isDisplayed());
	}

	
	
	
	
	

}
