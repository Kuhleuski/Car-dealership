package by.car.dealership;

import by.car.dealership.entity.*;
import by.car.dealership.util.HibernateUtil;


import javax.persistence.EntityManager;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;



public class App {
    public static void main(String[] args) {

        Wheel wheel = Wheel.builder()
                .name("Michelin")
                .model("Primacy 4+")
                .size(17)
                .price(BigDecimal.valueOf(12.56))
                .build();

        Engine engine = Engine.builder()
                .name("BMY")
                .model("BMY003716")
                .displacement(2)
                .fuelType("Бензин")
                .price(BigDecimal.valueOf(3000))
                .build();

        Car car = Car.builder()
                .name("Volkswagen")
                .model("Golf 5")
                .bodyType("Хэтчбэк")
                .weight(1920)
                .engine(engine)
                .wheel(wheel)
                .price(BigDecimal.valueOf(12.459))
                .build();

        Car car2 = Car.builder()
                .name("Nissan")
                .model("Note")
                .bodyType("Cedan")
                .weight(2200)
                .engine(engine)
                .wheel(wheel)
                .price(BigDecimal.valueOf(21.986))
                .build();

        Set<Car> cars = new HashSet<>();
        cars.add(car);

        wheel.setCars(cars);
        engine.setCars(cars);


        Customer customer = Customer.builder()
                .name("Sergey")
                .surname("Petrov")
                .build();

        customer.setCars(cars);
        //customer.setCar(car);

        car.setCustomer(customer);

        Deal deal = new Deal();
        deal.setCar(car);
        deal.setCustomer(customer);

        List<Car> carsOnSale = new ArrayList<>();
        carsOnSale.add(car);
        carsOnSale.add(car2);



        Stock stock = new Stock();
        stock.setCarStock(carsOnSale);

        car.setStock(stock);
        car2.setStock(stock);

        EntityManager manager = HibernateUtil.getEntityManager();

        manager.getTransaction().begin();

        manager.persist(wheel);
        manager.persist(engine);
        manager.persist(car);
        manager.persist(car2);
        manager.persist(customer);
        manager.persist(deal);
        manager.persist(stock);

        manager.getTransaction().commit();
//
//        manager.getTransaction().begin();
//
// //       deal.setCar(car2);
//
//        manager.getTransaction().commit();


        manager.close();
        HibernateUtil.close();


    }
}
