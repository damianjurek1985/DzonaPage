import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SimplyTest {

    WebDriver driver = new ChromeDriver();

    @Test
    public void startWebDriver() throws InterruptedException {
        driver.navigate().to("http://google.pl");

        driver.close();
        driver.quit();
    }

}


