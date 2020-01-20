import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class SingletonConfig {

    private static SingletonConfig singletonConfig = null;

    public static WebDriver driver = new ChromeDriver();
    public static Actions drag;

    public SingletonConfig(){
        System.setProperty("webdriver.chrome.driver","chromedriver");
        String baseUrl = "https://qa.integral.syhos.org";
        driver.get(baseUrl);
    }

    public WebDriver getDriver(){
        return  driver;
    }

    public static SingletonConfig getInstance(){

        if(singletonConfig == null)
            singletonConfig =new SingletonConfig();
        return singletonConfig;
    }

    public boolean scrollSideMenu(WebElement webelement, int scrollPoints) {
        try
        {
            System.out.println("---------------- Started - scroll_Page ----------------");
            drag = new Actions(driver);

            // drag downwards
            int numberOfPixelsToDragTheScrollbarDown = 10;
            for (int i = 10; i < scrollPoints; i = i + numberOfPixelsToDragTheScrollbarDown)
            {
                drag.moveToElement(webelement).clickAndHold().moveByOffset(0,
                        numberOfPixelsToDragTheScrollbarDown).release(webelement).build().perform();
            }
            Thread.sleep(500);
            System.out.println("---------------- scrolling down to vendors module link ----------------");
            return true;
        }
        catch (Exception e)
        {
            System.out.println("---------------- scroll is not successful ----- -----------");
            e.printStackTrace();
            return false;
        }

    }


}
