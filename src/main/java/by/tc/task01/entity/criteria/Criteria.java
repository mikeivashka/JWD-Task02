package by.tc.task01.entity.criteria;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Criteria {

    private final String groupSearchName;

    private final Map<String, Object> criteriaMap = new HashMap<>();

    public Criteria(String groupSearchName) {
        this.groupSearchName = groupSearchName;
    }

    public String getGroupSearchName() {
        return groupSearchName;
    }

    public void add(String searchCriteria, Object value) {
        criteriaMap.put(searchCriteria, value);
    }

    public Set<String> getUsedSearchCriteria() {
        return criteriaMap.keySet();
    }

    public Set<Map.Entry<String, Object>> entrySet() {
        return criteriaMap.entrySet();
    }

    public Object get(String key) {
        return criteriaMap.get(key);
    }

}
