package tests;
import org.junit.Test;
import pages.HomePage;
import pages.LogInPage;

public class LogInTests extends BaseTests{

    public LogInPage logInPage;

    
    String lockedOutUsername = "locked_out_user";
    String password = "secret_sauce";
    String errorTextLockedOutUser = "Epic sadface: Sorry, this user has been locked out.";

    String username = "standard_user";
    String invalidPassword = "Test";
    String errorTextInvalidPassword = "Epic sadface: Username and password do not match any user in this service";

    String emptyPassword = "";
    String errorTextEmptyPassword= "Epic sadface: Password is required";

    String SuccesfulLogInExpectedText = "PRODUCTS";

    
    @Test

    public void verifyLockedOutUser(){
    LogInPage logInPage = new LogInPage(driver);
    logInPage.basePage();
    logInPage.logIn(lockedOutUsername, password);
    logInPage.verifyLockedOutUser(errorTextLockedOutUser);

    try{
        Thread.sleep(5000);
    }catch(InterruptedException e){
        e.printStackTrace();
    }
    }

    @Test

    public void verifyInvalidPassword(){
    LogInPage logInPage = new LogInPage(driver);
    logInPage.basePage();
    logInPage.logIn(username, invalidPassword);
    logInPage.verifyInvalidPassword(errorTextInvalidPassword);
    
    try{
        Thread.sleep(5000);
    }catch(InterruptedException e){
        e.printStackTrace();
    }
    }

    @Test

    public void verifyEmptyPassword(){
    LogInPage logInPage = new LogInPage(driver);
    logInPage.basePage();
    logInPage.logIn(username, emptyPassword);
    logInPage.verifyEmptyPassword(errorTextEmptyPassword);

    try{
        Thread.sleep(5000);
    }catch(InterruptedException e){
        e.printStackTrace();
    }
    }

    @Test

    public void verifySuccesfulLogout(){
    LogInPage logInPage = new LogInPage(driver);
    HomePage homePage = new HomePage(driver);

    logInPage.basePage();
    logInPage.logIn(username, password);
    homePage.verifySuccesfulLogIn(SuccesfulLogInExpectedText);
    homePage.logout();
    logInPage.verifySuccesfulLogout();

    try{
        Thread.sleep(5000);
    }catch(InterruptedException e){
        e.printStackTrace();
        }
    } 


}
