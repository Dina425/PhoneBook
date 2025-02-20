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
        contact.setName("Alik")
                .setLastname("Koby")
                .setPhoneNumber("1234234"+i)
                .setEmail("asdas@gmail.com")
                .setAddress("Akko")
                .setDescription("Rutina");


        app.getHelperContact().SubmitADDButton();
        app.getHelperContact().fillContactsForm(contact);
        app.getHelperContact().submitSaveButton();
        Assert.assertTrue(app.getHelperUser().isElementPresent(By.xpath("//*[text()='Alik']")));
        Assert.assertTrue(app.getHelperUser().isElementPresent(By.xpath("//*[text()='Alik']")));










    }

}
