package com.locatorConstants;

public class LLogin {

    public static final String CONTINUE_WITH_MOBILE_NUMBER_BUTTON = "//button[@type='button']//span[@class='v-btn__content']//img[@class='mr-3']";
    public static final String PHONE_NUMBER_INPUT_FIELD = "//input[@placeholder=\"Phone number\"]";
    public static final String GET_OTP_BUTTON = "//span[contains(text(), 'Get OTP')]";
    public static final String ALERT_POPUP = "//div[contains(text(), 'Alert!')]";
    public static final String OKAY_BUTTON = "//span[contains(text(), 'Okay')]";
    public static final String VERIFY_BUTTON = "//span[contains(text(),\" Verify \")]";
    public static final String TITLE = "//span[contains(text(), 'Testing Institute')]";

//TODO Constructor
    public LLogin(){
    }

    public static String otpFields(int index){
        return "//input[@class='otp-field-box--" + index + "']";
    }
}
