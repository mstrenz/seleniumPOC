package Pages;

import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;

import static Utilities.TestBase.driver;

public class GooglePage {

    public GooglePage(RemoteWebDriver driver){
        PageFactory.initElements(driver, this);
    }

    public void goTo(){
        driver.get("https://www.google.com");
    }
}
