package com.classes;
import com.interfaces.ILogin;
import com.interfaces.IOpenClassroom;
import com.interfaces.ISessionSchedule;
import com.locatorConstants.LOpenClassroom;
import com.locatorConstants.LSessionSchedule;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.Properties;

public class SessionSchedule implements ISessionSchedule {

    Properties properties;
    WebDriver driver;
    WebDriverWait webDriverWait;
    ILogin iLogin;
    IOpenClassroom iOpenClassroom;

//TODO Constructor
    private SessionSchedule(){
    }

    public SessionSchedule(Properties properties, WebDriver driver, ILogin iLogin, IOpenClassroom iOpenClassroom){
        this.properties = properties;
        this.driver = driver;
        this.webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        this.iLogin = iLogin;
        this.iOpenClassroom = iOpenClassroom;
    }

    public String sessionSchedule() {
        String title = "";
        try {
            iOpenClassroom.openClassroom();

            WebElement liveSessions = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(LSessionSchedule.LIVE_SESSIONS)));
            liveSessions.click();

            WebElement scheduleSessions = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(LSessionSchedule.SCHEDULE_SESSIONS)));
            scheduleSessions.click();

            WebElement addSession = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(LSessionSchedule.ADD_SESSION)));
            addSession.click();

            webDriverWait.wait(4000);

            WebElement timeDropdown = webDriverWait.until(ExpectedConditions.elementToBeClickable(By.xpath(LSessionSchedule.TIME_DROPDOWN)));
            timeDropdown.click();

            WebElement scrollContainer = webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.className(LSessionSchedule.SCROLL_CONTAINER)));

            JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
            jsExecutor.executeScript("arguments[0].scrollTop = arguments[0].scrollHeight;", scrollContainer);

            WebElement exactTime = webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(LSessionSchedule.EXACT_TIME)));
            exactTime.click();

            WebElement createButton = webDriverWait.until(ExpectedConditions.elementToBeClickable(By.xpath(LSessionSchedule.CREATE_BUTTON)));
            createButton.click();

            title = driver.getTitle();
        } catch (Exception error) {
            System.out.println("Error in Session Schedule function: " + error.getMessage());
        }
        return title;
    }

    public boolean validateUpcomingSession() {
        try {
            boolean upcomingSessionDisplayed = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class=\"d-flex align-center\"]//div[contains(text(), '10:00 PM')]"))).isDisplayed();
            if (upcomingSessionDisplayed) {
                return true;
            }
        } catch (Exception error) {
            System.out.println("Error in Validating Upcoming Session function: " + error.getMessage());
        }
        return false;
    }
}
