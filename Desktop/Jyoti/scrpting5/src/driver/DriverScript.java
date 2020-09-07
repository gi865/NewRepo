package driver;

import methods.AppDependentMethods;
import methods.AppIndependentMethods;
import testScripts.TestScripts;

public class DriverScript {
	public static AppIndependentMethods appInd = null;
	public static AppDependentMethods appDep = null;
	public static TestScripts scripts = null;
	public static boolean blnRes = false;
	
	public static void main(String[] args) {
		try {
	      appInd=new AppIndependentMethods();
	      appDep=new AppDependentMethods();
	      scripts=new TestScripts();
	     
	    //TS_LoginLogout()
	      blnRes=scripts.TS_LoginLogout();
	      if(blnRes) appInd.writeResult("pass", "Test script 'TS_LoginLogout()' Failed");
	      else appInd.writeResult("Fail", "Test script 'TS_LoginLogout()' passed");
			
			System.out.println("*************************************");
			
			//TS_CreateDeleteUser()
			blnRes = scripts.TS_CreateDeleteUser();
			if(blnRes) appInd.writeResult("pass","Test script 'TS_CreateDeleteUser()'Failed");
			else appInd.writeResult("Fail", "Test script 'TS_CreateDeleteUser()' passed");
			
			System.out.println("*************************************");
			
			/*//TS_LoginWithNewUser_DeleteUser()
			blnRes = scripts.TS_LoginWithNewUser_DeleteUser();
			if(blnRes) appInd.writeResult("Pass","Test script 'TS_LoginWithNewUser_DeleteUser()' passed");
			else appInd.writeResult("Fail","Test script 'TS_LoginWithNewUser_DeleteUser()' Failed");
			appInd.writeResult("#", "*************************************");
			appInd.writeResult("#", "*************************************");*/
		}catch(Exception e)
		{
			System.out.println(e);
		}

		}
	}

	


