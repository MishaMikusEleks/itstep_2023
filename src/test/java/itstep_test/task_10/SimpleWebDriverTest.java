package itstep_test.task_10;

import io.github.bonigarcia.wdm.managers.ChromeDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

public class SimpleWebDriverTest {
    private WebDriver driver;

    @BeforeTest
    void setup(){
        //System.setProperty("webdriver.chrome.driver","driver/chromedriver");
        //WebDriver driver = new ChromeDriver();

        //Setup ChromeDriver using DriverManager.
        ChromeDriverManager.getInstance().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);

    }

    @Test
    void simpleWDTest(){

        //step 1
        driver.get("https://jsonplaceholder.typicode.com");

        //step 2
        WebElement placeholderLink=driver.findElement(By.linkText("JSONPlaceholder"));
        Assert.assertTrue(placeholderLink.isDisplayed());
        Assert.assertEquals(placeholderLink.getAttribute("href"),
                "https://jsonplaceholder.typicode.com/","unexpected href");

        WebElement img=driver.findElement(By.xpath("//a[starts-with(@href,\"https://tryretool.com\")]/img"));
        Assert.assertTrue(img.isDisplayed());

        List<WebElement> linkImgList=driver.findElements(By.xpath("//a/img"));
        linkImgList.forEach(we-> Assert.assertTrue(we.isDisplayed()));


    }

    @AfterTest
    void closeBrowser(){
        driver.close();
        driver.quit();
    }

}
