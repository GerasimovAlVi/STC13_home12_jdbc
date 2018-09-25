package ru.innopolis.classwork12.realExample.dao;

import ru.innopolis.classwork12.realExample.dao.Pojo.Manufacture;
import ru.innopolis.classwork12.realExample.dao.Pojo.Mobile;
import ru.innopolis.classwork12.realExample.dao.dao.ManufactureDAO;
import ru.innopolis.classwork12.realExample.dao.dao.ManufactureDAOImpl;
import ru.innopolis.classwork12.realExample.dao.dao.MobileDAO;
import ru.innopolis.classwork12.realExample.dao.dao.MobileDAOImpl;

public class Main {
    public static void main(String[] args) {
        Manufacture manufacture2 = new Manufacture();
        ManufactureDAO manufactureDAO2 = new ManufactureDAOImpl();
        manufacture2 = manufactureDAO2.getById(5);
        Mobile mobile = new Mobile(null, "Iphone 4", 40000L, manufacture2);
        MobileDAO mobileDAO = new MobileDAOImpl();
        //mobileDAO.add(mobile);
        //mobileDAO.deleteById(9);
        mobile = mobileDAO.getById(9);
        System.out.println(mobile);
        mobile.setPrice(50000L);
        mobileDAO.updateById(mobile);
        mobile = mobileDAO.getById(9);
        System.out.println(mobile);

        Manufacture manufacture = new Manufacture(null, "Xiaomi", "null");
        ManufactureDAO manufactureDAO = new ManufactureDAOImpl();
        //manufactureDAO.add(manufacture);
        //manufactureDAO.deleteById(6);
        manufacture = manufactureDAO.getById(7);
        System.out.println(manufacture);
        manufacture.setCountry("China");
        manufactureDAO.updateById(manufacture);
        manufacture = manufactureDAO.getById(7);
        System.out.println(manufacture);
    }
}
