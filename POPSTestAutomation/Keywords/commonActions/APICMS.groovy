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



	public static String AdminLogin() {
		RestAssured.baseURI = CMS_URL;
		RequestSpecification request = given();
		JSONObject requestParams = new JSONObject();
		requestParams.put("email", EMAIL); // Cast
		requestParams.put("password", PASSWORD);
		requestParams.put("applicationID", APPLICATION_ID);
		request.body(requestParams.toJSONString());
		Response response = request.header(new Header("Content-Type", "application/json"))
		.config(RestAssured.config()
		.encoderConfig(EncoderConfig.encoderConfig().appendDefaultContentCharsetToContentTypeIfUndefined(false)))
		.post(API_VERSION + API_LOGINWITHACCOUNT);
		String responseBody = response.getBody().asString();
		TOKEN= JsonPath.parse(responseBody).read("$.token");
	return TOKEN;
	}


	public static Response getComicList()
	{
		RestAssured.baseURI = CMS_URL;
		RequestSpecification request = given();
		Response response = request
				.header(new Header("accept-encoding", "gzip, deflate, br"))
				.header(new Header("authorization", AdminLogin()))
				.config(RestAssured.config()
						.encoderConfig(EncoderConfig.encoderConfig().appendDefaultContentCharsetToContentTypeIfUndefined(false)))
				.queryParam("filter","{\"skip\":null,\"order\":\"_modifiedAt DESC\",\"where\":{}}")
				.get(API_VERSION + COMIC_TITLE_LIST);
		String responseBody = response.getBody().asString();
//        List<String> comictitlelist = JsonPath.parse(responseBody).read("$.data..[?(@.country=='VN')].title");
		return response;
	}

	public static String isComicPurchase(){
			Properties prop = new Properties();
			try {
				prop.load(new FileInputStream(propertyFilePath));

			} catch (Exception ex) {
				System.out.println("Configuration properties file cannot be found");
			}
		for(int i=1;i<=getComicNumber().size();i++){
			List<String> unlocklist = APIHelpers.checkComicHasUnlockChapter(getComicNumber().get(i),System.getProperty("username"), System.getProperty("password"));
			if(unlocklist.size()>0){
				COMIC_ID=getComicNumber().get(i);
				return getComicNumber().get(i);
			}
		}
		return "Comic List not found";

	}

	public static List<String> getComicNumber() {
		String responseBody = getComicList().getBody().asString();
		List<String> comicnamelist = JsonPath.parse(responseBody).read("$.data..[?(@.country=='VN')].id");
		return comicnamelist;
	}

	public static String getComicNameCanUnlock()
	{
		String responseBody = getComicList().getBody().asString();
		String coid=isComicPurchase();
		String comicnamelist = JsonPath.parse(responseBody).read("$.data..[?(@.id=='"+coid+"')].title").toString().replace("[\"", "").replace("\"]", "");
		System.out.println("xxxx " + comicnamelist);
		return comicnamelist;
	}
}
