package com.library;

import com.library.frame.LibraryApp;
import com.library.tool.DatabaseTool;
import com.mysql.cj.log.Log;
import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginFrame extends JFrame {
    private JTextField usernameTxt;
    private JPasswordField passwordTxt;
    private JRadioButton radioButton1;
    private JRadioButton radioButton2;
    private JButton clearBtn;
    private JButton loginBtn;


    public LoginFrame() {
        setTitle("LibraryManagement");
        setSize(500, 400);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setBounds((Toolkit.getDefaultToolkit().getScreenSize().width - this.getWidth()) / 2,
                (Toolkit.getDefaultToolkit().getScreenSize().height - this.getHeight()) / 2,
                this.getWidth(), this.getHeight());
        init();
        addListener();

    }

    private void init() {


        JLabel jLabel = new JLabel("username:");
        jLabel.setBounds(20, 50, 120, 30);
        add(jLabel);
        usernameTxt = new JTextField();
        usernameTxt.setBounds(100, 50, 200, 30);
        add(usernameTxt);
        JLabel jLabel1 = new JLabel("password:");
        jLabel1.setBounds(20, 100, 120, 30);
        add(jLabel1);
        passwordTxt = new JPasswordField();
        passwordTxt.setBounds(100, 100, 200, 30);
        add(passwordTxt);
        radioButton1 = new JRadioButton("manager");
        radioButton1.setBounds(50, 200, 100, 30);
        add(radioButton1);
        radioButton2 = new JRadioButton("reader");
        radioButton2.setBounds(250, 200, 100, 30);
        add(radioButton2);
        clearBtn = new JButton("clear");
        clearBtn.setBounds(50, 300, 100, 30);
        add(clearBtn);
        loginBtn = new JButton("login");
        loginBtn.setBounds(200, 300, 100, 30);
        radioButton1.setSelected(true);
        add(loginBtn);
        setLayout(null);
    }

    private void addListener() {
        clearBtn.addActionListener(e -> {
            passwordTxt.setText("");
            usernameTxt.setText("");

        });
        radioButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (radioButton1.isSelected()) {
                    radioButton2.setSelected(false);
                }
            }
        });
        radioButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (radioButton2.isSelected()) {
                    radioButton1.setSelected(false);
                }
            }
        });
        loginBtn.addActionListener(e -> {
            Connection conn= DatabaseTool.getConn();
            assert conn!=null;
            if (radioButton1.isSelected()){
                String sql="select * from manager where username=? and password=?";
                try {
                    PreparedStatement statement=conn.prepareStatement(sql);
                    statement.setString(1,usernameTxt.getText());
                    statement.setString(2, String.valueOf(passwordTxt.getPassword()));
                    ResultSet rs=statement.executeQuery();
                    if (rs.first()){
                        LibraryApp libraryApp=new LibraryApp();
                        libraryApp.init();
                        libraryApp.setVisible(true);
                        setVisible(false);
                    }
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }else{
                String sql="select *  from reader where readerName=? and password=?";
                try {
                    PreparedStatement statement=conn.prepareStatement(sql);
                    statement.setString(1,usernameTxt.getText());
                    statement.setString(2, String.valueOf(passwordTxt.getPassword()));
                    ResultSet rs=statement.executeQuery();
                    if (rs.first()){
                        LibraryApp libraryApp=new LibraryApp();
                        libraryApp.readerInit();
                        libraryApp.setVisible(true);
                        setVisible(false);
                    }
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        });
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(new org.jvnet.substance.skin.SubstanceMistSilverLookAndFeel());
                } catch (Exception e) {
                    e.printStackTrace();
                }
                JFrame.setDefaultLookAndFeelDecorated(true);
                JDialog.setDefaultLookAndFeelDecorated(true);
                LoginFrame frame = new LoginFrame();
                frame.setVisible(true);

            }
        });
    }


}
