package internal

import com.kms.katalon.core.configuration.RunConfiguration
import com.kms.katalon.core.main.TestCaseMain


/**
 * This class is generated automatically by Katalon Studio and should not be modified or deleted.
 */
public class GlobalVariable {
     
    /**
     * <p></p>
     */
    public static Object SourceURL
     
    /**
     * <p></p>
     */
    public static Object APIServer
     
    /**
     * <p></p>
     */
    public static Object USER_Token
     
    /**
     * <p></p>
     */
    public static Object USER_AdultProfileID
     
    /**
     * <p></p>
     */
    public static Object USER_KidsProfileID
     
    /**
     * <p></p>
     */
    public static Object API_KEY
     
    /**
     * <p></p>
     */
    public static Object PLATFORM
     
    /**
     * <p></p>
     */
    public static Object EMAIL_TO_RESET_PASSWORD
     
    /**
     * <p></p>
     */
    public static Object EMAIL_TO_RESET_PASSWORD_BY_BUTTON
     
    /**
     * <p></p>
     */
    public static Object CMS_API
     
    /**
     * <p></p>
     */
    public static Object SHORT_TIMEOUT
     
    /**
     * <p></p>
     */
    public static Object LONG_TIMEOUT
     
    /**
     * <p></p>
     */
    public static Object LOGIN_FACEBOOK_EMAIL
     
    /**
     * <p></p>
     */
    public static Object LOGIN_FACEBOOK_PASSWORD
     
    /**
     * <p></p>
     */
    public static Object LOGIN_GOOGLE_EMAIL
     
    /**
     * <p></p>
     */
    public static Object USERNAME
     
    /**
     * <p></p>
     */
    public static Object PASSWORD
     
    /**
     * <p></p>
     */
    public static Object LOGIN_GOOGLE_PASSWORD
     
    /**
     * <p></p>
     */
    public static Object G_Timeout
     
    /**
     * <p></p>
     */
    public static Object G_NotificationMessage
     
    /**
     * <p></p>
     */
    public static Object G_AndroidApp
     
    /**
     * <p></p>
     */
    public static Object G_ShortTimeOut
     

    static {
        try {
            def selectedVariables = TestCaseMain.getGlobalVariables("default")
			selectedVariables += TestCaseMain.getGlobalVariables(RunConfiguration.getExecutionProfile())
            selectedVariables += RunConfiguration.getOverridingParameters()
    
            SourceURL = selectedVariables['SourceURL']
            APIServer = selectedVariables['APIServer']
            USER_Token = selectedVariables['USER_Token']
            USER_AdultProfileID = selectedVariables['USER_AdultProfileID']
            USER_KidsProfileID = selectedVariables['USER_KidsProfileID']
            API_KEY = selectedVariables['API_KEY']
            PLATFORM = selectedVariables['PLATFORM']
            EMAIL_TO_RESET_PASSWORD = selectedVariables['EMAIL_TO_RESET_PASSWORD']
            EMAIL_TO_RESET_PASSWORD_BY_BUTTON = selectedVariables['EMAIL_TO_RESET_PASSWORD_BY_BUTTON']
            CMS_API = selectedVariables['CMS_API']
            SHORT_TIMEOUT = selectedVariables['SHORT_TIMEOUT']
            LONG_TIMEOUT = selectedVariables['LONG_TIMEOUT']
            LOGIN_FACEBOOK_EMAIL = selectedVariables['LOGIN_FACEBOOK_EMAIL']
            LOGIN_FACEBOOK_PASSWORD = selectedVariables['LOGIN_FACEBOOK_PASSWORD']
            LOGIN_GOOGLE_EMAIL = selectedVariables['LOGIN_GOOGLE_EMAIL']
            USERNAME = selectedVariables['USERNAME']
            PASSWORD = selectedVariables['PASSWORD']
            LOGIN_GOOGLE_PASSWORD = selectedVariables['LOGIN_GOOGLE_PASSWORD']
            G_Timeout = selectedVariables['G_Timeout']
            G_NotificationMessage = selectedVariables['G_NotificationMessage']
            G_AndroidApp = selectedVariables['G_AndroidApp']
            G_ShortTimeOut = selectedVariables['G_ShortTimeOut']
            
        } catch (Exception e) {
            TestCaseMain.logGlobalVariableError(e)
        }
    }
}
