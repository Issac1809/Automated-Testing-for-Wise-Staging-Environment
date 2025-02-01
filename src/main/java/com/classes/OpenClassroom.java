package com.classes;
import com.interfaces.ILogin;
import com.interfaces.IOpenClassroom;
import com.locatorConstants.LOpenClassroom;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;

public class OpenClassroom implements IOpenClassroom {

    ILogin iLogin;
    WebDriver driver;
    WebDriverWait webDriverWait;

//TODO Constructor
    private OpenClassroom(){
    }

    public OpenClassroom(ILogin iLogin, WebDriver driver){
        this.iLogin = iLogin;
        this.driver = driver;
        this.webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public String openClassroom() {
        String title;
        try {
            iLogin.login();

            WebElement groupCourseElement = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(LOpenClassroom.GROUP_COURSE)));
            groupCourseElement.click();

            List<WebElement> elements = webDriverWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(LOpenClassroom.CANCEL_BUTTON)));
            WebElement lastElement = elements.get(elements.size() - 1);
            lastElement.click();

            WebElement classroomField = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(LOpenClassroom.CLASSROOM)));
            classroomField.click();

            webDriverWait.until(ExpectedConditions.titleContains(LOpenClassroom.TITLE));

            title = driver.getTitle();
        } catch (Exception error) {
            System.out.println("Error in login function: " + error.getMessage());
            throw error;
        }
        return title;
    }
}