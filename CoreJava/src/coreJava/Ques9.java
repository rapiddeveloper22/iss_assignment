package coreJava;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class Ques9 {
    public static void main(String[] args) {
        // Specify the path to your JSON file
        String jsonFilePath = "/Users/aswinmm/new/CoreJava/src/coreJava/example.json";

        try {
            // Create an ObjectMapper instance
            ObjectMapper objectMapper = new ObjectMapper();

            // Read JSON file into JsonNode
            JsonNode jsonNode = objectMapper.readTree(new File(jsonFilePath));

            // Accessing data from the JSON file
            String name = jsonNode.get("name").asText();
            int age = jsonNode.get("age").asInt();

            System.out.println("Name: " + name);
            System.out.println("Age: " + age);

            // Accessing nested objects or arrays
            JsonNode addressNode = jsonNode.get("address");
            String city = addressNode.get("city").asText();
            String country = addressNode.get("country").asText();

            System.out.println("City: " + city);
            System.out.println("Country: " + country);

            // Accessing an array
            JsonNode skillsNode = jsonNode.get("skills");
            System.out.print("Skills: ");
            for (JsonNode skill : skillsNode) {
                System.out.print(skill.asText() + " ");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
