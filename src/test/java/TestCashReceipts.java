import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class TestCashReceipts {
    private SingletonConfig singletonConfig = SingletonConfig.getInstance();
    private  WebDriver driver = singletonConfig.getDriver();
    private TestLogin testLogin = new TestLogin();
    private TestRegisterBooking registerBooking = new TestRegisterBooking();

//    @Test(priority =1, description = "process a cash receipt ")
//    public void loadCashPatient() throws InterruptedException {
//
//        WebDriverWait wait = new WebDriverWait(driver, 45);
//        Thread.sleep(5000);
//        registerBooking.setFirstName("John");
//        registerBooking.setSurName("Drake26");
//        registerBooking.registerNewPatient();
//        registerBooking.loadWallet();
//        registerBooking.addBill();
//         }
@Test(priority = 2)
    public void generateReceipt() throws InterruptedException {
     testLogin.login();
    WebDriverWait wait = new WebDriverWait(driver, 30);
    Thread.sleep(30000);
    //Call the scroll method on this web element
    WebElement scrollArea = driver.findElement(By.cssSelector("#kt_aside_menu > div.ps__rail-y"));
    singletonConfig.scrollSideMenu(scrollArea, 20);

    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"kt_aside_menu\"]/ul/li[12]"))).click();
    Thread.sleep(2000);
//    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"menuAccountCashPayment\"]"))).click();
//    Thread.sleep(2000);
    //*[@id="kt_aside_menu"]/ul/li[12]/div
    wait.until(ExpectedConditions.visibilityOfElementLocated(
            By.xpath("//*[@id=\"kt_aside_menu\"]/ul/li[12]/div"))).click();


    //*[@id="kt_aside_menu"]/ul/li[12]/div/ul
    wait.until(ExpectedConditions.visibilityOfElementLocated(
            By.xpath("//*[@id=\"kt_aside_menu\"]/ul/li[12]/div/ul"))).click();



//*[@id="menuAccountCashPayment"]
    wait.until(ExpectedConditions.visibilityOfElementLocated(
            By.id("menuAccountCashPayment"))).click();
    wait.until(ExpectedConditions.visibilityOfElementLocated(
            By.xpath("//*[@id=\"tblCashBills_filter\"]/label/input"))).sendKeys("Drake26");


    wait.until(ExpectedConditions.visibilityOfElementLocated(
            By.xpath("/html/body/div[4]/div/div[2]/div[2]/div[1]/div/div/div[1]/div[1]/div/div[2]/div/div[2]/div/table/tbody/tr[1]/td[2]/a"))).click();

//    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"select2-cashAccount-results\"]/li[text()='CASH']"))).click();
//    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"cashPaid\"]"))).sendKeys("2000");
//    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"btnSaveCashPayment\"]"))).click();
    this.printThisReceipt();
}
    private void printThisReceipt() {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//*[@id=\"divCashPaymentBase\"]/div/div[2]"))).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//*[@id=\"divCashPaymentBase\"]/div/div[2]/div[2]"))).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//*[@id=\"divPaymentChannel\"]"))).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//*[@id=\"divPaymentChannel\"]/div"))).click();

        //Cash
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//*[@id=\"select2-cashAccount-container\"]"))).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//*[@id=\"select2-cashAccount-results\"]/li[text()='CASH']"))).click();


        WebElement cashelement = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//*[@id=\"cashTotal\"]")));

        String amount = cashelement.getText();


        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//*[@id=\"cashPaid\"]"))).sendKeys("1000");


        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//*[@id=\"btnSaveCashPayment\"]"))).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("/html/body/div[6]/div/div[3]/button[2]"))).click();

    }
}
