package com.base;
import com.classes.Login;
import com.classes.OpenClassroom;
import com.classes.SessionSchedule;
import com.factory.SeleniumFactory;
import com.interfaces.ILogin;
import com.interfaces.IOpenClassroom;
import com.interfaces.ISessionSchedule;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import java.util.Properties;

public class BaseTest {

    protected SeleniumFactory seleniumFactory;
    protected Properties properties;
    protected WebDriver driver;
    protected ILogin iLogin;
    protected IOpenClassroom iOpenClassroom;
    protected ISessionSchedule iSessionSchedule;

//TODO Constructor
    public BaseTest(){
    }

    @BeforeClass
    public void setUp() {
        try {
            seleniumFactory = new SeleniumFactory();
            properties = seleniumFactory.initializeProperties();
            driver = seleniumFactory.initializeDriver(properties);

//TODO Login
            iLogin = new Login(properties, driver);

//TODO Open Classroom
            iOpenClassroom = new OpenClassroom(iLogin, driver);

//TODO Session Schedule
            iSessionSchedule = new SessionSchedule(properties, driver, iLogin, iOpenClassroom);
        } catch (Exception error) {
            System.out.println("Error Initializing SetUp Function: " + error.getMessage());
        }
    }

    @AfterClass
    public void tearDown() {
        try {
            driver.close();
        } catch (Exception exception) {
            System.out.println("Error Initializing TearDown Function: " + exception.getMessage());
        }
    }
}
