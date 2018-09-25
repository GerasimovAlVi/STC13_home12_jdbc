package ru.innopolis.classwork12.realExample.dao.dao;

import ru.innopolis.classwork12.realExample.dao.ConnectionManager.ConnectionManager;
import ru.innopolis.classwork12.realExample.dao.ConnectionManager.ConnectionManagerImpl;
import ru.innopolis.classwork12.realExample.dao.Pojo.Manufacture;
import ru.innopolis.classwork12.realExample.dao.Pojo.Mobile;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MobileDAOImpl implements MobileDAO {
    private static ConnectionManager connectionManager = ConnectionManagerImpl.getInstance();

    @Override
    public boolean add(Mobile mobile) {
        try(Connection connection = connectionManager.getConnection()){
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "insert into mobiles values (default, ?, ?, ?)");
            preparedStatement.setString(1, mobile.getModel());
            preparedStatement.setLong(2, mobile.getPrice());
            preparedStatement.setInt(3, mobile.getManufacture().getId());
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public Mobile getById(Integer id) {
        try (Connection connection = connectionManager.getConnection();) {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "SELECT * FROM mobiles WHERE id = ?");
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            Manufacture manufacture = null;
            if (resultSet.next()) {
                PreparedStatement preparedStatement2 = connection.prepareStatement(
                        "SELECT * FROM manufacture WHERE id = ?");
                preparedStatement2.setInt(1, resultSet.getInt(4));
                ResultSet resultSet2 = preparedStatement2.executeQuery();
                if(resultSet2.next()){
                    manufacture = new Manufacture(
                            resultSet2.getInt(1),
                            resultSet2.getString(2),
                            resultSet2.getString(3));
                }

                Mobile mobile = new Mobile(
                        resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getLong(3),
                        manufacture);
                return mobile;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean updateById(Mobile mobile) {
        try (Connection connection = connectionManager.getConnection();) {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "UPDATE mobiles SET model = ?, price = ?, manufacture_id = ? WHERE id = ?");
            preparedStatement.setString(1, mobile.getModel());
            preparedStatement.setLong(2, mobile.getPrice());
            preparedStatement.setInt(3, mobile.getManufacture().getId());
            preparedStatement.setInt(4, mobile.getId());
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
                    "DELETE FROM mobiles WHERE id = ?");
            preparedStatement.setInt(1, id);
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
