package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class LogInPage extends BasePage {

        public LogInPage (WebDriver driver){
            super (driver);
        }

        String baseURL = "https://www.saucedemo.com/";

        By usernameBy = By.id("user-name");
        By passwordBy = By.id("password");
        By logInButtonBy = By.id("login-button");

        By errorContainerBy = By.xpath("//*[@id='login_button_container']/div/form/div[3]/h3");

        public LogInPage basePage(){
            driver.get(baseURL); 
            return this;
        }

        public LogInPage logIn(String username, String pasword){
            writeText(usernameBy, username);
            writeText(passwordBy, pasword);
            click(logInButtonBy);
            return this;
        }

        public LogInPage verifyLockedOutUser(String expectedText){
            String actualText = readText(errorContainerBy);
            assertTextEquals(expectedText, actualText);
            return this;
        }

        public LogInPage verifyInvalidPassword(String expectedText){
            String actualText = readText(errorContainerBy);
            assertTextEquals(expectedText, actualText);
            return this;
        }

        public LogInPage verifyEmptyPassword(String expectedText){
            String actualText = readText(errorContainerBy);
            assertTextEquals(expectedText, actualText);
            return this;
        }

        public LogInPage verifySuccesfulLogout(){
        waitVisability(logInButtonBy);
        return this;
        }


    }

    

 