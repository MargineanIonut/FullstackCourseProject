package people;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public abstract class PeopleReportGenerator {

    abstract List<People> readPeople();

    ReportCriteria reportCriteria = new ReportCriteria();

    public void generateReport(String outputFile) throws IOException {
        List<People> peopleList = readPeople();
        generateReport(peopleList, outputFile);
    }

    private void generateReport(List<People> peopleList, String outputFile) throws IOException {
        Map<String, List<PeopleWithAgeGroup>> map = new HashMap<>();
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {
            for (People people : peopleList) {
                map = reportCriteria.setAgeGroup(people).stream().collect(Collectors.groupingBy(PeopleWithAgeGroup::ageGroup));
            }
            for (Map.Entry<String, List<PeopleWithAgeGroup>> entry : map.entrySet()){
                writeLine(writer, entry.getKey() + entry.getValue());
            }
        }
    }

    private void writeLine(BufferedWriter writer, String line) {
        try {
            writer.write(line);
            writer.newLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}