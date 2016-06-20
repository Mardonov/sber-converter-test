package elements;

import org.openqa.selenium.*;

public class Input {

    public static WebElement inputFieldFromFlipperFromLabel(WebDriver driver, String flipperName, String labelName){
        return driver.findElement(By.xpath(Locator.findFlipper(flipperName) + "/" + Locator.findLabel(labelName) + "/" + Locator.findInputFromLabel));
    }

    public static WebElement getInputFieldFromFlipperFromLabel(WebDriver driver, String flipperName, String labelName){
        return driver.findElement(By.xpath(Locator.findFlipper(flipperName) + "/" + Locator.findLabel(labelName) + "/" + Locator.findInputFromLabel));
    }

}
