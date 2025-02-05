package tests;

import org.testng.annotations.Test;

public class LoginTests extends TestBase{
    @Test
    public void loginSuccesss(){
        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationform("bazhenovadina321@gmail.com","3837115@Aa");
        app.getHelperUser().submitLogin();
        //Assert


    }

}
