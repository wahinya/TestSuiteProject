import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class TestCreditWallet {
    private SingletonConfig singletonConfig = SingletonConfig.getInstance();
    private WebDriver driver = singletonConfig.getDriver();

    private WebDriverWait wait;
    @Test(priority = 6)
    public void creditWallet()throws InterruptedException {
        Thread.sleep(4000);
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//*[@id=\"select2-walletCustomerCategory-container\"]"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//*[@id=\"select2-walletCustomerCategory-results\"]/li[text()='Credit']"))).click();

        //customer
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//*[@id=\"select2-walletCustomer-container\"]"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//*[@id=\"select2-walletCustomer-results\"]/li[text()='MASM INSURANCE_SAMPLE']"))).click();

        //add scheme
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//*[@id=\"select2-walletScheme-container\"]"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//*[@id=\"select2-walletScheme-results\"]/li[text()='MASM EXECUTIVE SCHEME']"))).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//*[@id=\"walletIdentification\"]"))).sendKeys("123456");

        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//*[@id=\"walletPrincipal\"]/option[2]"))).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//*[@id=\"btnSaveWallet\"]"))).click();
    }

    @Test (priority = 7)
    public void addVisitOP()throws InterruptedException {
        Thread.sleep(2000);
        wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"tblWallet\"]/tbody/tr/td[2]/a"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"select2-walletBookVisitType-container\"]"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"select2-walletBookVisitType-results\"]/li[text()='OutPatient']"))).click();
        Thread.sleep(500);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"btnSaveWalletBook\"]"))).click();

        // run this once to open a shift

        //wait.until(ExpectedConditions.visibilityOfElementLocated(
        // By.xpath("/html/body/div[6]/div/div[3]/button[2]"))).click();


    }

    @Test(priority = 8, description="adding an optional bill e.g consultation")
    public void addBill(){
        wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"select2-WorkSpaceRequestProduct-container\"]"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/span/span/span[1]/input"))).sendKeys("Consultation");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/span/span/span[2]/ul/li[1]"))).click();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"btnSaveRequestWorkSpace\"]"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"btnCancelRequestWorkSpace\"]"))).click();
    }
}
