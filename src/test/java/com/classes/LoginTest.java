package com.classes;
import com.base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {
    @Test
    public void login() {
        try {
            String title = iLogin.login();
            Assert.assertEquals(title, "Testing Institute", "Login was not Successful");
        } catch (Exception error) {
            System.out.println("Error in Login Test Function: " + error.getMessage());
        }
    }
}