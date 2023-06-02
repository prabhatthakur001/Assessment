import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class FirstUI {

        public static void  main(String[] args) {

            // Setup WebDriverManager for Chrome
            System.setProperty("webdriver.chrome.driver", "./chromedriver.exe");
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--start-maximized"); // Optional: Maximize browser window
            options.addArguments("--accept-cookie", "true");
            options.addArguments("--disable-cache"); // Disable cache
            options.addArguments("--delete-cookies"); // Delete cookies
            // Create a new instance of the ChromeDriver
            WebDriver driver = new ChromeDriver(options);

            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

            driver.get("https://auth.dev.vntech.io");

            WebElement acceptCookies = driver.findElement(By.xpath("(//button[contains(text(),'Accept All')])[1]"));
            WebDriverWait wait = new WebDriverWait(driver,10);
            wait.until(ExpectedConditions.visibilityOf(acceptCookies));
//            acceptCookies.click();
            JavascriptExecutor executor = (JavascriptExecutor)driver;
            executor.executeScript("arguments[0].click();", acceptCookies);

            WebElement signUpButton = driver.findElement(By.xpath("//a[normalize-space()='Sign up']"));
            signUpButton.click();

            WebElement verifyingWeAreSigningUp = driver.findElement(By.xpath("//h6[normalize-space()='Get started with VN Secure']"));
            Assert.assertTrue(verifyingWeAreSigningUp.isDisplayed());

            //--------------- Signup Via Google ----------------------------//

//            WebElement iFrameForGoogleLogin = driver.findElement(By.xpath("//iframe[@title='Sign in with Google Button']"));
//
//            iFrameForGoogleLogin.click();
//
//            String currentWindowHandle = driver.getWindowHandle();
//            for (String windowHandle : driver.getWindowHandles()) {
//                if (!windowHandle.equals(currentWindowHandle)) {
//                    driver.switchTo().window(windowHandle);
//                    break;
//                }
//            }
//
//
//            WebElement emailInput = driver.findElement(By.id("identifierId"));
//            emailInput.sendKeys("prabhat.thakur4@gmail.com"); //enter email here
//
//            WebElement nextButton = driver.findElement(By.id("identifierNext"));
//            nextButton.click();
//
//            WebElement passwordInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("password")));
//
//            passwordInput.sendKeys("password");  //enter password here
//
//
//            WebElement loginButton = driver.findElement(By.id("passwordNext"));
//            loginButton.click();

//            String currentHandle = driver.getWindowHandle();
//            driver.switchTo().window(currentHandle);

             //----------Signup Google Ends------------------------------//

            //----------- Signup with apple --------------------------------//

//            WebElement loginViaApple = driver.findElement(By.xpath("//button[normalize-space()='Continue with Apple']"));
//            loginViaApple.click();
//
//            //            String currentWindowHandle = driver.getWindowHandle();
////            for (String windowHandle : driver.getWindowHandles()) {
////                if (!windowHandle.equals(currentWindowHandle)) {
////                    driver.switchTo().window(windowHandle);
////                    break;
////                }
////            }
//
//            //enter email here
//            WebElement appleIdInput = driver.findElement(By.xpath("//input[@id='account_name_text_field']"));
//            appleIdInput.sendKeys("your_apple_id@example.com");
//
//            WebElement continueButton = driver.findElement(By.xpath("//button[@id='sign-in']"));
//            continueButton.click();
//
//            // enter your password
//            WebElement applePassword = driver.findElement(By.xpath("//input[@id='password_text_field']"));
//            applePassword.sendKeys("your_password");
//
//            WebElement appleSignInButton = driver.findElement(By.xpath("//button[@id='sign-in']"));
//            appleSignInButton.click();
//            String currentHandle = driver.getWindowHandle();
//            driver.switchTo().window(currentHandle);

            //--------------signup with apple end-----------------------------------//

            //---------Signup With Facebook -------------------------------//

//            WebElement loginViaFacebook = driver.findElement(By.xpath("//button[normalize-space()='Continue with Facebook']"));
//            loginViaFacebook.click();

//            String currentWindowHandle = driver.getWindowHandle();
//            for (String windowHandle : driver.getWindowHandles()) {
//                if (!windowHandle.equals(currentWindowHandle)) {
//                    driver.switchTo().window(windowHandle);
//                    break;
//                }
//            }
//
//            //enter Facebook email
//            WebElement facebookEmailInput = driver.findElement(By.id("email"));
//            facebookEmailInput.sendKeys("your_email@example.com");
//
//            // enter your password
//            WebElement facebookPasswordInput = driver.findElement(By.id("pass"));
//            facebookPasswordInput.sendKeys("your_password");
//
//
//            WebElement facebookLoginButton = driver.findElement(By.name("login"));
//            facebookLoginButton.click();

//            String currentHandle = driver.getWindowHandle();
//            driver.switchTo().window(currentHandle);


            //------------------------ Signup Via Facebook Ends ---------------------------------------//

            //----------------------Signup via microsoft ------------------------------------------------//
//
//            WebElement loginViaMS = driver.findElement(By.xpath("//p[contains(.,'Continue with Microsoft')]"));
//            loginViaMS.click();
//
//            String currentWindowHandle = driver.getWindowHandle();
//            for (String windowHandle : driver.getWindowHandles()) {
//                if (!windowHandle.equals(currentWindowHandle)) {
//                    driver.switchTo().window(windowHandle);
//                    break;
//                }
//            }
//
//            //enter MS email
//            WebElement msEmailInput = driver.findElement(By.xpath("//input[@type='email']"));
//            msEmailInput.sendKeys("your_email@example.com");
//
//            WebElement msNextButton = driver.findElement(By.xpath("//input[@type='submit']"));
//            msNextButton.click();
//
//
//            //enter ms password
//            WebElement msPasswordInput = driver.findElement(By.xpath("//input[@type='password']"));
//            wait.until(ExpectedConditions.visibilityOf(msPasswordInput));
//            msPasswordInput.sendKeys("your_password");
//
//            WebElement signInButton = driver.findElement(By.xpath("//input[@type='submit']"));
//            signInButton.click();

//            String currentHandle = driver.getWindowHandle();
//            driver.switchTo().window(currentHandle);

            //-------------------- Signup via microsoft ends -------------------------------------------//

            //----------- Signup via others --------------------------------------------//

            WebElement loginViaOthers = driver.findElement(By.xpath("//p[.='Other']"));
            loginViaOthers.click();

            //enter first, second name and email here
            WebElement enterFirstName = driver.findElement(By.xpath("//p[normalize-space()='First Name']/..//input[@type='text']"));
            enterFirstName.sendKeys("FirstName");

            WebElement enterLastName = driver.findElement(By.xpath("//p[normalize-space()='Last Name']/..//input[@type='text']"));
            enterLastName.sendKeys("SecondName");

            WebElement enterOtherEmail = driver.findElement(By.xpath("(//input[@type='text'])[3]"));
            enterOtherEmail.sendKeys("your_email@email.com");

            WebElement clickCreateAccount = driver.findElement(By.xpath("//button[normalize-space()='Create Account']"));
            clickCreateAccount.click();
            //-------------- Signup via others end -------------------------------------//

            //VALIDATION OF MENU
            WebElement menuAdvanced = driver.findElement(By.xpath("//p[normalize-space()='Advanced']"));
            WebElement menuEssentials = driver.findElement(By.xpath("//p[normalize-space()='Essentials']"));
            Assert.assertTrue(menuEssentials.isDisplayed());
            Assert.assertTrue(menuAdvanced.isDisplayed(),"Menu option didn't get displayed");

            loginGmailAndVerifyEmail();
        }

        public static void loginGmailAndVerifyEmail(){
           WebDriver driver = new ChromeDriver();
            driver.get("https://www.gmail.com");

            // enter your email address
            WebElement emailInput = driver.findElement(By.id("identifierId"));
            emailInput.sendKeys("your_email@gmail.com");
            WebElement nextButton = driver.findElement(By.id("identifierNext"));
            nextButton.click();

            WebDriverWait wait = new WebDriverWait(driver, 20);
            WebElement passwordInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("password")));

            // Enter your password
            passwordInput.sendKeys("your_password");


            WebElement loginButton = driver.findElement(By.id("passwordNext"));
            loginButton.click();

            wait.until(ExpectedConditions.titleContains("Inbox"));

            WebElement verificationEmail = driver.findElement(By.xpath("(//span[@name='VN Secure'])[2]"));
            wait.until(ExpectedConditions.visibilityOf(verificationEmail));
            verificationEmail.click();


            WebElement verifyEmailButton = driver.findElement(By.xpath("Verify_Email_Xpath"));
            verifyEmailButton.click();

            driver.quit();
        }

        public static void signInFlow(){

            WebDriver driver = new ChromeDriver();

            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

            driver.get("https://auth.dev.vntech.io");

            WebElement acceptCookies = driver.findElement(By.xpath("(//button[contains(text(),'Accept All')])[1]"));
            WebDriverWait wait = new WebDriverWait(driver,10);
            wait.until(ExpectedConditions.visibilityOf(acceptCookies));
//            acceptCookies.click();
            JavascriptExecutor executor = (JavascriptExecutor)driver;
            executor.executeScript("arguments[0].click();", acceptCookies);

            WebElement iFrameForGoogleLogin = driver.findElement(By.xpath("//iframe[@title='Sign in with Google Button']"));

            iFrameForGoogleLogin.click();


            String currentWindowHandle = driver.getWindowHandle();
            for (String windowHandle : driver.getWindowHandles()) {
                if (!windowHandle.equals(currentWindowHandle)) {
                    driver.switchTo().window(windowHandle);
                    break;
                }
            }


            WebElement emailInput = driver.findElement(By.id("identifierId"));
            emailInput.sendKeys("prabhat.thakur4@gmail.com"); //enter email here

            WebElement nextButton = driver.findElement(By.id("identifierNext"));
            nextButton.click();

            WebElement passwordInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("password")));

            passwordInput.sendKeys("password");  //enter password here


            WebElement loginButton = driver.findElement(By.id("passwordNext"));
            loginButton.click();

            String currentHandle = driver.getWindowHandle();
            driver.switchTo().window(currentHandle);

        }

    }
