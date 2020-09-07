package testScripts;

import org.openqa.selenium.WebDriver;

import driver.DriverScript;

public class TestScripts extends DriverScript {
	
	/*******************************************************
	 * TestScript Name		: TS_LoginLogout
	 * TestCase ID			: SRS_Login01
	 * Purpose				: 
	 * Return Type			: boolean
	 * Date Created			: 
	 * Date modified		:
	 * Reviewed By			:
	 * Example				:  
	 ******************************************************
	 */
	public boolean TS_LoginLogout() {
		WebDriver oBrowser=null;
		String strStatus=null;
		try {
		         oBrowser=appInd.launchBrowser(appInd.getPropData("Browser"));
			if(oBrowser!=null)
			{
			strStatus+=appDep.navigateURL(oBrowser, appInd.getPropData("URL"));
			strStatus+=appDep.loginToApp(oBrowser, appInd.getPropData("UserName"), appInd.getPropData("Password"));
			strStatus+=appDep.logoutFromApp(oBrowser);
			strStatus+=appInd.closeBrowser(oBrowser);
			
			}else {
				return false;
			}
			if(strStatus.contains("false")) {
				return false;
			}else {
				return true;
			}
		}catch(Exception e)
		{
			appInd.writeResult("Exception", "Exception in TS_LoginLogout() test script. "+e.getMessage());
			return false;
		}finally {
			oBrowser = null;
			strStatus = null;
		}
	}
		
		

		/*******************************************************
		 * TestScript Name		: TS_CreateDeleteUser
		 * TestCase ID			: SRS_User01
		 * Purpose				: 
		 * Return Type			: boolean
		 * Date Created			: 
		 * Date modified		:
		 * Reviewed By			:
		 * Example				:  
		 ******************************************************
		 */
		public boolean TS_CreateDeleteUser() {
			WebDriver oBrowser = null;
			String strStatus = null;
			try {
				oBrowser = appInd.launchBrowser(appInd.getPropData("Browser"));
				if(oBrowser!=null) {
					strStatus+=appDep.navigateURL(oBrowser, appInd.getPropData("URL"));
					strStatus+=appDep.loginToApp(oBrowser, appInd.getPropData("UserName"), appInd.getPropData("Password"));
					String strUserName = appDep.createUser(oBrowser);
					strStatus+=appDep.deleteUser(oBrowser, strUserName);
					strStatus+=appDep.logoutFromApp(oBrowser);
					strStatus+=appInd.closeBrowser(oBrowser);
				}else {
					return false;
				}
				
				if(strStatus.contains("false")) {
					return false;
				}else {
					return true;
				}
			}catch(Exception e)
			{
				appInd.writeResult("Exception", "Exception in TS_CreateDeleteUser() test script. "+e.getMessage());
				return false;
			}
			finally {
				oBrowser = null;
				strStatus = null;
		        }
		}
	
		
		/*******************************************************
		 * TestScript Name		: TS_LoginWithNewUser_DeleteUser
		 * TestCase ID			: SRS_User02
		 * Purpose				: 
		 * Return Type			: boolean
		 * Date Created			: 
		 * Date modified		:
		 * Reviewed By			:
		 * Example				:  
		 ******************************************************
		 */
		public boolean TS_LoginWithNewUser_DeleteUser() {
			WebDriver oBrowser1 = null;
			WebDriver oBrowser2 = null;
			String strStatus = null;
			try {
				oBrowser1 = appInd.launchBrowser(appInd.getPropData("Browser"));
				if(oBrowser1!=null) {
					strStatus+=appDep.navigateURL(oBrowser1, appInd.getPropData("URL"));
					strStatus+=appDep.loginToApp(oBrowser1, appInd.getPropData("UserName"), appInd.getPropData("Password"));
					String strUserName = appDep.createUser(oBrowser1);
					
					//Login with new USer
					oBrowser2 = appInd.launchBrowser(appInd.getPropData("Browser"));
					if(oBrowser2!=null) {
						strStatus+=appDep.navigateURL(oBrowser2, appInd.getPropData("URL"));
						boolean blnRes = appDep.loginToApp(oBrowser2, appInd.getPropData("User_UserName"), 
								appInd.getPropData("User_Pwd"));
						if(blnRes) {
							appInd.writeResult("pass", "Login with new user was successful");
							oBrowser2.close();
						}else {
							appInd.writeResult("Fail","Failed to login with newly created user");
							oBrowser2.close();
							return false;
						}
					}else {
						return false;
					}
					strStatus+=appDep.deleteUser(oBrowser1, strUserName);
					strStatus+=appDep.logoutFromApp(oBrowser1);
					strStatus+=appInd.closeBrowser(oBrowser1);
				}else {
					return false;
				}
				
				if(strStatus.contains("false")) {
					return false;
				}else {
					return true;
				}
			}catch(Exception e)
			{
				appInd.writeResult("Exception","Exception in TS_LoginWithNewUser_DeleteUser() test script. "+e.getMessage());
				return false;
			}
			finally {
				oBrowser1 = null;
				oBrowser2 = null;
				strStatus = null;
			}
		}	
		
	
	}


