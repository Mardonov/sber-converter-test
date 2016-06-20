package tests;

import objects.Converter;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Description;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Stories;

public class Test1 extends TestNGBase{

    @Features("USD to RUB")
    @Stories("Проверка")
    @Description("Выполняется проверка работы")
    @Test(priority = 1)
    public void test1() throws Exception {
        Converter converter = new Converter(driver);
        converter.fromInput.sendKeys("100");
        converter.setFromDropdown("USD");
        converter.setToDropdown("RUB");
        System.out.println(" value : " + converter.toInput.getAttribute("value"));
        System.out.println(" converter.getCurrencyRateToValue2() : " + converter.getCurrencyRateToValue2());
        converter.getTestCurrencyRateToValue(converter.getCurrencyRateToValue2(), converter.toInput.getAttribute("value"));

    }

    @Features("RUB to USD")
    @Stories("Проверка 2")
    @Description("Выполняется проверка работы 2")
    @Test(priority = 2)
    public void test2() throws Exception {

        Converter converter2 = new Converter(driver);
        converter2.fromInput.clear();
        converter2.fromInput.sendKeys("100");
        converter2.setFromDropdown("RUB");
        converter2.setToDropdown("USD");

//        System.out.println(" toInput.getAttribute(\"value\") = "+converter2.toInput.getAttribute("value"));
//        System.out.println(" getCurrencyRateToValue2() " + converter2.getCurrencyRateToValue2());
        converter2.getTestCurrencyRateToValue(converter2.getCurrencyRateToValue2(), converter2.toInput.getAttribute("value"));
//        Assert.assertEquals(converter2.toInput.getAttribute("value"), "1.47");

    }

    @Features("RUB to EUR")
    @Stories("Проверка 3")
    @Description("Выполняется проверка работы 3")
    @Test(priority = 3)
    public void test3() throws Exception {

        Converter converter3 = new Converter(driver);
        converter3.fromInput.clear();
        converter3.fromInput.sendKeys("100");
        converter3.setFromDropdown("RUB");
        converter3.setToDropdown("EUR");
//      Assert.assertEquals(converter3.toInput.getAttribute("value"), "1.31");
        converter3.getTestCurrencyRateToValue(converter3.getCurrencyRateToValue2(), converter3.toInput.getAttribute("value"));
//      System.out.println(converter3.toInput.getAttribute("value"));
//      System.out.println(" ---- " + converter3.getCurrencyRateToValue2());
    }
}

