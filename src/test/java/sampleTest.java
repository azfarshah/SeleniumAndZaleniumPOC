import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class sampleTest {

    RemoteWebDriver driver;
    DesiredCapabilities capabilities;

    @BeforeTest
    @Parameters({"browserName"})
    public void setup(String browserName) throws MalformedURLException {
        capabilities = new DesiredCapabilities();

        if (browserName.equals("Chrome1")) {
            capabilities.setCapability(CapabilityType.BROWSER_NAME, BrowserType.CHROME);
            capabilities.setCapability(CapabilityType.PLATFORM_NAME, Platform.LINUX);
        } else if (browserName.equals("Firefox2")) {
            capabilities.setCapability(CapabilityType.BROWSER_NAME, BrowserType.FIREFOX);
            capabilities.setCapability(CapabilityType.PLATFORM_NAME, Platform.LINUX);
        } /*else if (browserName.equals("Chrome3")) {
            capabilities.setCapability(CapabilityType.BROWSER_NAME, BrowserType.CHROME);
            capabilities.setCapability(CapabilityType.PLATFORM_NAME, Platform.LINUX);
        } else if (browserName.equals("Firefox4")) {
            capabilities.setCapability(CapabilityType.BROWSER_NAME, BrowserType.FIREFOX);
            capabilities.setCapability(CapabilityType.PLATFORM_NAME, Platform.LINUX);
        }*/
        URL url = new URL("http://127.0.0.1:4444/wd/hub");

        driver = new RemoteWebDriver(url, capabilities);
        driver.navigate().to("https://demo.nopcommerce.com/");
    }

    @Test
    public void testexeute() throws InterruptedException {
        driver.findElement(By.xpath("//a[@class='ico-login']")).click();
        driver.findElement(By.id("Email")).sendKeys("ahmzee23@gmail.com");
        driver.findElement(By.id("Password")).sendKeys("thunder27");
        driver.findElement(By.xpath("//input[@class='button-1 login-button']")).click();

        Thread.sleep(5000);

        Assert.assertEquals(driver.getTitle(), "nopCommerce demo store");
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }
}