package enquiryForm.actions;

import enquiryForm.navigation.EnquiryDetailsPage;
import enquiryForm.utils.FetchFieldSelectors;
import enquiryForm.utils.FetchFieldValues;
import enquiryForm.utils.FieldInteractions;
import net.serenitybdd.core.pages.WebElementFacade;
import org.json.simple.JSONObject;

import java.util.List;

public class FillEnquiryForm {
    FetchFieldSelectors fieldSelectors = new FetchFieldSelectors();

    public void fillSection(EnquiryDetailsPage detailsPage, String sectionKey) {
        List<List<String>> fields = fieldSelectors.getFields(sectionKey);
        JSONObject fieldValues = new FetchFieldValues().getFieldValues(sectionKey);

        for (List<String> row : fields) {
            String fieldName = row.get(0);
            String fieldPartialSelector = row.get(1);
            String fieldType = row.get(2);

            String elementSelector = fieldSelectors.getElementSelector(fieldPartialSelector, fieldType);
            WebElementFacade element = detailsPage.$(elementSelector);
            Object fieldValue = fieldValues.get(fieldName);
            if (fieldValue != null) {
                if (isLookUpField(fieldType)) {
                    element.type(fieldValue.toString());
                    //TODO - Ask the developer to change this code so that the <ul> can be viewed in dom to select
                } else if (isInputField(fieldType)) {
                    FieldInteractions.enterInputText(element, fieldValue.toString());
                } else if (isSelectField(fieldType)) {
                    FieldInteractions.selectByText(element, fieldValue.toString());
                } else if (isButtonField(fieldType) && (boolean) fieldValue == true) {
                    FieldInteractions.clickButton(element);
                }
            }
        }
    }

    private boolean isButtonField(String fieldType) {
        return fieldType.contains("button");
    }

    private boolean isSelectField(String fieldType) {
        return fieldType.contains("select");
    }

    private boolean isInputField(String fieldType) { return fieldType.contains("input"); }

    private boolean isLookUpField(String fieldType) {
        return fieldType.contains("input") && fieldType.contains("lookup");
    }
}
