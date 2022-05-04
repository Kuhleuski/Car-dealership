package by.car.dealership;

import by.car.dealership.dao.GenericDao;
import by.car.dealership.entity.Wheel;

import java.util.List;

public class GeneralService {

    static Integer getIdWheel(String wheelName, GenericDao<Wheel> wheelDao) {
        List<Wheel> allWheels = wheelDao.findAll();
        Wheel wheel = allWheels.stream().filter(c -> c.getName().equals(wheelName))
                .findAny().orElse(null);
        if (wheel != null) {
            return wheel.getId();
        } else {
            return null;
        }
    }

}
