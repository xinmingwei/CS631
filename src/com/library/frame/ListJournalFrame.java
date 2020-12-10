package com.library.frame;

import com.library.pojo.Journal;
import com.library.pojo.Proceeding;
import com.library.service.JournalService;
import com.library.service.ProceedingService;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.Vector;

/**
 * @author MSI-NB
 */
public class ListJournalFrame extends JInternalFrame {
    private JSpinner textField;
    private JTable table;
    private JButton jButton;
    public ListJournalFrame(){
        setIconifiable(true);
        setClosable(true);
        setTitle("proceedings list");
        setSize(800,500);
        setLayout(null);
        init();
        fresh();


    }
    private void init(){

        JLabel jLabel=new JLabel("drop journal info:");
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
        JournalService service=new JournalService();
        Vector<Vector> vData = new Vector<Vector>();
        Vector<String> vName = new Vector<String>();
        vName.add("document ID");
        vName.add("title");
        vName.add("publish date");
        vName.add("publisher id");
        vName.add("volume no");
        vName.add("issue no");
        vName.add("scope");
        for (Journal journal:service.list()){
            Vector vector=new Vector();
            vector.add(journal.getDocId());
            vector.add(journal.getTitle());
            vector.add(journal.getpDate());
            vector.add(journal.getPublishId());
            vector.add(journal.getVolumeNo());
            vector.add(journal.getIssieNo());
            vector.add(journal.getScope());
            vData.add(vector);
        }
        DefaultTableModel model = new DefaultTableModel(vData, vName);
        table.setModel(model);
    }

    private void addListener(){
        jButton.addActionListener(e -> {
            ProceedingService service=new ProceedingService();
            if(service.delete((Integer) textField.getValue())){
                JOptionPane.showMessageDialog(null,
                        "delete journal info success");
                fresh();
            }else{
                JOptionPane.showMessageDialog(null,
                        "delete journal info  fail");
            }

        });

    }


}
