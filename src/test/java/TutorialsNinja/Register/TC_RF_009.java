package TutorialsNinja.Register;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class TC_RF_009 {

    @Test
    public void verifyRegisterAccountGivingExistingEmail() {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(40));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.get("https://tutorialsninja.com/demo/");

        driver.findElement(By.xpath("//span[text()='My Account']")).click();
        driver.findElement(By.linkText("Register")).click();

        driver.findElement(By.id("input-firstname")).sendKeys("Demo");
        driver.findElement(By.id("input-lastname")).sendKeys("user");
        driver.findElement(By.id("input-email")).sendKeys("demouser@g.co");
        driver.findElement(By.id("input-telephone")).sendKeys("1023456789");
        driver.findElement(By.id("input-password")).sendKeys("123456");
        driver.findElement(By.id("input-confirm")).sendKeys("123456");
        driver.findElement(By.xpath("//input[@name='newsletter'][@value='1']")).click();
        driver.findElement(By.name("agree")).click();
        driver.findElement(By.xpath("//input[@value='Continue']")).click();

        String expectedWarningMessage = "Warning: E-Mail Address is already registered!";
        Assert.assertEquals(driver.findElement(By.xpath("//div[@class='alert alert-danger alert-dismissible']")).getText(), expectedWarningMessage);

        driver.quit();
    }
}
