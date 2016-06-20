package elements;


public class Locator {


    public static String findElementByReactId(String input){
        return ".//div[@class='currency-converter-result']/span[@data-reactid='" + input+ "']";
                 //*[@data-reactid='.u.2.2']
                 // .//div//span[@data-reactid='.v.2.4']
        // --  .//div[@class="currency-converter-result"]/span[@data-reactid='.u.2.4']
        //  ".//div//span[@data-reactid='" + input+ "']";
    }

    public static String findFlipper(String input) {
        return ".//*[contains(text(),'" + input + "')]/ancestor::div[@class='flipper']";
    }
    //1 .//*[text()=@data-reactid='.v.2.4']
    public static String findInputText(){ return ".//*[@data-reactid='.v.2.4']";}

    public static String findLabel(String input) {
        return ".//label[text()='" + input + "']";
    }

    public static String findInputFromLabel = "following-sibling::div/descendant::input[contains(@class,'form_input_text')]";

    public static String findDropdownFromLabel = "following-sibling::div/descendant::span[contains(@class,'chosen')]";

    public static String findDropdownList = ".//div[@id='select2-drop' and not(contains(@style,'display: none'))]";

    public static String findDropdownElement(String input) {
        return ".//li/div[text()='" + input + "']";
    }



}
