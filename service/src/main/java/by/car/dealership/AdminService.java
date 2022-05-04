package by.car.dealership;

import by.car.dealership.dao.*;
import by.car.dealership.entity.Car;
import by.car.dealership.entity.Engine;
import by.car.dealership.entity.Wheel;

import java.math.BigDecimal;

public class AdminService {

    private final GenericDao<Wheel> wheelDao = new WheelDaoImpl();
    private final GenericDao<Engine> engineDao = new EngineDaoImpl();
    private final GenericDao<Car> carDao = new CarDaoImpl();

    public void createWheel(String name,String model, int size, BigDecimal price){
        Integer idWheel = GeneralService.getIdWheel(name,wheelDao);
        //доделать проверку на имя и модель и размер
        if (idWheel == null){
            Wheel wheel = wheelDao.create(Wheel.builder().name(name)
                    .model(model)
                    .size(size)
                    .price(price)
                    .build());

        } else {
            System.out.println("Wheel already exist");
        }


    }

}
