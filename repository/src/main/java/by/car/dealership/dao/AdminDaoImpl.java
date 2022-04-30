package by.car.dealership.dao;

import by.car.dealership.entity.Admin;
import by.car.dealership.util.HibernateUtil;

import javax.persistence.EntityManager;

public class AdminDaoImpl extends AbstractDao<Admin> implements AdminDao{
    public AdminDaoImpl() {
        super(Admin.class, HibernateUtil.getEntityManager());
    }
}
