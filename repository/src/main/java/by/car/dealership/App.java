package by.car.dealership;


import by.car.dealership.entity.Car;
import by.car.dealership.entity.Engine;
import by.car.dealership.entity.Wheel;
import by.car.dealership.util.HibernateUtil;

import javax.persistence.EntityManager;
import java.util.HashSet;
import java.util.Set;

public class App {
    public static void main(String[] args) {

        Wheel wheel = Wheel.builder()
                .name("Michelin")
                .model("Primacy 4+")
                .size(17)
                .price(2000)
                .build();

        Engine engine = Engine.builder()
                .name("BMY")
                .model("BMY003716")
                .displacement(2)
                .fuelType("Бензин")
                .price(3000)
                .build();

        Car car = Car.builder()
                .name("Volkswagen")
                .model("Golf 5")
                .bodyType("Хэтчбэк")
                .engine(engine)
                .wheel(wheel)
                .price(15000)
                .build();

        Set<Car> cars = new HashSet<>();
        cars.add(car);

        wheel.setCars(cars);
        engine.setCars(cars);


        EntityManager manager = HibernateUtil.getEntityManager();

        manager.getTransaction().begin();
        manager.persist(wheel);
        manager.persist(engine);
        manager.persist(car);

        manager.getTransaction().commit();

        manager.close();
        HibernateUtil.close();


    }
}
