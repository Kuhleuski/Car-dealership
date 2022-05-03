package by.car.dealership.dao;

import by.car.dealership.entity.Deal;
import by.car.dealership.util.HibernateUtil;

public class DealDaoImpl extends AbstractDao<Deal> implements DealDao {
    public DealDaoImpl() {
        super(Deal.class, HibernateUtil.getEntityManager());
    }
}
