package dataloader;


import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Simple Class that parses data set from a json file
 * without knowing the file's format
 * & prints out the key value pairs.
 */


public class JsonDataLoader {

    public void parseFile(String jsonFile) throws IOException {

        File json = new File(jsonFile);
        HashMap<String, Object> dataset = new HashMap();

        JsonFactory factory = new JsonFactory();
        ObjectMapper mapper = new ObjectMapper(factory);
        JsonNode rootNode = mapper.readTree(json);

        Iterator<Map.Entry<String, JsonNode>> fieldsIterator = rootNode.fields();
        while (fieldsIterator.hasNext()) {
            Map.Entry<String, JsonNode> field = fieldsIterator.next();
            dataset.put(field.getKey(), field.getValue());

            System.out.println(dataset);
            System.out.println("Key: " + field.getKey() + "\tValue: " + field.getValue());
        }
    }
}
