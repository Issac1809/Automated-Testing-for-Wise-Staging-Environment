package com.classes;
import com.base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SessionScheduleTest extends BaseTest {
    @Test
    public void sessionSchedule() {
        try {
            String title = iSessionSchedule.sessionSchedule();
            Assert.assertEquals(title, "Classroom for Automated testing - WISE", "Session Schedule was not successful");

            boolean value = iSessionSchedule.validateUpcomingSession();
            Assert.assertTrue(value, "Session Schedule Creation was not successful");

        } catch (Exception error) {
            System.out.println("Error in Session Schedule Test Function: " + error.getMessage());
        }
    }
}
