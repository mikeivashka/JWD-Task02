package by.tc.task01.entity.criteria;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SearchCriteriaFactory {
    private SearchCriteriaFactory() {
    }

    public static List<Enum> getAllowedValues(String criteriaTitle) {
        switch (criteriaTitle.toLowerCase()) {
            case "oven":
                return Arrays.asList(SearchCriteria.Oven.values());
            case "laptop":
                return Arrays.asList(SearchCriteria.Laptop.values());
            case "refrigerator":
                return Arrays.asList(SearchCriteria.Refrigerator.values());
            case "speakers":
                return Arrays.asList(SearchCriteria.Speakers.values());
            case "tabletpc":
                return Arrays.asList(SearchCriteria.TabletPC.values());
            case "vacuumcleaner":
                return Arrays.asList(SearchCriteria.VacuumCleaner.values());
            default:
                return Collections.emptyList();
        }
    }
}