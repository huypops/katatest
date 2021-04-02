
/**
 * This class is generated automatically by Katalon Studio and should not be modified or deleted.
 */

import java.lang.String

import com.kms.katalon.core.testobject.TestObject

import com.kms.katalon.core.testobject.ResponseObject

import java.io.File

import java.lang.Integer

import java.lang.Double

import com.kms.katalon.core.model.FailureHandling

import java.lang.Boolean

import java.lang.Number

import com.applitools.eyes.selenium.Eyes

import org.openqa.selenium.WebElement

import com.applitools.eyes.RectangleSize



def static "commonActions.Mailinator.OpenMailinatorMailboxAndGetCode"(
    	String mailBox	
     , 	String emailTitle	) {
    (new commonActions.Mailinator()).OpenMailinatorMailboxAndGetCode(
        	mailBox
         , 	emailTitle)
}


def static "commonActions.Mailinator.OpenMailinatorMail"(
    	String mailBox	
     , 	String emailTitle	) {
    (new commonActions.Mailinator()).OpenMailinatorMail(
        	mailBox
         , 	emailTitle)
}


def static "commonActions.PageActions.verifyLinksOnPage"() {
    (new commonActions.PageActions()).verifyLinksOnPage()
}


def static "commonActions.PageActions.verifyURLContains"(
    	String containsText	) {
    (new commonActions.PageActions()).verifyURLContains(
        	containsText)
}


def static "commonActions.PageActions.openComicPage"() {
    (new commonActions.PageActions()).openComicPage()
}


def static "commonActions.PageActions.openSeriesPage"(
    	TestObject object	) {
    (new commonActions.PageActions()).openSeriesPage(
        	object)
}


def static "commonActions.PageActions.openVideoPage"() {
    (new commonActions.PageActions()).openVideoPage()
}


def static "commonActions.PageActions.checkBrokenImages"(
    	TestObject object	
     , 	String attribute	) {
    (new commonActions.PageActions()).checkBrokenImages(
        	object
         , 	attribute)
}


def static "commonActions.PageActions.checkRecommandation"(
    	TestObject object	) {
    (new commonActions.PageActions()).checkRecommandation(
        	object)
}


def static "commonActions.PageActions.checkReCommandationCanClickable"(
    	TestObject object	) {
    (new commonActions.PageActions()).checkReCommandationCanClickable(
        	object)
}


def static "commonActions.PageActions.checkAlbumItems"(
    	TestObject object	) {
    (new commonActions.PageActions()).checkAlbumItems(
        	object)
}


def static "commonActions.PageActions.checkAlbumItemsCanClickable"(
    	TestObject object	) {
    (new commonActions.PageActions()).checkAlbumItemsCanClickable(
        	object)
}


def static "commonActions.Comics.CheckComicRankingDisplay20Items"(
    	TestObject object	) {
    (new commonActions.Comics()).CheckComicRankingDisplay20Items(
        	object)
}


def static "commonActions.Comics.checkUnlockChapterVisible"(
    	TestObject object	) {
    (new commonActions.Comics()).checkUnlockChapterVisible(
        	object)
}


def static "commonActions.SearchActions.verifyVideoSuggest"(
    	TestObject object	) {
    (new commonActions.SearchActions()).verifyVideoSuggest(
        	object)
}


def static "commonActions.SearchActions.verifyComicSuggest"(
    	TestObject object	) {
    (new commonActions.SearchActions()).verifyComicSuggest(
        	object)
}


def static "commonActions.SearchActions.searchAnyVideo"(
    	TestObject object	
     , 	String videoname	) {
    (new commonActions.SearchActions()).searchAnyVideo(
        	object
         , 	videoname)
}


def static "commonActions.SearchActions.searchAnyComic"(
    	TestObject object	
     , 	String comicname	) {
    (new commonActions.SearchActions()).searchAnyComic(
        	object
         , 	comicname)
}


def static "commonActions.ClickableActions.clickingOnGenre"(
    	TestObject object	) {
    (new commonActions.ClickableActions()).clickingOnGenre(
        	object)
}


def static "commonActions.ClickableActions.addToMyList"() {
    (new commonActions.ClickableActions()).addToMyList()
}


def static "commonActions.CMS_APIs.getCMSPageLayout"(
    	String pageCode	
     , 	String country	) {
    (new commonActions.CMS_APIs()).getCMSPageLayout(
        	pageCode
         , 	country)
}


def static "commonActions.CMS_APIs.getPageListComponentItem"(
    	ResponseObject response	) {
    (new commonActions.CMS_APIs()).getPageListComponentItem(
        	response)
}

/**
	 * provides the same function as takeElementImage(WebDriver, WebElement).
	 * The WebDriver object is resolved by calling DriverFactory.getWebDriver()
	 *
	 * @param testObject
	 * @return
	 */
def static "commonActions.ScreenshotDriver.takeElementImage"(
    	TestObject testObject	) {
    (new commonActions.ScreenshotDriver()).takeElementImage(
        	testObject)
}

/**
	 * provides the same function as saveElementImage(WebDriver, WebElement, File)
	 * The WebDriver object is resolved by calling DriverFactory.getWebDriver()
	 *
	 * @param testObject
	 * @param file
	 */
def static "commonActions.ScreenshotDriver.saveElementImage"(
    	TestObject testObject	
     , 	File file	) {
    (new commonActions.ScreenshotDriver()).saveElementImage(
        	testObject
         , 	file)
}

/**
	 * provides the same function as takeEntirePageImage(WebDriver, Integer)
	 * The WebDriver object is resolved by calling DriverFactory.getWebDriver()
	 *
	 * @timeout millisecond, wait for page to displayed stable after scrolling downward
	 * @return
	 */
def static "commonActions.ScreenshotDriver.takeEntirePageImage"(
    	Integer timeout	) {
    (new commonActions.ScreenshotDriver()).takeEntirePageImage(
        	timeout)
}

/**
	 * provides the same function as saveEntirePageImage(WebDriver, File, Integer)
	 * The WebDriver object is resolved by calling DriverFactory.getWebDriver()
	 *
	 * @param file
	 */
def static "commonActions.ScreenshotDriver.saveEntirePageImage"(
    	File file	
     , 	Integer timeout	) {
    (new commonActions.ScreenshotDriver()).saveEntirePageImage(
        	file
         , 	timeout)
}

/**
	 * Compare 2 images, expected one is read from file, actual one is cropped from web page,
	 * and check if images are SIMILAR enough.
	 * When failed, the actual image is saved into file of which path is shown in the error message.
	 *
	 * @param expectedImage of java.io.File prepared beforehand using saveElementImage(File) method
	 * @param actualImage of TestObject which points HTML element in question
	 * @return true if expectedImage and actualImage are similar enough; difference ratio < criteriaPercent
	 */
def static "commonActions.ScreenshotDriver.verifyImagesAreSimilar"(
    	File expected	
     , 	TestObject actual	
     , 	Double criteriaPercent	
     , 	File snapshotsDir	
     , 	FailureHandling flowControl	) {
    (new commonActions.ScreenshotDriver()).verifyImagesAreSimilar(
        	expected
         , 	actual
         , 	criteriaPercent
         , 	snapshotsDir
         , 	flowControl)
}

/**
	 * Compare 2 images, expected one is read from file, actual one is cropped from web page,
	 * and check if images are DIFFERENT enough.
	 * When failed, the actual image is saved into file of which path is shown in the error message.
	 *
	 * @param expectedImage of java.io.File prepared beforehand using saveElementImage(File) method
	 * @param actualImage of TestObject which points HTML element in question
	 * @return true if expecteImage and actualImage are different enough; differenece ratio > criteriaPercent
	 */
def static "commonActions.ScreenshotDriver.verifyImagesAreDifferent"(
    	File expected	
     , 	TestObject actual	
     , 	Double criteriaPercent	
     , 	File snapshotsDir	
     , 	FailureHandling flowControl	) {
    (new commonActions.ScreenshotDriver()).verifyImagesAreDifferent(
        	expected
         , 	actual
         , 	criteriaPercent
         , 	snapshotsDir
         , 	flowControl)
}


def static "commonActions.ScreenshotDriver.verifyImagesAreSimilar"(
    	TestObject expected	
     , 	TestObject actual	
     , 	Double criteriaPercent	
     , 	File snapshotsDir	
     , 	FailureHandling flowControl	) {
    (new commonActions.ScreenshotDriver()).verifyImagesAreSimilar(
        	expected
         , 	actual
         , 	criteriaPercent
         , 	snapshotsDir
         , 	flowControl)
}


def static "commonActions.ScreenshotDriver.verifyImagesAreDifferent"(
    	TestObject expected	
     , 	TestObject actual	
     , 	Double criteriaPercent	
     , 	File snapshotsDir	
     , 	FailureHandling flowControl	) {
    (new commonActions.ScreenshotDriver()).verifyImagesAreDifferent(
        	expected
         , 	actual
         , 	criteriaPercent
         , 	snapshotsDir
         , 	flowControl)
}


def static "commonActions.ScreenshotDriver.verifyImagesAreDifferent"(
    	File expected	
     , 	File actual	
     , 	Double criteriaPercent	
     , 	File snapshotsDir	
     , 	FailureHandling flowControl	) {
    (new commonActions.ScreenshotDriver()).verifyImagesAreDifferent(
        	expected
         , 	actual
         , 	criteriaPercent
         , 	snapshotsDir
         , 	flowControl)
}


def static "commonActions.ScreenshotDriver.takeEntirePageImage"() {
    (new commonActions.ScreenshotDriver()).takeEntirePageImage()
}


def static "commonActions.ScreenshotDriver.saveEntirePageImage"(
    	File file	) {
    (new commonActions.ScreenshotDriver()).saveEntirePageImage(
        	file)
}


def static "commonActions.ScreenshotDriver.verifyImagesAreSimilar"(
    	File expected	
     , 	TestObject actual	
     , 	Double criteriaPercent	
     , 	File snapshotsDir	) {
    (new commonActions.ScreenshotDriver()).verifyImagesAreSimilar(
        	expected
         , 	actual
         , 	criteriaPercent
         , 	snapshotsDir)
}


def static "commonActions.ScreenshotDriver.verifyImagesAreSimilar"(
    	File expected	
     , 	TestObject actual	
     , 	Double criteriaPercent	) {
    (new commonActions.ScreenshotDriver()).verifyImagesAreSimilar(
        	expected
         , 	actual
         , 	criteriaPercent)
}


def static "commonActions.ScreenshotDriver.verifyImagesAreDifferent"(
    	File expected	
     , 	TestObject actual	
     , 	Double criteriaPercent	
     , 	File snapshotsDir	) {
    (new commonActions.ScreenshotDriver()).verifyImagesAreDifferent(
        	expected
         , 	actual
         , 	criteriaPercent
         , 	snapshotsDir)
}


def static "commonActions.ScreenshotDriver.verifyImagesAreDifferent"(
    	File expected	
     , 	TestObject actual	
     , 	Double criteriaPercent	) {
    (new commonActions.ScreenshotDriver()).verifyImagesAreDifferent(
        	expected
         , 	actual
         , 	criteriaPercent)
}


def static "commonActions.ScreenshotDriver.verifyImagesAreSimilar"(
    	TestObject expected	
     , 	TestObject actual	
     , 	Double criteriaPercent	
     , 	File snapshotsDir	) {
    (new commonActions.ScreenshotDriver()).verifyImagesAreSimilar(
        	expected
         , 	actual
         , 	criteriaPercent
         , 	snapshotsDir)
}


def static "commonActions.ScreenshotDriver.verifyImagesAreSimilar"(
    	TestObject expected	
     , 	TestObject actual	
     , 	Double criteriaPercent	) {
    (new commonActions.ScreenshotDriver()).verifyImagesAreSimilar(
        	expected
         , 	actual
         , 	criteriaPercent)
}


def static "commonActions.ScreenshotDriver.verifyImagesAreDifferent"(
    	TestObject expected	
     , 	TestObject actual	
     , 	Double criteriaPercent	
     , 	File snapshotsDir	) {
    (new commonActions.ScreenshotDriver()).verifyImagesAreDifferent(
        	expected
         , 	actual
         , 	criteriaPercent
         , 	snapshotsDir)
}


def static "commonActions.ScreenshotDriver.verifyImagesAreDifferent"(
    	TestObject expected	
     , 	TestObject actual	
     , 	Double criteriaPercent	) {
    (new commonActions.ScreenshotDriver()).verifyImagesAreDifferent(
        	expected
         , 	actual
         , 	criteriaPercent)
}


def static "commonActions.ScreenshotDriver.verifyImagesAreDifferent"(
    	File expected	
     , 	File actual	
     , 	Double criteriaPercent	
     , 	File snapshotsDir	) {
    (new commonActions.ScreenshotDriver()).verifyImagesAreDifferent(
        	expected
         , 	actual
         , 	criteriaPercent
         , 	snapshotsDir)
}


def static "commonActions.ScreenshotDriver.verifyImagesAreDifferent"(
    	File expected	
     , 	File actual	
     , 	Double criteriaPercent	) {
    (new commonActions.ScreenshotDriver()).verifyImagesAreDifferent(
        	expected
         , 	actual
         , 	criteriaPercent)
}

/**
	 *
	 */
def static "commonActions.Assert.assertTrue"(
    	String message	
     , 	Boolean condition	
     , 	FailureHandling flowControl	) {
    (new commonActions.Assert()).assertTrue(
        	message
         , 	condition
         , 	flowControl)
}


def static "commonActions.Assert.assertFalse"(
    	String message	
     , 	Boolean condition	
     , 	FailureHandling flowControl	) {
    (new commonActions.Assert()).assertFalse(
        	message
         , 	condition
         , 	flowControl)
}

/**
	 *
	 */
def static "commonActions.Assert.assertEquals"(
    	String message	
     , 	String expected	
     , 	String actual	
     , 	FailureHandling flowControl	) {
    (new commonActions.Assert()).assertEquals(
        	message
         , 	expected
         , 	actual
         , 	flowControl)
}

/**
	 *
	 */
def static "commonActions.Assert.assertEquals"(
    	String message	
     , 	Number expected	
     , 	Number actual	
     , 	FailureHandling flowControl	) {
    (new commonActions.Assert()).assertEquals(
        	message
         , 	expected
         , 	actual
         , 	flowControl)
}


def static "commonActions.Assert.assertTrue"(
    	String message	
     , 	Boolean condition	) {
    (new commonActions.Assert()).assertTrue(
        	message
         , 	condition)
}


def static "commonActions.Assert.assertFalse"(
    	String message	
     , 	Boolean condition	) {
    (new commonActions.Assert()).assertFalse(
        	message
         , 	condition)
}


def static "commonActions.Assert.assertEquals"(
    	String message	
     , 	String expected	
     , 	String actual	) {
    (new commonActions.Assert()).assertEquals(
        	message
         , 	expected
         , 	actual)
}


def static "commonActions.Assert.assertEquals"(
    	String message	
     , 	Number expected	
     , 	Number actual	) {
    (new commonActions.Assert()).assertEquals(
        	message
         , 	expected
         , 	actual)
}


def static "commonActions.VideoPlayer.videoPlayerCheck"(
    	TestObject videoframe	
     , 	int duration	) {
    (new commonActions.VideoPlayer()).videoPlayerCheck(
        	videoframe
         , 	duration)
}


def static "commonActions.VideoPlayer.verifyPlayer"(
    	int duration	) {
    (new commonActions.VideoPlayer()).verifyPlayer(
        	duration)
}


def static "commonActions.VideoPlayer.nextVideoByClicking"(
    	TestObject object	) {
    (new commonActions.VideoPlayer()).nextVideoByClicking(
        	object)
}


def static "commonActions.VideoPlayer.nextVideoAutomatic"(
    	TestObject nextbutton	) {
    (new commonActions.VideoPlayer()).nextVideoAutomatic(
        	nextbutton)
}


def static "commonActions.RankingCheckActions.rankingCheck"() {
    (new commonActions.RankingCheckActions()).rankingCheck()
}


def static "com.kms.katalon.keyword.applitools.BasicKeywords.checkElement"(
    	Eyes eyes	
     , 	WebElement element	) {
    (new com.kms.katalon.keyword.applitools.BasicKeywords()).checkElement(
        	eyes
         , 	element)
}


def static "com.kms.katalon.keyword.applitools.BasicKeywords.checkTestObject"(
    	TestObject testObject	
     , 	String testName	) {
    (new com.kms.katalon.keyword.applitools.BasicKeywords()).checkTestObject(
        	testObject
         , 	testName)
}


def static "com.kms.katalon.keyword.applitools.BasicKeywords.checkWindow"(
    	String testName	) {
    (new com.kms.katalon.keyword.applitools.BasicKeywords()).checkWindow(
        	testName)
}


def static "commonActions.APICMS.cmsLogin"() {
    (new commonActions.APICMS()).cmsLogin()
}


def static "commonActions.APICMS.getComicListCanPurchase"() {
    (new commonActions.APICMS()).getComicListCanPurchase()
}


def static "commonActions.APICMS.getComicIDListCanUnlock"() {
    (new commonActions.APICMS()).getComicIDListCanUnlock()
}


def static "commonActions.APICMS.getComicNameCanUnlock"() {
    (new commonActions.APICMS()).getComicNameCanUnlock()
}


def static "commonActions.APICMS.getChapterListCanUnlock"() {
    (new commonActions.APICMS()).getChapterListCanUnlock()
}


def static "commonActions.SignInActions.SignInWithValidAccount"(
    	String email	
     , 	String password	) {
    (new commonActions.SignInActions()).SignInWithValidAccount(
        	email
         , 	password)
}


def static "commonActions.APIs.getPageComponents"(
    	String pageCode	
     , 	String slug	
     , 	String limit	
     , 	String profileID	) {
    (new commonActions.APIs()).getPageComponents(
        	pageCode
         , 	slug
         , 	limit
         , 	profileID)
}


def static "commonActions.APIs.anonymousLogin"() {
    (new commonActions.APIs()).anonymousLogin()
}


def static "commonActions.APIs.getVideoSuggestListNumber"() {
    (new commonActions.APIs()).getVideoSuggestListNumber()
}


def static "commonActions.APIs.getComicSuggestListNumber"() {
    (new commonActions.APIs()).getComicSuggestListNumber()
}


def static "commonActions.APIs.loginAsUser"() {
    (new commonActions.APIs()).loginAsUser()
}


def static "commonActions.APIs.getUserToken"() {
    (new commonActions.APIs()).getUserToken()
}


def static "commonActions.APIs.getProfileID"() {
    (new commonActions.APIs()).getProfileID()
}


def static "commonActions.APIs.checkComicHasUnlockChapter"(
    	String comidid	) {
    (new commonActions.APIs()).checkComicHasUnlockChapter(
        	comidid)
}


def static "commonActions.APIs.getRecommandationText"() {
    (new commonActions.APIs()).getRecommandationText()
}


def static "commonActions.APIs.getRecommandationList"() {
    (new commonActions.APIs()).getRecommandationList()
}


def static "commonActions.APIs.getRecommandationListItems"() {
    (new commonActions.APIs()).getRecommandationListItems()
}


def static "commonActions.APIs.getNumberItemInRecommandation"() {
    (new commonActions.APIs()).getNumberItemInRecommandation()
}


def static "commonActions.APIs.getAlbumItemsNumber"() {
    (new commonActions.APIs()).getAlbumItemsNumber()
}


def static "commonActions.BaseActions.ScrollToBottom"(
    	int numberOfComponents	) {
    (new commonActions.BaseActions()).ScrollToBottom(
        	numberOfComponents)
}


def static "commonActions.BaseActions.ScrollToFooter"() {
    (new commonActions.BaseActions()).ScrollToFooter()
}


def static "commonActions.BaseActions.ScrollToEndOfPage"(
    	String pageCode	
     , 	String slug	
     , 	String limit	
     , 	String profileID	) {
    (new commonActions.BaseActions()).ScrollToEndOfPage(
        	pageCode
         , 	slug
         , 	limit
         , 	profileID)
}


def static "commonActions.BaseActions.ScrollToLastVisibleComponentOnPage"(
    	String pageCode	
     , 	String slug	
     , 	String limit	
     , 	String profileID	) {
    (new commonActions.BaseActions()).ScrollToLastVisibleComponentOnPage(
        	pageCode
         , 	slug
         , 	limit
         , 	profileID)
}


def static "commonActions.BaseActions.ClickByJS"(
    	TestObject testObject	) {
    (new commonActions.BaseActions()).ClickByJS(
        	testObject)
}


def static "commonActions.BaseActions.clickFirstElement"(
    	TestObject object	
     , 	int i	) {
    (new commonActions.BaseActions()).clickFirstElement(
        	object
         , 	i)
}


def static "commonActions.BaseActions.clickFirstElement"(
    	TestObject object	) {
    (new commonActions.BaseActions()).clickFirstElement(
        	object)
}


def static "commonActions.BaseActions.ClickByJS"(
    	TestObject object	
     , 	int timeout	) {
    (new commonActions.BaseActions()).ClickByJS(
        	object
         , 	timeout)
}


def static "commonActions.BaseActions.ClickElementsByJS"(
    	TestObject object	
     , 	int timeout	) {
    (new commonActions.BaseActions()).ClickElementsByJS(
        	object
         , 	timeout)
}


def static "com.kms.katalon.keyword.applitools.EyesKeywords.eyesOpen"(
    	String testName	
     , 	RectangleSize viewportSize	) {
    (new com.kms.katalon.keyword.applitools.EyesKeywords()).eyesOpen(
        	testName
         , 	viewportSize)
}


def static "com.kms.katalon.keyword.applitools.EyesKeywords.eyesClose"(
    	Eyes eyes	) {
    (new com.kms.katalon.keyword.applitools.EyesKeywords()).eyesClose(
        	eyes)
}


def static "com.kms.katalon.keyword.applitools.EyesKeywords.eyesInit"() {
    (new com.kms.katalon.keyword.applitools.EyesKeywords()).eyesInit()
}


def static "com.kms.katalon.keyword.applitools.EyesKeywords.eyesOpenWithBaseline"(
    	String baselineName	
     , 	String testName	
     , 	RectangleSize viewportSize	) {
    (new com.kms.katalon.keyword.applitools.EyesKeywords()).eyesOpenWithBaseline(
        	baselineName
         , 	testName
         , 	viewportSize)
}
