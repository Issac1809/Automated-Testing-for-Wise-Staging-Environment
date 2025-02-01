package com.base;
import com.classes.Login;
import com.classes.OpenClassroom;
import com.classes.SessionSchedule;
import com.factory.SeleniumFactory;
import com.interfaces.ILogin;
import com.interfaces.IOpenClassroom;
import com.interfaces.ISessionSchedule;
import org.openqa.selenium.WebDriver;
import java.util.Properties;

public class BaseMain {

    protected SeleniumFactory seleniumFactory;
    protected Properties properties;
    protected WebDriver driver;
    protected ILogin iLogin;
    protected IOpenClassroom iOpenClassroom;
    protected ISessionSchedule iSessionSchedule;

    //TODO Constructor
    public BaseMain(){
        try {
            seleniumFactory = new SeleniumFactory();
            properties = seleniumFactory.initializeProperties();
            driver = seleniumFactory.initializeDriver(properties);
            iLogin = new Login(properties, driver);
            iOpenClassroom = new OpenClassroom(iLogin, driver);
            iSessionSchedule = new SessionSchedule(properties, driver, iLogin, iOpenClassroom);


        } catch (Exception error) {
            System.out.println("Error Initializing BaseMain Constructor: " + error.getMessage());
        }
    }
}
