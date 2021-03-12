import groovy.json.StringEscapeUtils

import groovy.json.StringEscapeUtils

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import org.openqa.selenium.By
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.ui.ExpectedConditions
import org.openqa.selenium.support.ui.WebDriverWait
import org.openqa.selenium.WebDriver

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.driver.DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.webui.keyword.internal.WebUIAbstractKeyword
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows

import internal.GlobalVariable
import net.sf.jasperreports.engine.data.ListOfArrayDataSource

public class Mailinator {

	@Keyword
	def OpenMailinatorMailboxAndGetCode(String mailBox, String emailTitle) {
		WebUI.navigateToUrl("https://www.mailinator.com/v3/index.jsp?zone=public&query="+mailBox+"#/#inboxpane")
		//WebUI.click(findTestObject('Object Repository/MailinatorPageUI/emailTitle'))

		WebDriver driver = DriverFactory.getWebDriver()
		WebDriverWait wait = new WebDriverWait(driver,10)
		By emailInBox= By.xpath("//table[contains(@class,'table-striped')]/tbody/tr[@ng-repeat='email in emails']/td/a[contains(.,'"+emailTitle+"')]")

		By test = By.xpath("//div[@class='right_col']/div/div[@id='inboxpane']/div/div/div/table[contains(@class,'table-striped')]/tbody/tr[@ng-repeat='email in emails']/td/a[contains(.,'Chào')]")
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(emailInBox))
		Thread.sleep(3000)
		WebElement email = driver.findElement(emailInBox)
				
		email.click()
		
		By IFRAME_EMAILBODY=By.xpath("//iframe")
		
		WebElement iframe=driver.findElement(IFIFRAME_EMAILBODY)
		driver.switchTo().frame(iframe)
		
		By EMAIL_CONTENT=By.xpath("//div[@class='mj-container']/div")
		
		List<WebElement> listOfDivs = driver.findElements(EMAIL_CONTENT)
		
		int code =0
		for (WebElement div :listOfDivs ) {
			int numberInText=getCodeInText(listOfDivs.get(div.in))
		}
		
	
//		WebUI.switchToFrame(findTestObject('Object Repository/MailinatorPageUI/iframe_-- HTML EMAIL BODY --'))

		//List listOfDiv= driver.findAll(ByXPath("//div[@class='mj-container']/div"))
	}
	
	def getCodeInText(String text)
	{
		String textFilterred = text.replaceAll("\\D", "");
		if (textFilterred.isEmpty()) return 0;
		else return Integer.parseInt(textFilterred);
	}
}
