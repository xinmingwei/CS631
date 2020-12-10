package com.library.service;

import com.library.pojo.Book;
import com.library.tool.DatabaseTool;
import com.mysql.cj.x.protobuf.MysqlxDatatypes;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author MSI-NB
 */
public class BookService {


    public boolean insert(Book book) {
        Connection conn = DatabaseTool.getConn();
        String sql = "insert into document(docid, title, pdate, publisherid,author) values(?,?,?,?,?)";
        String sql2 = "insert into book(docid, isbn) VALUE (?,?)";
        try {
            assert conn != null;
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, book.getDocId());
            statement.setString(2, book.getTitle());
            statement.setString(3, book.getpDate());
            statement.setInt(4, book.getPublishId());
            statement.setString(5,book.getAuthor());
            PreparedStatement statement1 = conn.prepareStatement(sql2);
            statement1.setInt(1, book.getDocId());
            statement1.setString(2, book.getIsbn());
            statement.executeUpdate();
            statement1.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean update(Book book) {
        Connection conn = DatabaseTool.getConn();
        String sql = "update document set Title=?,PDate=?,PublisherId=?,author=? where DocId=?";
        String sql2 = "update book set ISBN=? where DocId=?";
        try {
            assert conn != null;
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, book.getTitle());
            statement.setString(2, book.getpDate());
            statement.setInt(3, book.getPublishId());
            statement.setString(4,book.getAuthor());
            statement.setInt(5, book.getDocId());
            PreparedStatement statement1 = conn.prepareStatement(sql2);
            statement1.setString(1, book.getIsbn());
            statement1.setInt(2, book.getDocId());
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

    public List<Book> list() {
        List<Book> list=new ArrayList<>();
        Connection conn = DatabaseTool.getConn();
        String sql = "select document.DocId, Title, PDate, PublisherId, author,ISBN from document inner join book b on document.DocId = b.DocId";
        try {
            assert conn != null;
            Statement statement = conn.createStatement();
            ResultSet rs=statement.executeQuery(sql);
            while (rs.next()){
                Book book=new Book();
                book.setDocId(rs.getInt(1));
                book.setTitle(rs.getString(2));
                book.setpDate(rs.getString(3));
                book.setPublishId(rs.getInt(4));
                book.setAuthor(rs.getString(5));
                book.setIsbn(rs.getString(6));
                list.add(book);
            }
            return list;

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }

    }


}
