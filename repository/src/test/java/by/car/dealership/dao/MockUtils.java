package by.car.dealership.dao;

import by.car.dealership.entity.*;

import java.math.BigDecimal;

import static by.car.dealership.dao.MockConstants.*;

public class MockUtils {

    public static Car createCar() {
        return Car.builder()
                .name(CAR_NAME_FORD)
                .model(CAR_MODEL_FOCUS)
                .bodyType(CAR_BODY_TYPE_SEDAN)
                .weight(CAR_WEIGHT_2_500)
                .price(BigDecimal.valueOf(CAR_PRICE_13_000))
                .build();
    }

    public static Engine createEngine() {
        return Engine.builder()
                .name(ENGINE_NAME)
                .model(ENGINE_MODEL)
                .fuelType(PETROL_FUEL)
                .displacement(DISPLACEMENT)
                .price(BigDecimal.valueOf(ENGINE_PRICE))
                .build();
    }

    public static Wheel createWheel() {
        return Wheel.builder()
                .name(GOODYEAR_WHEEL_NAME)
                .model(WHEEL_MODEL)
                .size(WHEEL_SIZE_17)
                .price(BigDecimal.valueOf(WHEEL_PRICE))
                .build();
    }

    public static Customer createCustomer(){
        return Customer.builder()
                .name(CUSTOMER_NAME)
                .surname(CUSTOMER_SURNAME)
                .build();
    }

}
