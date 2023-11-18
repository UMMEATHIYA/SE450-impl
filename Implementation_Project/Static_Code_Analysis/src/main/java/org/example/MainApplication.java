package org.example;

import org.eclipse.jgit.api.errors.GitAPIException;
import org.example.analysis.StaticCodeAnalysis;
import org.example.csv.CSVHandler;
import org.example.git.GitHandler;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;



public class MainApplication {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the GitHub repository URL: ");
        String repositoryUrl = scanner.nextLine();

        System.out.print("Enter the local path to clone the repository: ");
        String localPath = scanner.nextLine();

        //System.out.print("Enter the path to the PMD ruleset file: ");
        String rulesetFilePath = "C:\\Users\\ummea\\OneDrive\\Documents\\Wahid-OOPs\\Implementation_Project\\Static_Code_Analysis\\custom-ruleset.xml";  // Add this line to get the ruleset file path

        // Path for PMD report file
        String pmdReportFilePath = "pmd_results.csv";

        try {
            // Clone GitHub repository
            GitHandler.cloneRepository(repositoryUrl, localPath);

            // Run PMD analysis and generate CSV report
            List<String[]> pmdResults = StaticCodeAnalysis.analyzeAndGetResults(localPath + "/src", rulesetFilePath);

            // Optionally, write PMD results to a CSV file
            CSVHandler.writeResultsToCsv(pmdReportFilePath, new String[]{"File", "Line", "Rule", "Description"}, pmdResults);
            System.out.println("PMD results written to CSV file successfully.");

            // Example: Count commits


            // Example data for the final CSV
            String[] header = {"Column1", "Column2", "Column3"};
            List<String[]> data = Arrays.asList(
                    new String[]{"Value1", "Value2", "Value3"},
                    new String[]{"Value4", "Value5", "Value6"}
                    // Add more rows as needed
            );

            // Write the final CSV file
            CSVHandler.writeResultsToCsv(pmdReportFilePath, header, data);
            System.out.println("Final CSV file written successfully.");

        } catch (GitAPIException e) {
            throw new RuntimeException(e);
        }
    }
}
