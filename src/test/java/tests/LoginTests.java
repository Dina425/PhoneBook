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
        logger.info("Before method finished logout");
    }
    @Test
    public void loginSuccess(){
       // logger.info("Start test with name loginSuccess");
        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationform("sonicboom@gmail.com","Snow123456!");
        logger.info("Test data--> email:sonicboom@gmail.com & password:Snow123456!");
        app.getHelperUser().submitLogin();
        //Assert

//        Assert.assertEquals();
//        Assert.assertNotEquals();
//        Assert.assertTrue();
//        Assert.assertFalse();

        Assert.assertTrue(app.getHelperUser().isLogged());
        logger.info("End");
    }
    @Test
    public void loginSuccess1(){
        User user = new User();
        user.setEmail("sonicboom@gmail.com").setPassword("Snow123456!");

        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationform(user);
        app.getHelperUser().submitLogin();

        Assert.assertTrue(app.getHelperUser().isLogged());

    }
    @Test
    public void loginWrongEmail(){
        logger.info("Test data--> email:sonicboom@gmail.com & password:Snow123456!");
        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationform("sonicboomgmail.com","Snow123456!");
        app.getHelperUser().submitLogin();
        Assert.assertTrue(app.getHelperUser().isAlertPresent("Wrong email or password"));
        logger.info("Assert check is alert Wrong email or password");
    }
    @Test
    public void loginWrongPassword(){
        logger.info("Test data--> email:sonicboom@gmail.com & password:Snow123456");
        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationform("sonicboom@gmail.com","Snow123456");
        app.getHelperUser().submitLogin();
    Assert.assertTrue(app.getHelperUser().isAlertPresent("Wrong email or password"));
        logger.info("Assert check is alert Wrong email or password");

    }
    @Test
    public void loginUnregisteredUser(){
        logger.info("Test data--> email:sonicboom@gmail.com & password:Snow123456!");
        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationform("sonicboom678@gmail.com","Snow123456!");
        app.getHelperUser().submitLogin();
        Assert.assertTrue(app.getHelperUser().isAlertPresent("Wrong email or password"));
        logger.info("Assert check is alert Wrong email or password");
    }

}
