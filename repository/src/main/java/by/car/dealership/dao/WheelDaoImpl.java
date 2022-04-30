package by.car.dealership.dao;

import by.car.dealership.entity.Wheel;
import by.car.dealership.util.HibernateUtil;

public class WheelDaoImpl extends AbstractDao<Wheel> implements WheelDao {

    public WheelDaoImpl() {
        super(Wheel.class, HibernateUtil.getEntityManager());
    }
}
