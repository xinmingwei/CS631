package com.library.service;

import com.library.pojo.Branch;
import com.library.pojo.Publisher;
import com.library.tool.DatabaseTool;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author MSI-NB
 */
public class BranchService {
    public boolean insert(Branch branch) {
        Connection conn = DatabaseTool.getConn();
        String sql = "insert into branch(bid, name, location) values(?,?,?)";
        try {
            assert conn != null;
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, branch.getBid());
            statement.setString(2, branch.getName());
            statement.setString(3, branch.getLocation());
            statement.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean update(Branch branch) {
        Connection conn = DatabaseTool.getConn();
        String sql = "update branch set bid=?,name=?,location=? where bid=?";
        try {
            assert conn != null;
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, branch.getBid());
            statement.setString(2, branch.getName());
            statement.setString(3, branch.getLocation());
            statement.setInt(4, branch.getBid());
            statement.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean delete(Integer branchId) {
        Connection conn = DatabaseTool.getConn();
        String sql = "delete from branch where bid=?";
        try {
            assert conn != null;
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, branchId);
            statement.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<Branch> list() {
        List<Branch> list = new ArrayList<>();
        Connection conn = DatabaseTool.getConn();
        String sql = "select * from branch";
        try {
            assert conn != null;
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                Branch branch = new Branch();
                branch.setBid(rs.getInt(1));
                branch.setName(rs.getString(2));
                branch.setLocation(rs.getString(3));
                list.add(branch);
            }
            return list;

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }

    }
}
