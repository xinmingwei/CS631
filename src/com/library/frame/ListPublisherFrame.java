package com.library.frame;

import com.library.pojo.Publisher;
import com.library.service.PublisherService;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.List;
import java.util.Vector;

/**
 * @author MSI-NB
 */
public class ListPublisherFrame extends JInternalFrame {
    private JSpinner textField;
    private JTable table;
    private JButton jButton;
    public ListPublisherFrame(){
        setIconifiable(true);
        setClosable(true);
        setTitle("publisher list");
        setSize(800,500);
        setLayout(null);
        init();
        fresh();


    }
    private void init(){

        JLabel jLabel=new JLabel("drop publisher info:");
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
        PublisherService service=new PublisherService();
        List<Publisher> list =service.list();

        Vector<Vector> vData = new Vector<Vector>();
        Vector<String> vName = new Vector<String>();
        vName.add("Publisher ID");
        vName.add("Publisher Name");
        vName.add("Address");
        for (Publisher p:list){
            Vector vector=new Vector();
            vector.add(p.getPublisherId());
            vector.add(p.getPubName());
            vector.add(p.getAddress());
            vData.add(vector);
        }
        DefaultTableModel model = new DefaultTableModel(vData, vName);
        table.setModel(model);
    }

    private void addListener(){
        jButton.addActionListener(e -> {
            PublisherService service = new PublisherService();
            if(service.delete((Integer) textField.getValue())){
                JOptionPane.showMessageDialog(null,
                        "delete publisher success");
                fresh();
            }else{
                JOptionPane.showMessageDialog(null,
                        "delete publisher fail");
            }

        });

    }


}
