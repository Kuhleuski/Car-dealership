package by.car.dealership.dao;

import by.car.dealership.entity.Car;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static by.car.dealership.dao.MockConstants.*;
import static by.car.dealership.dao.MockUtils.createCar;
import static org.junit.jupiter.api.Assertions.*;

class CarDaoImplTest {

    GenericDao<Car> carDao = new CarDaoImpl();

    @Test
    void createTest() {

        Car car = carDao.create(createCar());

        try {
            Car entityCar = carDao.findOne(car.getId());
            assertEquals(car, entityCar);
            Assertions.assertEquals(entityCar.getName(), CAR_NAME_FORD);
            Assertions.assertEquals(entityCar.getModel(), CAR_MODEL_FOCUS);
            carDao.delete(car);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    void findOneTest() {

        Car car = carDao.create(createCar());
        Integer carId = car.getId();

        try {
            assertEquals(car, carDao.findOne(carId));
            carDao.delete(car);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    void findAllTest() {

        Car car = carDao.create(createCar());
        Car car2 = carDao.create(createCar());

        List<Car> myListCars = new ArrayList<>();
        myListCars.add(car);
        myListCars.add(car2);

        List<Car> listFromDb = carDao.findAll();

        assertEquals(myListCars, listFromDb);

        carDao.delete(car);
        carDao.delete(car2);
    }

    @Test
    void updateTest() {

        Car car = carDao.create(createCar());
        car.setBodyType(HATCHBACK_BODY_TYPE);
        carDao.update(car);

        try {
            Car entityCar = carDao.findOne(car.getId());

            assertEquals(car, entityCar);
            Assertions.assertEquals(entityCar.getBodyType(), HATCHBACK_BODY_TYPE);
            carDao.delete(car);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    void deleteTest() {

        Car car = carDao.create(createCar());

        List<Car> carList = carDao.findAll();


        carDao.delete(car);

        List<Car> carList2 = carDao.findAll();

        assertTrue(carList.contains(car));
        assertFalse(carList2.contains(car));
    }
    
    @Test
    void deleteByIdTest() {

        Car car = carDao.create(createCar());
        List<Car> carList = carDao.findAll();

        Integer currentCarId = car.getId();

        try {
            carDao.deleteById(currentCarId);

            List<Car> carList2 = carDao.findAll();

            assertTrue(carList.contains(car));
            assertFalse(carList2.contains(car));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}