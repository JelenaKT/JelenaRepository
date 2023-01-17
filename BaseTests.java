package tests;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseTests {

    public WebDriver driver;

    @Before
    public void setup(){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\PC\\Desktop\\JelenaProject\\JelenaProject\\lib\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }
    
    @After
    public void teardown(){
        driver.quit();
    }

    
}
