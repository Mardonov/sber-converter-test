package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Text {

    public static WebElement textByReactId(WebDriver driver, String reactId){
        return driver.findElement(By.xpath(Locator.findElementByReactId(reactId)));
    }

}
