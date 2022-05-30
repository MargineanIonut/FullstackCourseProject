package people;

import java.io.IOException;

public class PeopleMain {
    public static void main(String[] args) throws IOException {
 //   var inMemoryReportGenerator = new InMemoryReportGenerator();
    var generator = new FileReportGenerator("src/main/resources/people.txt");
    generator.generateReport("outputPeople.txt");
//    inMemoryReportGenerator.generateReport("inMemPeople.txt");
    }
}
