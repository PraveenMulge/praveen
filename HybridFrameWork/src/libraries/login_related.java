package libraries;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import utils.constant;

public class login_related extends constant {

	
     
     
	public void login(String user,String pass) 
	{
	
	driver.findElement(By.id("txtUsername")).sendKeys(user);
	driver.findElement(By.id("txtPassword")).sendKeys(pass);
	driver.findElement(By.id("btnLogin")).click();

	}
	
    
     public boolean logout()
 	{
 	driver.findElement(By.partialLinkText("Welcome")).click();
 	driver.findElement(By.partialLinkText("Logout")).click();
      if(driver.findElement(By.id("btnLogin")).isDisplayed())
      {
    	 return true; 
      }else
      {
    	  return false;
      }
 	
 	
 	
 	
 	
 	
 	
 	
 	}
	
     public boolean registration(String first,String last)
 	{
 	driver.findElement(By.linkText("PIM")).click();
 	driver.findElement(By.linkText("Add Employee")).click();
 	driver.findElement(By.id("firstName")).sendKeys(first);
 	driver.findElement(By.id("lastName")).sendKeys(last);
 	
 	 String id= driver.findElement(By.id("employeeId")).getAttribute("value");
 	 driver.findElement(By.id("btnSave")).click();
 	 driver.findElement(By.id("menu_pim_viewEmployeeList")).click();
 	 driver.findElement(By.id("empsearch_id")).sendKeys(id);
 	 driver.findElement(By.id("searchBtn")).click();
 	 
 	 driver.findElement(By.id("resultTable"));
 	 List<WebElement> tr=  driver.findElements(By.tagName("tr"));
 	 
 	 
 	 boolean ne=false;
 	 
 	 for (int i = 1; i < tr.size(); i++)
 	 {
 		  List<WebElement>td= tr.get(i).findElements(By.tagName("td"));
 		   String idname=  td.get(1).getText();
 	 
 	    if(idname.equals(id))
 	    {
 	    	ne=true;
 	    	break;
 	    }
 	 
 	 }
 	if(ne)
 	{
 		return true;
 	}else
 	{
 		return false;
 	}

 	} 

	




public boolean isavailable()
{
 	
	if	(driver.findElement(By.linkText("Admin")).isDisplayed())
  {
	  return true;
  }else
  {
	  return false;
  }
}



public boolean userdisplayed()
{
	
try
{
if (driver.findElement(By.linkText("Admin")).isDisplayed())
{
	return false;
}
}
catch(Exception e)
{
	
}
return true;

}


public boolean user_registration(String emp,String user,String pwd,String lst) throws InterruptedException
{
	driver.findElement(By.linkText("PIM")).click();
	driver.findElement(By.linkText("Add Employee")).click();
	driver.findElement(By.id("firstName")).sendKeys(emp);
	driver.findElement(By.id("lastName")).sendKeys(lst);
	
	 String id= driver.findElement(By.id("employeeId")).getAttribute("value");
	 driver.findElement(By.id("btnSave")).click();

     driver.findElement(By.linkText("Admin")).click();
     driver.findElement(By.linkText("User Management")).click();
     //driver.findElement(By.linkText("Users")).click();
     driver.findElement(By.name("btnAdd")).click();
    
     driver.findElement(By.id("systemUser_employeeName_empName")).sendKeys(emp+" "+lst);
     driver.findElement(By.id("systemUser_userName")).sendKeys(user);
     driver.findElement(By.id("systemUser_password")).sendKeys(pwd);

     driver.findElement(By.id("systemUser_confirmPassword")).sendKeys(pwd);
     Thread.sleep(4000);
     driver.findElement(By.id("btnSave")).click();
     Thread.sleep(2000);
     driver.findElement(By.id("searchSystemUser_userName")).sendKeys(user);
     driver.findElement(By.id("searchBtn")).click();
     
      WebElement table= driver.findElement(By.id("resultTable"));
     List<WebElement> tr,td;
     
     tr=table.findElements(By.tagName("tr"));
     
     for(int i=1;i<tr.size();i++)
     {
    	 td=tr.get(i).findElements(By.tagName("td"));
    	 
    	   String text= td.get(1).getText();
    	   if(text.equals(user))
    	   {
    		   return true;
    	   }
    	   
    	   
     }
	return false;
}

 public boolean isErrMsgDis()
 {
	  String msg=driver.findElement(By.id("spanMessage")).getText();
	 if(msg.equals("Invalid credentials"))
	 {
		 return true;
	 }else
	 {
		 return false;
	 }
	  
 }











 



}
	
	










