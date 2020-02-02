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

    @Test(dataProvider = "data-provider")
    public void testOne(String id,String pwd){
        try{
            driver.get("https://www.facebook.com/");
            pom.loginFb(id,pwd);
        }
        catch(Exception e){
            System.out.println("Something wrong with Credentials");
        }
    }
    @Test(dataProvider = "data-provider1")
    public void testTwo(String id,String pwd){
        String input = "Feedback occurs when outputs of a system are routed back as inputs as part of a chain of cause-and-effect that forms a circuit or loop." +
                "The system can then be said to feed back into itself. The notion of cause-and-effect has to be handled carefully when applied to feedback systems";
        driver.get("https://wallethub.com/profile/test-insurance-company-13732055i");
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        pom.postReview(input);
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        pom.loginWallet(id,pwd);
    }
    @DataProvider(name = "data-provider")
    public Object[][] dataProviderMethod() {
        return new Object[][] { {"test@gmail.com","testPwd" }};
    }
    @DataProvider(name = "data-provider1")
    public Object[][] dataProviderMethod1() {
        return new Object[][] { { "sharmaankur001@gmail.com","Markanda@93"}};
    }
}
