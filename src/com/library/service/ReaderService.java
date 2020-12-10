package com.library.service;

import com.library.pojo.Publisher;
import com.library.pojo.Reader;
import com.library.tool.DatabaseTool;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author MSI-NB
 */
public class ReaderService {
    public boolean insert(Reader reader){
        Connection conn = DatabaseTool.getConn();
        String sql="insert into reader(readerId, readerName, type, phoneNo, address) VALUES (?,?,?,?,?)";
        try {
            assert conn != null;
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1,reader.getReaderId());
            statement.setString(2, reader.getReaderName());
            statement.setString(3,reader.getType());
            statement.setString(4,reader.getPhoneNo());
            statement.setString(5,reader.getAddress());
            statement.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    public boolean update(Reader reader){
        Connection conn = DatabaseTool.getConn();
        String sql="update reader set readerName=?,type=?,phoneNo=?,address=? where readerId=?";
        try {
            assert conn != null;
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1,reader.getReaderName());
            statement.setString(2,reader.getType());
            statement.setString(3,reader.getPhoneNo());
            statement.setString(4,reader.getAddress());
            statement.setInt(5,reader.getReaderId());
            statement.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    public boolean delete(Integer readerId){
        Connection conn = DatabaseTool.getConn();
        String sql="delete from reader where readerId=?";
        try {
            assert conn != null;
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, readerId);
            statement.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<Reader> list(){
        List<Reader> list=new ArrayList<>();
        Connection conn = DatabaseTool.getConn();
        String sql="select * from reader";
        try {
            assert conn != null;
           Statement statement = conn.createStatement();
           ResultSet rs=statement.executeQuery(sql);
           while (rs.next()){
               Reader reader=new Reader();
               reader.setReaderId(rs.getInt(1));
               reader.setReaderName(rs.getString(2));
               reader.setType(rs.getString(3));
               reader.setPhoneNo(rs.getString(4));
               reader.setAddress(rs.getString(5));
               list.add(reader);

           }
           return list;

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }

    }
}
