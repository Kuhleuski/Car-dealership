package by.car.dealership.dao;

import by.car.dealership.entity.Customer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static by.car.dealership.dao.MockConstants.*;
import static by.car.dealership.dao.MockUtils.createCustomer;
import static org.junit.jupiter.api.Assertions.*;

class CustomerDaoImplTest {

    GenericDao<Customer> customerDao= new CustomerDaoImpl();

    @Test
    void createTest() {

        Customer customer = customerDao.create(createCustomer());

        try {
            Customer entityCustomer = customerDao.findOne(customer.getId());
            assertEquals(customer, entityCustomer);
            Assertions.assertEquals(entityCustomer.getName(), CUSTOMER_NAME);
            Assertions.assertEquals(entityCustomer.getSurname(), CUSTOMER_SURNAME);
            customerDao.delete(customer);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    void findOneTest() {

        Customer customer = customerDao.create(createCustomer());
        Integer customerIdId = customer.getId();

        try {
            assertEquals(customer, customerDao.findOne(customerIdId));
            customerDao.delete(customer);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    void findAllTest() {

        Customer customer1 = customerDao.create(createCustomer());
        Customer customer2 = customerDao.create(createCustomer());

        List<Customer> myListCustomers = new ArrayList<>();
        myListCustomers.add(customer1);
        myListCustomers.add(customer2);

        List<Customer> listFromDb = customerDao.findAll();

        assertEquals(myListCustomers, listFromDb);

        customerDao.delete(customer1);
        customerDao.delete(customer2);
    }

    @Test
    void updateTest() {

        Customer customer = customerDao.create(createCustomer());
        customer.setSurname(CUSTOMER_SURNAME_IVANOV);
        customerDao.update(customer);

        try {
            Customer entityCustomer = customerDao.findOne(customer.getId());

            assertEquals(customer, entityCustomer);
            Assertions.assertEquals(entityCustomer.getSurname(), CUSTOMER_SURNAME_IVANOV);
            customerDao.delete(customer);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    void deleteTest() {

        Customer customer = customerDao.create(createCustomer());

        List<Customer> customers = customerDao.findAll();

        customerDao.delete(customer);

        List<Customer> customers2 = customerDao.findAll();

        assertTrue(customers.contains(customer));
        assertFalse(customers2.contains(customer));
    }

    @Test
    void deleteByIdTest() {

        Customer customer = customerDao.create(createCustomer());
        List<Customer> customers = customerDao.findAll();

        Integer currentCustomerId = customer.getId();

        try {
            customerDao.deleteById(currentCustomerId);

            List<Customer> customers2 = customerDao.findAll();

            assertTrue(customers.contains(customer));
            assertFalse(customers2.contains(customer));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}