package itstep.task_12.bo;

import itstep.task_12.po.HomePage;
import itstep.task_12.po.SignUpPage;
import org.testng.Assert;

import java.util.UUID;

public class DemoblazeBO {

    private HomePage homePage;
    private SignUpPage signUpPage;
    private String login;
    private String pass;

    public DemoblazeBO checkSignUpRandomUser() throws InterruptedException {
        //2. login
        homePage= new HomePage();

        signUpPage=homePage.signUp();

        //1.1 verify sign up page open
        Assert.assertTrue(signUpPage.isOpen());

        //1.2  sign up
        login= randomString();
         pass= randomString();

        homePage = signUpPage.inputLogin(login)
                .inputPass(pass)
                .signUp()
                .checkAndAcceptAlert();

        return this;
    }


    private String randomString() {
        return UUID.randomUUID().toString().substring(0,10).replace("-","");
    }

    public void checkLoginUser() throws InterruptedException {
        String userLabel = homePage.goToLoginPage()
                .inputLogin(login)
                .inputPassword(pass)
                .login()
                .loginLabel();

        Assert.assertEquals(userLabel, "Welcome "+login," unsuccessfull login");
    }
}
