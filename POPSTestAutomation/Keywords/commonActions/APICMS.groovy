package commonActions

import com.kms.katalon.core.testobject.RestRequestObjectBuilder
import com.kms.katalon.core.testobject.TestObjectProperty
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS

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

	
	public static String cmsLogin() {
		String searchSuggestion = "/Searches/suggestions";
		def builder =new RestRequestObjectBuilder()
		def requestObject = builder
				.withRestRequestMethod("POST")
				.withRestUrl(CMS_URL + API_VERSION + API_LOGINWITHACCOUNT)
				.withHttpHeaders([
					new TestObjectProperty('Content-Type','application/json'),

				]).build()
		def response = WS.sendRequest(requestObject)
		String responseBody = response.getResponseText()
		return responseBody;
	}




}
