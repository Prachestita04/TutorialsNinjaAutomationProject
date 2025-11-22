package TutorialsNinja.Register;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Date;

public class TC_RF_003 {

    @Test
    public void verifyAllFieldsInRegister(){
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
        driver.findElement(By.id("input-confirm")).sendKeys("12345");
        driver.findElement(By.xpath("//input[@name='newsletter'][@value='1']")).click();
        driver.findElement(By.name("agree")).click();
        driver.findElement(By.xpath("//input[@value='Continue']")).click();

        Assert.assertTrue(driver.findElement(By.linkText("Logout")).isDisplayed());

        String expectProperDetailOne = "Your Account Has Been Created!";
        String expectProperDetailTwo = "Congratulations! Your new account has been successfully created!";
        String expectProperDetailThree = "You can now take advantage of member privileges to enhance your online shopping experience with us.";
        String expectProperDetailFour = "If you have ANY questions about the operation of this online shop, please e-mail the store owner.";
        String expectProperDetailFive = "A confirmation has been sent to the provided e-mail address. If you have not received it within the hour, please ";
        String expectProperDetailSix = "contact us.";
        String actualProperDetails = driver.findElement(By.id("content")).getText();

        Assert.assertTrue(actualProperDetails.contains(expectProperDetailOne));
        Assert.assertTrue(actualProperDetails.contains(expectProperDetailTwo));
        Assert.assertTrue(actualProperDetails.contains(expectProperDetailThree));
        Assert.assertTrue(actualProperDetails.contains(expectProperDetailFour));
        Assert.assertTrue(actualProperDetails.contains(expectProperDetailFive));
        Assert.assertTrue(actualProperDetails.contains(expectProperDetailSix));

        Assert.assertTrue(driver.findElement(By.linkText("Success")).isDisplayed());

        driver.findElement(By.linkText("Continue")).click();

        Assert.assertTrue(driver.findElement(By.linkText("Edit your account information")).isDisplayed());

        driver.quit();

    }

    public String randomMailUsingTimestamp(){
        Date date = new Date();
        String dateString = date.toString();
        String replaceDateString = dateString.replaceAll("\\s","").replaceAll("\\:","");
        String dateUsingTimeStamp = replaceDateString+"@g.co";
        return dateUsingTimeStamp;
    }
}
