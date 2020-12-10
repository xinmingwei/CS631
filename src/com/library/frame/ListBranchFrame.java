package com.library.frame;

import com.library.pojo.Branch;
import com.library.pojo.Publisher;
import com.library.service.BranchService;
import com.library.service.PublisherService;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.List;
import java.util.Vector;

/**
 * @author MSI-NB
 */
public class ListBranchFrame extends JInternalFrame {
    private JSpinner textField;
    private JTable table;
    private JButton jButton;
    public ListBranchFrame(){
        setIconifiable(true);
        setClosable(true);
        setTitle("branch list");
        setSize(800,500);
        setLayout(null);
        init();
        fresh();


    }
    private void init(){

        JLabel jLabel=new JLabel("drop branch info:");
        jLabel.setBounds(20,50,200,30);
        add(jLabel);

        textField=new JSpinner();
        textField.setBounds(180,50,150,30);
        add(textField);

        jButton=new JButton("delete");
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
        BranchService service=new BranchService();
        List<Branch> list =service.list();
        Vector<Vector> vData = new Vector<Vector>();
        Vector<String> vName = new Vector<String>();
        vName.add("branch id");
        vName.add("branch Name");
        vName.add("location");
        for (Branch b:list){
            Vector vector=new Vector();
            vector.add(b.getBid());
            vector.add(b.getName());
            vector.add(b.getLocation());
            vData.add(vector);
        }
        DefaultTableModel model = new DefaultTableModel(vData, vName);
        table.setModel(model);
    }

    private void addListener(){
        jButton.addActionListener(e -> {
            BranchService service = new BranchService();
            if(service.delete((Integer) textField.getValue())){
                JOptionPane.showMessageDialog(null,
                        "delete branch success");
                fresh();
            }else{
                JOptionPane.showMessageDialog(null,
                        "delete branch fail");
            }

        });

    }


}
