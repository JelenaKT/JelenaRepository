package pages;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.junit.Assert;


public class BasePage {

    public WebDriver driver;
    public WebDriverWait wait;

    public BasePage (WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    public void waitVisability (By elementBy){
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(elementBy));
    }

    public void writeText(By elementBy, String text){
        waitVisability(elementBy);
        driver.findElement(elementBy).clear();
        driver.findElement(elementBy).sendKeys(text);
    }

    public void click (By elementBy){
        waitVisability(elementBy);
        driver.findElement(elementBy).click();       
    }

    public String readText(By elementBy){
        waitVisability(elementBy);
        return driver.findElement(elementBy).getText();
    }

    public void assertTextEquals(String expectedText, String actualText){
        Assert.assertEquals(expectedText, actualText);
    }

    public int countItems(By elementBy){
        waitVisability(elementBy);
        return driver.findElements(elementBy).size();
    }

    public void assertIntEquals(int expectedNumber, int actualNumber){
        Assert.assertEquals(expectedNumber, actualNumber);
    }

    public void assertDoubleEquals(double expectedNumber, double actualNumber){
        Assert.assertEquals(expectedNumber, actualNumber, 0.001);
    }

}