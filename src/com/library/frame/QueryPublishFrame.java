package com.library.frame;

import com.library.tool.DatabaseTool;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

/**
 * @author MSI-NB
 */
public class QueryPublishFrame extends JInternalFrame {
    private JSpinner textField;
    private JTable table;
    private JButton jButton;
    public QueryPublishFrame(){
        setIconifiable(true);
        setClosable(true);
        setTitle("Query publish list");
        setSize(800,500);
        setLayout(null);
        init();
        fresh();


    }
    private void init(){

        JLabel jLabel=new JLabel("publish id:");
        jLabel.setBounds(20,50,200,30);
        add(jLabel);

        textField=new JSpinner();
        textField.setBounds(180,50,150,30);
        add(textField);

        jButton=new JButton("query");
        jButton.setBounds(350,50,100,30);
        add(jButton);
        addListener();



        table = new JTable();
        table.setBounds(0,100,800,400);
        add(table);

        JScrollPane scroll = new JScrollPane(table);
        scroll.setSize(800, 400);
        scroll.setLocation(0, 100);
        add(scroll);

    }

    public void fresh(){


        Connection connection= DatabaseTool.getConn();

        Vector<Vector> vData = new Vector<Vector>();
        Vector<String> vName = new Vector<String>();
        vName.add("Document Id");
        vName.add("Document Title");
        vName.add("Publish date");
        try {
            String sql="select docId,Title,PDate from document where PublisherId=?";
            assert connection != null;
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, (Integer) textField.getValue());
            ResultSet rs=statement.executeQuery();
            while (rs.next()){
                Vector vector=new Vector();
                vector.add(rs.getInt(1));
                vector.add(rs.getString(2));
                vector.add(rs.getString(3));
                vData.add(vector);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }


        DefaultTableModel model = new DefaultTableModel(vData, vName);
        table.setModel(model);
    }

    private void addListener(){
        jButton.addActionListener(e -> {
            fresh();
        });

    }


}
