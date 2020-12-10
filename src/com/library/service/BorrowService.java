package com.library.service;

import com.library.pojo.Book;
import com.library.pojo.Borrow;
import com.library.tool.DatabaseTool;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author MSI-NB
 */
public class BorrowService {


    public boolean insert(Borrow borrow) {
        Connection conn = DatabaseTool.getConn();
        String sql = "insert into borrows(borNumber, BorDateTime, dueDate, fineAmount, RetDateTime, ReaderId, copyNo) values(?,?,?,?,?,?,?)";
        try {
            assert conn != null;
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1,borrow.getBorrowNumber());
            statement.setString(2, borrow.getBorrowDate());
            statement.setString(3, borrow.getDueDate());
            statement.setInt(4, borrow.getFineAmount());
            statement.setString(5,borrow.getReturnDate());
            statement.setInt(6,borrow.getReaderId());
            statement.setInt(7,borrow.getCopyNumber());
            statement.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean update(Borrow borrow) {
        Connection conn = DatabaseTool.getConn();
        String sql = "update borrows set borNumber=?,BorDateTime=?,dueDate=?,fineAmount=?,RetDateTime=?,ReaderId=?,copyNo=? where borNumber=?";
        try {
            assert conn != null;
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1,borrow.getBorrowNumber());
            statement.setString(2, borrow.getBorrowDate());
            statement.setString(3, borrow.getDueDate());
            statement.setInt(4, borrow.getFineAmount());
            statement.setString(5,borrow.getReturnDate());
            statement.setInt(6,borrow.getReaderId());
            statement.setInt(7,borrow.getCopyNumber());
            statement.setInt(8,borrow.getBorrowNumber());
            statement.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean delete(Integer borNumber) {
        Connection conn = DatabaseTool.getConn();
        String sql = "delete from borrows where borNumber=?";
        try {
            assert conn != null;
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, borNumber);
            statement.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<Borrow> list() {
        List<Borrow> list=new ArrayList<>();
        Connection conn = DatabaseTool.getConn();
        String sql = "select * from borrows";
        try {
            assert conn != null;
            Statement statement = conn.createStatement();
            ResultSet rs=statement.executeQuery(sql);
            while (rs.next()){
                Borrow borrow=new Borrow();
                borrow.setBorrowNumber(rs.getInt(1));
                borrow.setBorrowDate(rs.getString(2));
                borrow.setDueDate(rs.getString(3));
                borrow.setFineAmount(rs.getInt(4));
                borrow.setReturnDate(rs.getString(5));
                borrow.setReaderId(rs.getInt(6));
                borrow.setCopyNumber(rs.getInt(7));
                list.add(borrow);
            }
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }

    }


}
