package objects;

import elements.Dropdown;
import elements.Input;
import elements.Text;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import ru.yandex.qatools.allure.annotations.Step;

public class Converter extends Page{

    public Converter(WebDriver driver) {
        super(driver);
    }

    public WebElement fromDropdown = Dropdown.dropdownFromFlipperFromLabel(driver,"Конвертер валют","Поменять");
    public WebElement fromInput = Input.inputFieldFromFlipperFromLabel(driver,"Конвертер валют","Поменять");
    public WebElement toDropdown = Dropdown.dropdownFromFlipperFromLabel(driver,"Конвертер валют","На");
    public WebElement toInput = Input.inputFieldFromFlipperFromLabel(driver,"Конвертер валют","На");


    @Step("Выбор валюты {0} в списке валют для \"Поменять\".")
    public void setFromDropdown(String data){
        fromDropdown = Dropdown.dropdownFromFlipperFromLabel(driver,"Конвертер валют","Поменять");
        clickAndPick(fromDropdown,data);
    }

    @Step("Получение выбранной валюты списке валют для \"Поменять\".")
    public String getFromDropdown(){
        return fromDropdown.getText();
    }

    @Step("Ввод значения {0} в поле ввода для \"Поменять\".")
    public void setFromInput(String data){
        fromInput.sendKeys(data);
    }

    @Step("Получение значения из поле ввода для \"Поменять\".")
    public String getFromInput(){
        return fromInput.getAttribute("value");
    }

    @Step("Выбор валюты {0} в списке валют для \"На\".")
    public void setToDropdown(String data){
        toDropdown = Dropdown.dropdownFromFlipperFromLabel(driver,"Конвертер валют","На");
        clickAndPick(toDropdown,data);
    }

    @Step("Получение выбранной валюты списке валют для \"На\".")
    public String getToDropdown(){
        return toDropdown.getText();
    }

    @Step("Ввод значения {0} в поле ввода для \"На\".")
    public void setToInput(String data){
        toInput.sendKeys(data);
    }

    @Step("Получение значения из поле ввода для \"На\".")
    public String getToInput(){
        return toInput.getAttribute("value");
    }

    @Step("Получение наименования валюты для курса \"Поменять\".")
    public String getCurrencyRateFromName(){
        WebElement currencyRateFromName = Text.textByReactId(driver,".u.2.2");
        return currencyRateFromName.getText();
    }

    @Step("Получение значения валюты для курса \"Поменять\".")
    public String getCurrencyRateFromValue(){
        WebElement currencyRateFromValue = Text.textByReactId(driver,".u.2.0");
        return currencyRateFromValue.getText();
    }

    @Step("Получение значения валюты для курса \"На\".")
    public String getCurrencyRateToName(){
        WebElement currencyRateToName = Text.textByReactId(driver,".u.2.6");
        return currencyRateToName.getText();
    }


//    @Step("Получение значения валюты для курса \"На\".")
//    public String getCurrencyRateToValue(){
//        return Locator.findInputText();
//
//    }


    @Step("Получение значения валюты для курса \"На\".")

    public String getCurrencyRateToValue2(){
        WebElement currencyRateToValue = Text.textByReactId(driver,".u.2.4");
        return currencyRateToValue.getText();
    }
//        @Step("Получение значения валюты для курса \"На\".")
//        public String getCurrencyRateToValue(){
//        WebElement currencyRateToValue = Text.textByReactId(driver,".v.1.1.1.1");
//        return currencyRateToValue.getText();
//    }

    @Step("Проверка получени значения валюты для курса \"На\".")
    public static void getTestCurrencyRateToValue(String currency, String result){
//        System.out.println(" currency : " +currency);
        String currencyP = currency.replaceAll(" ", "");
//        System.out.println(" currencyP : " +currencyP);
        Double currencyDouble = Double.parseDouble(currencyP);
        currencyDouble*= 100;
//        System.out.println(" currencyDouble*100 : " +currencyDouble);
        String currencyStr = Double.toString(currencyDouble);
//        System.out.println(" currencyStr : " + currencyStr);
        String resultP = result.replaceAll(" ", "");
//        System.out.println(" resultP : " + resultP);
        String resultPP = resultP.replaceAll(".00", ".0");
//        System.out.println(" resultP : " + resultPP);
        Assert.assertEquals(currencyStr, resultPP);

    }

}
