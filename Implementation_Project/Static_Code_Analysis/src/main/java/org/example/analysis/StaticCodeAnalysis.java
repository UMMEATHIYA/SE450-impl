package org.example.analysis;

import net.sourceforge.pmd.PMD;
import net.sourceforge.pmd.PMDConfiguration;
import net.sourceforge.pmd.renderers.CSVRenderer;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class StaticCodeAnalysis {
    public static List<String[]> analyzeAndGetResults(String sourceDirectory, String rulesetFilePath) {
        PMDConfiguration pmdConfiguration = new PMDConfiguration();
        pmdConfiguration.setInputPaths(sourceDirectory);
        pmdConfiguration.setRuleSets(rulesetFilePath);

        List<String[]> pmdResults = new ArrayList<>();

        try {
            // Create a StringWriter to capture the CSV output from PMD
            try (FileWriter stringWriter = new FileWriter("pmd_results.csv")) {
                CSVRenderer csvRenderer = new CSVRenderer();
                csvRenderer.setWriter(stringWriter);

                // Set the renderer for PMD to capture the results
                pmdConfiguration.getReportFile();

                // Perform static code analysis using PMD
                PMD.doPMD(pmdConfiguration);

                // Now, the CSV results are captured in the pmd_results.csv file

                // Optionally, you can read the captured CSV file and parse it into a list
                // For simplicity, let's assume that each line in the CSV file is a separate result
                // You may need to adjust this based on the actual structure of your CSV file

                // Read the captured CSV file
                // Process each line and add it to the pmdResults list
                // Adjust the logic based on the structure of your CSV file

                // Example:
                // Files.readAllLines(Paths.get("pmd_results.csv")).forEach(line -> {
                //    pmdResults.add(line.split(","));
                // });

            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return pmdResults;
    }
}
