import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.chrome.ChromeOptions;
import java.net.URL;
 
class RemoteTest {
 
  public static void main(String[] args) throws Exception {
    // Change this to match the location of your server
    URL server = new URL("http://127.0.0.1:4444/wd/hub");
    final ChromeOptions chromeOptions = new ChromeOptions();
    chromeOptions.addArguments("--headless");
 
    DesiredCapabilities capabilities = new DesiredCapabilities();
    capabilities.setBrowserName("chrome");
    capabilities.setCapability(ChromeOptions.CAPABILITY, chromeOptions);
 
    System.out.println("Connecting to " + server);
 
    WebDriver driver = new RemoteWebDriver(server, capabilities);
 
    driver.get("http://www.google.com");

Thread.sleep(1000);
 
                if (driver.getPageSource().contains("I'm Feeling Lucky")) {
                        System.out.println("Pass");
                } else {
                        System.out.println("Fail");
                }
 
    driver.quit();
  }
}
