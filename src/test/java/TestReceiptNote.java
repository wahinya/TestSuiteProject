import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class TestReceiptNote {
    private SingletonConfig singletonConfig = SingletonConfig.getInstance();
    private  WebDriver driver = singletonConfig.getDriver();

    private TestLogin testLogin = new TestLogin();

    @Test(priority= 12)
    public void receiptNote() throws InterruptedException {
        testLogin.login();
        Thread.sleep(40000);
        WebDriverWait wait = new WebDriverWait(driver, 30);

        WebElement scrollArea1 = driver.findElement(By.cssSelector("#kt_aside_menu > div.ps__rail-y"));
        singletonConfig.scrollSideMenu(scrollArea1 ,30);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"aside-menu-receipt-note\"]"))).click();
        Thread.sleep(500);
        String vendorName = "Kemsa Ltd";
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"tblReceiptNoteHeader_filter\"]/label/input"))).sendKeys(vendorName);
        Thread.sleep(1000);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"tblReceiptNoteHeader\"]/tbody/tr/td[8]/span/a"))).click();
        Thread.sleep(1000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"tblReceiptNoteHeader\"]/tbody/tr/td[8]/span/div/a[2]"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[6]/div/div[3]/button[2]"))).click();
    }
}
