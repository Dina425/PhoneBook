package tests;

import org.testng.annotations.Test;

public class LoginTests extends TestBase{
    @Test
    public void loginSuccesss(){
        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationform();

    }

}
