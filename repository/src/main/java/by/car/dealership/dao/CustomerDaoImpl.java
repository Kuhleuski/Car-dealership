package by.car.dealership.dao;

import by.car.dealership.entity.Customer;
import by.car.dealership.util.HibernateUtil;


public class CustomerDaoImpl extends AbstractDao<Customer> implements CustomerDao{
    public CustomerDaoImpl() {
        super(Customer.class, HibernateUtil.getEntityManager());
    }
}
