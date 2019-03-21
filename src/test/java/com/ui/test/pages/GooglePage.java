package com.ui.test.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static com.ui.test.utilities.TestBase.driver;

public class GooglePage {

    @FindBy(css= "input[name='q']")
    private WebElement searchInput = null;

    public GooglePage(RemoteWebDriver driver){
        PageFactory.initElements(driver, this);
    }

    public void goTo(){
        driver.get("https://www.google.com");
    }

    public WebElement getSearchInput() {
        return searchInput;
    }
}
