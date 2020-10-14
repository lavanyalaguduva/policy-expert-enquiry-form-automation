package enquiryForm.utils;

import java.util.ArrayList;
import java.util.List;

public class FetchFieldSelectors {
    private final String pattern = "[class*='" + "<field-selector>" + "']" + " <fieldType>";
    private final String aboutMeCsvFilePath = "src/test/resources/data/about-me-field-selectors.csv";
    private final String aboutPropertyCsvFilePath = "src/test/resources/data/about-property-field-selectors.csv";
    private final List<List<String>> records = new ArrayList<>();

    public List<List<String>> getFields(String key) {
        switch(key){
            case "about me":
                return LoadFile.getCSVRecords(aboutMeCsvFilePath);
            case "about property":
                return LoadFile.getCSVRecords(aboutPropertyCsvFilePath);
        }
        return null;
    }

    public String getElementSelector(String fieldSelector, String fieldType) {
        return pattern.replace("<field-selector>", fieldSelector)
                .replace("<fieldType>", fieldType);
    }
}
