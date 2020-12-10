package com.library.service;

import com.library.pojo.Book;
import com.library.pojo.Proceeding;
import com.library.tool.DatabaseTool;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author MSI-NB
 */
public class ProceedingService {


    public boolean insert(Proceeding proceeding) {
        Connection conn = DatabaseTool.getConn();
        String sql = "insert into document(docid, title, pdate, publisherid) values(?,?,?,?)";
        String sql2 = "insert into proceedings(docId, location, cDate) VALUE (?,?,?)";
        try {
            assert conn != null;
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, proceeding.getDocId());
            statement.setString(2, proceeding.getTitle());
            statement.setString(3, proceeding.getpDate());
            statement.setInt(4, proceeding.getPublishId());
            PreparedStatement statement1 = conn.prepareStatement(sql2);
            statement1.setInt(1, proceeding.getDocId());
            statement1.setString(2, proceeding.getLocation());
            statement1.setString(3, proceeding.getcDate());
            statement.executeUpdate();
            statement1.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean update(Proceeding proceeding) {
        Connection conn = DatabaseTool.getConn();
        String sql = "update document set Title=?,PDate=?,PublisherId=? where DocId=?";
        String sql2 = "update proceedings set location=?,cDate=? where docId=?";
        try {
            assert conn != null;
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, proceeding.getTitle());
            statement.setString(2,proceeding.getpDate());
            statement.setInt(3, proceeding.getPublishId());
            statement.setInt(4, proceeding.getDocId());
            PreparedStatement statement1 = conn.prepareStatement(sql2);
            statement1.setString(1, proceeding.getLocation());
            statement1.setString(2, proceeding.getcDate());
            statement1.setInt(3, proceeding.getDocId());
            statement.executeUpdate();
            statement1.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean delete(Integer docId) {
        Connection conn = DatabaseTool.getConn();
        String sql = "delete from document where DocId=?";
        try {
            assert conn != null;
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, docId);
            statement.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<Proceeding> list() {
        List<Proceeding> list=new ArrayList<>();
        Connection conn = DatabaseTool.getConn();
        String sql = "select document.*,location,cDate from document inner join proceedings p on document.DocId = p.docId";
        try {
            assert conn != null;
            Statement statement = conn.createStatement();
            ResultSet rs=statement.executeQuery(sql);
            while (rs.next()){
               Proceeding proceeding = new Proceeding();
                proceeding.setDocId(rs.getInt(1));
                proceeding.setTitle(rs.getString(2));
                proceeding.setpDate(rs.getString(3));
                proceeding.setPublishId(rs.getInt(4));
                proceeding.setLocation(rs.getString(5));
                proceeding.setcDate(rs.getString(6));
                list.add(proceeding);
            }
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }

    }


}
