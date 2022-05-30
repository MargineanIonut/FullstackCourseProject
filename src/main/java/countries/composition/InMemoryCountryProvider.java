package countries.composition;

import countries.Country;

import java.util.List;

public class InMemoryCountryProvider implements CountryProvider {
    @Override
    public List<Country> readCountries() {
        return List.of(
                new Country("Romania", "Bucharest"),
                new Country("Ungaria", "Budapest"),
                new Country("Ucraina", "Kiev"),
                new Country("USA", "Washington")
        );
    }
}
