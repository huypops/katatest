package commonActions;
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.mobile.helper.MobileElementCommonHelper
import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject


class Registration {
	/**
	 * Check if element present in timeout
	 * @param to Katalon test object
	 * @param timeout time to wait for element to show up
	 * @return true if element present, otherwise false
	 */
	@Keyword
	def isElementPresent_Mobile(TestObject to, int timeout){
		try {
			KeywordUtil.logInfo("Finding element with id:" + to.getObjectId())

			WebElement element = MobileElementCommonHelper.findElement(to, timeout)
			if (element != null) {
				KeywordUtil.markPassed("Object " + to.getObjectId() + " is present")
			}
			return true
		} catch (Exception e) {
			KeywordUtil.markFailed("Object " + to.getObjectId() + " is not present")
		}
		return false;
	}

	/**
	 * Get mobile driver for current session
	 * @return mobile driver for current session
	 */
	@Keyword
	def WebDriver getCurrentSessionMobileDriver() {
		return MobileDriverFactory.getDriver();
	}
	public String getGetCurrentDateTime() {
		Date today = new Date()
		String todaysDate = today.format('yymmddhhmmss')
		return todaysDate;
	}

	@Keyword
	public void registrationByValidEmail() {
		Mobile.waitForElementPresent(findTestObject('REGISTRATION/SPLASHPAGE_SIGNUP_BUTTON'), 0);

		Mobile.tap(findTestObject('REGISTRATION/SPLASHPAGE_SIGNUP_BUTTON'), 0);

		Mobile.setText(findTestObject('REGISTRATION/SIGNUPPAGE_EMAIL_TXTBOX'), 'mail'+getGetCurrentDateTime()+'@mailinator.com', 0);

		Mobile.setText(findTestObject('REGISTRATION/SIGNUPPAGE_PASSWORD_TXTBOX'), '123456', 0);

		Mobile.tap(findTestObject('REGISTRATION/SIGNUPPAGE_REGISTER_BUTTON'), 0);

		Mobile.tap(findTestObject('REGISTRATION/ACTIVATIONPAGE_CONFIRM_POPUP'), 0);
	}
}