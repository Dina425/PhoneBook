package tests;

import models.User;
import org.testng.Assert;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RemoveContactTests extends TestBase{
    @BeforeMethod
    public void preCondition(){
        if(!app.getHelperUser().isLogged())
            app.getHelperUser().login(new User().setEmail("bazhenovadina321@gmail.com").setPassword("3837115@Aa"));
        app.getHelperContact().provideContacts();

    }
    @Test
    public void removeFirstContact(){

        int resOfDelete =app.getHelperContact().deleteFirstContact();
        Assert.assertEquals(resOfDelete,1);

    }
    @Test
    public void removeAllContacts(){
        app.getHelperContact().deleteAllContact();
        Assert.assertTrue(app.getHelperUser().isNoContactsHereDisplayed());

    }
}
