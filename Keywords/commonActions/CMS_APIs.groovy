package commonActions

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import javax.persistence.metamodel.StaticMetamodel

import org.xbill.DNS.AAAARecord

import com.google.gson.JsonArray
import com.jayway.jsonpath.JsonPath
import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.testobject.RestRequestObjectBuilder
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.testobject.TestObjectProperty
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows

import cucumber.api.java.sk.Azároveň
import groovy.json.StringEscapeUtils
import groovy.util.ObservableList.ElementAddedEvent
import internal.GlobalVariable
import net.minidev.json.JSONArray
import net.minidev.json.JSONObject

public class CMS_APIs {


	static final String GET_PAGE_LAYOUT ="/api/v2/CmsPages/findByCode"
	static final String ADULT_MPAAID ="5d23e12595251b98bd043376"
	static final String KIDS_MPAAID=""
	static final String CMS_TOKEN="RgMFiv3j1xleLHldSKZfxIWsY9ItnY4IQSxKhT0bwFle2i9VMpgzmOCyrOFqpot1"


	@Keyword
	def getCMSPageLayout(String pageCode ,String country) {
		String link = GlobalVariable.CMS_API+GET_PAGE_LAYOUT+"?code="+pageCode+"&mpaaID="+ADULT_MPAAID+"&applicationID=5d23007cc69d24a09cf5af5a&country="+country
		def builder =new RestRequestObjectBuilder()
		def requestObject = builder
				.withRestRequestMethod("GET")
				.withRestUrl(link)
				.withHttpHeaders([new TestObjectProperty('Authorization',ConditionType.EQUALS,CMS_TOKEN)])
				.build()
		def response = WS.sendRequest(requestObject)
		getPageListComponentItem(response)
		System.out.println(response)
	}

	@Keyword
	def getPageListComponentItem(ResponseObject response) {
		String ResponseBody = response.getResponseText()
		def listItems  =JsonPath.parse(ResponseBody).read('$.data.[?(@.platform==\'web\')].data.[?(@.code==\'playlist_page\')].data.*')

		List<String> itemIDs = JsonPath.parse(listItems).read('$..*.id')
		int numberOfItems = itemIDs.size()
		String[][] pagelistItems=new String[numberOfItems][4]

		listItems.eachWithIndex { it,index ->

			String pageListItem_Title= it['title']
			String pageListItem_Description = it['description']
			String pageListItem_bgImageUrl = it['bgImageUrl']
			String pageListItem_iconImageUrl = it['iconImageUrl']

			pagelistItems[index][0]=pageListItem_Title
			pagelistItems[index][1]=pageListItem_Description
			pagelistItems[index][2]=pageListItem_bgImageUrl
			pagelistItems[index][3]=pageListItem_iconImageUrl
		}
		System.out.println(pagelistItems)
	}
}
