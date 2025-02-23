package manager;

import models.Contacts;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class HelperContact extends HelperBase{
    public HelperContact(WebDriver wd) {
        super(wd);
    }
    public void submitADDButton() {
        pause(1000);

        // click(By.xpath("//a[4]"));
       // click(By.cssSelector("div"));
        click(By.cssSelector("a[href='/add']"));
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
        click(By.xpath("//div[@class='add_form__2rsm2']//button"));
    }

    public boolean isElementSaveStillPresent() {
        return isElementPresent(By.xpath("//div[@class='add_form__2rsm2']//button"));
    }

    public boolean isContactAddedByName(String name) {
        List<WebElement> list=wd.findElements(By.cssSelector("h2"));
        for(WebElement el:list){
            if(el.getText().equals(name)){
                return true;
            }
        }return false;
    }

    public boolean isContactAddedByPhoneNumber(String phoneNumber) {
        List<WebElement> list=wd.findElements(By.cssSelector("h3"));
        for(WebElement el:list){
            if(el.getText().equals(phoneNumber)){
                return true;
            }
        }return false;
    }

    public boolean isAddPageStillDisplayed() {
        return isElementPresent(By.cssSelector("a.active[href='/add']"));
    }

    public void provideContacts() {
    int count=countElements();
        int i = (int)((System.currentTimeMillis()/1000)%3600);

        if(count<3){

            for(int x = 0; x<3; x++) {
                Contacts contact=Contacts.builder()
                        .name("Kobby")
                        .lastname("Yassy")
                        .phoneNumber("17845454"+i+x)
                        .email("asdas"+i+"@gmail.com")
                        .address("akko")
                        .description("sdfsdf")
                        .build();



                submitADDButton();
                fillContactsForm(contact);
                submitSaveButton();
            }

        }

    }
    public int countElements(){
        List<WebElement> list=wd.findElements(By.cssSelector("h3"));
        int count=0;
        for(WebElement el:list){
            count++;
        }
        return count;
    }

    public int deleteFirstContact() {

        int before=countElements();


        click(By.xpath("(//div[@class='contact-item_card__2SOIM'])[1]"));
        click(By.xpath("//button[text()='Remove']"));
        pause(1000);

        int after=countElements();

        return before-after;

    }


    public void deleteAllContact() {
        int res=countElements();
        for( int x=0;x<res;x++){

            click(By.xpath("(//div[@class='contact-item_card__2SOIM'])"));
            click(By.xpath("//button[text()='Remove']"));
            pause(1000);

        }

    }
}
