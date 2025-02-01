package com.locatorConstants;

public class LSessionSchedule {

    public static final String LIVE_SESSIONS = "//a[contains(text(), 'Live Sessions')]";
    public static final String SCHEDULE_SESSIONS = "//span[contains(text(), 'Schedule Sessions')]";
    public static final String ADD_SESSION = "//span[@class=\"v-btn__content\"]//i[@class=\"v-icon notranslate mr-1 mdi mdi-plus theme--light\"]";
    public static final String TIME_DROPDOWN = "(//input[@type=\"text\" and @autocomplete=\"off\"])[4]";
    public static final String SCROLL_CONTAINER = "v-menu__content";
    public static final String EXACT_TIME = "//div[contains(text(), '10:00')]";
    public static final String CREATE_BUTTON = "//span[contains(text(), ' Create ')]";


//TODO Constructor
    public LSessionSchedule(){
    }
}
