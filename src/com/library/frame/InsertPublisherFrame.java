package com.library.frame;

import com.library.pojo.Publisher;
import com.library.service.PublisherService;

import javax.swing.*;

/**
 * @author MSI-NB
 */
public class InsertPublisherFrame extends JInternalFrame {
    private JSpinner spinner;
    private JTextField textField;
    private JTextField textField2;
    private JButton jButton;
    private JButton jButton2;
    public InsertPublisherFrame(){
        setIconifiable(true);
        setClosable(true);
        setTitle("publisher register");
        setSize(800,400);
        setLayout(null);
        init();
        addListener();
    }

    private void init(){
        JLabel jLabel=new JLabel("publisher id:");
        jLabel.setBounds(50,50,150,30);
        add(jLabel);

        spinner=new JSpinner();
        spinner.setBounds(150,50,150,25);
        add(spinner);

        JLabel jLabel1=new JLabel("publisher name:");
        jLabel1.setBounds(50,150,150,30);
        add(jLabel1);

        textField= new JTextField();
        textField.setBounds(150,150,150,25);
        add(textField);

        JLabel jLabel2=new JLabel("publisher address:");
        jLabel2.setBounds(50,250,150,30);
        add(jLabel2);

        textField2=new JTextField();
        textField2.setBounds(150,250,150,25);
        add(textField2);

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
        });
        jButton.addActionListener(e -> {
            Publisher publisher=new Publisher();
            publisher.setAddress(textField2.getText());
            publisher.setPubName(textField.getText());
            publisher.setPublisherId((Integer) spinner.getValue());
            PublisherService publisherService=new PublisherService();
            if(publisherService.insert(publisher)){
                JOptionPane.showMessageDialog(null,
                        "register publisher success");
            }else{
                JOptionPane.showMessageDialog(null,
                        "register publisher fail");
            }
        });
    }
}
