package commonActions
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import com.eviware.soapui.config.HttpRequest
import com.github.kklisura.cdt.protocol.types.fetch.ResponseBody
import com.googlecode.javacv.cpp.opencv_features2d.SimpleBlobDetector.Params
import com.jayway.jsonpath.JsonPath
import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.RequestObject
import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.testobject.RestRequestObjectBuilder
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.testobject.TestObjectProperty
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows

import cucumber.api.java.en.Given
import groovy.json.StringEscapeUtils
import groovy.swing.impl.DefaultAction
import groovy.ui.SystemOutputInterceptor
import internal.GlobalVariable
import io.restassured.RestAssured
import io.restassured.config.EncoderConfig
import io.restassured.response.Response
import io.restassured.specification.RequestSpecification


public class APIs {
	static String API_KEY='5d2300c2c69d24a09cf5b09b'
	String ANONYMOUS_LOGIN='/api/v5/auths/anonymousLoginV2a'




	@Keyword
	static def getPageComponents(String pageCode, String slug, String limit,String profileID ) {

		String url = "https://products.popsww.com/api/v5/Pages/components?code="+pageCode+"&page=1&limit="+limit+
				"&slug="+slug+"&profileID="+profileID

		def builder =new RestRequestObjectBuilder()
		def requestObject = builder
				.withRestRequestMethod("GET")
				.withRestUrl(url)
				.withHttpHeaders([
					new TestObjectProperty('api-key',ConditionType.EQUALS,API_KEY),
					new TestObjectProperty('platform',ConditionType.EQUALS,GlobalVariable.PLATFORM),
					new TestObjectProperty('Authorization',ConditionType.EQUALS,GlobalVariable.USER_Token)
				])
				.build()
		def response = WS.sendRequest(requestObject)
		String ResponseBody = response.getResponseText()
		return ResponseBody
	}

	@Keyword
	def anonymousLogin() {

		def responseData = WS.sendRequest(findTestObject('01_APIs/AnonymousLogin'))
		System.out.println("==================Response========================")
		System.out.println(responseData.getResponseText())
		String ResponseBody = responseData.getResponseText()
		String token = JsonPath.parse(ResponseBody).read('data.userInfo.id')
		String adultProfileID= JsonPath.parse(ResponseBody).read('$.data.profiles.[?(@.type==\'adult\')].id')
		String kidsProfileID= JsonPath.parse(ResponseBody).read('$.data.profiles.[?(@.type==\'kids\')].id')


		GlobalVariable.USER_Token=token
		GlobalVariable.USER_AdultProfileID=adultProfileID.replace("[\"", "").replace("\"]", "")
		GlobalVariable.USER_KidsProfileID=kidsProfileID.replace("[\"", "").replace("\"]", "")

		System.out.println("*************Global Var token ="+ GlobalVariable.USER_Token)
	}



	def getNumberOfComponentsOnPage(String listOfPageComponents) {
	}

	def numberOfComponentsOnPage(String pageComponentsData) {
		int numberOfComponents = JsonPath.parse(pageComponentsData).read(arg0)
	}
}
