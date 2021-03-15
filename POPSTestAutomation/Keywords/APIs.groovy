import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import com.github.kklisura.cdt.protocol.types.fetch.ResponseBody
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
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.testobject.TestObjectProperty
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows

import internal.GlobalVariable


public class APIs {
	String API_KEY='5d2300c2c69d24a09cf5b09b'
	String ANONYMOUS_LOGIN='/api/v5/auths/anonymousLoginV2a'

	@Keyword
	def anonymousLogin() {
		def anonymousUserInfo = [:]
		def responseData = WS.sendRequest(findTestObject('API/AnonymousLogin'))
		System.out.println("==================Response========================")
		System.out.println(responseData.getResponseText())
		String ResponseBody = responseData.getResponseText()
		String token = JsonPath.parse(ResponseBody).read('data.userInfo.id')
		String adultProfileID= JsonPath.parse(ResponseBody).read('$.data.profiles.[?(@.type==\'adult\')].id')
		String kidsProfileID= JsonPath.parse(ResponseBody).read('$.data.profiles.[?(@.type==\'kids\')].id')
		
		anonymousUserInfo["token"]= token
		anonymousUserInfo["adultProfileID"]=adultProfileID
		anonymousUserInfo["kidsProfileID"]=kidsProfileID
		
		GlobalVariable.USER_Token=token
		GlobalVariable.USER_AdultProfileID=adultProfileID
		GlobalVariable.USER_KidsProfileID=kidsProfileID
		
		System.out.println("*************Global Var token ="+ GlobalVariable.USER_Token)
		
		
		return anonymousUserInfo


	}
}
