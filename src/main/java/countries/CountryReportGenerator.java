package countries;

import java.io.BufferedWriter;
import java.io.FileDescriptor;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public abstract class CountryReportGenerator {

    abstract List<Country> readCountries();

    public void generateReport(String outputFile) throws IOException {
        List<Country> countries = readCountries();
        generateReport(countries, outputFile);
    }

    private void generateReport(List<Country> countries, String outputFile) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {
            countries.stream()
                    .map(country -> country.name() + " : " + country.capital())
                    .forEach(line -> writeLine(writer, line));
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
