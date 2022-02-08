package OrangeHrm.Tests;

import Base.TestBase;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.io.IOException;

public class LoginTest extends TestBase {
    String title;
    public  LoginTest(){
        super();
    }
    @BeforeSuite
    public void launch() throws Exception {
        launch_browser();
        obj.getLogin();
    }
    @Test
    public void CheckTitle(){
        title = obj.getLogin().verify_title();
        Assert.assertEquals(title, "OrangeHRM");
    }
    @Test
    public void login_details() throws IOException, InterruptedException {
        obj.getLogin().login();
    }
    @Test
    public void ForgetPassword(){
        obj.getLogin().forget_password();
    }
}
