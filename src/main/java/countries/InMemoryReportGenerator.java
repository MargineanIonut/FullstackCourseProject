package countries;

import java.util.List;

public class InMemoryReportGenerator extends CountryReportGenerator {
    @Override
    List<Country> readCountries() {
        return List.of(
                new Country("Romania", "Bucharest"),
                new Country("Ungaria", "Budapest"),
                new Country("Ucraina", "Kiev"),
                new Country("USA", "Washington")
        );
    }
}
