package by.tc.task01.main;

import by.tc.task01.entity.Appliance;
import by.tc.task01.entity.criteria.Criteria;
import by.tc.task01.service.ApplianceService;
import by.tc.task01.service.ServiceFactory;
import lombok.extern.java.Log;

import java.io.IOException;
import java.util.List;
import java.util.logging.Level;

import static by.tc.task01.entity.criteria.SearchCriteria.Oven;
import static by.tc.task01.entity.criteria.SearchCriteria.TabletPC;

@Log
public class Main {

    public static void main(String[] args) {
        Appliance appliance;

        ServiceFactory factory = ServiceFactory.getInstance();
        ApplianceService service = factory.getApplianceService();

        //////////////////////////////////////////////////////////////////

        Criteria criteriaOven = new Criteria(Oven.class.getSimpleName());//"Oven"
        criteriaOven.add(Oven.CAPACITY.toString(), 32);
        List<Appliance> searchResult = null;
        try {
            searchResult = service.find(criteriaOven);
        } catch (IOException e) {
            log.log(Level.WARNING, e.getMessage());
        }

        appliance = (searchResult != null && !searchResult.isEmpty()) ? searchResult.get(0) : null;

        if (appliance != null) {
            PrintApplianceInfo.print(appliance);
        }

        //////////////////////////////////////////////////////////////////

        criteriaOven = new Criteria(Oven.class.getSimpleName());
        criteriaOven.add(Oven.HEIGHT.toString(), 200);
        criteriaOven.add(Oven.DEPTH.toString(), 300);

        try {
            searchResult = service.find(criteriaOven);
        } catch (IOException e) {
            log.log(Level.WARNING, e.getMessage());
        }

        appliance = (searchResult != null && !searchResult.isEmpty()) ? searchResult.get(0) : null;

        if (appliance != null) {
            PrintApplianceInfo.print(appliance);
        }

        //////////////////////////////////////////////////////////////////

        Criteria criteriaTabletPC = new Criteria(TabletPC.class.getSimpleName());
        criteriaTabletPC.add(TabletPC.COLOR.toString(), "BLUE");
        criteriaTabletPC.add(TabletPC.DISPLAY_INCHES.toString(), 14);
        criteriaTabletPC.add(TabletPC.MEMORY_ROM.toString(), 8000);

        try {
            searchResult = service.find(criteriaTabletPC);
        } catch (IOException e) {
            log.log(Level.WARNING, e.getMessage());
        }

        appliance = (searchResult != null && !searchResult.isEmpty()) ? searchResult.get(0) : null;

        if (appliance != null) {
            PrintApplianceInfo.print(appliance);
        }


    }

}
