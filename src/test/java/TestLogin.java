import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class TestLogin {
    SingletonConfig singletonConfig = SingletonConfig.getInstance();
    public  WebDriver driver = singletonConfig.getDriver();
    public String firstName = "Seach";
    public String surName = "D16";


    @Test(priority=1, description = "handles access before any functional testing ")
    public void login(){
        WebDriverWait wait = new WebDriverWait(driver, 30);

        WebElement username = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div/div/div[2]/div/div/form/div[1]/input")));
        String user = "duncan@sycomafrica.com";
        username.sendKeys(user);

        WebElement password = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div/div/div[2]/div/div/form/div[2]/input")));
        String pass = "d@nsyh0s";
        password.sendKeys(pass);

        WebElement loginButton= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div/div/div[2]/div/div/form/div[3]/button")));
        loginButton.click();
    }

}
