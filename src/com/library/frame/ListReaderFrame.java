package com.library.frame;

import com.library.pojo.Publisher;
import com.library.pojo.Reader;
import com.library.service.PublisherService;
import com.library.service.ReaderService;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.List;
import java.util.Vector;

/**
 * @author MSI-NB
 */
public class ListReaderFrame extends JInternalFrame {
    private JSpinner textField;
    private JTable table;
    private JButton jButton;
    public ListReaderFrame(){
        setIconifiable(true);
        setClosable(true);
        setTitle("reader list");
        setSize(800,500);
        setLayout(null);
        init();
        fresh();


    }
    private void init(){

        JLabel jLabel=new JLabel("drop reader:");
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
        ReaderService service=new ReaderService();
        List<Reader> list =service.list();

        Vector<Vector> vData = new Vector<>();
        Vector<String> vName = new Vector<String>();
        vName.add("reader ID");
        vName.add("reader Name");
        vName.add("type");
        vName.add("phoneNo");
        vName.add("address");
        for (Reader r:list){
            Vector vector=new Vector();
            vector.add(r.getReaderId());
            vector.add(r.getReaderName());
            vector.add(r.getType());
            vector.add(r.getPhoneNo());
            vector.add(r.getAddress());
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
                        "delete reader success");
                fresh();
            }else{
                JOptionPane.showMessageDialog(null,
                        "delete reader fail");
            }

        });

    }


}
