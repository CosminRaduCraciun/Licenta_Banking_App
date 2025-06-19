package reports;


import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;

import java.io.File;
import java.util.Collections;
import java.util.List;
public class GenerateCucumberReport {
    public static void main(String[] args) {
        File reportOutputDirectory = new File("target/cucumber-html-reports");
        List<String> jsonFiles = Collections.singletonList("target/cucumber.json");

        Configuration config = new Configuration(reportOutputDirectory, "My Automation Project");
        config.setBuildNumber("1");
        config.addClassifications("Platform", System.getProperty("os.name"));
        config.addClassifications("Browser", "Chrome");
        config.addClassifications("Branch", "main");
        config.addClassifications("Date of Run", "2025-04-15 11:25:07");

        ReportBuilder reportBuilder = new ReportBuilder(jsonFiles, config);
        reportBuilder.generateReports();
    }
}
