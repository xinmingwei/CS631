package com.library.frame;

import com.library.pojo.Book;
import com.library.pojo.Proceeding;
import com.library.service.BookService;
import com.library.service.ProceedingService;

import javax.swing.*;

/**
 * @author MSI-NB
 */
public class InsertProceedingsFrame extends JInternalFrame {
    private JSpinner spinner;
    private JTextField textField;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;
    private JTextField textField5;
    private JButton jButton;
    private JButton jButton2;

    public InsertProceedingsFrame() {
        setIconifiable(true);
        setClosable(true);
        setTitle("append proceeding information");
        setSize(800, 670);
        setLayout(null);
        init();
        addListener();
    }

    private void init() {
        JLabel jLabel = new JLabel("document id:");
        jLabel.setBounds(50, 50, 150, 30);
        add(jLabel);

        spinner = new JSpinner();
        spinner.setBounds(150, 50, 150, 25);
        add(spinner);

        JLabel jLabel1 = new JLabel("title:");
        jLabel1.setBounds(50, 150, 150, 30);
        add(jLabel1);

        textField = new JTextField();
        textField.setBounds(150, 150, 150, 25);
        add(textField);

        JLabel jLabel2 = new JLabel("publish date:");
        jLabel2.setBounds(50, 250, 150, 30);
        add(jLabel2);

        textField2 = new JTextField();
        textField2.setBounds(150, 250, 150, 25);
        add(textField2);

        JLabel jLabel3 = new JLabel("publisher Id:");
        jLabel3.setBounds(50, 350, 150, 30);
        add(jLabel3);

        textField3 = new JTextField();
        textField3.setBounds(150, 350, 150, 25);
        add(textField3);

        JLabel jLabel4 = new JLabel("location:");
        jLabel4.setBounds(50, 450, 150, 30);
        add(jLabel4);

        textField4 = new JTextField();
        textField4.setBounds(150, 450, 150, 25);
        add(textField4);

        JLabel jLabel5 = new JLabel("create date:");
        jLabel5.setBounds(50, 550, 150, 30);
        add(jLabel5);

        textField5 = new JTextField();
        textField5.setBounds(150, 550, 150, 25);
        add(textField5);


        jButton = new JButton("append");
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
            textField3.setText("");
            textField4.setText("");
            textField5.setText("");
        });
        jButton.addActionListener(e -> {
            Proceeding proceeding = new Proceeding();
            proceeding.setDocId((Integer) spinner.getValue());
            proceeding.setTitle(textField.getText());
            proceeding.setpDate(textField2.getText());
            proceeding.setPublishId(Integer.parseInt(textField3.getText()));
            proceeding.setLocation(textField4.getText());
            proceeding.setcDate(textField5.getText());
            ProceedingService service = new ProceedingService();
            if (service.insert(proceeding)) {
                JOptionPane.showMessageDialog(null,
                        "append proceeding success");
            } else {
                JOptionPane.showMessageDialog(null,
                        "append proceeding fail");
            }
        });
    }
}
