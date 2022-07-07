package pageobjects;

import java.io.IOException;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import common.WebpageCommon;
import junit.framework.Assert;
import utils.TestBase;

public class BrokenImages extends TestBase{
	
	WebpageCommon webpage = new WebpageCommon();
	int iBrokenImageCount =0;
	
	@SuppressWarnings("deprecation")
	public void userclicksonlink(String brokenimage)
	{
		driver.findElement(By.xpath("//a[text()='"+brokenimage+"']")).click();
		Assert.assertTrue("user land to correct webpage",webpage.getpagetitle().equalsIgnoreCase(brokenimage) );
	}
	
	public void getallbrokenimages() throws ClientProtocolException, IOException
	{
		try
		{
			List<WebElement> image_list = driver.findElements(By.tagName("img"));
			System.out.println("pages unsder the broken images are :"+image_list.size());
			for(WebElement images : image_list)
			{
				HttpClient hp = HttpClientBuilder.create().build();
				HttpGet request = new HttpGet(images.getAttribute("src"));
				HttpResponse response= hp.execute(request);
				if(response.getStatusLine().getStatusCode()!=200)
				{
					System.out.println(images.getAttribute("outerHTML") + " is broken.");
	                iBrokenImageCount++;
				}
				
			}
		}
		catch(Exception e)
	 
		{
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		
		System.out.println("webpages have broken iages count: "+iBrokenImageCount);
		
	}

}
