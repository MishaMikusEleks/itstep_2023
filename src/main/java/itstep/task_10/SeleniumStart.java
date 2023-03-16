package itstep.task_10;

import io.github.bonigarcia.wdm.managers.ChromeDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.List;

public class SeleniumStart {


    //General
    //Setup ChromeDriver using driver file and properties.
    //Setup ChromeDriver using DriverManager.
    //My first UI test:
    //go to the page from your variant
    //choose any 5 different elements;
    //Use different WebElement methods to communicate with those elements. (one element - at least one interaction)
    //Make a testNG test case to check visibility of your elements.

    public static void main(String[] args) {
        //Setup ChromeDriver using driver file and properties.
        System.setProperty("webdriver.chrome.driver","driver/chromedriver");
        //WebDriver driver = new ChromeDriver();

        //Setup ChromeDriver using DriverManager.
        ChromeDriverManager.getInstance().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.get("https://jsonplaceholder.typicode.com");

        //1
        WebElement placeholderLink=driver.findElement(By.linkText("JSONPlaceholder"));
        System.out.println(placeholderLink.getAttribute("href"));
        placeholderLink.click();
        System.out.println("click "+placeholderLink);

        //2
        WebElement img=driver.findElement(By.xpath("//a[starts-with(@href,\"https://tryretool.com\")]/img"));
        System.out.println("img rect "+img.getRect().x+" "+img.getRect().y);


        //3 list
        //
        List<WebElement> linkImgList=driver.findElements(By.xpath("//a/img"));
        linkImgList.forEach(we-> System.out.println(we.getAttribute("src")));

        driver.close();
        driver.quit();

    }
}
