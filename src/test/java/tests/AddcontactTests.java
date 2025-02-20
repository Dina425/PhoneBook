package tests;

import models.Contacts;
import models.User;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class AddcontactTests extends TestBase{
    @BeforeClass
    public void preCondition(){
        if(!app.getHelperUser().isLogged())
            app.getHelperUser().login(new User().setEmail("bazhenovadina321@gmail.com").setPassword("3837115@Aa"));

    }
    @Test
    public void addNewContactSuccess(){
        int i = (int)((System.currentTimeMillis()/1000)%3600);
        Contacts contact=new Contacts();
        contact.setName("Kate")
                .setLastname("Wisdom")
                .setPhoneNumber("2334"+i)
                .setAddress("Akko")
                .setDescription("fire");

        app.getHelperContacts().SubmitADDButton();
  //      app.getHelperContacts().SubmitADDButton();
//        app.getHelperContacts().fillContactsForm(contact);
//        app.getHelperContacts().submitSaveButton();
//        app.getHelperUser().isElementPresent(By.cssSelector("a[href='/home']"));
//        Assert.assertTrue(app.getHelperUser().isElementPresent(By.cssSelector("a[href='/home']")));
//        app.getHelperUser().click(By.cssSelector("a[4]"));





    }

}
