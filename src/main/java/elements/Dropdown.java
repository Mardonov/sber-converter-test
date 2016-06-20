package elements;

import org.openqa.selenium.*;

public class Dropdown {

    public static WebElement dropdownFromFlipperFromLabel(WebDriver driver, String flipperName, String labelName){
        return driver.findElement(By.xpath(Locator.findFlipper(flipperName) + "/" + Locator.findLabel(labelName) + "/" + Locator.findDropdownFromLabel));
    }

    public static WebElement dropdownListElement(WebDriver driver, String elementName){
        return driver.findElement(By.xpath(Locator.findDropdownList + "/" + Locator.findDropdownElement(elementName)));
    }

}
