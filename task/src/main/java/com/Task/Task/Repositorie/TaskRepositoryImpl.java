package com.Task.Task.Repositorie;

import com.Task.Task.Controller.TaskRepositorie;
import com.Task.Task.Model.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class TaskRepositoryImpl implements TaskRepositorie{
    private final DataSource dataSource;
    @Autowired

    public TaskRepositoryImpl(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public List<Task> getAllTask(){
        List<Task> tasks = new ArrayList<>();
        try(Connection connection = dataSource.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from taske")){
        while (resultSet.next()){
            tasks.add(new Task(resultSet.getInt("id"),resultSet.getString("name"),resultSet.getString("firstName")));
        }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return tasks;
    }

    @Override
    public Task getTaskById(int id) {
        String query = "select * from taske where id =?";
        try(Connection connection = dataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query)){
            preparedStatement.setInt(1,id);
            try (ResultSet resultSet =preparedStatement.executeQuery()){
                if (resultSet.next()){
                    return mapRowToTaks(resultSet);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    //INSERT
    public void  insert(Task task){
        String query = "insert into taske (id, name, firstName) values(?,?,?)";
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
             preparedStatement.setInt(1,task.getId());
             preparedStatement.setString(2,task.getName());
             preparedStatement.setString(3, task.getFirstName());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private Task mapRowToTaks(ResultSet resultSet) throws SQLException {
        return new Task(resultSet.getInt("id"),resultSet.getString("name"),resultSet.getString("firstName"));
    }
}

