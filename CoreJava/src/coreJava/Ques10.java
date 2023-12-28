package coreJava;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

/**
 * This program demonstrates reading data from an XML file using Java's DOM (Document Object Model) approach.
 * It parses an XML file, extracts information about a user, including name, age, address, and skills.
 */
public class Ques10 {

    /**
     * The main method where the program execution begins.
     *
     * @param args Command-line arguments (not used in this program)
     */
    public static void main(String[] args) {
        // Specify the path to your XML file
        String xmlFilePath = "/Users/aswinmm/new/CoreJava/src/coreJava/example.xml";

        try {
            // Create a DocumentBuilder
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();

            // Parse the XML file
            Document document = builder.parse(new File(xmlFilePath));

            // Accessing data from the XML file
            Element userElement = document.getDocumentElement();
            String name = getTextContent(userElement, "name");
            int age = Integer.parseInt(getTextContent(userElement, "age"));

            System.out.println("Name: " + name);
            System.out.println("Age: " + age);

            Element addressElement = (Element) userElement.getElementsByTagName("address").item(0);
            String city = getTextContent(addressElement, "city");
            String country = getTextContent(addressElement, "country");

            System.out.println("City: " + city);
            System.out.println("Country: " + country);

            NodeList skillsNodeList = userElement.getElementsByTagName("skill");
            System.out.print("Skills: ");
            for (int i = 0; i < skillsNodeList.getLength(); i++) {
                Element skillElement = (Element) skillsNodeList.item(i);
                String skill = skillElement.getTextContent();
                System.out.print(skill + " ");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Retrieves the text content of a child element with the specified tag name from a parent element.
     *
     * @param parentElement The parent element containing the child element
     * @param childTagName  The tag name of the child element
     * @return The text content of the child element, or null if not found
     */
    private static String getTextContent(Element parentElement, String childTagName) {
        NodeList nodeList = parentElement.getElementsByTagName(childTagName);
        if (nodeList.getLength() > 0) {
            return nodeList.item(0).getTextContent();
        } else {
            return null;
        }
    }
}
