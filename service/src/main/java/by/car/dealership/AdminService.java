package by.car.dealership;

import by.car.dealership.dao.*;
import by.car.dealership.entity.Car;
import by.car.dealership.entity.Engine;
import by.car.dealership.entity.Wheel;

public class AdminService {

    private final GenericDao<Wheel> wheelDao = new WheelDaoImpl();
    private final GenericDao<Engine> engineDao = new EngineDaoImpl();
    private final GenericDao<Car> carDao = new CarDaoImpl();

    public void createWheel(String name,String model, int size, int price){
        // TODO тут надо написать GeneralService для поиска id колёс
        Wheel wheel = Wheel.builder()
                .name(name)
                .model(model)
                .size(size)
                .price(price)
                .build();

    }

}
