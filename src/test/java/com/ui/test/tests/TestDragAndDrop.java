package com.ui.test.tests;

import com.ui.test.utilities.ScreenShotOnFailure;
import com.ui.test.utilities.TestBase;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.html5.Location;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(ScreenShotOnFailure.class)
@DisplayName("Passing Tests")
public class TestDragAndDrop extends TestBase {

    @Test
    public void testDragAndDrop(){
        //goto web page with draggable elements
        driver.get("http://the-internet.herokuapp.com/drag_and_drop");

        //get elements for moving
        WebElement source = driver.findElementByXPath("//header[contains(text(), 'A')]");
        WebElement destination = driver.findElementByXPath("//header[contains(text(), 'B')]");

        //determine destination target location
        Point locationDestination = destination.getLocation();

        //attempt 1:
        new Actions(driver)
                .moveToElement(source)
                .pause(Duration.ofSeconds(1))
                .clickAndHold(source)
                .pause(Duration.ofSeconds(1))
                .moveByOffset(1, 0)
                .moveToElement(destination)
                .moveByOffset(1, 0)
                .pause(Duration.ofSeconds(1))
                .release().perform();


        //attempt 2:
        /*
        Actions actions = new Actions(driver);
        actions.dragAndDrop(source, destination).perform();
        */

        //prevent stale element exception
        source = driver.findElementByXPath("//header[contains(text(), 'A')]");

        //get actual location after move
        Point locationAfter = source.getLocation();

        //log out location
        System.out.println("After: " + locationAfter);

        //Fail if not moved
        assertEquals(locationDestination, locationAfter);

    }
}
