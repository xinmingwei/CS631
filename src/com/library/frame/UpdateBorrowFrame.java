package com.library.frame;

import com.library.pojo.Borrow;
import com.library.service.BorrowService;

import javax.swing.*;

/**
 * @author MSI-NB
 */
public class UpdateBorrowFrame extends JInternalFrame {
    private JSpinner spinner;
    private JTextField textField;
    private JTextField textField2;
    private JSpinner textField3;
    private JTextField textField4;
    private JSpinner textField5;
    private JSpinner textField6;
    private JButton jButton;
    private JButton jButton2;

    public UpdateBorrowFrame() {
        setIconifiable(true);
        setClosable(true);
        setTitle("update borrow information");
        setSize(800, 670);
        setLayout(null);
        init();
        addListener();
    }

    private void init() {
        JLabel jLabel = new JLabel("borrow number:");
        jLabel.setBounds(50, 50, 150, 30);
        add(jLabel);

        spinner = new JSpinner();
        spinner.setBounds(150, 50, 150, 25);
        add(spinner);

        JLabel jLabel1 = new JLabel("borrow date:");
        jLabel1.setBounds(50, 150, 150, 30);
        add(jLabel1);

        textField = new JTextField();
        textField.setBounds(150, 150, 150, 25);
        add(textField);

        JLabel jLabel2 = new JLabel("due date:");
        jLabel2.setBounds(50, 250, 150, 30);
        add(jLabel2);

        textField2 = new JTextField();
        textField2.setBounds(150, 250, 150, 25);
        add(textField2);

        JLabel jLabel3 = new JLabel("fine amount:");
        jLabel3.setBounds(50, 350, 150, 30);
        add(jLabel3);

        textField3 = new JSpinner();
        textField3.setBounds(150, 350, 150, 25);
        add(textField3);

        JLabel jLabel4 = new JLabel("return date:");
        jLabel4.setBounds(50, 450, 150, 30);
        add(jLabel4);

        textField4 = new JTextField();
        textField4.setBounds(150, 450, 150, 25);
        add(textField4);

        JLabel jLabel5 = new JLabel("reader id:");
        jLabel5.setBounds(50, 550, 150, 30);
        add(jLabel5);

        textField5 = new JSpinner();
        textField5.setBounds(150, 550, 150, 25);
        add(textField5);

        JLabel jLabel6 = new JLabel("copy number:");
        jLabel6.setBounds(350, 550, 150, 30);
        add(jLabel6);

        textField6 = new JSpinner();
        textField6.setBounds(450, 550, 150, 25);
        add(textField6);

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
            textField4.setText("");
            textField5.setValue(0);
            textField6.setValue(0);
        });
        jButton.addActionListener(e -> {
            BorrowService service = new BorrowService();
            Borrow borrow = new Borrow();
            borrow.setBorrowNumber((Integer) spinner.getValue());
            borrow.setBorrowDate(textField.getText());
            borrow.setDueDate(textField.getText());
            borrow.setFineAmount((Integer) textField3.getValue());
            borrow.setReturnDate(textField4.getText());
            borrow.setReaderId((Integer) textField5.getValue());
            borrow.setCopyNumber((Integer) textField6.getValue());
            if (service.update(borrow)) {
                JOptionPane.showMessageDialog(null,
                        "update borrow info success");
            } else {
                JOptionPane.showMessageDialog(null,
                        "update borrow info fail");
            }
        });
    }
}
