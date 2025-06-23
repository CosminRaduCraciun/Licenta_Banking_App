package reports;


import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;
import org.joda.time.DateTime;

import java.io.File;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Collections;
import java.util.List;



public class GenerateCucumberReport {
    public static void main(String[] args) {
        File reportOutputDirectory = new File("target/cucumber-html-reports");
        List<String> jsonFiles = Collections.singletonList("target/cucumber.json");
        String dateOfRun = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        Configuration config = new Configuration(reportOutputDirectory, "My Automation Project");
        config.addClassifications("Platform", System.getProperty("os.name"));
        config.addClassifications("Browser", ConfigReader.getBrowser());
        config.addClassifications("Branch", "main");
        config.addClassifications("Date of Run", dateOfRun);

        ReportBuilder reportBuilder = new ReportBuilder(jsonFiles, config);
        reportBuilder.generateReports();
    }
}
