package com.library.frame;

import com.library.pojo.Book;
import com.library.pojo.Reserve;
import com.library.service.BookService;
import com.library.service.ReserveService;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

/**
 * @author MSI-NB
 */
public class ListReserveFrame extends JInternalFrame {
    private JSpinner textField;
    private JTable table;
    private JButton jButton;
    public ListReserveFrame(){
        setIconifiable(true);
        setClosable(true);
        setTitle("reserve list");
        setSize(800,500);
        setLayout(null);
        init();
        fresh();


    }
    private void init(){

        JLabel jLabel=new JLabel("drop reserve info:");
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
        ReserveService service=new ReserveService();
        Vector<Vector> vData = new Vector<Vector>();
        Vector<String> vName = new Vector<String>();
        vName.add("reserve number");
        vName.add("date");
        vName.add("status");
        vName.add("copy number");
        vName.add("reader id");
        for (Reserve r:service.list()){
            Vector vector=new Vector();
            vector.add(r.getResNumber());
            vector.add(r.getResDate());
            vector.add(r.getResStatus());
            vector.add(r.getCopyNo());
            vector.add(r.getReaderId());
            vData.add(vector);
        }
        DefaultTableModel model = new DefaultTableModel(vData, vName);
        table.setModel(model);
    }

    private void addListener(){
        jButton.addActionListener(e -> {
            BookService service=new BookService();
            if(service.delete((Integer) textField.getValue())){
                JOptionPane.showMessageDialog(null,
                        "delete reserve info success");
                fresh();
            }else{
                JOptionPane.showMessageDialog(null,
                        "delete reserve info fail");
            }

        });

    }


}
