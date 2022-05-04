package by.car.dealership.dao;

import by.car.dealership.entity.Car;
import by.car.dealership.entity.Customer;
import by.car.dealership.entity.Deal;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static by.car.dealership.dao.MockConstants.HATCHBACK_BODY_TYPE;
import static by.car.dealership.dao.MockUtils.createCar;
import static by.car.dealership.dao.MockUtils.createCustomer;
import static org.junit.jupiter.api.Assertions.*;

class DealDaoImplTest {

    GenericDao<Deal> dealDao = new DealDaoImpl();
    GenericDao<Car> carDao = new CarDaoImpl();
    GenericDao<Customer> customerDao= new CustomerDaoImpl();

    @Test
    void createTest() {

        Car car = carDao.create(createCar());
        Customer customer = customerDao.create(createCustomer());

        Deal myDeal = new Deal();
        myDeal .setCustomer(customer);
        myDeal .setCar(car);

        Deal deal = dealDao.create(myDeal);

        try {
            Deal dealEntity = dealDao.findOne(deal.getId());
            assertEquals(deal, dealEntity);
            Assertions.assertEquals(dealEntity.getDate(), deal.getDate());
            Assertions.assertEquals(dealEntity.getCustomer(), deal.getCustomer());
            Assertions.assertEquals(dealEntity.getCar(), deal.getCar());
            dealDao.delete(deal);
            carDao.delete(car);
            customerDao.delete(customer);

        } catch (SQLException e) {
            e.printStackTrace();
        }
   }

    @Test
    void findOneTest() {

        Car car = carDao.create(createCar());
        Customer customer = customerDao.create(createCustomer());

        Deal myDeal = new Deal();
        myDeal .setCustomer(customer);
        myDeal .setCar(car);

        Deal deal = dealDao.create(myDeal);

        Integer dealId = deal.getId();

        try {
            assertEquals(deal, dealDao.findOne(dealId));
            dealDao.delete(deal);
            carDao.delete(car);
            customerDao.delete(customer);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    @Test
    void findAllTest() {

        Car car = carDao.create(createCar());
        Customer customer = customerDao.create(createCustomer());

        Deal myDeal = new Deal();
        myDeal .setCustomer(customer);
        myDeal .setCar(car);

        Deal deal = dealDao.create(myDeal);

        List<Deal> listDeals = new ArrayList<>();
        listDeals.add(deal);


        List<Deal> listFromDb = dealDao.findAll();

        assertEquals(listDeals, listFromDb);
        dealDao.delete(deal);
        carDao.delete(car);
        customerDao.delete(customer);
    }


    // в тестах даёт обновлять данные но в таблице отсаются правильные,
    // работает првильно, но тест всеравно проходит, и вообще-то
    // по хорошему тут не должно быть метода обновить

//    @Test
//    void updateTest() {
//
//        Car car1 = carDao.create(createCar());
//        Car car2 = carDao.create(createCar());
//        Customer customer = customerDao.create(createCustomer());
//
//        Deal myDeal = new Deal();
//        myDeal .setCustomer(customer);
//        myDeal .setCar(car1);
//
//        Deal deal = dealDao.create(myDeal);
//
//        try {
//            Deal entityDeal = dealDao.findOne(deal.getId());
//            entityDeal.setCar(car2);
//            dealDao.update(entityDeal);
//
//            Deal tt = dealDao.findOne(deal.getId());
//            System.out.println(tt.getId());
//
//
//            //assertEquals(car, entityCar);
//            Assertions.assertEquals(car1,tt.getCar());
////            carDao.delete(car);
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
}
