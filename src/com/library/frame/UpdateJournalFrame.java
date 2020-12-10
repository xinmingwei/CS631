package com.library.frame;

import com.library.pojo.Journal;
import com.library.service.JournalService;

import javax.swing.*;

/**
 * @author MSI-NB
 */
public class UpdateJournalFrame extends JInternalFrame {
    private JSpinner spinner;
    private JTextField textField;
    private JTextField textField2;
    private JSpinner textField3;
    private JSpinner textField4;
    private JSpinner textField5;
    private JTextField textField6;
    private JButton jButton;
    private JButton jButton2;

    public UpdateJournalFrame() {
        setIconifiable(true);
        setClosable(true);
        setTitle("update journal information");
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

        textField3 = new JSpinner();
        textField3.setBounds(150, 350, 150, 25);
        add(textField3);

        JLabel jLabel4 = new JLabel("volume no:");
        jLabel4.setBounds(50, 450, 150, 30);
        add(jLabel4);

        textField4 = new JSpinner();
        textField4.setBounds(150, 450, 150, 25);
        add(textField4);

        JLabel jLabel5 = new JLabel("issue no:");
        jLabel5.setBounds(50, 550, 150, 30);
        add(jLabel5);

        textField5 = new JSpinner();
        textField5.setBounds(150, 550, 150, 25);
        add(textField5);

        JLabel jLabel6 = new JLabel("scope:");
        jLabel6.setBounds(350, 550, 150, 30);
        add(jLabel6);

        textField6 = new JTextField();
        textField6.setBounds(450, 550, 150, 25);
        add(textField6);


        jButton = new JButton("update");
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
            textField5.setValue(0);
            textField6.setText("");
        });
        jButton.addActionListener(e -> {
            Journal journal =new Journal();
            journal.setDocId((Integer) spinner.getValue());
            journal.setTitle(textField.getText());
            journal.setpDate(textField2.getText());
            journal.setPublishId((Integer) textField3.getValue());
            journal.setVolumeNo((Integer) textField4.getValue());
            journal.setIssieNo((Integer) textField5.getValue());
            journal.setScope(textField6.getText());
            JournalService service = new JournalService();
            if (service.update(journal)) {
                JOptionPane.showMessageDialog(null,
                        "update journal info success");
            } else {
                JOptionPane.showMessageDialog(null,
                        "update journal info fail");
            }
        });
    }
}
