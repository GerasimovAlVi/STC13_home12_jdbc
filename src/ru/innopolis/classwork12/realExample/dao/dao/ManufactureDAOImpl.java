package ru.innopolis.classwork12.realExample.dao.dao;

import ru.innopolis.classwork12.realExample.dao.ConnectionManager.ConnectionManager;
import ru.innopolis.classwork12.realExample.dao.ConnectionManager.ConnectionManagerImpl;
import ru.innopolis.classwork12.realExample.dao.Pojo.Manufacture;
import ru.innopolis.classwork12.realExample.dao.Pojo.Mobile;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ManufactureDAOImpl implements ManufactureDAO {
    private static ConnectionManager connectionManager = ConnectionManagerImpl.getInstance();

    @Override
    public boolean add(Manufacture manufacture) {
        try(Connection connection = connectionManager.getConnection()){
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "insert into manufacture values (default, ?, ?)");
            preparedStatement.setString(1, manufacture.getName());
            preparedStatement.setString(2, manufacture.getCountry());
        preparedStatement.execute();
    } catch (SQLException e) {
        e.printStackTrace();
        return false;
    }
        return true;
    }

    @Override
    public Manufacture getById(Integer id) {
        try (Connection connection = connectionManager.getConnection();) {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "SELECT * FROM manufacture WHERE id = ?");
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                Manufacture manufacture = new Manufacture(
                        resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getString(3));
                return manufacture;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean updateById(Manufacture manufacture) {
        try (Connection connection = connectionManager.getConnection();) {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "UPDATE manufacture SET name = ?, country = ? WHERE id = ?");
            preparedStatement.setString(1, manufacture.getName());
            preparedStatement.setString(2, manufacture.getCountry());
            preparedStatement.setInt(3, manufacture.getId());
            preparedStatement.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean deleteById(Integer id) {
        try (Connection connection = connectionManager.getConnection();) {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "DELETE FROM manufacture WHERE id = ?");
            preparedStatement.setInt(1, id);
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
