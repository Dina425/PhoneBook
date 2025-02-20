package manager;

import models.Contacts;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HelperContacts extends HelperBase{
    public HelperContacts(WebDriver wd) {
        super(wd);
    }

    public void SubmitADDButton() {
        pause(2000);
        if(isElementPresent(By.xpath("//a[4]")))
        click(By.xpath("//a[4]"));
    }

    public void fillContactsForm(Contacts contact) {
        type(By.cssSelector(" input[placeholder='Name']"), contact.getName());
        type(By.cssSelector(" input[placeholder='Last Name']"), contact.getLastname());
        type(By.cssSelector(" input[placeholder='Phone']"), contact.getPhoneNumber());
        type(By.cssSelector(" input[placeholder='email']"), contact.getEmail());
        type(By.cssSelector(" input[placeholder='Address']"), contact.getAddress());
        type(By.cssSelector(" input[placeholder='description']"), contact.getDescription());
    }

    public void submitSaveButton() {
        pause(6000);
        click(By.cssSelector("a[href='/add']"));
    }
}
