package commonActions
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.jayway.jsonpath.JsonPath
import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.RestRequestObjectBuilder
import com.kms.katalon.core.testobject.TestObjectProperty
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS

import internal.GlobalVariable


public class APIs {
	static String API_KEY='5d2300c2c69d24a09cf5b09b'
	String ANONYMOUS_LOGIN='/api/v5/auths/anonymousLoginV2a'
	static String API_URL="https://products.popsww.com";
	static String apiversion = "/api/v5";





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

	public static String getSearchSuggest() {
		String searchSuggestion = "/Searches/suggestions";
		println("xxxxxxx " + API_URL + apiversion + searchSuggestion+"?profileID="+GlobalVariable.USER_AdultProfileID)
		def builder =new RestRequestObjectBuilder()
		def requestObject = builder
				.withRestRequestMethod("GET")
				.withRestUrl(API_URL + apiversion + searchSuggestion+"?profileID="+GlobalVariable.USER_AdultProfileID)
				.withHttpHeaders([
					new TestObjectProperty('api-key',ConditionType.EQUALS,API_KEY),
					new TestObjectProperty('platform',ConditionType.EQUALS,GlobalVariable.PLATFORM),
					new TestObjectProperty('Authorization',ConditionType.EQUALS,GlobalVariable.USER_Token)
				]).build()
		def response = WS.sendRequest(requestObject)
		String responseBody = response.getResponseText()
		return responseBody;
	}

	@Keyword
	public static List<String> getVideoSuggestListNumber(){
		List<String> listvideotitle = JsonPath.parse(getSearchSuggest()).read('$..[?(@.type==\'video\')].contents..text');
		System.out.println("nnnnnnnnnnnnnn" + listvideotitle);
		return listvideotitle;
	}
	@Keyword
	public static List<String> getComicSuggestListNumber(){
		List<String> listcomictitle = JsonPath.parse(getSearchSuggest()).read('$..[?(@.type==\'comic\')].contents..text');
		System.out.println("nnnnnnnnnnnnnn" + listcomictitle);
		return listcomictitle;
	}
	//	@Keyword
	//	public static List<String> getTokenAuThen(){
	//		String token = JsonPath.parse(ResponseBody).read('data.userInfo.id')
	//		List<String> listvideotitle = JsonPath.parse(getSearchSuggest()).read('$..[?(@.type==\'video\')].contents..text');
	//		System.out.println("nnnnnnnnnnnnnn" + listvideotitle);
	//		return listvideotitle;
	//	}
}
