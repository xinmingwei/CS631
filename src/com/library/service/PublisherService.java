package com.library.service;

import com.library.pojo.Book;
import com.library.pojo.Publisher;
import com.library.tool.DatabaseTool;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author MSI-NB
 */
public class PublisherService {
    public boolean insert(Publisher publisher){
        Connection conn = DatabaseTool.getConn();
        String sql="insert into publisher(publisherid, pubname, address) values(?,?,?)";
        try {
            assert conn != null;
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1,publisher.getPublisherId());
            statement.setString(2, publisher.getPubName());
            statement.setString(3,publisher.getAddress());
            statement.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    public boolean update(Publisher publisher){
        Connection conn = DatabaseTool.getConn();
        String sql="update publisher set PubName=?,Address=? where PublisherId=?";
        try {
            assert conn != null;
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, publisher.getPubName());
            statement.setString(2,publisher.getAddress());
            statement.setInt(3,publisher.getPublisherId());
            statement.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    public boolean delete(Integer publisherId){
        Connection conn = DatabaseTool.getConn();
        String sql="delete from publisher where PublisherId=?";
        try {
            assert conn != null;
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, publisherId);
            statement.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<Publisher> list(){
        List<Publisher> list=new ArrayList<>();
        Connection conn = DatabaseTool.getConn();
        String sql="select * from publisher";
        try {
            assert conn != null;
           Statement statement = conn.createStatement();
           ResultSet rs=statement.executeQuery(sql);
           while (rs.next()){
               Publisher p = new Publisher();
               p.setPublisherId(rs.getInt(1));
               p.setPubName(rs.getString(2));
               p.setAddress(rs.getString(3));
               list.add(p);
           }
           return list;

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }

    }
}
