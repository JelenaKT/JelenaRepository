package tests;
import org.junit.Test;
import pages.HomePage;
import pages.LogInPage;

public class HomeTests extends BaseTests {
    
    public LogInPage logInPage;
    public HomePage homepage;

    String username = "standard_user";
    String password = "secret_sauce";
    String SuccesfulLogInExpectedText = "PRODUCTS";

    int expectedNumberOfProducts = 6;

    String firstName = "Jelena";
    String lastName = "Krivokapic Tosic";
    String postalCode = "11000";

    String SuccesfulOrderText = "THANK YOU FOR YOUR ORDER";


    @Test
    public void verifySuccesfulLogIn(){
        LogInPage logInPage = new LogInPage(driver);
        HomePage homePage = new HomePage(driver);
        
        logInPage.basePage();
        logInPage.logIn(username, password);
        homePage.verifySuccesfulLogIn(SuccesfulLogInExpectedText);
       
        try{
            Thread.sleep(5000);
        }catch(InterruptedException e){
            e.printStackTrace();
        }
    }

    @Test

    public void verifyNumberOfProductsOnHomePage(){
        LogInPage logInPage = new LogInPage(driver);
        HomePage homePage = new HomePage(driver);

        logInPage.basePage();
        logInPage.logIn(username, password);
        homePage.verifySuccesfulLogIn(SuccesfulLogInExpectedText);
        homePage.verifyNumberOfProductsOnHomePage(expectedNumberOfProducts);

        try{
            Thread.sleep(5000);
        }catch(InterruptedException e){
            e.printStackTrace();
        }
    }

    @Test

    public void verifyProductsAddedToCart(){
        LogInPage logInPage = new LogInPage(driver);
        HomePage homePage = new HomePage(driver);

        logInPage.basePage();
        logInPage.logIn(username, password);
        homePage.verifySuccesfulLogIn(SuccesfulLogInExpectedText);
        homePage.verifyProductsAddedToCart();
       
        try{
            Thread.sleep(5000);
        }catch(InterruptedException e){
            e.printStackTrace();
        }
    }

    @Test

    public void verifyNumberOfProductsAddedToCart(){
        LogInPage logInPage = new LogInPage(driver);
        HomePage homePage = new HomePage(driver);

        logInPage.basePage();
        logInPage.logIn(username, password);
        homePage.verifySuccesfulLogIn(SuccesfulLogInExpectedText);
        homePage.verifyProductsAddedToCart();
        homePage.verifyNumberOfProductsAddedToCart(2);  

        try{
            Thread.sleep(5000);
        }catch(InterruptedException e){
            e.printStackTrace();
        }  
    }

    @Test

    public void verifyCorrectPrice(){
        LogInPage logInPage = new LogInPage(driver);
        HomePage homePage = new HomePage(driver);
        
        logInPage.basePage();
        logInPage.logIn(username, password);
        homePage.verifySuccesfulLogIn(SuccesfulLogInExpectedText);
        homePage.verifyProductsAddedToCart();
        homePage.verifyNumberOfProductsAddedToCart(2);
        homePage.goToCheckout();
        homePage.fillInformationForm(firstName, lastName, postalCode);
        homePage.verifyCorrectSubtotal();
        homePage.verifyCorrectTotal();

        try{
            Thread.sleep(5000);
        }catch(InterruptedException e){
            e.printStackTrace();
        }
    }

    @Test

    public void verifySuccesfulOrder(){
        LogInPage logInPage = new LogInPage(driver);
        HomePage homePage = new HomePage(driver);
       
        logInPage.basePage();
        logInPage.logIn(username, password);
        homePage.verifySuccesfulLogIn(SuccesfulLogInExpectedText);
        homePage.verifyProductsAddedToCart();
        homePage.verifyNumberOfProductsAddedToCart(2);
        homePage.goToCheckout();
        homePage.fillInformationForm(firstName, lastName, postalCode);
        homePage.verifySuccesfulOrder(SuccesfulOrderText);

        try{
            Thread.sleep(5000);
        }catch(InterruptedException e){
            e.printStackTrace();
        }
    }


  
    
}
