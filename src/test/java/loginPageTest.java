import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.asserts.SoftAssert;

public class loginPageTest {

    public static void main(String[] args) throws InterruptedException {

        //setting up chrome driver for launching Chrome browser
        ChromeOptions options = new ChromeOptions();
        options.setBrowserVersion("117");
        WebDriver driver = new ChromeDriver(options);

        // open required website
        driver.get("https://www.linkedin.com/");

        //maximixe the browser windowgit config [--global] user.name "Full Name"
        driver.manage().window().maximize();

        //find login button on page and click
        WebElement loginButton= driver.findElement(By.xpath("//a[contains(@class,'nav__button-secondary')]"));
        loginButton.click();

        //wait for login page to open
        Thread.sleep(3000);


        //get different elements on login page 1. pageUrl, 2. pageTitle, 3. signInButton, 4. forgot password link
        String pageUrl = driver.getCurrentUrl();
        WebElement pageTitle = driver.findElement(By.xpath("//h1[@class='header__content__heading ']"));
        WebElement signInButton = driver.findElement(By.xpath("//button[text()='Sign in']"));
        WebElement forgotPasswordLink = driver.findElement(By.xpath("//a[text()='Forgot password?']"));

        //verifying each element on page if that is present or not

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(pageUrl.contains("login"), "page url doesn't contain login text");
        softAssert.assertEquals(pageTitle.getText(),"Sign in","page title is not correct");
        softAssert.assertTrue(signInButton.isDisplayed(), "sign in button is not displayed");
        softAssert.assertTrue(forgotPasswordLink.isDisplayed(),"forgot password link is not displayed");
        softAssert.assertAll();

        //closing all active browser session during execution
        driver.quit();
    }
}
