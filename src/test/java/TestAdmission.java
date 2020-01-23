import org.openqa.selenium.WebDriver;

public class TestAdmission{
    private SingletonConfig singletonConfig = SingletonConfig.getInstance();
    public WebDriver driver = singletonConfig.getDriver();

    private TestLogin testLogin = new TestLogin();

    public void addDeposit(){
        testLogin.login();



    }
    public void wardAllocation(){

    }
    public void addBill(){

    }
    public void addNoted(){

    }


}
