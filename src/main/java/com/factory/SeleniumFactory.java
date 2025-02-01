package com.factory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import java.io.FileInputStream;
import java.util.Properties;

public class SeleniumFactory {

    protected ChromeOptions chromeOptions;
    protected FirefoxOptions firefoxOptions;
    protected EdgeOptions edgeOptions;
    protected Properties properties;
    protected FileInputStream fileInputStream;
    protected WebDriver driver;

//TODO Constructor
    public SeleniumFactory() {
        this.chromeOptions = new ChromeOptions();
        this.firefoxOptions = new FirefoxOptions();
        this.edgeOptions = new EdgeOptions();
    }

    public Properties initializeProperties() {
        try {
            fileInputStream = new FileInputStream("./src/test/resources/config/Properties");
            properties = new Properties();
            properties.load(fileInputStream);
            fileInputStream.close();
        } catch (Exception error) {
            System.out.println("Error in Initialize Property Function: " + error.getMessage());
        }
        return properties;
    }

    public WebDriver initializeDriver(Properties properties) {
        try {
            String browserName = properties.getProperty("browserName").trim().toUpperCase();
            String url = properties.getProperty("appUrl");

            switch (browserName.toUpperCase()) {
                case "CHROME":
                    System.setProperty("webdriver.chrome.driver", "./chromedriver/chromedriver-win64/chromedriver.exe");
                    chromeOptions.addArguments("--remote-allow-origins=*");
                    driver = new ChromeDriver(chromeOptions);
                    break;

                case "FIREFOX":
                    System.setProperty("webdriver.gecko.driver", "./firefoxdriver/geckodriver.exe");
                    firefoxOptions.addArguments("--remote-allow-origins=*");
                    driver = new FirefoxDriver(firefoxOptions);
                    break;

                case "EDGE":
                    System.setProperty("webdriver.msedge.driver", ".edgedriver/msedgedriver.exe");
                    edgeOptions.addArguments("--remote-allow-origins=*");
                    driver = new EdgeDriver(edgeOptions);
                    break;

                default:
                    System.out.println("--Enter Proper Browser Name--");
                    break;
            }
            driver.manage().window().maximize();
            driver.get(url);
        } catch (Exception error) {
            System.out.println("Error in Initialize Driver Function: " + error.getMessage());
        }
        return driver;
    }
}
