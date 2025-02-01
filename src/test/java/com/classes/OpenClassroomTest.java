package com.classes;
import com.base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class OpenClassroomTest extends BaseTest {
    @Test
    public void openClassroom() {
        try {
            String title = iOpenClassroom.openClassroom();
            Assert.assertEquals(title, "Classroom for Automated testing - WISE", "Opening the classroom was not successful");
        } catch (Exception error) {
            System.out.println("Error in Open Classroom Test Function: " + error.getMessage());
        }
    }
}
