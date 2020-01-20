import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestDoctorTreatment {
    SingletonConfig singletonConfig = SingletonConfig.getInstance();
    public WebDriver driver = singletonConfig.getDriver();

    TestRegisterBooking testRegisterBooking= new TestRegisterBooking();
    TestCashReceipts testCashReceipts = new TestCashReceipts();

    @Test(priority= 1, description = "access  the system before vendor testing script is fired")
    public void LoadPatient() throws InterruptedException {

        driver.manage().window().maximize();
        testRegisterBooking.setFirstName("Tuesday");
        testRegisterBooking.setSurName("Drake21");
        testRegisterBooking.registerNewPatient();
        testRegisterBooking.loadWallet();
        testRegisterBooking.addBill();

        Thread.sleep(5000);

        WebDriverWait wait=new WebDriverWait(driver, 30);

        WebElement doctorTreatmentModule = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"menuTreatment\"]")));
        doctorTreatmentModule.click();
        Thread.sleep(2000);

        WebElement searchPatient= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"tblTreatmentQueue_filter\"]/label/input")));
        searchPatient.sendKeys(testRegisterBooking.getSurName());
        Thread.sleep(2000);

        }
        @Test(priority=2, description = "loading the patient history and visit summary")
        public void loadPatientHistory(){
            WebDriverWait wait=new WebDriverWait(driver, 30);

            WebElement action = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(" //*[@id=\"tblTreatmentQueue\"]/tbody/tr/td[2]/a")));
            action.click();

            WebElement claimPatient = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(" /html/body/div[6]/div/div[3]/button[2]")));
            claimPatient.click();

        }

        @Test(priority = 3, description = "add one or more medical conditions e.g Cataract, congenital condition, chronic disease etc.")
        public void addMedicalCondition() throws InterruptedException {
        WebDriverWait wait=new WebDriverWait(driver, 30);

            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"btnAddMedicalCondition\"]"))).click();
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"formMedicalConditionVisit\"]/div[1]/span[2]/span[1]/span"))).click();
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"select2-MedicalConditionAddName-results\"]/li[1]"))).click();
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"MedicalConditionAddRemarks\"]"))).sendKeys("Asthmatic since 1990; Alergic to penicillin");
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"btnSaveMedicalCondition\"]"))).click();
            WebElement scrollTop= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"kt_scrolltop\"]")));
            scrollTop.click();
            Thread.sleep(2000);
    }
    @Test(priority = 4, description = "doctors type notes or use a preset template")
    public void addNotes() throws InterruptedException {

        WebDriverWait wait=new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"divTreatmentBase\"]/div[2]/div[1]/div[1]/ul/li[3]/a"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"btnAddNotes\"]"))).click();
        Thread.sleep(5000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("@id=PatientNote"))).sendKeys("Notes goes here.....");
//*[@id="cke_117_contents"]/iframe
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"btnSaveNotesAdd\"]"))).click();
        Thread.sleep(5000);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[7]/div/div[3]/button[2]"))).click();


        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"btnCancelNotes\"]"))).click();
    }
    public void addInvestigation() throws InterruptedException {
        WebDriverWait wait=new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"divTreatmentBase\"]/div[2]/div[1]/div[1]/ul/li[4]/a"))).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"select2-InvestigationAddProduct-container\"]"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/span/span/span[1]/input"))).sendKeys("Albumin");
        Thread.sleep(1000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"select2-InvestigationAddProduct-results\"]/li[1]"))).click();
        Thread.sleep(1000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"InvestigationAddRemarks\"]"))).sendKeys("STAT");
        Thread.sleep(1000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"btnSaveInvestigation\"]"))).click();
    }
    @Test(priority = 6,description = "a doctor read results")
    public void readResults(){
        WebDriverWait wait=new WebDriverWait(driver, 30);


    }
    @Test(priority = 7,description = "")
    public void addDiagnosis(){
        WebDriverWait wait=new WebDriverWait(driver, 30);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"divTreatmentBase\"]/div[2]/div[1]/div[1]/ul/li[6]/a"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(" //*[@id=\"btnAddDiagnosis\"]"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"select2-DiagnosisDisease-container\"]"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"select2-DiagnosisDisease-results\"]/li[text()='Malaria']"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"btnSaveDiagnosisAdd\"]"))).click();
    }

}
