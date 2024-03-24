package util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

@Component
public class DataBootstrap {

    private final String csvFilePath;

    public DataBootstrap(@Value("${data.bootstrap.csv.file}") String csvFilePath) {
        this.csvFilePath = csvFilePath;
    }

    public List<String[]> loadDataFromCSV() {
        List<String[]> data = new ArrayList<>();

        // Load CSV file from resources
        try (InputStream inputStream = getClass().getResourceAsStream(csvFilePath);
             BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] values = line.split(",");
                data.add(values);
            }
        } catch (IOException e) {
            // Handle IOException
            e.printStackTrace();
        }

        return data;
    }
}
