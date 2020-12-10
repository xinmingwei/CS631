package com.library.frame;

import com.library.pojo.Book;
import com.library.pojo.Reserve;
import com.library.service.BookService;
import com.library.service.ReserveService;

import javax.swing.*;

/**
 * @author MSI-NB
 */
public class InsertReserveFrame extends JInternalFrame {
    private JSpinner spinner;
    private JTextField textField;
    private JTextField textField2;
    private JSpinner textField3;
    private JSpinner textField4;
    private JButton jButton;
    private JButton jButton2;

    public InsertReserveFrame() {
        setIconifiable(true);
        setClosable(true);
        setTitle("add reserve information");
        setSize(800, 600);
        setLayout(null);
        init();
        addListener();
    }

    private void init() {
        JLabel jLabel = new JLabel("reserve number:");
        jLabel.setBounds(50, 50, 150, 30);
        add(jLabel);

        spinner = new JSpinner();
        spinner.setBounds(150, 50, 150, 25);
        add(spinner);

        JLabel jLabel1 = new JLabel("reserve date:");
        jLabel1.setBounds(50, 150, 150, 30);
        add(jLabel1);

        textField = new JTextField();
        textField.setBounds(150, 150, 150, 25);
        add(textField);

        JLabel jLabel2 = new JLabel("reserve status:");
        jLabel2.setBounds(50, 250, 150, 30);
        add(jLabel2);

        textField2 = new JTextField();
        textField2.setBounds(150, 250, 150, 25);
        add(textField2);

        JLabel jLabel3 = new JLabel("copy number:");
        jLabel3.setBounds(50, 350, 150, 30);
        add(jLabel3);

        textField3 = new JSpinner();
        textField3.setBounds(150, 350, 150, 25);
        add(textField3);

        JLabel jLabel4 = new JLabel("reader id:");
        jLabel4.setBounds(50, 450, 150, 30);
        add(jLabel4);

        textField4 = new JSpinner();
        textField4.setBounds(150, 450, 150, 25);
        add(textField4);


        jButton = new JButton("add");
        jButton.setBounds(400, 100, 80, 30);
        add(jButton);

        jButton2 = new JButton("clear");
        jButton2.setBounds(400, 200, 80, 30);
        add(jButton2);


        setLayout(null);

    }

    private void addListener() {
        jButton2.addActionListener(e -> {
            spinner.setValue(0);
            textField2.setText("");
            textField.setText("");
            textField3.setValue(0);
            textField4.setValue(0);
        });
        jButton.addActionListener(e -> {
            Reserve reserve=new Reserve();
            reserve.setResNumber((Integer) spinner.getValue());
            reserve.setResDate(textField.getText());
            reserve.setResStatus(textField2.getText());
            reserve.setCopyNo((Integer) textField3.getValue());
            reserve.setReaderId((Integer) textField4.getValue());
            ReserveService service = new ReserveService();
            if (service.insert(reserve)) {
                JOptionPane.showMessageDialog(null,
                        "reserve success");
            } else {
                JOptionPane.showMessageDialog(null,
                        "reserve fail");
            }
        });
    }
}
