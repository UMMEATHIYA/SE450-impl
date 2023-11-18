package org.example.csv;

import com.opencsv.CSVWriter;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class CSVHandler {
    public static void writeResultsToCsv(String filePath, String[] header, List<String[]> data) {
        try (CSVWriter csvWriter = new CSVWriter(new FileWriter(filePath))) {
            // Write the header to the CSV file
            csvWriter.writeNext(header);

            // Write all data rows to the CSV file
            csvWriter.writeAll(data);
        } catch (IOException e) {
            // Handle the exception more gracefully, e.g., log the error
            e.printStackTrace();
        }
    }
}
