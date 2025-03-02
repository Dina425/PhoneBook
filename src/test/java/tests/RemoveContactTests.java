package tests;

import models.User;
import org.testng.Assert;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RemoveContactTests extends TestBase{
    @BeforeMethod
    public void preCondition(){
        if(!app.getHelperUser().isLogged())
            app.getHelperUser().login(new User().setEmail("sonicboom@gmail.com").setPassword("Snow123456!"));
        app.getHelperContact().provideContacts();

    }
    @Test
    public void removeFirstContact(){


        Assert.assertEquals(app.getHelperContact().deleteFirstContact(),1);

    }
    @Test
    public void removeAllContacts(){
        app.getHelperContact().deleteAllContact();
        Assert.assertTrue(app.getHelperContact().isNoContactsHereDisplayed());

    }
}
