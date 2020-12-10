package com.library.service;

import com.library.pojo.Reader;
import com.library.pojo.Reserve;
import com.library.tool.DatabaseTool;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author MSI-NB
 */
public class ReserveService {
    public boolean insert(Reserve reserve) {
        Connection conn = DatabaseTool.getConn();
        String sql = "insert into reserves(resNumber, resDateTime, resStatus, copyNo, readerId) VALUES (?,?,?,?,?)";
        try {
            assert conn != null;
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, reserve.getResNumber());
            statement.setString(2, reserve.getResDate());
            statement.setString(3, reserve.getResStatus());
            statement.setInt(4, reserve.getCopyNo());
            statement.setInt(5, reserve.getReaderId());
            statement.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean update(Reserve reserve) {
        Connection conn = DatabaseTool.getConn();
        String sql = "update reserves set resNumber=?,resDateTime=?,resStatus=?,copyNo=?,readerId=? where resNumber=?";
        try {
            assert conn != null;
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, reserve.getResNumber());
            statement.setString(2, reserve.getResDate());
            statement.setString(3, reserve.getResStatus());
            statement.setInt(4, reserve.getCopyNo());
            statement.setInt(5, reserve.getReaderId());
            statement.setInt(6, reserve.getResNumber());
            statement.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean delete(Integer resNumber) {
        Connection conn = DatabaseTool.getConn();
        String sql = "delete from reserves where resNumber=?";
        try {
            assert conn != null;
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, resNumber);
            statement.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<Reserve> list() {
        List<Reserve> list = new ArrayList<>();
        Connection conn = DatabaseTool.getConn();
        String sql = "select * from reserves";
        try {
            assert conn != null;
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                Reserve reserve = new Reserve();
                reserve.setResNumber(rs.getInt(1));
                reserve.setResDate(rs.getString(2));
                reserve.setResStatus(rs.getString(3));
                reserve.setCopyNo(rs.getInt(4));
                reserve.setReaderId(rs.getInt(5));
                list.add(reserve);
            }
            return list;

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }

    }
}
