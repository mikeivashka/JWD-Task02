package by.tc.task01.service.validation;

import by.tc.task01.entity.criteria.Criteria;
import by.tc.task01.entity.criteria.SearchCriteriaFactory;
import by.tc.task01.enumeration.ApplianceType;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Validator {

    private Validator (){}

    public static boolean criteriaValidator(Criteria criteria) {
        Optional<ApplianceType> targetType = Arrays.stream(ApplianceType.values())
                .filter(t -> t.getClassName().equalsIgnoreCase(criteria.getGroupSearchName()))
                .findFirst();
        if (!targetType.isPresent()) return false;
        List<String> allowedCriteria = new ArrayList<>();
        SearchCriteriaFactory.getAllowedValues(targetType.get().getClassName())
                .forEach(v -> allowedCriteria.add(v.toString()));
        return allowedCriteria.containsAll(criteria.getUsedSearchCriteria());
    }

}