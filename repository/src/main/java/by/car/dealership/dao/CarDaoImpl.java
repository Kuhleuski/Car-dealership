package by.car.dealership.dao;

import by.car.dealership.entity.Car;
import by.car.dealership.util.HibernateUtil;

import javax.persistence.EntityManager;


public class CarDaoImpl extends AbstractDao<Car> implements CarDao {


    public CarDaoImpl() {
        super(Car.class, HibernateUtil.getEntityManager());
    }

}
