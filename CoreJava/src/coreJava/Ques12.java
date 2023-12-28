package coreJava;

import java.io.*;

/**
 * This program demonstrates reading content from a file, processing it, and writing the processed content to a new file.
 */
public class Ques12 {

    public static void main(String[] args) {
        // Specify the file paths
        String inputFilePath = "input.txt";
        String outputFilePath = "output.txt";

        // Read from a file
        String fileContent = readFile(inputFilePath);

        // Process the data (e.g., convert to uppercase)
        String processedContent = processContent(fileContent);

        // Write to a new file
        writeFile(outputFilePath, processedContent);
    }

    /**
     * Reads content from a file.
     *
     * @param filePath The path of the file to read.
     * @return The content read from the file.
     */
    private static String readFile(String filePath) {
        StringBuilder content = new StringBuilder();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line).append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return content.toString();
    }

    /**
     * Processes the content (e.g., converts to uppercase).
     *
     * @param content The content to process.
     * @return The processed content.
     */
    private static String processContent(String content) {
        // In this example, let's convert the content to uppercase
        return content.toUpperCase();
    }

    /**
     * Writes content to a file.
     *
     * @param filePath The path of the file to write.
     * @param content  The content to write to the file.
     */
    private static void writeFile(String filePath, String content) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write(content);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
