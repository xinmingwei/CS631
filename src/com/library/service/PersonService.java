package com.library.service;

import com.library.pojo.Person;
import com.library.pojo.Publisher;
import com.library.tool.DatabaseTool;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author MSI-NB
 */
public class PersonService {
    public boolean insert(Person person) {
        Connection conn = DatabaseTool.getConn();
        String sql = "insert into person(pid, pname) VALUES (?,?)";
        try {
            assert conn != null;
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, person.getPid());
            statement.setString(2, person.getPname());
            statement.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean update(Person person) {
        Connection conn = DatabaseTool.getConn();
        String sql = "update person set Pid=?,Pname=? where Pid=?";
        try {
            assert conn != null;
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, person.getPid());
            statement.setString(2, person.getPname());
            statement.setInt(3, person.getPid());
            statement.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean delete(Integer pid) {
        Connection conn = DatabaseTool.getConn();
        String sql = "delete from person where Pid=?";
        try {
            assert conn != null;
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, pid);
            statement.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<Person> list() {
        List<Person> list = new ArrayList<>();
        Connection conn = DatabaseTool.getConn();
        String sql = "select * from person";
        try {
            assert conn != null;
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                Person p = new Person();
                p.setPid(rs.getInt(1));
                p.setPname(rs.getString(2));
                list.add(p);
            }
            return list;

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }

    }
}
