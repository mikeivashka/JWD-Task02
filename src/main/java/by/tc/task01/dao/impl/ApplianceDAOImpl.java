package by.tc.task01.dao.impl;

import by.tc.task01.dao.ApplianceDAO;
import by.tc.task01.entity.Appliance;
import by.tc.task01.entity.ApplianceFactory;
import by.tc.task01.entity.criteria.Criteria;
import by.tc.task01.enumeration.ApplianceType;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class ApplianceDAOImpl implements ApplianceDAO {

    private static final String PATH_TO_DATABASE = "appliances_db.txt";


    @Override
    public List<Appliance> find(Criteria criteria) throws IOException {
        List<Appliance> devices = new ArrayList<>();
        List<Map<String, Object>> devicesMatchingCriteria = getDevicesMatchingCriteria(criteria);
        for (Map<String, Object> params : devicesMatchingCriteria) {
            Appliance device = ApplianceFactory
                    .getAppliance((ApplianceType) params.get("type"), params);
            devices.add(device);
        }

        return devices;
    }

    private List<Map<String, Object>> getDevicesMatchingCriteria(Criteria criteria) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(PATH_TO_DATABASE));
        HashMap<String, Object> criterionMap;
        List<Map<String, Object>> resultList = new ArrayList<>();
        String line = reader.readLine();
        while (line != null) {
            if (isMatchingLine(line, criteria)) {
                criterionMap = splitLineToParams(line);
                resultList.add(criterionMap);
            }
            line = reader.readLine();
        }
        return resultList;
    }

    private boolean isMatchingLine(String line, Criteria criteria) {
        boolean result = false;
        HashMap<String, Object> params;
        if (line.contains(criteria.getGroupSearchName())) {
            params = splitLineToParams(line);
            for (String paramToSearch : criteria.getUsedSearchCriteria()) {
                if (((String) params.get(paramToSearch))
                        .equalsIgnoreCase(criteria.get(paramToSearch).toString().toLowerCase())) {
                    result = true;
                } else {
                    return false;
                }
            }
        }
        return result;

    }

    private HashMap<String, Object> splitLineToParams(String line) {
        HashMap<String, Object> resultMap = new HashMap<>();
        String[] params = line.split(":");
        ApplianceType type = ApplianceType.valueOf(params[0].trim().toUpperCase());
        resultMap.put("type", type);
        Arrays.stream(params[1].split(",")).forEach(p -> {
            String[] result = p.split("=");
            resultMap.put(result[0].trim(), result[1].trim());
        });
        return resultMap;
    }

}


//you may add your own new classes