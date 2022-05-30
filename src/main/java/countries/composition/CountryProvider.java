package countries.composition;

import countries.Country;

import java.util.List;

public interface CountryProvider {
    List<Country> readCountries();
}

