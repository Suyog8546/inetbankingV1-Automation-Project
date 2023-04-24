package com.inetbanking.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetbanking.pageObject.AddCustomerPage;
import com.inetbanking.pageObject.LoginPage;
public class TC_AddCustomerTest_003 extends BaseClass {
	@Test
	public void addNewCustomer() throws InterruptedException, IOException
	{
		LoginPage lp=new LoginPage(driver);
		lp.setUserName(username);
		logger.info("User name is provided");
		lp.setPassword(password);
		logger.info("Passsword is provided");
		lp.clickSubmit();
		
		Thread.sleep(3000);
		
		AddCustomerPage addcust=new AddCustomerPage(driver);
		
		addcust.clickAddNewCustomer();
		
		logger.info("providing customer details....");
		
		
		addcust.custName("Suyog");
		addcust.custgender("male");
		addcust.custdob("15","07","1996");
		Thread.sleep(5000);
		addcust.custaddress("INDIA");
		addcust.custcity("Pune");
		addcust.custstate("Maharashtra");
		addcust.custpinno("411038");
		addcust.custtelephoneno("8329025107");
		
		String email=randomestring()+"@gmail.com";
		addcust.custemailid(email);
		addcust.custpassword("abcdef");
		addcust.custsubmit();
		
		Thread.sleep(3000);
		
		logger.info("validation started....");
		
		boolean res=driver.getPageSource().contains("Customer Registered Successfully!!!");
		
		if(res==true)
		{
			Assert.assertTrue(true);
			logger.info("test case passed....");
			
		}
		else
		{
			logger.info("test case failed....");
			captureScreen(driver,"addNewCustomer");
			Assert.assertTrue(false);
		}
			
	}
	
	
}
