import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;


public class TestRegisterBooking {
    private SingletonConfig singletonConfig = SingletonConfig.getInstance();
    private  WebDriver driver = singletonConfig.getDriver();
    private String firstName;
    private String surName;

    public TestRegisterBooking() {
    }

    public TestRegisterBooking(String firstName, String surName) {
        this.firstName = firstName;
        this.surName = surName;
    }



    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    private WebDriverWait wait;
    private TestLogin testLogin = new TestLogin();


    @Test(priority = 1)
    public void registerNewPatient() throws InterruptedException {
        //driver.manage().window().maximize();
        testLogin.login();

        WebDriverWait wait=new WebDriverWait(driver, 60);
        Thread.sleep(30000);
        WebElement sideMenu = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"kt_aside_menu\"]/ul/li[4]/a")));
        sideMenu.click();

        WebElement registrationModule = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"PatientRegistration\"]")));
        registrationModule.click();

        WebElement newPatientBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"btnNewPatient\"]")));
        newPatientBtn.click();

        WebElement title = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"select2-patientTitle-container\"]")));
        title.click();

        WebElement title1= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"select2-patientTitle-results\"]/li[text()='Ms.']")));
        title1.click();

        WebElement name= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"patientFirstName\"]")));
        name.sendKeys(firstName);

        WebElement middleName= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"patientMiddleName\"]")));
        middleName.sendKeys("Test");

        WebElement surName1=  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"patientLastName\"]")));
        surName1.sendKeys(surName);

        WebElement dob=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"patientDOB\"]")));
        dob.click();

        WebElement sex=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"patientSex\"]/option[2]")));
        sex.click();

        WebElement idType=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"select2-patientIdentificationType-container\"]")));
        idType.click();

        WebElement idType1=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"select2-patientIdentificationType-results\"]/li[text()='National ID']")));
        idType1.click();

        WebElement identification= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"patientIdentification\"]")));
        identification.sendKeys("200200");

        WebElement country= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"select2-patientCountry-container\"]")));
        country.click();

        WebElement country1= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"select2-patientCountry-results\"]/li[text()='Kenya']")));
        country1.click();

        WebElement residence= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"patientAddress\"]")));
        residence.sendKeys("Upper Hill");

        WebElement town= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"select2-patientArea-container\"]")));
        town.click();

        WebElement town1=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"select2-patientArea-results\"]/li[text()='Nairobi']")));
        town1.click();

        WebElement mobile= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"patientMobile\"]")));
        mobile.sendKeys("100100");

        WebElement religion=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"select2-patientReligion-container\"]")));
        religion.click();

        WebElement religion1=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"select2-patientReligion-results\"]/li[text()='Christian']")));
        religion1.click();

        WebElement occupation= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"patientOccupation\"]")));
        occupation.sendKeys("Student");

        WebElement employer=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"patientEmployer\"]")));
        employer.sendKeys("University of Nairobi");

        WebElement email= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"patientEmail\"]")));
        email.sendKeys("john@email.com");

        WebElement comment=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"patientComment\"]")));
        comment.sendKeys("VIP");

        // pause to allow explanation  of the registration form
        Thread.sleep(5000);

        WebElement savePatient= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"btnPatientSave\"]")));
        savePatient.click();

//        WebElement goBack = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"btnPatientCancel\"]")));
//        goBack.click();



    }
@Test(priority=2, description = "loading the add new wallet module")
   public void loadWallet() throws InterruptedException {
    WebDriverWait wait=new WebDriverWait(driver, 30);
    Thread.sleep(10000);

//    WebElement searchPatient = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"tblPatient_filter\"]/label/input")));
//    searchPatient.sendKeys(surName);
//    Thread.sleep(2000);
//
//    WebElement action = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"tblPatient\"]/tbody/tr/td[8]/div/button")));
//    action.click();
//
//    WebElement viewPatient = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"tblPatient\"]/tbody/tr/td[8]/div/div/a[1]")));
//    viewPatient.click();

    WebElement scrollTop= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"kt_scrolltop\"]")));
    scrollTop.click();
    Thread.sleep(2000);

    WebElement newWalletWrapper= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"divPatientBase\"]/div[1]/div[2]/div[1]/div[1]/div/ul/li[1]/a")));
    newWalletWrapper.click();

    WebElement newWallet = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"btnAddWallet\"]")));
    newWallet.click();
    Thread.sleep(2000);


    WebElement newCash = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"select2-walletCustomerCategory-container\"]")));
    newCash.click();
    Thread.sleep(1000);

    WebElement selectCash = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"select2-walletCustomerCategory-results\"]/li[1]")));
    selectCash.click();
    Thread.sleep(1000);

    WebElement submitCashWallet = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"btnSaveWallet\"]")));
    submitCashWallet.click();
    Thread.sleep(1000);

    WebElement bookCashWallet = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"tblWallet\"]/tbody/tr/td[2]/a")));
    bookCashWallet.click();
    Thread.sleep(2000);

    WebElement selectVisit = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"select2-walletBookVisitType-container\"]")));
    selectVisit.click();
    //*[@id="select2-walletBookVisitType-results"]/li
    WebElement selectVisit2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"select2-walletBookVisitType-results\"]/li/div/div/div[1]")));
    selectVisit2.click();
    Thread.sleep(3000);
    WebElement saveBooking = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"btnSaveWalletBook\"]")));
    saveBooking.click();

    Thread.sleep(3000);

}

    @Test(priority = 8, description="adding an optional bill e.g consultation")
    public void addBill() throws InterruptedException {
        wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"select2-WorkSpaceRequestProduct-container\"]"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/span/span/span[1]/input"))).sendKeys("Consultation");
            Thread.sleep(3000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"select2-WorkSpaceRequestProduct-results\"]/li[1]"))).click();
        Thread.sleep(5000);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"btnSaveRequestWorkSpace\"]"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"btnCancelRequestWorkSpace\"]"))).click();
    }
}

