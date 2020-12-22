package by.tc.task01.parser.impl;

import by.tc.task01.entity.Appliance;
import by.tc.task01.entity.ApplianceFactory;
import by.tc.task01.entity.criteria.Criteria;
import by.tc.task01.enumeration.ApplianceType;
import by.tc.task01.parser.ApplianceParser;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ApplianceTextParser implements ApplianceParser<String> {

    private static ApplianceTextParser instance;


    private ApplianceTextParser() {
    }

    public static ApplianceTextParser getInstance() {
        if (instance == null) instance = new ApplianceTextParser();
        return instance;
    }

    @Override
    public Appliance parse(String source, ApplianceType type) {
        return ApplianceFactory.getAppliance(type, splitLineToParams(source));
    }

    public List<String> getLinesMatchingType(List<String> lines, ApplianceType type) {
        return lines.stream().filter(s -> !s.isBlank() && getType(s) == type).collect(Collectors.toList());
    }

    public List<String> getLinesMatchingCriteria(List<String> lines, Criteria criteria) {
        return getLinesMatchingType(lines, ApplianceType.valueOf(criteria.getGroupSearchName().toUpperCase()))
                .stream()
                .filter(line -> criteria.entrySet().stream()
                        .allMatch(entry ->
                                getParameterValueFromString(line, entry.getKey())
                                        .equalsIgnoreCase(entry.getValue().toString()))
                ).collect(Collectors.toList());
    }

    public String getParameterValueFromString(String source, String parameter) {
        return source.substring(source.lastIndexOf(parameter.toUpperCase()) + parameter.length())
                .transform(s ->
                        s.substring(s.indexOf("=") + 1, (s.indexOf(',') >= 0 ? s.indexOf(',') : s.length())).trim()
                );
    }

    public ApplianceType getType(String line) {
        try {
            return ApplianceType.valueOf(line.transform(s -> s.substring(0, s.indexOf(':')).trim()).toUpperCase());
        } catch (IndexOutOfBoundsException e) {
            throw new IllegalArgumentException(e.getMessage() + "; Line doesn't contain type separator: " + line);
        }
    }

    private Map<String, Object> splitLineToParams(String line) {
        Map<String, Object> paramsMap = new HashMap<>();
        Arrays.stream(line.substring(line.indexOf(':') + 1).split(","))
                .forEach(pair -> {
                    String[] keyValue = pair.split("=");
                    paramsMap.put(keyValue[0].trim(), keyValue[1].trim());
                });
        return paramsMap;
    }
}
