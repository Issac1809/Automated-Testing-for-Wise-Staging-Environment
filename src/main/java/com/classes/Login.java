package com.classes;
import com.interfaces.ILogin;
import com.locatorConstants.LLogin;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;
import java.util.Properties;

public class Login implements ILogin {

    Properties properties;
    WebDriver driver;
    WebDriverWait webDriverWait;

//TODO Constructor
    private Login(){
    }

    public Login(Properties properties, WebDriver driver){
        this.properties = properties;
        this.driver = driver;
        this.webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public String login() {
        String title;
        try {
            String phoneNumber = properties.getProperty("phoneNumber");
            String otp = properties.getProperty("otp");

            List<WebElement> elements = webDriverWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(LLogin.CONTINUE_WITH_MOBILE_NUMBER_BUTTON)));
            WebElement lastElement = elements.get(elements.size() - 1);
            lastElement.click();

            WebElement phoneNumberField = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(LLogin.PHONE_NUMBER_INPUT_FIELD)));
            phoneNumberField.sendKeys(phoneNumber);

            WebElement otpButton = webDriverWait.until(ExpectedConditions.elementToBeClickable(By.xpath(LLogin.GET_OTP_BUTTON)));
            otpButton.click();

            for (int i = 0; i < otp.length(); i++) {
                String otpField = LLogin.otpFields(i);
                WebElement element = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(otpField)));
                element.sendKeys(String.valueOf(otp.charAt(i)));
            }

            List<WebElement> alertPopup = driver.findElements(By.xpath(LLogin.ALERT_POPUP));

            if (!alertPopup.isEmpty() && alertPopup.get(0).isDisplayed()) {
                WebElement okayButton = webDriverWait.until(ExpectedConditions.elementToBeClickable(By.xpath(LLogin.OKAY_BUTTON)));
                okayButton.click();
            }

            WebElement verifyButton = webDriverWait.until(ExpectedConditions.elementToBeClickable(By.xpath(LLogin.VERIFY_BUTTON)));
            verifyButton.click();

            WebElement titleElement = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(LLogin.TITLE)));
            title = titleElement.getText();
        } catch (Exception error) {
            System.out.println("Error in login function: " + error.getMessage());
            throw error;
        }
        return title;
    }
}
