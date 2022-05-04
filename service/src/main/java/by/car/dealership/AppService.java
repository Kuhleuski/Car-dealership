package by.car.dealership;

import by.car.dealership.dao.GenericDao;
import by.car.dealership.dao.WheelDaoImpl;
import by.car.dealership.entity.Wheel;

import java.math.BigDecimal;

public class AppService {
    public static void main(String[] args) {
        AdminService adminService = new AdminService();
        GeneralService generalService;

        GenericDao<Wheel> wheelDao = new WheelDaoImpl();
        adminService.createWheel("Nokian","WT-33",16, BigDecimal.valueOf(1350.30));
        Integer idWheel = GeneralService.getIdWheel("Nokian",wheelDao);
        System.out.println(idWheel);




    }


}
