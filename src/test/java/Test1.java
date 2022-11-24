import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import utils.Driver;
import utils.DriverSingleton;

public class Test1 {

    WebDriver driver;


    @BeforeTest
    public void beforeTest(){
        driver= Driver.getDriver();
    }

    @Test
    @Parameters({"url"})
    public void test1(String url) {

        driver.get(url);
    }

    @AfterTest
    public void afterTest(){
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.quit();
    }


}


