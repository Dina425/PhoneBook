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
    public void addNewContactSuccessFull(){
        int i = (int)((System.currentTimeMillis()/1000)%3600);
        Contacts contact=new Contacts();
        contact.setName("Alik")
                .setLastname("Koby")
                .setPhoneNumber("1234234"+i)
                .setEmail("asdas"+i+"@gmail.com")
                .setAddress("Akko")
                .setDescription("Rutina");


        app.getHelperContact().SubmitADDButton();
        app.getHelperContact().fillContactsForm(contact);
        app.getHelperContact().submitSaveButton();

        Assert.assertTrue(app.getHelperUser().isElementPresent(
                By.xpath("//*[text()='"+contact.getName()+"']")));
        Assert.assertTrue(app.getHelperUser().isElementPresent(
                By.xpath("//*[text()='"+contact.getPhoneNumber()+"']")));

    }
    @Test
    public void addNewContactSuccessPartly(){
        int i = (int)((System.currentTimeMillis()/1000)%3600);
        Contacts contact=new Contacts();
        contact.setName("Alik"+i)
                .setLastname("Koby")
                .setPhoneNumber("1234234"+i)
                .setEmail("asdas@gmail.com")
                .setAddress("Akko")
                .setDescription("");


        app.getHelperContact().SubmitADDButton();
        app.getHelperContact().fillContactsForm(contact);
        app.getHelperContact().submitSaveButton();

        Assert.assertTrue(app.getHelperUser().isElementPresent(
                By.xpath("//*[text()='"+contact.getName()+"']")));
        Assert.assertTrue(app.getHelperUser().isElementPresent(
                By.xpath("//*[text()='"+contact.getPhoneNumber()+"']")));

    }
    @Test
    public void addNewContactEmptyName(){
        int i = (int)((System.currentTimeMillis()/1000)%3600);
        Contacts contact=new Contacts();
        contact.setName("")
                .setLastname("Koby")
                .setPhoneNumber("1234234"+i)
                .setEmail("asdas@gmail.com")
                .setAddress("Akko")
                .setDescription("");


        app.getHelperContact().SubmitADDButton();
        app.getHelperContact().fillContactsForm(contact);
        app.getHelperContact().submitSaveButton();
        Assert.assertTrue(app.getHelperContact().isElementSaveStillPresent());

    }
    @Test
    public void addNewContactEmptyLastName(){
        int i = (int)((System.currentTimeMillis()/1000)%3600);
        Contacts contact=new Contacts();
        contact.setName("Koby")
                .setLastname("")
                .setPhoneNumber("1234234"+i)
                .setEmail("asdas@gmail.com")
                .setAddress("Akko")
                .setDescription("");


        app.getHelperContact().SubmitADDButton();
        app.getHelperContact().fillContactsForm(contact);
        app.getHelperContact().submitSaveButton();
        Assert.assertTrue(app.getHelperContact().isElementSaveStillPresent());

    }
    @Test
    public void addNewContactWrongNumber(){
        int i = (int)((System.currentTimeMillis()/1000)%3600);
        Contacts contact=new Contacts();
        contact.setName("Koby")
                .setLastname("Yassy")
                .setPhoneNumber("1"+i)
                .setEmail("asdas@gmail.com")
                .setAddress("Akko")
                .setDescription("");


        app.getHelperContact().SubmitADDButton();
        app.getHelperContact().fillContactsForm(contact);
        app.getHelperContact().submitSaveButton();
        Assert.assertTrue(app.getHelperUser()
                .isAlertPresent("Phone not valid: Phone number must contain only digits! And length min 10, max 15!"));

    }
    @Test
    public void addNewContactEmptyNumber(){
        int i = (int)((System.currentTimeMillis()/1000)%3600);
        Contacts contact=new Contacts();
        contact.setName("Koby")
                .setLastname("Yassy")
                .setPhoneNumber(" ")
                .setEmail("asdas@gmail.com")
                .setAddress("Akko")
                .setDescription("");


        app.getHelperContact().SubmitADDButton();
        app.getHelperContact().fillContactsForm(contact);
        app.getHelperContact().submitSaveButton();
      //  app.getHelperUser().pause(2000);
        Assert.assertTrue(app.getHelperUser()
                .isAlertPresent("Phone not valid: Phone number must contain only digits! And length min 10, max 15!"));

    }
    @Test
    public void addNewContactWrongEmail(){
        int i = (int)((System.currentTimeMillis()/1000)%3600);
        Contacts contact=new Contacts();
        contact.setName("Koby")
                .setLastname("Yassy")
                .setPhoneNumber("1234234"+i)
                .setEmail("asdasgmail.com")
                .setAddress("Akko")
                .setDescription("");


        app.getHelperContact().SubmitADDButton();
        app.getHelperContact().fillContactsForm(contact);
        app.getHelperContact().submitSaveButton();
        Assert.assertTrue(app.getHelperUser()
                .isAlertPresent("Email not valid:"));

    }
//    @Test//bug -must be allert
//    public void addNewContactEmptyEmail(){
//        int i = (int)((System.currentTimeMillis()/1000)%3600);
//        Contacts contact=new Contacts();
//        contact.setName("Koby")
//                .setLastname("Yassy")
//                .setPhoneNumber("1234234"+i)
//                .setEmail("")
//                .setAddress("Akko")
//                .setDescription("");
//
//
//        app.getHelperContact().SubmitADDButton();
//        app.getHelperContact().fillContactsForm(contact);
//        app.getHelperContact().submitSaveButton();
//        Assert.assertTrue(app.getHelperUser()
//                .isAlertPresent("Email not valid:"));
//
//    }
//    @Test//bug -must be allert
//    public void addNewContactSameEmail(){
//        int i = (int)((System.currentTimeMillis()/1000)%3600);
//        Contacts contact=new Contacts();
//        contact.setName("Koby")
//                .setLastname("Yassy")
//                .setPhoneNumber("1234234"+i)
//                .setEmail("")
//                .setAddress("Akko")
//                .setDescription("");
//
//
//        app.getHelperContact().SubmitADDButton();
//        app.getHelperContact().fillContactsForm(contact);
//        app.getHelperContact().submitSaveButton();
//        Assert.assertTrue(app.getHelperUser()
//                .isAlertPresent("Email not valid:"));
//
//    }
    @Test
public void addNewContactEmptyAddress(){
    int i = (int)((System.currentTimeMillis()/1000)%3600);
    Contacts contact=new Contacts();
    contact.setName("Koby")
            .setLastname("Yassy")
            .setPhoneNumber("1234234"+i)
            .setEmail("asdas@gmail.com")
            .setAddress("")
            .setDescription("");


    app.getHelperContact().SubmitADDButton();
    app.getHelperContact().fillContactsForm(contact);
    app.getHelperContact().submitSaveButton();
        Assert.assertTrue(app.getHelperContact().isElementSaveStillPresent());

}



}
