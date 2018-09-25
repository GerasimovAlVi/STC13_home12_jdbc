package ru.innopolis.classwork12.realExample.dao.dao;

import ru.innopolis.classwork12.realExample.dao.Pojo.Manufacture;

public interface ManufactureDAO {
    public boolean add(Manufacture manufacture);
    public Manufacture getById(Integer id);
    public boolean updateById(Manufacture manufacture);
    public boolean deleteById(Integer id);
}
