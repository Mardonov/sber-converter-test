package objects;

import elements.Locator;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class Page {

    protected WebDriver driver;

    public Page(WebDriver driver){
        this.driver = driver;
    }

    public void scrollIntoElement(WebElement element){
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
    }

    public void explicitWaitElement (WebDriver driver, WebElement element){
        WebDriverWait wait = new WebDriverWait(driver, 7);
        wait.until(ExpectedConditions.visibilityOf(element));
    }


    public void clickAndPick(WebElement element, String name){
        //scrollIntoElement(element);
        //System.out.println(element.getAttribute("id"));
        //Thread.sleep(10000);

        element.click();
        // Thread.sleep(10000);
        explicitWaitElement(driver, driver.findElement(By.xpath(Locator.findDropdownList + "/" + Locator.findDropdownElement(name))));
        driver.findElement(By.xpath(Locator.findDropdownList + "/" + Locator.findDropdownElement(name))).click();
    }
}
