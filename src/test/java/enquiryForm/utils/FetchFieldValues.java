package enquiryForm.utils;

import org.json.simple.JSONObject;

public class FetchFieldValues {
    private final String aboutMeFieldsValueJSONFilePath = "src/test/resources/data/happy-path-field-values.json";

    public JSONObject getFieldValues(String key) {
        return LoadFile.getJSONObjects(aboutMeFieldsValueJSONFilePath, key);

    }

}
