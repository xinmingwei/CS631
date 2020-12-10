package com.library.frame;

import com.library.pojo.Copy;
import com.library.pojo.Publisher;
import com.library.service.CopyService;
import com.library.service.PublisherService;

import javax.swing.*;

/**
 * @author MSI-NB
 */
public class InsertCopyFrame extends JInternalFrame {
    private JSpinner spinner;
    private JTextField textField;
    private JSpinner textField2;
    private JButton jButton;
    private JButton jButton2;
    public InsertCopyFrame(){
        setIconifiable(true);
        setClosable(true);
        setTitle("insert copy info");
        setSize(800,400);
        setLayout(null);
        init();
        addListener();
    }

    private void init(){
        JLabel jLabel=new JLabel("copy number:");
        jLabel.setBounds(50,50,150,30);
        add(jLabel);

        spinner=new JSpinner();
        spinner.setBounds(150,50,150,25);
        add(spinner);

        JLabel jLabel1=new JLabel("position:");
        jLabel1.setBounds(50,150,150,30);
        add(jLabel1);

        textField= new JTextField();
        textField.setBounds(150,150,150,25);
        add(textField);

        JLabel jLabel2=new JLabel("document id:");
        jLabel2.setBounds(50,250,150,30);
        add(jLabel2);

        textField2=new JSpinner();
        textField2.setBounds(150,250,150,25);
        add(textField2);

        jButton=new JButton("add");
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
            textField2.setValue(0);
            textField.setText("");
        });
        jButton.addActionListener(e -> {
            Copy copy=new Copy();
            copy.setCopyNo((Integer)spinner.getValue());
            copy.setDocId((Integer)textField2.getValue());
            copy.setPosition(textField.getText());
            CopyService service=new CopyService();
            if(service.insert(copy)){
                JOptionPane.showMessageDialog(null,
                        "insert copy info success");
            }else{
                JOptionPane.showMessageDialog(null,
                        "insert copy info fail");
            }
        });
    }
}
