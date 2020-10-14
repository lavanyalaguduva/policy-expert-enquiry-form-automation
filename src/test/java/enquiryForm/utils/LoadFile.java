package enquiryForm.utils;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LoadFile {

    public static List<List<String>> getCSVRecords(String filePath) {
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(filePath));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        List<List<String>> rows = br.lines()
                .skip(1) // skip headers
                .map(line -> Arrays.asList(line.split(",")))
                .collect(Collectors.toList());
        return rows;
    }

    public static JSONObject getJSONObjects(String filePath, String key) {
        JSONObject section = null;
        try {
            Object obj = new JSONParser().parse(new FileReader(filePath));
            JSONObject jsonObject = (JSONObject) obj;
            section = (JSONObject) jsonObject.get(key);
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
        return section;
    }

}
