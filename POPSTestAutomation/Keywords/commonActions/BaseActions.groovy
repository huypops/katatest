package commonActions

import org.bouncycastle.cert.crmf.ProofOfPossessionSigningKeyBuilder
import org.openqa.selenium.By
import org.openqa.selenium.JavascriptExecutor
<<<<<<< HEAD
=======
import org.openqa.selenium.WebDriver
>>>>>>> mydev
import org.openqa.selenium.WebElement
import org.openqa.selenium.interactions.Actions

import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.jayway.jsonpath.JsonPath
import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testobject.RestRequestObjectBuilder
import com.kms.katalon.core.testobject.SelectorMethod
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.common.WebUiCommonHelper
import com.kms.katalon.core.webui.driver.DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import groovy.json.StringEscapeUtils

<<<<<<< HEAD
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
=======
>>>>>>> mydev

public class BaseActions {
	WebDriver driver = DriverFactory.getWebDriver()


	@Keyword
	def ScrollToBottom(int numberOfComponents) {

		int times = Math.ceil((Double)numberOfComponents/5)
		System.out.println("time is ===="+ times)
	}

	/*Scroll down until page load complete by checking if POPS Logo in Footer visible in viewport
	 * */
	@Keyword
	def ScrollToFooter() {

		TestObject POPS_Logo_Footer=	findTestObject('POPS App UI/Footer/POPS_Logo_In_Footer')
		Boolean isDisplayed = false
		while (isDisplayed== false) {
			ScrollByHeight()
			WebUI.delay(2)
			isDisplayed=WebUI.verifyElementInViewport(POPS_Logo_Footer, 1, FailureHandling.OPTIONAL)
		}
		String a =""
	}

	@Keyword
	def ScrollToEndOfPage(String pageCode, String slug, String limit,String profileID) {
		//def response = CustomKeywords.'commonActions.APIs.getPageComponents'(pageCode, slug, limit, profileID)
		def response = commonActions.APIs.getPageComponents(pageCode, slug, limit, profileID)
		def numberOfComponents = JsonPath.parse(response).read('$.componentCount')
		//		def lastComponent
		int times = Math.ceil((Double)numberOfComponents/5)+3
		System.out.println("time is ===="+ times)
		for (int i=0;i<times;i++) {

			ScrollByHeight()
			System.out.println("Scroll time ===="+ i)
			WebUI.delay(3)
		}
	}

	@Keyword
	def ScrollToLastVisibleComponentOnPage(String pageCode, String slug, String limit,String profileID)
	{
		String lastComponentTitle = null
		def response = commonActions.APIs.getPageComponents(pageCode, slug, limit, profileID)
		List<String> listComponentTitles = JsonPath.parse(response).read('$.data.[?(@.itemCount!=0&&@.type!=\'ads\')].title')
		lastComponentTitle = listComponentTitles.get(listComponentTitles.size() - 1)

		TestObject lastElement = new TestObject('ObjectID')
		lastElement.setSelectorValue(SelectorMethod.XPATH, '//*[contains(text(),\''+lastVisibleComponentTitle+'\')]')
		while (WebUI.verifyElementNotInViewport(lastElement, 3)) {
			ScrollByHeight()
		}
	}

	def ScrollByHeight() {
		WebUI.executeJavaScript("window.scrollTo(0, document.body.scrollHeight)",null)
	}


	static	def CheckBrokenLink()
	{
		def driver = DriverFactory.getWebDriver()
		List<WebElement> elements = driver.findElements(By.tagName('img'))
		def brokenLinks =[:]
		for (WebElement element  in elements) {
			try {
				String linkTest = element.getAttribute('src')
				if(linkTest!=null)
				{
					if(!isLinkOK(linkTest))
					{
						brokenLinks.put(linkTest, generateXPATH(element, ""))

					}

				}

			} catch (Exception e) {
				String xpath = generateXPATH(element, "");
				System.out.println("failed at " + elements.indexOf(element) + xpath);
			}
		}
		return brokenLinks
	}

	static	def isLinkOK(String link)
	{
		Boolean isOK = true
		try {
			if (!link.contains("data:image")) {
				def builder =new RestRequestObjectBuilder()
				def requestObject = builder.withRestRequestMethod("HEAD")
						.withRestUrl(link)
						.withRestRequestMethod("GET")
						.build()
				def res =WS.sendRequest(requestObject)
				int responseCode = res.getStatusCode()
				if(responseCode>=400) {
					isOK=false
				}
			}

		}catch (Exception e)
		{
			System.out.println("broken link is "+ link)
			e.printStackTrace()
		}
		return isOK
	}

	static def generateXPATH(WebElement childElement, String current)
	{String childTag = childElement.getTagName();
		if (childTag.equals("html")) {
			return "/html[1]" + current;
		}
		WebElement parentElement = childElement.findElement(By.xpath(".."));
		List<WebElement> childrenElements = parentElement.findElements(By.xpath("*"));
		int count = 0;
		for (int i = 0; i < childrenElements.size(); i++) {
			WebElement childrenElement = childrenElements.get(i);
			String childrenElementTag = childrenElement.getTagName();
			if (childTag.equals(childrenElementTag)) {
				count++;
			}
			if (childElement.equals(childrenElement)) {
				return generateXPATH(parentElement, "/" + childTag + "[" + count + "]" + current);
			}
		}
		return null;

	}
<<<<<<< HEAD
	
	@Keyword
	def ClickByJS(TestObject testObject)
	{
		WebElement element = WebUiCommonHelper.findWebElement(testObject, 5)
		def driver = DriverFactory.getWebDriver()
		JavascriptExecutor js = (JavascriptExecutor)driver
		js.executeScript("arguments[0].click()", element)
		
	}
=======


	public static int getNumberofElements(TestObject object) {
		WebUI.waitForElementPresent(object, 3);
		List<WebElement> elements = WebUI.findWebElements(object,3);
		return elements.size();
	}

	public static String getTextFirstElement(TestObject object, int i) {
		return WebUI.findWebElements(object,2).get(i).getText();
	}
	
	public static String getAttributeFirstElement(TestObject object, String attribute) {
		return WebUI.findWebElements(object,2).get(0).getAttribute(attribute);
	}
	@Keyword
	public static void clickFirstElement(TestObject object, int i) {
		WebUI.findWebElements(object,10).get(i).click();
	}
	public static void clickFirstElement(TestObject object) {
		WebUI.findWebElements(object,10).get(0).click();
	}


	public void mouseHoverJS(By locator) {
		WebElement section = driver.findElement(locator);
		Actions action = new Actions(driver);
		action.moveToElement(section).build().perform();
	}

	public void mouseHoverJS(By locator, By nexbuttonlocator) {
		Actions actions = new Actions(driver);
		WebElement element = driver.findElement(locator);
		WebElement element1 = driver.findElement(nexbuttonlocator);
		actions.moveToElement(element).click(element1).build().perform();
	}
	public void ClickByJS(By locator) {
		WebElement element = driver.findElement(locator);
		new Actions(driver).click(element).build().perform();
	}

	@Keyword
	def static clickUsingJS(TestObject object, int timeout)
	{
		WebElement element = WebUiCommonHelper.findWebElement(object,timeout);
		WebUI.executeJavaScript("arguments[0].click()", Arrays.asList(element));
	}




>>>>>>> mydev
}


