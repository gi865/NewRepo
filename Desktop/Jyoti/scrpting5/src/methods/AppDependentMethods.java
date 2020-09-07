package methods;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import driver.DriverScript;
import locators.ObjectLocators;

public class AppDependentMethods extends DriverScript implements ObjectLocators{
	/*******************************************************
	 * Method Name			: navigateURL
	 * Purpose				: It is used to load the required URL
	 * Return Type			: void
	 * Date Created			: 
	 * Date modified		:
	 * Reviewed By			:
	 * Example				:  
	 ******************************************************
	 */
	public boolean navigateURL(WebDriver oDriver,String strURL) {
		try {
			oDriver.navigate().to(strURL);
			Thread.sleep(2000);
			if(appInd.compareValue(oDriver.getTitle(),"actiTIME - Login))")) {
				return true;
			}else {
				return false;
			}
		}catch(Exception e)
		{
			appInd.writeResult("Exception", "Exception in 'navigateURL()' method."+e.getMessage());
			return false;
		}
	}
	
	/*******************************************************
	 * Method Name			: loginToApp
	 * Purpose				: Login to the actiTime application
	 * Return Type			: void
	 * Date Created			: 
	 * Date modified		:
	 * Reviewed By			:
	 * Example				:  
	 ******************************************************
	 */
	public boolean loginToApp(WebDriver oDriver, String strUN, String strPWD) {
		String strStatus=null;
		try {
			strStatus+=appInd.setObject(oDriver, obj_UserName_Edit, strUN);
			strStatus+=appInd.setObject(oDriver, obj_Password_Edit, strPWD);
			strStatus+=appInd.clickObject(oDriver, obj_Login_Btn);
			
			//Verify optional element 
			if(appInd.verifyOptionalElemnet(oDriver, obj_Explore_Btn)) {
				strStatus+=String.valueOf(appInd.clickObject(oDriver, obj_Explore_Btn));
			}
			Thread.sleep(4000);
			
			
			//Handle the shortcut window
			if(appInd.verifyOptionalElemnet(oDriver, obj_ShortCut_Window))
			{
				strStatus+=appInd.clickObject(oDriver, obj_shortCut_Close_Btn);
			}
			
			

			//3. Verify login is successful
			strStatus+=appInd.verifyElementExist(oDriver, obj_Logo_Img);
			if(strStatus.contains("flase"))
			{
				   return false;
			}else {
				return true;
			}
				
			
		}catch(Exception e)
		{
			appInd.writeResult("Exception","Exception in 'loginToApp()' method."+e.getMessage());
			return false;
		}
		
	}
	/*******************************************************
	 * Method Name			: createUser
	 * Purpose				: to create the user in the actiTime application
	 * Return Type			: void
	 * Date Created			: 
	 * Date modified		:
	 * Reviewed By			:
	 * Example				:  
	 ******************************************************
	 */
	public String createUser(WebDriver oDriver)
	{
		String strUserName=null;
		String strStatus=null;
		try {
			strStatus+=appInd.clickObject(oDriver, obj_USER_Menu);
			Thread.sleep(2000);
			
			strStatus+=appInd.clickObject(oDriver, obj_AddUser_Btn);
			Thread.sleep(2000);
			
			String LN=appInd.getPropData("LastName");
			String FN=appInd.getPropData("FirstName");
			strStatus+=appInd.setObject(oDriver, obj_FirstName_Edit, FN);
			strStatus+=appInd.setObject(oDriver, obj_LastName_Edit, LN);
			strStatus+=appInd.setObject(oDriver, obj_Email_Edit, appInd.getPropData("EmailID"));
			strStatus+=appInd.setObject(oDriver, obj_User_UN_Edit, appInd.getPropData("User_UserName"));
			strStatus+=appInd.setObject(oDriver, obj_User_PWD_Edit, appInd.getPropData("User_Pwd"));
			strStatus+=appInd.setObject(oDriver, obj_User_Retype_Edit, appInd.getPropData("User_Pwd"));
			
			//click on "Create User" button
			strStatus+=appInd.clickObject(oDriver,obj_CreateUser_Btn);
			Thread.sleep(2000);
			strUserName="nagoji, jyoti";
			
			//5. Verify user is created
			strStatus+=appInd.verifyElementExists(oDriver, By.xpath("//div[@class='name']/span[text()='nagoji, jyoti']"));
			if(strStatus.contains("false"))
			{
				appInd.writeResult("Fail","Failed to create the user");
				return null;
			}else {
				appInd.writeResult("pass", "User is created");
				return strUserName;
			}
			
		}catch(Exception e)
		{
			appInd.writeResult("Exception", "Exception in 'createUser()' method."+e.getMessage());
			return null;
		}
	}
	/*******************************************************
	 * Method Name			: deleteUser
	 * Purpose				: to delete the user in the actiTime application
	 * Return Type			: void
	 * Date Created			: 
	 * Date modified		:
	 * Reviewed By			:
	 * Example				:  
	 ******************************************************
	 */
	public boolean deleteUser(WebDriver oDriver,String userToBeDeleted)
	{
		String strStatus=null;
		try {
			strStatus+=appInd.clickObject(oDriver,  By.xpath("//div[@class='name']/span[text()="+"'"+userToBeDeleted+"'"+"]"));
			Thread.sleep(4000);
			
			strStatus+=appInd.clickObject(oDriver, obj_DeleteUser_Btn);
			Thread.sleep(2000);
			
			oDriver.switchTo().alert().accept();
			Thread.sleep(2000);
			
			//7. verify user is deleted
			strStatus+=appInd.verifyElementExists(oDriver, By.xpath("//div[@class='name']/span[text()="+"'"+userToBeDeleted+"'"+"]"));
			if(strStatus.contains("flase"))
			{
				appInd.writeResult("Fail", "Failed to delete the user");
				return false;
			}else {
				appInd.writeResult("pass","User deleted successful");
				return true;
			}
						
		}catch(Exception e)
		{
					appInd.writeResult("Exception","Exception in 'deleteUser()' method."+e.getMessage());
			return false;
		}	
	}
	
	/*******************************************************
	 * Method Name			: logoutFromApp()
	 * Purpose				: to logout from the actiTime application
	 * Return Type			: void
	 * Date Created			: 
	 * Date modified		:
	 * Reviewed By			:
	 * Example				:  
	 ******************************************************
	 */
	public boolean logoutFromApp(WebDriver oDriver)
	{
		String strStatus = null;
		try {
			strStatus+=appInd.clickObject(oDriver, obj_Logout_Btn);
			Thread.sleep(2000);
			
			
			//9. VErify logout is successful
			strStatus+=appInd.verifyElementExist(oDriver, obj_Header_Text);
			
			if(strStatus.contains("false")) {
				appInd.writeResult("Fail", "FAiled to logout form the application");
				return false;
			}else {
				appInd.writeResult("pass", "Logout is successful");
				return true;
			}
		}catch(Exception e)
		{
			appInd.writeResult("Exception", "Exception in 'logoutFromApp()' method."+e.getMessage());
			return false;
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
