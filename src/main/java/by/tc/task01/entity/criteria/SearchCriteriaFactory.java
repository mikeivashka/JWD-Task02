package by.tc.task01.entity.criteria;

import by.tc.task01.enumeration.ApplianceType;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SearchCriteriaFactory {
    private SearchCriteriaFactory() {
    }

    public static List<Enum> getAllowedSearchCriteria(ApplianceType applianceType) {
        switch (applianceType) {
            case OVEN:
                return Arrays.asList(SearchCriteria.Oven.values());
            case LAPTOP:
                return Arrays.asList(SearchCriteria.Laptop.values());
            case REFRIGERATOR:
                return Arrays.asList(SearchCriteria.Refrigerator.values());
            case SPEAKERS:
                return Arrays.asList(SearchCriteria.Speakers.values());
            case TABLETPC:
                return Arrays.asList(SearchCriteria.TabletPC.values());
            case VACUUMCLEANER:
                return Arrays.asList(SearchCriteria.VacuumCleaner.values());
            default:
                return Collections.emptyList();
        }
    }
}