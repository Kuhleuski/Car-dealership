package by.car.dealership.dao;

import by.car.dealership.entity.Engine;
import by.car.dealership.util.HibernateUtil;

public class EngineDaoImpl extends AbstractDao<Engine> implements EngineDao{
    public EngineDaoImpl() {
        super(Engine.class, HibernateUtil.getEntityManager());
    }
}
