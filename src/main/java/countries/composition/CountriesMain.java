package countries.composition;

import java.io.IOException;

public class CountriesMain {
    public static void main(String[] args) throws IOException {
        new CountryReportGenerator(getCountryProvider()).generateReport("output-composition.txt");
    }

    private static CountryProvider getCountryProvider() {
        return System.currentTimeMillis()%2==0
                ? new InMemoryCountryProvider()
                :new FileCountryProvider("src/main/resources/countries.txt");
    }
}
