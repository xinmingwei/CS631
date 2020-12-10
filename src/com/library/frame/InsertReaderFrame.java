package com.library.frame;

import com.library.pojo.Reader;
import com.library.service.ReaderService;

import javax.swing.*;

/**
 * @author MSI-NB
 */
public class InsertReaderFrame extends JInternalFrame {
    private JSpinner spinner;
    private JTextField textField;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;
    private JButton jButton;
    private JButton jButton2;
    public InsertReaderFrame(){
        setIconifiable(true);
        setClosable(true);
        setTitle("reader register");
        setSize(800,600);
        setLayout(null);
        init();
        addListener();
    }

    private void init(){
        JLabel jLabel=new JLabel("reader id:");
        jLabel.setBounds(50,50,150,30);
        add(jLabel);

        spinner=new JSpinner();
        spinner.setBounds(150,50,150,25);
        add(spinner);

        JLabel jLabel1=new JLabel("reader name:");
        jLabel1.setBounds(50,150,150,30);
        add(jLabel1);

        textField= new JTextField();
        textField.setBounds(150,150,150,25);
        add(textField);

        JLabel jLabel2=new JLabel("type:");
        jLabel2.setBounds(50,250,150,30);
        add(jLabel2);

        textField2=new JTextField();
        textField2.setBounds(150,250,150,25);
        add(textField2);

        JLabel jLabel3=new JLabel("phone number:");
        jLabel3.setBounds(50,350,150,30);
        add(jLabel3);

        textField3=new JTextField();
        textField3.setBounds(150,350,150,25);
        add(textField3);

        JLabel jLabel4=new JLabel("address:");
        jLabel4.setBounds(50,450,150,30);
        add(jLabel4);

        textField4=new JTextField();
        textField4.setBounds(150,450,150,25);
        add(textField4);


        jButton=new JButton("append");
        jButton.setBounds(400,100,80,30);
        add(jButton);

        jButton2=new JButton("clear");
        jButton2.setBounds(400,200,80,30);
        add(jButton2);


        setLayout(null);

    }

    private void addListener(){
        jButton2.addActionListener(e -> {
            spinner.setValue(0);
            textField2.setText("");
            textField.setText("");
            textField3.setText("");
            textField4.setText("");
        });
        jButton.addActionListener(e -> {
            Reader reader=new Reader();
            reader.setReaderId((Integer) spinner.getValue());
            reader.setReaderName(textField.getText());
            reader.setType(textField2.getText());
            reader.setPhoneNo(textField3.getText());
            reader.setAddress(textField4.getText());
            ReaderService service=new ReaderService();
            if(service.insert(reader)){
                JOptionPane.showMessageDialog(null,
                        "register reader success");
            }else{
                JOptionPane.showMessageDialog(null,
                        "register reader fail");
            }
        });
    }
}
