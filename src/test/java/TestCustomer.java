import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class TestCustomer {
    private SingletonConfig singletonConfig = SingletonConfig.getInstance();
    public  WebDriver driver = singletonConfig.getDriver();
    private TestLogin testLogin = new TestLogin();
    String customerName = "American Insurance3";

    @Test(priority = 9, description = "add a new customer, assuming you have a customer category defined")
    public void addCustomer() throws InterruptedException {
        testLogin.login();

        Thread.sleep(30000);
        WebDriverWait wait = new WebDriverWait(driver, 30);

        WebElement scrollArea = driver.findElement(By.cssSelector("#kt_aside_menu > div.ps__rail-y"));
        singletonConfig.scrollSideMenu(scrollArea ,20);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"kt_aside_menu\"]/ul/li[13]"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"menuCustomer\"]"))).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"btnAddCustomer\"]"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"select2-CustomerCategory-container\"]"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"select2-CustomerCategory-results\"]/li[text()='Credit']"))).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"CustomerName\"]"))).sendKeys(customerName);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"CustomerPhysicalAddress\"]"))).sendKeys("Capetown");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"CustomerPostalAddress\"]"))).sendKeys("999");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"CustomerTown\"]"))).sendKeys("CBD");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"select2-CustomerCountry-container\"]"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"select2-CustomerCountry-results\"]/li[text()='Kenya']"))).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"CustomerMobile\"]"))).sendKeys("254776709717");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"CustomerEmail\"]"))).sendKeys("qa.syhos.org");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"CustomerTerms\"]"))).sendKeys("....terms and conditions apply!");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"btnSaveCustomer\"]"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"tblCustomer_filter\"]/label/input"))).sendKeys(customerName);


    }

}
