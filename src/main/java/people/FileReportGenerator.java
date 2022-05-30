package people;

import lombok.RequiredArgsConstructor;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class FileReportGenerator extends PeopleReportGenerator {

    private final String sourceFile;

    @Override
    List<People> readPeople() {
        try {
            return Files.lines(Path.of(sourceFile))
                    .map(this::toPeople)
                    .toList();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    private People toPeople(String line) {
        Object[] tokens = line.split(",");
        return new People((String) tokens[0], (String) tokens[1], Integer.valueOf((String) tokens[2]));
    }
}
