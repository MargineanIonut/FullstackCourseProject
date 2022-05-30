package people;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReportCriteria {
    List<PeopleWithAgeGroup> ppl = new ArrayList<>();

    public List<PeopleWithAgeGroup> setAgeGroup(People people) {
        Map<String, List<Integer>> dinamicAgeGroup = getStringListMap();

        for (Map.Entry<String, List<Integer>> entry : dinamicAgeGroup.entrySet()) {
            if (people.age() >= entry.getValue().get(0) && people.age() <= entry.getValue().get(1)) {
                ppl.add(new PeopleWithAgeGroup(people.firstName(), people.lastName(), people.age(), entry.getKey()));
            }
        }
        return ppl;
    }

    private Map<String, List<Integer>> getStringListMap() {
        Map<String, List<Integer>> dinamicAgeGroup = new HashMap<>();
        dinamicAgeGroup.put("0-10", List.of(0, 10));
        dinamicAgeGroup.put("10-20", List.of(10, 20));
        dinamicAgeGroup.put("20-30", List.of(20, 30));
        dinamicAgeGroup.put("30-40", List.of(30, 40));
        dinamicAgeGroup.put("40-50", List.of(40, 50));
        dinamicAgeGroup.put("50+", List.of(50, 90));
        return dinamicAgeGroup;
    }

}
