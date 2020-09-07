package methods;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.Select;

import driver.DriverScript;

public class AppIndependentMethods extends DriverScript{
	//Methods for user actions
		/*******************************************************
		 * Method Name			: clickObject
		 * Purpose				: It is used to click on the elements
		 * Return Type			: boolean
		 * Date Created			: 
		 * Date modified		:
		 * Reviewed By			:
		 * Example				:  boolean blnRes = clickObject(oBrowser, By.xpath(""));
		 ******************************************************
		 */
      public boolean clickObject(WebDriver oDriver, By objBy) {
    	  WebElement oEle=null;
    	  try {
    		  oEle=oDriver.findElement(objBy);
    		  if(oEle.isDisplayed()) {
    			  oEle.click();
    			  appInd.writeResult("pass", "The Element '"+String.valueOf(objBy)+"' was clicked successful");
    			  return true;
    		  }else {
    			  appInd.writeResult("Fail", "Failed to find the element '"+String.valueOf(objBy)+"' in the DOM");
  				  return false;
    		  }
    	  }catch(Exception e)
    	  {
    		    appInd.writeResult("Exception","Exception in clickObject() method. "+ e.getMessage());
  			    return false;
    	  }finally
    	  {
    		  oEle = null;
  		}
    	  
      }
      
      /*******************************************************
  	 * Method Name			: clickObject
  	 * Purpose				: It is used to click on the elements
  	 * Return Type			: boolean
  	 * Date Created			: 
  	 * Date modified		:
  	 * Reviewed By			:
  	 * Example				:  boolean blnRes = clickObject(oBrowser, By.xpath(""));
  	 ******************************************************
  	 */
  	public boolean clickObject(WebDriver oDriver, String objLocator)
  	{
  		WebElement oEle = null;
  		try {
  			oEle = oDriver.findElement(By.xpath(objLocator));
  			if(oEle.isDisplayed()) {
  				oEle.click();
  				appInd.writeResult("Pass", "The element '"+objLocator+"' was clicked successful");
  				return true;
  			}else {
  				appInd.writeResult("Fail", "Failed to find the element '"+objLocator+"' in the DOM");
  				return false;
  			}
  		}catch(Exception e)
  		{
  			appInd.writeResult("Exception", "Exception in clickObject() method. "+ e.getMessage());
  			return false;
  		}
  		finally {
  			oEle = null;
  		}
  	}

  	/*******************************************************
  	 * Method Name			: setObject
  	 * Purpose				: It is used to enter the values in the elements
  	 * Return Type			: boolean
  	 * Date Created			: 
  	 * Date modified		:
  	 * Reviewed By			:
  	 * Example				:  boolean blnRes = setObject(oBrowser, By.xpath(""), "values");
  	 ******************************************************
  	 */ 
     public boolean setobject(WebDriver oDRiver,By objBy,String strData)  
     {
    	WebElement oEle=null;
    	try {
    		oEle=oDRiver.findElement(objBy);
    		if(oEle.isDisplayed()){
    			oEle.sendKeys(strData);
    			appInd.writeResult("Pass", "The element '"+strData+"' ws clicked successful");
    			return true;
    		}else {
    			appInd.writeResult("Fail", "Failed to find the element '"+String.valueOf(objBy)+"' in the DOM");
				return false;
    		}
    		
    	}catch(Exception e)
    	{
    		appInd.writeResult("Exception", "Exception in setObject() method. "+ e.getMessage());
			return false;
    	}finally {
    		oEle = null;
    	}
    
     }
     

 	/*******************************************************
 	 * Method Name			: setObject
 	 * Purpose				: It is used to enter the values in the elements
 	 * Return Type			: boolean
 	 * Date Created			: 
 	 * Date modified		:
 	 * Reviewed By			:
 	 * Example				:  boolean blnRes = setObject(oBrowser, By.xpath(""), "values");
 	 ******************************************************
 	 */
 	public boolean setObject(WebDriver oDriver, String objLocator, String strData) {
 		WebElement oEle = null;
 		try {
 			oEle = oDriver.findElement(By.xpath(objLocator));
 			if(oEle.isDisplayed()) {
 				oEle.sendKeys(strData);
 				appInd.writeResult("Pass", "The value '"+strData+"' was entered in the element '"+objLocator+"'");
 				return true;
 			}else {
 				appInd.writeResult("Fail", "Failed to find the element '"+objLocator+"' in the DOM");
 				return false;
 			}
 		}catch(Exception e)
 		{
 			appInd.writeResult("Exception", "Exception in setObject() method. "+ e.getMessage());
 			return false;
 		}
 		finally {
 			oEle = null;
 		}
 	}
 	
      
     /*******************************************************
 	 * Method Name			: clearAndSetObject
 	 * Purpose				: It is used to enter the values in the elements after clearing the old values
 	 * Return Type			: boolean
 	 * Date Created			: 
 	 * Date modified		:
 	 * Reviewed By			:
 	 * Example				:  boolean blnRes = clearAndSetObject(oBrowser, By.xpath(""), "values");
 	 ******************************************************
 	 */
     public boolean clearAndSetObject(WebDriver oDriver,By objBy,String strData)
     {
    	WebElement oEle=null;
    	try {
    		oEle=oDriver.findElement(objBy);
    		if(oEle.isDisplayed())
    		{
    			oEle.clear();
    			oEle.sendKeys(strData);
    			appInd.writeResult("pass", "The value '"+strData+"' was entered in the element '"+String.valueOf(objBy)+"'");
				return true;
    		}else {

				appInd.writeResult("Fail","Failed to find the element '"+String.valueOf(objBy)+"' in the DOM");
				return false;
    		}
    	}catch(Exception e)
    	{

			appInd.writeResult("Exception", "Exception in clearAndSetObject() method. "+ e.getMessage());
			return false;
    	}finally {
    		oEle = null;
    	}
    	 
     }
     
     /*******************************************************
 	 * Method Name			: clearAndSetObject
 	 * Purpose				: It is used to enter the values in the elements after clearing the old values
 	 * Return Type			: boolean
 	 * Date Created			: 
 	 * Date modified		:
 	 * Reviewed By			:
 	 * Example				:  boolean blnRes = clearAndSetObject(oBrowser, By.xpath(""), "values");
 	 ******************************************************
 	 */
 	public boolean clearAndSetObject(WebDriver oDriver, String objLocator, String strData) {
 		WebElement oEle = null;
 		try {
 			oEle = oDriver.findElement(By.xpath(objLocator));
 			if(oEle.isDisplayed()) {
 				oEle.clear();
 				oEle.sendKeys(strData);
 				appInd.writeResult("Pass", "The value '"+strData+"' was entered in the element '"+objLocator+"'");
 				return true;
 			}else {
 				appInd.writeResult("Fail", "Failed to find the element '"+objLocator+"' in the DOM");
 				return false;
 			}
 		}catch(Exception e)
 		{
 			appInd.writeResult("Exception", "Exception in clearAndSetObject() method. "+ e.getMessage());
 			return false;
 		}
 		finally {
 			oEle = null;
 		}
 	}
      
     /*******************************************************
 	 * Method Name			: selectObject
 	 * Purpose				: It is used to select the values from the dropdown elements
 	 * Return Type			: boolean
 	 * Date Created			: 
 	 * Date modified		:
 	 * Reviewed By			:
 	 * Example				:  boolean blnRes = selectObject(oBrowser, By.xpath(""), "valuesToSelect");
 	 ******************************************************
 	 */   
      public boolean selectObject(WebDriver oDriver,By objBy,String valueToSelect)
      {
    	  WebElement oEle=null;
    	  Select oSel=null;
    	  try {
    		  oEle=oDriver.findElement(objBy);
    		  if(oEle.isDisplayed()) {
    			  oSel=new Select(oEle);
    			  oSel.selectByVisibleText(valueToSelect);
    			  appInd.writeResult("pass", "The value '"+valueToSelect+"' was selected from the dropdown element '"+String.valueOf(objBy)+"'");
  				return true;
    			  
    		  }else {
    			  appInd.writeResult("Fail", "Failed to find the element '"+String.valueOf(objBy)+"' in the DOM");
  				return false;
      		  
    		  }
    	  }catch(Exception e)
    	  {
  			appInd.writeResult("Exception","Exception in selectObject() method. "+ e.getMessage());
  			return false;
     	  }finally {
     		 oEle = null;
 			oSel = null;
    	  }
    	  
      }
      
      /*******************************************************
  	 * Method Name			: selectObject
  	 * Purpose				: It is used to select the values from the dropdown elements
  	 * Return Type			: boolean
  	 * Date Created			: 
  	 * Date modified		:
  	 * Reviewed By			:
  	 * Example				:  boolean blnRes = selectObject(oBrowser, By.xpath(""), "valuesToSelect");
  	 ******************************************************
  	 */
  	public boolean selectObject(WebDriver oDriver, String objLocator, String valueToSelect)
  	{
  		WebElement oEle = null;
  		Select oSel = null;
  		try {
  			oEle = oDriver.findElement(By.xpath(objLocator));
  			if(oEle.isDisplayed()) {
  				oSel = new Select(oEle);
  				oSel.selectByVisibleText(valueToSelect);
  				appInd.writeResult("Pass", "The value '"+valueToSelect+"' was selected from the dropdown element '"+objLocator+"'");
  				return true;
  			}else {
  				appInd.writeResult("Fail", "Failed to find the element '"+objLocator+"' in the DOM");
  				return false;
  			}
  		}catch(Exception e)
  		{
  			appInd.writeResult("Exception", "Exception in selectObject() method. "+ e.getMessage());
  			return false;
  		}
  		finally {
  			oEle = null;
  			oSel = null;
  		}
  	}
  	
      
      /*******************************************************
  	 * Method Name			: compareValue
  	 * Purpose				: It is used to compare both actual & expected values
  	 * Return Type			: boolean
  	 * Date Created			: 
  	 * Date modified		:
  	 * Reviewed By			:
  	 * Example				:  boolean blnRes = compareValue("ActualValue", "ExpectedValue");
  	 ******************************************************
  	 */
     public boolean compareValue(String actual,String Expected) 
     {
    	 try {
    		 if(actual.equalsIgnoreCase(Expected))
    		 {
    			 appInd.writeResult("pass", "The both actual '"+actual+"' & expected '"+Expected+"' are matching");
 				return true;
    		 }else {
    			 appInd.writeResult("Fail", "Mis-match in both actual '"+actual+"' & expected '"+Expected+"'");
 				return false;
    		 }
    	 }catch(Exception e)
    	 {
    		appInd.writeResult("Exception", "Exception in compareValue() method. "+ e.getMessage());
 			return false; 
    	 }
     }
      
     /*******************************************************
 	 * Method Name			: verifyText
 	 * Purpose				: It is used to verify the text on the DOM
 	 * Return Type			: boolean
 	 * Date Created			: 
 	 * Date modified		:
 	 * Reviewed By			:
 	 * Example				:  boolean blnRes = verifyText(oBrowser, By, Type, Expected);
 	 ******************************************************
 	 */ 
      public boolean verifyText(WebDriver oDriver,By objBy,String objType,String expected)
      {
    	  WebElement oEle=null;
    	  String actual=null;
    	  Select oSel=null;
       	  try {
    		  oEle=oDriver.findElement(objBy);
    		  if(oEle.isDisplayed())
    		  {
    			  switch(objType.toLowerCase()) {
    			  case "text":
    				  actual=oEle.getText();
    				  break;
    			  case "value":
    				  actual=oEle.getAttribute("value");
    				  break;  
    			  case "list":
    				  oSel=new Select(oEle);
    				  actual=oSel.getFirstSelectedOption().getText();
    				  break;    
    				default:
    					appInd.writeResult("Fail", "Invalid object type '"+objType+"' was specified. please correct it & try");	
    				  
    			  }
    			  if(appInd.compareValue(actual,expected)) {
    				  return true;
    			  }else {
    				  return false;
    			  }
    		  }else {
    			  appInd.writeResult("Fail", "Failed to find the element '"+String.valueOf(objBy)+"' in the DOM");
  				return false;
    		  }
    	  }catch(Exception e)
       	  {
    		  appInd.writeResult("Exception", "Exception in verifyText() method. "+ e.getMessage());
  			return false;
       	  }finally {
       		oEle = null;
			oSel = null;
       	  }
      }
      /*******************************************************
  	 * Method Name			: verifyText
  	 * Purpose				: It is used to verify the text on the DOM
  	 * Return Type			: boolean
  	 * Date Created			: 
  	 * Date modified		:
  	 * Reviewed By			:
  	 * Example				:  boolean blnRes = verifyText(oBrowser, By, Type, Expected);
  	 ******************************************************
  	 */
  	public boolean verifyText(WebDriver oDriver, String objLocator, String objType, String expected)
  	{
  		WebElement oEle = null;
  		String actual = null;
  		Select oSel = null;
  		try {
  			oEle = oDriver.findElement(By.xpath(objLocator));
  			if(oEle.isDisplayed()) {
  				
  				switch(objType.toLowerCase()) {
  					case "text":
  						actual = oEle.getText();
  						break;
  					case "value":
  						actual = oEle.getAttribute("value");
  						break;
  					case "list":
  						oSel = new Select(oEle);
  						actual = oSel.getFirstSelectedOption().getText();
  						break;
  					default:
  						appInd.writeResult("Fail", "Invalid object type '"+objType+"' was specified. please correct it & try");
  						
  				}
  				
  				if(appInd.compareValue(actual, expected)) {
  					return true;
  				}else {
  					return false;
  				}
  			}else {
  				appInd.writeResult("Fail", "Failed to find the element '"+objLocator+"' in the DOM");
  				return false;
  			}
  		}catch(Exception e)
  		{
  			appInd.writeResult("Exception", "Exception in verifyText() method. "+ e.getMessage());
  			return false;
  		}
  		finally {
  			oEle = null;
  			oSel = null;
  		}
  	}
  	/*******************************************************
	 * Method Name			: verifyElementExist
	 * Purpose				: It is used to verify the presence of element in the DOM
	 * Return Type			: boolean
	 * Date Created			: 
	 * Date modified		:
	 * Reviewed By			:
	 * Example				:  boolean blnRes = verifyElementExist(oBrowser, By);
	 ******************************************************
	 */
	public boolean verifyElementExist(WebDriver oDriver, String objLocator)
	{
		List<WebElement> oEles = null;
		try {
			oEles = oDriver.findElements(By.xpath(objLocator));
			if(oEles.size()>0) {
				appInd.writeResult("PAss", "The element '"+objLocator+"' present in the DOM");
				return true;
			}else {
				appInd.writeResult("Fail", "The element '"+objLocator+"' doesnot exist in the DOM");
				return false;
			}
		}catch(Exception e)
		{
			appInd.writeResult("Exception", "Exception in verifyElementExist() method. "+ e.getMessage());
			return false;
		}
		finally {
			oEles = null;
		}
	}
  	
      
      /*******************************************************
  	 * Method Name			: verifyElementExist
  	 * Purpose				: It is used to verify the presence of element in the DOM
  	 * Return Type			: boolean
  	 * Date Created			: 
  	 * Date modified		:
  	 * Reviewed By			:
  	 * Example				:  boolean blnRes = verifyElementExist(oBrowser, By);
  	 ******************************************************
  	 */ 
     public boolean verifyElementExists(WebDriver oDriver,By objBy)
     {
    	 	List<WebElement> oEles=null;
    	 	try {
    	 		oEles=oDriver.findElements(objBy);
    	 		if(oEles.size()>0)
    	 		{
    	 			appInd.writeResult("pass", "The element '"+String.valueOf(objBy)+"' present in the DOM");
    	 			return true;
    	 		}else {

    				appInd.writeResult("Fail", "The element '"+String.valueOf(objBy)+"' doesnot exist in the DOM");
    				return false;
    	 		}
    	 	}catch(Exception e) {

    			appInd.writeResult("Exception", "Exception in verifyElementExist() method. "+ e.getMessage());
    			return false;
    	 	}finally {
    	 		oEles = null;
    	 	}
    	 	
     }

 	/*******************************************************
 	 * Method Name			: verifyElementNotExist
 	 * Purpose				: It is used to verify the non-presence of element in the DOM
 	 * Return Type			: boolean
 	 * Date Created			: 
 	 * Date modified		:
 	 * Reviewed By			:
 	 * Example				:  boolean blnRes = verifyElementNotExist(oBrowser, By);
 	 ******************************************************
 	 */
     public boolean verifyElementNotExist(WebDriver oDriver,By objBy)
     {
    	 List<WebElement> oEles=null;
    	 try {
    		 oEles=oDriver.findElements(objBy);
    		 if(oEles.size()>0)
    		 {
    			 appInd.writeResult("pass", "The element '"+String.valueOf(objBy)+"' still exist in the DOM");
 				return false;
    		 }else {
    			 appInd.writeResult("Fail", "The element '"+String.valueOf(objBy)+"' was removed from the DOM");
 				return true;
    		 }
    	 }catch(Exception e)
    	 {
    		 appInd.writeResult("Exception","Exception in verifyElementNotExist() method. "+ e.getMessage());
 			return false;
    	 }finally {
    		 oEles = null;
    	 }
     }
     
     /*******************************************************
 	 * Method Name			: verifyElementNotExist
 	 * Purpose				: It is used to verify the non-presence of element in the DOM
 	 * Return Type			: boolean
 	 * Date Created			: 
 	 * Date modified		:
 	 * Reviewed By			:
 	 * Example				:  boolean blnRes = verifyElementNotExist(oBrowser, By);
 	 ******************************************************
 	 */
 	public boolean verifyElementNotExist(WebDriver oDriver, String objLocator)
 	{
 		List<WebElement> oEles = null;
 		try {
 			oEles = oDriver.findElements(By.xpath(objLocator));
 			if(oEles.size()>0) {
 				appInd.writeResult("Fail", "The element '"+objLocator+"' still exist in the DOM");
 				return false;
 			}else {
 				appInd.writeResult("Pass", "The element '"+objLocator+"' was removed from the DOM");
 				return true;
 			}
 		}catch(Exception e)
 		{
 			appInd.writeResult("Exception", "Exception in verifyElementNotExist() method. "+ e.getMessage());
 			return false;
 		}
 		finally {
 			oEles = null;
 		}
 	}
 	

 	/*******************************************************
 	 * Method Name			: verifyOptionalElemnet
 	 * Purpose				: It is used to verify the presence of optional element in the DOM
 	 * Return Type			: boolean
 	 * Date Created			: 
 	 * Date modified		:
 	 * Reviewed By			:
 	 * Example				:  boolean blnRes = verifyOptionalElemnet(oBrowser, By);
 	 ******************************************************
 	 */
     public boolean verifyOptionalElement(WebDriver oDriver,By objBy)
     {
    	 List<WebElement> oEles=null;
    	 try {
    		oEles=oDriver.findElements(objBy);
    		if(oEles.size()>0)
    		{
    			return true;
    		}else {
    			return false;
    		}
    	 }catch(Exception e)
    	 {
    		 appInd.writeResult("Exception", "Exception in verifyOptionalElemnet() method. "+ e.getMessage());
 			return false; 
    	 }finally {
    		 oEles = null;
    	 }
     }
     
     /*******************************************************
 	 * Method Name			: verifyOptionalElemnet
 	 * Purpose				: It is used to verify the presence of optional element in the DOM
 	 * Return Type			: boolean
 	 * Date Created			: 
 	 * Date modified		:
 	 * Reviewed By			:
 	 * Example				:  boolean blnRes = verifyOptionalElemnet(oBrowser, By);
 	 ******************************************************
 	 */
 	public boolean verifyOptionalElemnet(WebDriver oDriver, String objLocator) {
 		List<WebElement> oEles = null;
 		try {
 			oEles = oDriver.findElements(By.xpath(objLocator));
 			if(oEles.size()>0) {
 				return true;
 			}else {
 				return false;
 			}
 		}catch(Exception e)
 		{
 			appInd.writeResult("Exception", "Exception in verifyOptionalElemnet() method. "+ e.getMessage());
 			return false;
 		}
 		finally {
 			oEles = null;
 		}
 	}
     

 	/*******************************************************
 	 * Method Name			: closeBrowser()
 	 * Purpose				: to close the browser & null the webdriver instance
 	 * Return Type			: void
 	 * Date Created			: 
 	 * Date modified		:
 	 * Reviewed By			:
 	 * Example				:  
 	 ******************************************************
 	 */ 
     public boolean closeBrowser(WebDriver oDriver)
     {
    	 try {
    		 oDriver.close();
    		 return true;
    	 }catch(Exception e)
    	 {
    		 appInd.writeResult("Exception", "Exception in 'closeBrowser()' method."+e.getMessage());
 			return false; 
    	 }
     }
     
     /*******************************************************
 	 * Method Name			: launchBrowser
 	 * Purpose				: It launches the chrome, ie & ff browsers
 	 * Return Type			: webDriver instance
 	 * Date Created			: 
 	 * Date modified		:
 	 * Reviewed By			:
 	 * Example				:  ChromeDriver ch = launchBrowser("chrome");
 	 ******************************************************
 	 */
     public WebDriver launchBrowser(String strBrowser) {
    	 WebDriver oDriver=null;
    	 try {
    		 switch(strBrowser.toLowerCase())
    		 {
    		 case "chrome":
    			 System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")
							+"\\Library\\drivers\\chromedriver.exe");
    			 oDriver=new ChromeDriver();
    			 break;
    		 case "firefox":
    			 System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")
							+"\\Library\\drivers\\geckodriver.exe");
    			 oDriver=new FirefoxDriver();
    			 break;
    		 case "ie":
    			 System.setProperty("webdriver.ie.driver", System.getProperty("user.dir")
							+"\\Library\\drivers\\IEDriverServer.exe");
    			 oDriver=new InternetExplorerDriver();
    			 break;
    			 default:
    				 appInd.writeResult("Fail", "Invalid browser name '"+strBrowser+"' was specified.");	 
    				 
    		 }
    		 if(oDriver!=null)
    		 {
    			 appInd.writeResult("pass", "The '"+strBrowser+"' browser has launched successful");
 				oDriver.manage().window().maximize();
 				return oDriver;
    		 }else {
    			 appInd.writeResult("Fail","Failed to launch '"+strBrowser+"' browser");
 				return null;
    		 }
	 
    	 }catch(Exception e)
    	 {
    		 appInd.writeResult("Exception","Exception in 'launchBrowser()' method."+e.getMessage());
 			return null;
    	 }
     }
     
     /*******************************************************
 	 * Method Name			: writeResult
 	 * Purpose				: log4j repoting where results are written in .log file
 	 * Return Type			: void
 	 * Date Created			: 
 	 * Date modified		:
 	 * Reviewed By			:
 	 * Example				:  writeResult("Pass", "Login was successful");
 	 * 						   writeResult("Fail", "Failed to login to application");
 	 *                         writeResult("Fatal", "Exception in loginToApp() method");
 	 ******************************************************
 	 */
     public void writeResult(String status, String message)
     {
    	 Logger log=null;
    	 try {
    		 log=Logger.getLogger(" - ");
    		 switch(status.toLowerCase())
    		 {
    		 case "pass":
    			 log.info(message);
    			 break;
    		 case "fail":
    			 log.info(message);
    			 break;
    		 case "exception":
    			 log.info(message);
    			 break;
    		 case "#":
    			 log.info(message);
    			 break;
    			 default:
    				 System.out.println("Invalid result status '"+status+"'");
    		 }
    	 }catch(Exception e) {
    		 System.out.println("Exception in writeResult() method. "+e.getMessage());
    	 }finally {
    		 log=null;
    	 }
     }
   
     /*******************************************************
  	 * Method Name			: getPropData
  	 * Purpose				: It is used to read the data from prop file using key name
  	 * Return Type			: String
  	 * Date Created			: 
  	 * Date modified		:
  	 * Reviewed By			:
  	 * Example				:  String strUN = getPropData("UserName");
  	 ******************************************************
  	 */
      public String getPropData(String strKey)
      {
     	 FileInputStream fin=null;
     	 Properties prop=null;
     	 try {
     		 fin=new FileInputStream(System.getProperty("user.dir")+"\\TestData\\Testdata.properties");
     		 prop=new Properties();
     		 prop.load(fin);
     		 
     		 return prop.getProperty(strKey);
     	 }catch(Exception e)
     	 {
     		appInd.writeResult("Exception", "Exception in getPropData() method. "+e.getMessage()); 
     		return null;
     	 }finally {
     		 try {
 				fin.close();
 				fin = null;
 				prop = null;
 			} catch (IOException e) {
 				appInd.writeResult("Exception", "Exception in getPropData() method. "+e.getMessage());
 				return null;
 			}
 				
     	 }
     	 
      }
    
}

