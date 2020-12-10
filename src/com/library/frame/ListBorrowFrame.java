package com.library.frame;

import com.library.pojo.Book;
import com.library.pojo.Borrow;
import com.library.service.BookService;
import com.library.service.BorrowService;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

/**
 * @author MSI-NB
 */
public class ListBorrowFrame extends JInternalFrame {
    private JSpinner textField;
    private JTable table;
    private JButton jButton;
    public ListBorrowFrame(){
        setIconifiable(true);
        setClosable(true);
        setTitle("book list");
        setSize(800,500);
        setLayout(null);
        init();
        fresh();


    }
    private void init(){

        JLabel jLabel=new JLabel("drop borrow info:");
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
        BorrowService service=new BorrowService();
        Vector<Vector> vData = new Vector<Vector>();
        Vector<String> vName = new Vector<String>();
        vName.add("borrow number");
        vName.add("borrow date");
        vName.add("due date");
        vName.add("fine amount");
        vName.add("return date");
        vName.add("reader id");
        vName.add("copy number");
        for (Borrow b:service.list()){
            Vector vector=new Vector();
            vector.add(b.getBorrowNumber());
            vector.add(b.getBorrowDate());
            vector.add(b.getDueDate());
            vector.add(b.getFineAmount());
            vector.add(b.getReturnDate());
            vector.add(b.getReaderId());
            vector.add(b.getCopyNumber());
            vData.add(vector);
        }
        DefaultTableModel model = new DefaultTableModel(vData, vName);
        table.setModel(model);
    }

    private void addListener(){
        jButton.addActionListener(e -> {
            BorrowService service=new BorrowService();
            if(service.delete((Integer) textField.getValue())){
                JOptionPane.showMessageDialog(null,
                        "delete borrow info success");
                fresh();
            }else{
                JOptionPane.showMessageDialog(null,
                        "delete borrow info fail");
            }

        });

    }


}
