import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;


public class AsignLeave {
    private SingletonConfig singletonConfig = SingletonConfig.getInstance();
    private WebDriver driver = singletonConfig.getDriver();
    private TestLogin testLogin = new TestLogin();

    // This class connects to an interviewers portal
    // Ignore the methods for now

    @Test(priority= 2)
    public void assignleave() throws InterruptedException{
        testLogin.login();

        Thread.sleep(30000);
        WebDriverWait wait = new WebDriverWait(driver, 30);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"menu_leave_viewLeaveModule\"]"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"menu_leave_assignLeave\"]"))).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"assignleave_txtEmployee_empName\"]"))).sendKeys("Linda Anderson");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"assignleave_txtLeaveType\"]"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"assignleave_txtLeaveType\"]/option[5]"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"assignleave_txtLeaveType\"]"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"assignleave_txtFromDate\"]"))).sendKeys("2020-02-12");

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"assignBtn\"]"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"confirmOkButton\"]"))).click();

        driver.quit();

    }


}
