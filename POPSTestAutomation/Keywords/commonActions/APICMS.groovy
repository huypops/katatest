package commonActions

import com.jayway.jsonpath.JsonPath
import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.RestRequestObjectBuilder
import com.kms.katalon.core.testobject.TestObjectProperty
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS

import net.sf.jasperreports.charts.util.XYZElement


public class APICMS {
	public static final String CMS_URL = "https://cms-aio.pops.vn";
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


	@Keyword
	public static String cmsLogin() {
		String sbody = '{"email": "huy.thanh.cms@pops.vn","password": "123qweASD","applicationID": "5d23007cc69d24a09cf5af5a"}';
		def builder =new RestRequestObjectBuilder()
		def requestObject = builder
				.withRestRequestMethod("POST")
				.withRestUrl(CMS_URL + API_VERSION + API_LOGINWITHACCOUNT)
				.withHttpHeaders([new TestObjectProperty("Content-Type",ConditionType.EQUALS,"application/json")])
				.withTextBodyContent(sbody).build()
		def response = WS.sendRequest(requestObject)
		String responseBody = response.getResponseText()
		String token= JsonPath.parse(responseBody).read('.token')
		String authentoken = token.replace("[\"", "").replace("\"]", "")
		return authentoken;
	}

	@Keyword
	public static String getComicListCanPurchase() {
		def builder =new RestRequestObjectBuilder()
		def requestObject = builder
				.withRestRequestMethod("GET")
				.withRestUrl(CMS_URL + API_VERSION + COMIC_TITLE_LIST )
				.withRestParameters([new TestObjectProperty("filter", ConditionType.EQUALS, '{"skip":null,"order":"index ASC","where":{"isFree":false}}')])
				.withHttpHeaders([new TestObjectProperty("authorization",ConditionType.EQUALS,cmsLogin())])
				.build()
		def response = WS.sendRequest(requestObject)
		String responseBody = response.getResponseText()
		return responseBody;
	}

	@Keyword
	public static List<String> getComicIDListCanUnlock() {
		List<String> comicnamelist = JsonPath.parse(getComicListCanPurchase()).read('$.data..[?(@.country==\'VN\')].id');
		println(comicnamelist)
		return comicnamelist;
	}




	public static String isComicPurchase(){
		Collections.shuffle(getComicIDListCanUnlock());
		for(int i=1;i<=getComicIDListCanUnlock().size();i++){
			List<String> unlocklist = APIs.checkComicHasUnlockChapter(getComicIDListCanUnlock().get(i));
			if(unlocklist.size()>0){
				COMIC_ID=getComicIDListCanUnlock().get(i);
				return getComicIDListCanUnlock().get(i);
			}
		}
		return "Comic List not found";
	}

	@Keyword
	public static String getComicNameCanUnlock() {
		String coid=isComicPurchase();
		String comicnamelist = JsonPath.parse(getComicListCanPurchase()).read('$.data..[?(@.id==\''+coid+'\')].title');
		System.out.println("Comic can unlock is  : " + comicnamelist.replace("[\"", "").replace("\"]", ""));
		return comicnamelist.replace("[\"", "").replace("\"]", "");
	}

	@Keyword
	public static List<String> getChapterListCanUnlock() {
		String coid=isComicPurchase();
		String comicnamelist = JsonPath.parse(getComicListCanPurchase()).read('$.data..[?(@.id==\''+coid+'\')].title');
		System.out.println("Comic can unlock is  : " + comicnamelist.replace("[\"", "").replace("\"]", ""));
		return comicnamelist.replace("[\"", "").replace("\"]", "");
	}

	private static void shuffleList(List list) {
		/*list size*/
		int listSize = list.size();

		/*Initialize random number generator*/
		Random random = new Random();
		for (int i = 0; i < listSize; i++) {

			/*Get element from list at index i*/
			int currentElement = list[i];

			/*Generate a random index number within the list size range*/
			int randomIndex = i + random.nextInt(listSize - i);

			/*set/replace the element at current index with the element of random index*/
			list.set(i, list.get(randomIndex));

			/*set/replace the element at random index with the element at current index*/
			list.set(randomIndex, currentElement);
		}
	}
}



