import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import utils.DriverSingleton;

public class Test1 {

    WebDriver driver;


    @Test
    public void test1(){

        driver= DriverSingleton.getDriver();
        driver.get("https://google.com");
        driver.quit();
    }
}
