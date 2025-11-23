package TutorialsNinja.Register;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Date;

public class TC_RF_001 {

    @Test
    public void verifyRegisterFieldWithMandatoryDetails() {
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(40));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

        driver.get("https://tutorialsninja.com/demo/");
        WebElement myAccount = driver.findElement(By.xpath("//span[text()='My Account']"));
        myAccount.click();
        WebElement register = driver.findElement(By.linkText("Register"));
        register.click();

        WebElement firstname = driver.findElement(By.id("input-firstname"));
        firstname.sendKeys("Demo");
        WebElement lastname = driver.findElement(By.id("input-lastname"));
        lastname.sendKeys("user");
        WebElement email = driver.findElement(By.id("input-email"));
        email.sendKeys(generateRandomEmail());
        WebElement telephone = driver.findElement(By.id("input-telephone"));
        telephone.sendKeys("1023456789");
        WebElement password = driver.findElement(By.id("input-password"));
        password.sendKeys("123456");
        WebElement confirmPassword = driver.findElement(By.id("input-confirm"));
        confirmPassword.sendKeys("123456");
        WebElement privacyCheck = driver.findElement(By.xpath("//input[@name='agree']"));
        privacyCheck.click();
        WebElement registerBtn = driver.findElement(By.xpath("//input[@value='Continue']"));
        registerBtn.click();

        //Do some validation to check if you are successfully logged in or not

        Assert.assertTrue(driver.findElement(By.linkText("Logout")).isDisplayed());
        String expectedHeading = "Your Account Has Been Created!";
        Assert.assertEquals(driver.findElement(By.xpath("//div[@id='common-success']//h1")).getText(), expectedHeading);

        String actualProperDetailsOne = "Congratulations! Your new account has been successfully created!";
        String actualProperDetailsTwo = "You can now take advantage of member privileges to enhance your online shopping experience with us.";
        String actualProperDetailsThree = "If you have ANY questions about the operation of this online shop, please e-mail the store owner.";
        String actualProperDetailsFour = " contact us";

        String expectedProperDetails = driver.findElement(By.xpath("//div[@id='content']")).getText();

        Assert.assertTrue(expectedProperDetails.contains(actualProperDetailsOne));
        Assert.assertTrue(expectedProperDetails.contains(actualProperDetailsTwo));
        Assert.assertTrue(expectedProperDetails.contains(actualProperDetailsThree));
        Assert.assertTrue(expectedProperDetails.contains(actualProperDetailsFour));

        WebElement continueBtn = driver.findElement(By.xpath("//a[text()='Continue']"));
        continueBtn.click();

        Assert.assertTrue(driver.findElement(By.linkText("Edit your account information")).isDisplayed());

        driver.quit();
    }

    public String generateRandomEmail() {
        //generate email using timestamp

        Date date = new Date();
        String dateString = date.toString();
        String replaceSpaceInDate = dateString.replaceAll("\\s", "");
        String replaceColonInDate = replaceSpaceInDate.replaceAll("\\:", "");
        String emailUsingTimestamp = replaceColonInDate + "@g.co";
        return emailUsingTimestamp;
    }
}
