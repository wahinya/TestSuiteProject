
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestVendor {
    private SingletonConfig singletonConfig = SingletonConfig.getInstance();
    public  WebDriver driver = singletonConfig.getDriver();

    private TestLogin testLogin = new TestLogin();

    @BeforeTest(description = "access  the system before vendor testing script is fired")
    public void BeforeVendor(){
        testLogin.login();
    }
    @Test(priority=1, description = "adding a new vendor")
    public void addVendor() throws InterruptedException {

        Thread.sleep(40000);
        WebElement scrollArea2 = driver.findElement(By.cssSelector("#kt_aside_menu > div.ps__rail-y"));
        singletonConfig.scrollSideMenu(scrollArea2 ,30);

        WebDriverWait wait = new WebDriverWait(driver, 30);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"kt_aside_menu\"]/ul/li[14]"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"menuVendor\"]"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"btnAddVendor\"]"))).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"formVendor\"]/div[1]/div/span/span[1]/span"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"select2-VendorCategory-results\"]/li[text()='Suppliers']"))).click();

        String vendorName = "Kemsa Ltd";
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"VendorName\"]"))).sendKeys(vendorName);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"VendorPhysicalAddress\"]"))).sendKeys("Capetown");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"VendorPostalAddress\"]"))).sendKeys("999");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"VendorTown\"]"))).sendKeys("CBD");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"select2-VendorCountry-container\"]"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"select2-VendorCountry-results\"]/li[text()='Kenya']"))).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"VendorMobile\"]"))).sendKeys("254776709717");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"VendorEmail\"]"))).sendKeys("qa.syhos.org");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"btnSaveVendor\"]"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"tblVendor_filter\"]/label/input"))).sendKeys(vendorName);

    }
}
