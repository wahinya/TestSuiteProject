import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class TestPurchaseOrder {
    private SingletonConfig singletonConfig = SingletonConfig.getInstance();
    private WebDriver driver;

    @Test(priority=1)
    public void purchaseOrder() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, 30);


        WebElement scrollArea1 = driver.findElement(By.cssSelector("#kt_aside_menu > div.ps__rail-y"));
        singletonConfig.scrollSideMenu(scrollArea1 ,20);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"menuPurchaseOrder\"]"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"btnAddPurchaseOrder\"]"))).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"select2-purchaseOrderCategory-container\"]"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"select2-purchaseOrderCategory-results\"]/li[text()='Local Purchase Order']"))).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"select2-purchaseOrderSupplier-container\"]"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/span/span/span[1]/input"))).sendKeys("Kemsa Ltd");
        Thread.sleep(1000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"select2-purchaseOrderSupplier-results\"]/li[text()='Panamedic Ltd5']"))).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"select2-purchaseOrderStore-container\"]"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"select2-purchaseOrderStore-results\"]/li[text()='Main Store']"))).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"select2-purchaseOrderProduct-container\"]"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/span/span/span[1]/input"))).sendKeys("Kemsa Ltd");
        Thread.sleep(1000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"select2-purchaseOrderProduct-results\"]/li[1]"))).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"purchaseOrderQuantity\"]"))).sendKeys("20");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"purchaseOrderCost\"]"))).sendKeys("200");

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"select2-purchaseOrderTaxRate-container\"]"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"select2-purchaseOrderTaxRate-results\"]/li[text()='0']"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(" //*[@id=\"btnSavePurchaseOrderDetail\"]"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(" //*[@id=\"btnCancelPurchaseOrder\"]"))).click();
        Thread.sleep(500);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"tblPurchaseOrderHeader\"]/tbody/tr/td[7]/span/button"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"tblPurchaseOrderHeader\"]/tbody/tr/td[7]/span/div/a[2]"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[6]/div/div[3]/button[2]"))).click();


    }

}
