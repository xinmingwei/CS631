package com.library.service;

import com.library.pojo.Copy;
import com.library.pojo.Publisher;
import com.library.tool.DatabaseTool;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author MSI-NB
 */
public class CopyService {
    public boolean insert(Copy copy) {
        Connection conn = DatabaseTool.getConn();
        String sql = "insert into copy(copyNo, position, docId)values(?,?,?)";
        try {
            assert conn != null;
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, copy.getCopyNo());
            statement.setString(2, copy.getPosition());
            statement.setInt(3, copy.getDocId());
            statement.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean update(Copy copy) {
        Connection conn = DatabaseTool.getConn();
        String sql = "update copy set copyNo=?,position=?,docId=? where copyNo=?";
        try {
            assert conn != null;
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, copy.getCopyNo());
            statement.setString(2, copy.getPosition());
            statement.setInt(3, copy.getDocId());
            statement.setInt(4, copy.getCopyNo());
            statement.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean delete(Integer copyNo) {
        Connection conn = DatabaseTool.getConn();
        String sql = "delete from copy where copyNo=?";
        try {
            assert conn != null;
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, copyNo);
            statement.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<Copy> list() {
        List<Copy> list = new ArrayList<>();
        Connection conn = DatabaseTool.getConn();
        String sql = "select * from copy";
        try {
            assert conn != null;
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                Copy copy = new Copy();
                copy.setCopyNo(rs.getInt(1));
                copy.setPosition(rs.getString(2));
                copy.setDocId(rs.getInt(3));
                list.add(copy);
            }
            return list;

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }

    }
}
