package commonActions

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows

import internal.GlobalVariable

public class APICMS {
	public static final String CMS_URL = "https://cms-aio.pops.vn/";
	public static final String API_VERSION = "/api/v2";
	public static final String API_LOGINWITHACCOUNT = "/CmsAuth/login";
	public static final String API_PAIDCOMIC = "/CmsAuth/login";
	public static final String APPLICATION_ID = "5d23007cc69d24a09cf5af5a";
	private static  final String EMAIL = "huy.thanh.cms@pops.vn";
	private static final String PASSWORD = "123qweASD";
	private static String propertyFilePath = System.getProperty("user.dir") + "\\src\\main\\resources\\config.properties";


	public static String getTOKEN() {
		return TOKEN;
	}

	public static void setTOKEN(String TOKEN) {
		APICMS.TOKEN = TOKEN;
	}

	private static String TOKEN;
	private static String PROFILE_ID;
	private static String COMIC_ID;
	private static final String COMIC_TITLE_LIST="/CmsComicTitles";




}
