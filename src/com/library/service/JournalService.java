package com.library.service;

import com.library.pojo.Book;
import com.library.pojo.Journal;
import com.library.tool.DatabaseTool;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author MSI-NB
 */
public class JournalService {


    public boolean insert(Journal journal) {
        Connection conn = DatabaseTool.getConn();
        String sql = "insert into document(docid, title, pdate, publisherid) values(?,?,?,?)";
        String sql2 = "insert into journal_volumn(docId, volumeNo) VALUE (?,?)";
        String sql3="insert into journal_issue(volumnno, issueno, scope) VALUES (?,?,?)";
        try {
            assert conn != null;
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1,journal.getDocId());
            statement.setString(2, journal.getTitle());
            statement.setString(3, journal.getpDate());
            statement.setInt(4, journal.getPublishId());
            PreparedStatement statement1 = conn.prepareStatement(sql2);
            statement1.setInt(1,journal.getDocId());
            statement1.setInt(2, journal.getVolumeNo());
            PreparedStatement statement2 = conn.prepareStatement(sql3);
            statement2.setInt(1,journal.getVolumeNo());
            statement2.setInt(2,journal.getIssieNo());
            statement2.setString(3,journal.getScope());
            statement.executeUpdate();
            statement1.executeUpdate();
            statement2.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean update(Journal journal) {
        Connection conn = DatabaseTool.getConn();
        String sql = "update document set Title=?,PDate=?,PublisherId=? where DocId=?";
        String sql2 = "update journal_volumn set docId=?,volumeNo=? where docId=?";
        String sql3="update journal_issue set VolumnNo=?,IssueNo=?,Scope=? where IssueNo=?";
        try {
            assert conn != null;
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, journal.getTitle());
            statement.setString(2, journal.getpDate());
            statement.setInt(3, journal.getPublishId());
            statement.setInt(4, journal.getDocId());
            PreparedStatement statement1 = conn.prepareStatement(sql2);
            statement1.setInt(1, journal.getDocId());
            statement1.setInt(2, journal.getVolumeNo());
            statement1.setInt(3, journal.getDocId());
            PreparedStatement statement2 = conn.prepareStatement(sql3);
            statement2.setInt(1,journal.getVolumeNo());
            statement2.setInt(2,journal.getIssieNo());
            statement2.setInt(3,journal.getIssieNo());
            statement2.setInt(4,journal.getVolumeNo());
            statement.executeUpdate();
            statement1.executeUpdate();
            statement2.executeUpdate();
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

    public List<Journal> list() {
        List<Journal> list=new ArrayList<>();
        Connection conn = DatabaseTool.getConn();
        String sql = "select document.docid, title, pdate, publisherid, author,ji.* from document inner join journal_volumn jv on document.DocId = jv.docId inner  join journal_issue ji on jv.volumeNo = ji.VolumnNo";
        try {
            assert conn != null;
            Statement statement = conn.createStatement();
            ResultSet rs=statement.executeQuery(sql);
            while (rs.next()){
                Journal journal=new Journal();
                journal.setDocId(rs.getInt(1));
                journal.setTitle(rs.getString(2));
                journal.setpDate(rs.getString(3));
                journal.setPublishId(rs.getInt(4));
                journal.setAuthor(rs.getString(5));
                journal.setVolumeNo(rs.getInt(6));
                journal.setIssieNo(rs.getInt(7));
                journal.setScope(rs.getString(8));
                list.add(journal);

            }
            return list;

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }

    }


}
