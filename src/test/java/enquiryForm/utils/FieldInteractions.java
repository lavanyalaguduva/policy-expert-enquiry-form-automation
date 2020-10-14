package enquiryForm.utils;

import net.serenitybdd.core.pages.WebElementFacade;

public class FieldInteractions {
    public static void enterInputText(WebElementFacade element, String fieldValue){
        element.type(fieldValue);
    }

    public static void selectByText(WebElementFacade element, String fieldValue) {
        element.selectByVisibleText(fieldValue);
    }

    public static void clickButton(WebElementFacade element) {
        element.click();

    }
}
