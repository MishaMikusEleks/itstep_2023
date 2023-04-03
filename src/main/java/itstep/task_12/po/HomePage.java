package itstep.task_12.po;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static itstep.task_12.WebDriverSupplier.driver;

public class HomePage {

    @FindBy(id="signin2")
    private WebElement signinPageButton;

    @FindBy(id="login2")
    private WebElement loginPageButton;

    public static final String URL="https://www.demoblaze.com/";

    public HomePage() {
        if(!URL.equals(driver.getCurrentUrl())){
            driver.get(URL);
        }
        PageFactory.initElements(driver,this);
    }

    public SignUpPage signUp() {
        signinPageButton.click();
        return new SignUpPage();
    }

    public LoginPage goToLoginPage() {
        //2. login
        loginPageButton.click();
        return new LoginPage();
    }
}
