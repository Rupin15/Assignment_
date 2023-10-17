import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class FileProcessing {
    public static void main(String[] args) {
        String filePath = "data.txt"; // Replace with the actual file path
        List<Integer> inputKeys = Arrays.asList(5, 10, 17, 23); // Replace with your desired input keys

        try {
            BufferedReader reader = new BufferedReader(new FileReader(filePath));
            String line;
            Map<String, Integer> concatenatedStringsCount = new HashMap<>();

            while ((line = reader.readLine()) != null) {
                String[] keyValuePairs = line.split(";");
                StringBuilder concatenatedValues = new StringBuilder();

                for (int key : inputKeys) {
                    for (String pair : keyValuePairs) {
                        String[] parts = pair.split("=");
                        int currentKey = Integer.parseInt(parts[0]);
                        String value = parts[1];
                        if (currentKey == key) {
                            concatenatedValues.append(value).append("|");
                        }
                    }
                }

                String concatenatedString = concatenatedValues.toString();
                if (!concatenatedString.isEmpty()) {
                    concatenatedString = concatenatedString.substring(0, concatenatedString.length() - 1); // Remove the
                                                                                                           // trailing
                                                                                                           // '|'
                    concatenatedStringsCount.put(concatenatedString,
                            concatenatedStringsCount.getOrDefault(concatenatedString, 0) + 1);
                    System.out.println("Concatenated String: " + concatenatedString);
                    System.out.println("Count: " + concatenatedStringsCount.get(concatenatedString));
                }
            }

            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
