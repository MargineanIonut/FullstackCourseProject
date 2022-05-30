package countries;

import lombok.RequiredArgsConstructor;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

@RequiredArgsConstructor
public class FileReportGenerator extends CountryReportGenerator{

    private final String sourceFile;
    @Override
    List<Country> readCountries() {
        try {
            return Files.lines(Path.of(sourceFile))
                    .map(this::toCountry)
                    .toList();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private Country toCountry(String line) {
        String[] tokens = line.split("\\|");
        return new Country(tokens[0],tokens[1]);
    }
}
