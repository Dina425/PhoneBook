package tests;

import models.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class LoginTests extends TestBase{
    @BeforeMethod
    public void preCondition(){
        // if SignOut present---logout
        if(app.getHelperUser().isLogged())
            app.getHelperUser().logout();
    }
    @Test
    public void loginSuccess(){
        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationform("bazhenovadina321@gmail.com","3837115@Aa");
        app.getHelperUser().submitLogin();
        //Assert

//        Assert.assertEquals();
//        Assert.assertNotEquals();
//        Assert.assertTrue();
//        Assert.assertFalse();

        Assert.assertTrue(app.getHelperUser().isLogged());
    }
    @Test
    public void loginSuccess1(){
        User user = new User();
        user.setEmail("bazhenovadina321@gmail.com").setPassword("3837115@Aa");

        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationform(user);
        app.getHelperUser().submitLogin();

        Assert.assertTrue(app.getHelperUser().isLogged());
    }
    @Test
    public void loginWrongEmail(){
        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationform("bazhenovadina321gmail.com","3837115@Aa");
        app.getHelperUser().submitLogin();
        Assert.assertTrue(app.getHelperUser().isAlertPresent("Wrong email or password"));
    }
    @Test
    public void loginWrongPassword(){
        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationform("bazhenovadina321@gmail.com","3837115@a");
        app.getHelperUser().submitLogin();
    Assert.assertTrue(app.getHelperUser().isAlertPresent("Wrong email or password"));

    }
    @Test
    public void loginUnregisteredUser(){
        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationform("bazhenovadina1234567@gmail.com","3837115@Aa");
        app.getHelperUser().submitLogin();
        Assert.assertTrue(app.getHelperUser().isAlertPresent("Wrong email or password"));
    }

}
