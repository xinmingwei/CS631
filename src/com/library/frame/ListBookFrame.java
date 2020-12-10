package com.library.frame;

import com.library.pojo.Book;
import com.library.pojo.Publisher;
import com.library.service.BookService;
import com.library.service.PublisherService;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

/**
 * @author MSI-NB
 */
public class ListBookFrame extends JInternalFrame {
    private JSpinner textField;
    private JTable table;
    private JButton jButton;
    public ListBookFrame(){
        setIconifiable(true);
        setClosable(true);
        setTitle("book list");
        setSize(800,500);
        setLayout(null);
        init();
        fresh();


    }
    private void init(){

        JLabel jLabel=new JLabel("drop book info:");
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
        BookService service=new BookService();
        List<Book> list=new ArrayList<>();

        Vector<Vector> vData = new Vector<Vector>();
        Vector<String> vName = new Vector<String>();
        vName.add("document ID");
        vName.add("title");
        vName.add("date");
        vName.add("publisher id");
        vName.add("isbn");
        for (Book b:service.list()){
            Vector vector=new Vector();
            vector.add(b.getDocId());
            vector.add(b.getTitle());
            vector.add(b.getpDate());
            vector.add(b.getPublishId());
            vector.add(b.getIsbn());
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
                        "delete book success");
                fresh();
            }else{
                JOptionPane.showMessageDialog(null,
                        "delete book fail");
            }

        });

    }


}
