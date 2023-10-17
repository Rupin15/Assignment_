import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class GenerateDataFile {
    public static void main(String[] args) {
        String outputPath = "data.txt";
        int numLines = 1000000; // Change this number to generate as many lines as needed

        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(outputPath));

            for (int i = 0; i < numLines; i++) {
                String line = generateRandomLine();
                writer.write(line);
                writer.newLine();
            }

            writer.close();
            System.out.println("Generated " + numLines + " lines of random data in " + outputPath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String generateRandomLine() {
        StringBuilder line = new StringBuilder();
        Random random = new Random();

        int numKeyValues = random.nextInt(5) + 1; // Randomly choose 1 to 5 key-value pairs
        for (int j = 0; j < numKeyValues; j++) {
            int key = random.nextInt(50) + 1; // Random key between 1 and 50
            String value = generateRandomValue();
            line.append(key).append('=').append(value);

            if (j < numKeyValues - 1) {
                line.append(';');
            }
        }

        return line.toString();
    }

    private static String generateRandomValue() {
        int length = 5 + new Random().nextInt(10); // Random value length between 5 and 15 characters
        StringBuilder value = new StringBuilder();

        for (int i = 0; i < length; i++) {
            char randomChar = (char) (97 + new Random().nextInt(26)); // Random lowercase letter
            value.append(randomChar);
        }

        return value.toString();
    }
}