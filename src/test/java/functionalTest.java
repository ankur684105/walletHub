import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

public class functionalTest {

    WebDriver driver;
    pageObjectTestElement pom;
    @BeforeTest
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        pom = new pageObjectTestElement(driver);
    }
    @AfterTest
    public void setupRemove(){
        driver.quit();
    }

    @Test
    public void testOne(){
        try{
            driver.get("https://www.facebook.com/");
            pom.loginFb("testAuto@gmail.com","testPass");
        }
        catch(Exception e){
            System.out.println("Something wrong with Credentials");
        }
    }
    @Test
    public void testTwo(){
        String input = "SLF4J: Failed to load class \"org.slf4j.impl.StaticLoggerBinder\".\n" +
                "SLF4J: Defaulting to no-operation (NOP) logger implementation\n" +
                "SLF4J: See http://www.slf4j.org/codes.html#StaticLoggerBinder for further details.";
        driver.get("https://wallethub.com/profile/test-insurance-company-13732055i");
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        pom.postReview(input);
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        pom.loginWallet("sharmaankur001@gmail.com","Markanda@93");
    }
}
