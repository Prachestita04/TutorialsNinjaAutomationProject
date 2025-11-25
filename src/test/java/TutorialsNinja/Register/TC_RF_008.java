package TutorialsNinja.Register;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Date;

public class TC_RF_008 {

    @Test
    public void verifyConfirmPasswordFieldGivingWrongPassword() {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(40));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.get("https://tutorialsninja.com/demo/");

        driver.findElement(By.xpath("//span[text()='My Account']")).click();
        driver.findElement(By.linkText("Register")).click();

        driver.findElement(By.id("input-firstname")).sendKeys("User");
        driver.findElement(By.id("input-lastname")).sendKeys("Demo");
        driver.findElement(By.id("input-email")).sendKeys(randomMailUsingTimestamp());
        driver.findElement(By.id("input-telephone")).sendKeys("1234567890");
        driver.findElement(By.id("input-password")).sendKeys("12345");
        driver.findElement(By.id("input-confirm")).sendKeys("12345678");
        driver.findElement(By.xpath("//input[@name='newsletter'][@value='1']")).click();
        driver.findElement(By.name("agree")).click();
        driver.findElement(By.xpath("//input[@value='Continue']")).click();

        String expectedWarning = "Password confirmation does not match password!";
        Assert.assertEquals(driver.findElement(By.xpath("//input[@id='input-confirm']/following-sibling::div")).getText(), expectedWarning);
        driver.quit();
    }

    public String randomMailUsingTimestamp() {
        Date date = new Date();
        String dateString = date.toString();
        String replaceDateString = dateString.replaceAll("\\s", "").replaceAll("\\:", "");
        String dateUsingTimeStamp = replaceDateString + "@g.co";
        return dateUsingTimeStamp;
    }
}
