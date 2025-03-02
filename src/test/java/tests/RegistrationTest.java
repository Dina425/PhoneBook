package tests;

import models.User;
import org.testng.Assert;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Random;

public class RegistrationTest extends TestBase {
    @BeforeMethod
    public void preCondition(){
        if(app.getHelperUser().isLogged())
            app.getHelperUser().logout();
    }
    @Test
    public void registrationSuccess(){
        Random randome=new Random();
        int i=randome.nextInt(1000)+2000;
        User user=new User()
                .setEmail("SonicBoom"+i+"@gmail.com")
                .setPassword("Snow123456@");
        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationform(user);
        app.getHelperUser().submitRegistration();
        Assert.assertTrue(app.getHelperUser().isElementLogoutPresent());
        Assert.assertTrue(app.getHelperUser().isNoContactsHereDisplayed());
    }
    @Test
    public void registrationWrongEmail(){
        User user=new User()
                .setEmail("SonicBoomgmail.com")
                .setPassword("Snow123456@");
        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationform(user);
        app.getHelperUser().submitRegistration();
        app.getHelperContact().pause(1000);
        Assert.assertTrue(app.getHelperUser().isAlertPresent("Wrong email or password"));
    }
    @Test
    public void registrationWrongPassword(){

        User user=new User()
                .setEmail("SonicBoom@gmail.com")
                .setPassword("Sn");
        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationform(user);
        app.getHelperUser().submitRegistration();
        Assert.assertTrue(app.getHelperUser().isAlertPresent("Wrong email or password"));
    }
    @Test
    public void registrationEmptyEmail(){

        User user=new User()
                .setEmail("")
                .setPassword("Snow123456@");
        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationform(user);
        app.getHelperUser().submitRegistration();
        app.getHelperUser().pause(8000);
        Assert.assertTrue(app.getHelperUser().isAlertPresent("Wrong email or password"));
    }
    @Test
    public void registrationEmptyPassword(){
        Random randome=new Random();
        int i=randome.nextInt(1000);
        User user=new User()
                .setEmail("SonicBoom"+i+"gmail.com")
                .setPassword("");
        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationform(user);
        app.getHelperUser().submitRegistration();
        Assert.assertTrue(app.getHelperUser().isAlertPresent("Wrong email or password"));
    }
    @Test
    public void registrationExistUser(){

        User user=new User()
                .setEmail("SonicBoom@gmail.com")
                .setPassword("Snow123456!");
        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationform(user);
        app.getHelperUser().submitRegistration();
        Assert.assertTrue(app.getHelperUser().isAlertPresent("User already exist"));


    }
}
