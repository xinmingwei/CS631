package com.library.frame;

import com.library.pojo.Branch;
import com.library.service.BranchService;

import javax.swing.*;

/**
 * @author MSI-NB
 */
public class UpdateBranchFrame extends JInternalFrame {
    private JSpinner spinner;
    private JTextField textField;
    private JTextField textField2;
    private JButton jButton;
    private JButton jButton2;
    public UpdateBranchFrame(){
        setIconifiable(true);
        setClosable(true);
        setTitle("branch info update");
        setSize(800,400);
        setLayout(null);
        init();
        addListener();
    }

    private void init(){
        JLabel jLabel=new JLabel("branch id:");
        jLabel.setBounds(50,50,150,30);
        add(jLabel);

        spinner=new JSpinner();
        spinner.setBounds(150,50,150,25);
        add(spinner);

        JLabel jLabel1=new JLabel("branch name:");
        jLabel1.setBounds(50,150,150,30);
        add(jLabel1);

        textField= new JTextField();
        textField.setBounds(150,150,150,25);
        add(textField);

        JLabel jLabel2=new JLabel("branch location:");
        jLabel2.setBounds(50,250,150,30);
        add(jLabel2);

        textField2=new JTextField();
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
            textField2.setText("");
            textField.setText("");
        });
        jButton.addActionListener(e -> {
            Branch branch=new Branch();
            branch.setBid((Integer) spinner.getValue());
            branch.setName(textField.getText());
            branch.setLocation(textField2.getText());
            BranchService service=new BranchService();
            if(service.update(branch)){
                JOptionPane.showMessageDialog(null,
                        "update branch success");
            }else{
                JOptionPane.showMessageDialog(null,
                        "update branch fail");
            }
        });
    }
}
