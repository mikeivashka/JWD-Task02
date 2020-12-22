package by.tc.task01.dao.impl;

import by.tc.task01.dao.ApplianceDAO;
import by.tc.task01.entity.Appliance;
import by.tc.task01.entity.criteria.Criteria;
import by.tc.task01.enumeration.ApplianceType;
import by.tc.task01.parser.impl.ApplianceTextParser;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ApplianceDAOImpl implements ApplianceDAO {

    private static final String PATH_TO_DATABASE = "appliances_db.txt";

    @Override
    public List<Appliance> find(Criteria criteria) throws IOException {
        ApplianceType type = ApplianceType.valueOf(criteria.getGroupSearchName().toUpperCase());
        var lines = new TextFileReader(PATH_TO_DATABASE).linesList();
        var parser = ApplianceTextParser.getInstance();
        var devices = new ArrayList<Appliance>();
        parser.getLinesMatchingCriteria(lines, criteria)
                .forEach(l -> devices.add(parser.parse(l, type)));
        return devices;
    }
}