package by.car.dealership.dao;

import by.car.dealership.entity.Wheel;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static by.car.dealership.dao.MockConstants.*;
import static by.car.dealership.dao.MockUtils.createWheel;
import static org.junit.jupiter.api.Assertions.*;

class WheelDaoImplTest {


    GenericDao<Wheel> wheelDao = new WheelDaoImpl();

    @Test
    void createTest() {

        Wheel wheel = wheelDao.create(createWheel());

        try {
            Wheel entityWheel = wheelDao.findOne(wheel.getId());
            assertEquals(wheel, entityWheel);
            Assertions.assertEquals(entityWheel.getName(), GOODYEAR_WHEEL_NAME);
            Assertions.assertEquals(entityWheel.getModel(), WHEEL_MODEL);
            wheelDao.delete(wheel);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    void findOneTest() {

        Wheel wheel = wheelDao.create(createWheel());
        Integer wheelId = wheel.getId();

        try {
            assertEquals(wheel, wheelDao.findOne(wheelId));
            wheelDao.delete(wheel);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    void findAllTest() {

        Wheel wheel1 = wheelDao.create(createWheel());
        Wheel wheel2 = wheelDao.create(createWheel());

        List<Wheel> myListWheels = new ArrayList<>();
        myListWheels.add(wheel1);
        myListWheels.add(wheel2);

        List<Wheel> listFromDb = wheelDao.findAll();

        assertEquals(myListWheels, listFromDb);

        wheelDao.delete(wheel1);
        wheelDao.delete(wheel2);
    }

    @Test
    void updateTest() {

        Wheel wheel = wheelDao.create(createWheel());
        wheel.setSize(WHEEL_SIZE_15);
        wheelDao.update(wheel);

        try {
            Wheel entityWheel = wheelDao.findOne(wheel.getId());

            assertEquals(wheel, entityWheel);
            Assertions.assertEquals(entityWheel.getSize(), WHEEL_SIZE_15);
            wheelDao.delete(wheel);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    void deleteTest() {

        Wheel wheel = wheelDao.create(createWheel());

        List<Wheel> wheelsList = wheelDao.findAll();

        wheelDao.delete(wheel);

        List<Wheel> wheelsList2 = wheelDao.findAll();

        assertTrue(wheelsList.contains(wheel));
        assertFalse(wheelsList2.contains(wheel));
    }

    @Test
    void deleteByIdTest() {

        Wheel wheel = wheelDao.create(createWheel());
        List<Wheel> wheelsList = wheelDao.findAll();

        Integer currentWheelId = wheel.getId();

        try {
            wheelDao.deleteById(currentWheelId);

            List<Wheel> wheelsList2 = wheelDao.findAll();

            assertTrue(wheelsList.contains(wheel));
            assertFalse(wheelsList2.contains(wheel));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}