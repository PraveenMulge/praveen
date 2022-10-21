package test_cases;

import java.io.IOException;

import org.junit.Assert;
import org.testng.annotations.Test;

import libraries.login_related;
import utils.Excel_utils;
import utils.constant;

public class all_in_one_hybrid  extends constant{

	
	public static String file_path="C:\\Users\\prave\\workspace\\HybridFrameWork\\keywordfiles\\OrangeHRMKeywords.xlsx";
	public static String sheet1="TestCases";
	public static String sheet2="TestSteps";
	
		public static boolean re;
	public static	String res,resu;
	
	@Test
	public static void orangeHRMSuite() throws IOException, InterruptedException
	{
	   
		login_related lo=new login_related();
		
	     int rows1=Excel_utils.getRowCount(file_path,sheet1);
	     int row2=Excel_utils.getRowCount(file_path, sheet2);
		
		for(int i=1;i<=rows1;i++)
	    {
			String status=Excel_utils.getStringCellData(file_path,sheet1,i,2);
			if(status.equalsIgnoreCase("y"))
			{
			String tc_id=Excel_utils.getStringCellData(file_path, sheet1, i, 0);
			
			for(int j=1;j<=row2;j++)
			{
			  String ts_id=Excel_utils.getStringCellData(file_path, sheet2, j, 0);
				
				if(tc_id.equals(ts_id))
			{
			String keys=Excel_utils.getStringCellData(file_path, sheet2, j,4);
			switch(keys.toLowerCase())
			{
			
			case "adminlogin":
			String admin_user=Excel_utils.getStringCellData(file_path, sheet2, j, 5);
			 String admin_pass=Excel_utils.getStringCellData(file_path, sheet2, j, 6);
			lo.login(admin_user,admin_pass);
			re=lo.isavailable();
		    
			
			break;
				
			
			case "logout":
			re=lo.logout();
			
			break;
			
			
			case "newempreg":
				
			String first=Excel_utils.getStringCellData(file_path, sheet2, j, 5);
			String last=Excel_utils.getStringCellData(file_path, sheet2, j, 6);
			 re=lo.registration(first, last);
			break;
			
			
			case "newuserreg":
				
			String emp=	Excel_utils.getStringCellData(file_path, sheet2, j, 6);
			String user=Excel_utils.getStringCellData(file_path, sheet2, j, 7);
			String pwd=	Excel_utils.getStringCellData(file_path, sheet2, j, 8);
			String lst=	Excel_utils.getStringCellData(file_path, sheet2, j, 9);
				
			re=lo.user_registration(emp, user, pwd, lst);
		    break;
			
			
			case "emplogin":
			String emp_user=Excel_utils.getStringCellData(file_path, sheet2, j, 5);
			String emp_pass=Excel_utils.getStringCellData(file_path, sheet2, j, 6);
				
				lo.login(emp_user,emp_pass);
			    re=lo.userdisplayed();
		    break;
		    
			case "invalidlogin":
				
				String inv_user=Excel_utils.getStringCellData(file_path, sheet2, j, 5);
				String inv_pass=Excel_utils.getStringCellData(file_path, sheet2, j, 6);
				
				lo.login(inv_user, inv_pass);
		        re=lo.isErrMsgDis();
		        break;
		    
			}
			if(re)
			{
				res="Pass";
				Excel_utils.Create_Cell(file_path, sheet2, j, 3,res);
				Excel_utils.green_colour(file_path, sheet2, j, 3);
			
			}else
			{
				 resu="Fail";
				Excel_utils.Create_Cell(file_path, sheet2, j, 3,resu);
				Excel_utils.redcolour(file_path, sheet2, j, 3);
			}
			
		    String val=	Excel_utils.getStringCellData(file_path, sheet1, i, 3);
			if(!val.equals("Fail"))
			{
				Excel_utils.Create_Cell(file_path, sheet1, i, 3,res);
				Excel_utils.green_colour(file_path, sheet1, i, 3);
			}else
			{
				Excel_utils.Create_Cell(file_path, sheet1, i, 3,resu);
				Excel_utils.redcolour(file_path, sheet1, i, 3);
			}
			
			
			}
			}
			}else
			{
			 Excel_utils.Create_Cell(file_path, sheet1, i, 3,"Blocked");
			Excel_utils.redcolour(file_path, sheet1, i, 3);
				
				
			}
	    }	
	}
	
	}	

