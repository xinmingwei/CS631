package com.library.frame;

import com.library.pojo.Copy;
import com.library.pojo.Person;
import com.library.service.CopyService;
import com.library.service.PersonService;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.List;
import java.util.Vector;

/**
 * @author MSI-NB
 */
public class ListCopyFrame extends JInternalFrame {
    private JSpinner textField;
    private JTable table;
    private JButton jButton;
    public ListCopyFrame(){
        setIconifiable(true);
        setClosable(true);
        setTitle("copy list");
        setSize(800,500);
        setLayout(null);
        init();
        fresh();


    }
    private void init(){

        JLabel jLabel=new JLabel("drop copy info:");
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
        CopyService service=new CopyService();
        List<Copy> list =service.list();

        Vector<Vector> vData = new Vector<Vector>();
        Vector<String> vName = new Vector<String>();
        vName.add("Copy Number");
        vName.add("position");
        vName.add("Document Number");
        for (Copy c:list){
            Vector vector=new Vector();
            vector.add(c.getCopyNo());
            vector.add(c.getPosition());
            vector.add(c.getDocId());
            vData.add(vector);
        }
        DefaultTableModel model = new DefaultTableModel(vData, vName);
        table.setModel(model);
    }

    private void addListener(){
        jButton.addActionListener(e -> {
            CopyService service=new CopyService();
            if(service.delete((Integer) textField.getValue())){
                JOptionPane.showMessageDialog(null,
                        "delete copy info success");
                fresh();
            }else{
                JOptionPane.showMessageDialog(null,
                        "delete copy info fail");
            }

        });

    }


}
