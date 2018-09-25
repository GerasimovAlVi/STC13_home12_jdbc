package ru.innopolis.classwork12.realExample.dao.dao;

import ru.innopolis.classwork12.realExample.dao.Pojo.Mobile;

public interface MobileDAO {
    public boolean add(Mobile mobile);
    public Mobile getById(Integer id);
    public boolean updateById(Mobile mobile);
    public boolean deleteById(Integer id);
}
