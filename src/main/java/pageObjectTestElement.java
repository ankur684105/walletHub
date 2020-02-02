
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class pageObjectTestElement {
    WebDriver driver;
    By fbEmail = By.xpath("//input[@id='email']");
    By fbPwd = By.xpath("//input[@id='pass']");
    By fbSubmit = By.xpath("//input[@id='u_0_4']");
    By fourthStar = By.xpath("//div[@class='review-action ng-enter-element']//*[4]");
    By selectProduct = By.xpath("//span[contains(text(),'Select...')]");
    By healthInsurance = By.xpath("//li[contains(text(),'Health Insurance')]");
    By reviewTextView = By.xpath("//textarea[@placeholder='Write your review...']");
    By reviewSubmitBtn = By.xpath("//div[@class='sbn-action semi-bold-font btn fixed-w-c tall']");
    By loginLinkText = By.linkText("Login");
    By loginEmail = By.xpath("//input[@placeholder='Email Address']");
    By loginPwd = By.xpath("//input[@placeholder='Password']");
    By loginBtn = By.xpath("//button[@class='btn blue touch-element-cl']");

    public pageObjectTestElement(WebDriver driver) {
        this.driver = driver;
    }
    // Function to login WalletHub A/C
    public void loginWallet(String id, String pwd){
        try {
            driver.findElement(loginLinkText).click();
            driver.findElement(loginEmail).sendKeys(id);
            driver.findElement(loginPwd).sendKeys(pwd);
            driver.findElement(loginBtn).click();
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
    // Function to paste Review
    public void postReview(String input){
        driver.findElement(fourthStar).click();
        driver.findElement(selectProduct).click();
        driver.findElement(healthInsurance).click();
        driver.findElement(reviewTextView).sendKeys(input);
        driver.findElement(reviewSubmitBtn).click();
    }

    // Function to login Facebook
    public void loginFb(String id, String pwd){
        try {
            driver.findElement(fbEmail).sendKeys(id);
            driver.findElement(fbPwd).sendKeys(pwd);
            driver.findElement(fbSubmit).click();
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

}
