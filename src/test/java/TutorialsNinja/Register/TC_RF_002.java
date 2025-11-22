/*
Amazon forgot password link verification. If they share any email to user's email id and validate with its subject,sender address, mail body
For that we need some steps and those are given below
-Gmail account/any mail account
-Account is already registered in amazon site.
-2 Factor Authentication is on in your google account
-IMAP Enables or not (Email account settings)
-App passcode


incomplete needs to update......
 */

package TutorialsNinja.Register;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class TC_RF_002 {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        driver.get("https://www.amazon.in/");

        driver.findElement(By.xpath("//button[contains(text(),'Continue shopping')]")).click();
        driver.findElement(By.xpath("//span[text()='Hello, sign in']")).click();
        driver.findElement(By.id("ap_email_login")).sendKeys("demouser@gmail.com");
        driver.findElement(By.xpath("//input[@aria-labelledby='continue-announce']")).click();
        driver.findElement(By.id("auth-fpp-link-bottom")).click();

        String email = "demouser@gmail.com";
        String appPassCode = "random-passcode-automatic-generate-by-email";

        driver.findElement(By.id("continue")).click();
    }
}
