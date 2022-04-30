package by.car.dealership.dao;

import by.car.dealership.entity.Car;

import javax.persistence.EntityManager;


public class CarDaoImpl extends AbstractDao<Car> implements CarDao {


    public CarDaoImpl(Class<Car> clazz, EntityManager entityManager) {
        super(clazz, entityManager);
    }

    @Override
    public void print() {
        System.out.println("Hello from CarDaoImpl");
    }
}
