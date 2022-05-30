package people;

import java.util.List;

public class InMemoryReportGenerator extends PeopleReportGenerator {
    @Override
    List<People> readPeople() {
        return List.of(
                new People("Ionut", "Marginean", 23),
                new People("Andrei", "Selegean", 33),
                new People("Alex", "Adrian", 43),
                new People("Paul", "Razvan", 12)
        );
    }
}
