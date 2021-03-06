package com.library.frame;


import com.library.LoginFrame;

import javax.swing.*;
import java.awt.*;

/**
 * @author MSI-NB
 */
public class LibraryApp extends JFrame {
    private JMenuItem exitItem;
    private JLabel banner;

    private JMenuItem insertBookItem;
    private JMenuItem updateBookItem;
    private JMenuItem listBookItem;

    private JMenuItem insertJournalItem;
    private JMenuItem updateJournalItem;
    private JMenuItem listJournalItem;

    private JMenuItem insertProceedingsItem;
    private JMenuItem updateProceedingItem;
    private JMenuItem listProceedingItem;

    private JMenuItem insertReaderItem;
    private JMenuItem updateReaderItem;
    private JMenuItem listReaderItem;

    private JMenuItem insertPublisherItem;
    private JMenuItem updatePublisherItem;
    private JMenuItem listPublisherItem;

    private JMenuItem insertAuthorItem;
    private JMenuItem updateAuthorItem;
    private JMenuItem listAuthorItem;

    private JMenuItem insertReserveItem;
    private JMenuItem updateReserveItem;
    private JMenuItem listReserveItem;

    private JMenuItem insertBorrowItem;
    private JMenuItem updateBorrowItem;
    private JMenuItem listBorrowItem;

    private JMenuItem insertCopyItem;
    private JMenuItem updateCopyItem;
    private JMenuItem listCopyItem;

    private JMenuItem insertBranchItem;
    private JMenuItem updateBranchItem;
    private JMenuItem listBranchItem;

    private JMenuItem cal1Item;
    private JMenuItem cal2Item;
    private JMenuItem cal3Item;

    private JPanel jPanel;

    public LibraryApp(){
        setTitle("LibraryManagement");
        setSize(1200,800);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setBounds((Toolkit.getDefaultToolkit().getScreenSize().width - this.getWidth()) / 2,
                (Toolkit.getDefaultToolkit().getScreenSize().height - this.getHeight()) / 2,
                this.getWidth(), this.getHeight());
    }

    public void init(){
        /*
        * menus setting
         */
        JMenuBar jMenuBar = new JMenuBar();
        setJMenuBar(jMenuBar);

        JMenu jMenu = new JMenu("Setting(S)");
        jMenuBar.add(jMenu);
        JMenuItem jMenuItem = new JMenuItem("exit");
        jMenuItem.addActionListener(e -> System.exit(0));
        jMenu.add(jMenuItem);

        JMenu jMenu1=new JMenu("Document(D)");
        jMenuBar.add(jMenu1);

        JMenu jMenu2 = new JMenu("Book");
        jMenu1.add(jMenu2);

        JMenu jMenu3 = new JMenu("Journal");
        jMenu1.add(jMenu3);

        JMenu jMenu4 = new JMenu("Proceedings");
        jMenu1.add(jMenu4);

        JMenu jMenu10 = new JMenu("Copy");
        jMenu1.add(jMenu10);

        insertCopyItem=new JMenuItem("add");
        updateCopyItem=new JMenuItem("update");
        listCopyItem=new JMenuItem("list");
        jMenu10.add(insertCopyItem);
        jMenu10.add(updateCopyItem);
        jMenu10.add(listCopyItem);


        insertBookItem = new JMenuItem("add");
        updateBookItem = new JMenuItem("update");
        listBookItem=new JMenuItem("list");
        jMenu2.add(insertBookItem);
        jMenu2.add(updateBookItem);
        jMenu2.add(listBookItem);

        insertJournalItem=new JMenuItem("add");
        updateJournalItem=new JMenuItem("update");
        listJournalItem=new JMenuItem("list");
        jMenu3.add(insertJournalItem);
        jMenu3.add(updateJournalItem);
        jMenu3.add(listJournalItem);

        insertProceedingsItem=new JMenuItem("add");
        updateProceedingItem=new JMenuItem("update");
        listProceedingItem=new JMenuItem("list");
        jMenu4.add(insertProceedingsItem);
        jMenu4.add(updateProceedingItem);
        jMenu4.add(listProceedingItem);

        JMenu jMenu5=new JMenu("Reader(R)");
        jMenuBar.add(jMenu5);
        insertReaderItem=new JMenuItem("add");
        updateReaderItem=new JMenuItem("update");
        listReaderItem=new JMenuItem("list");
        jMenu5.add(insertReaderItem);
        jMenu5.add(updateReaderItem);
        jMenu5.add(listReaderItem);


        JMenu jMenu6 = new JMenu("Publisher(P)");
        jMenuBar.add(jMenu6);
        insertPublisherItem=new JMenuItem("add");
        updatePublisherItem=new JMenuItem("update");
        listPublisherItem=new JMenuItem("list");
        jMenu6.add(insertPublisherItem);
        jMenu6.add(updatePublisherItem);
        jMenu6.add(listPublisherItem);



        JMenu jMenu8 = new JMenu("Reserves(E)");
        jMenuBar.add(jMenu8);
        insertReserveItem=new JMenuItem("add");
        updateReserveItem=new JMenuItem("update");
        listReserveItem=new JMenuItem("list");
        jMenu8.add(insertReserveItem);
        jMenu8.add(updateReserveItem);
        jMenu8.add(listReserveItem);


        JMenu jMenu9=new JMenu("Borrow(B)");
        jMenuBar.add(jMenu9);
        insertBorrowItem=new JMenuItem("insert");
        updateBorrowItem=new JMenuItem("update");
        listBorrowItem=new JMenuItem("list");
        jMenu9.add(insertBorrowItem);
        jMenu9.add(updateBorrowItem);
        jMenu9.add(listBorrowItem);

        JMenu jMenu11=new JMenu("Branch(H)");
        jMenuBar.add(jMenu11);
        insertBranchItem=new JMenuItem("add");
        updateBranchItem=new JMenuItem("update");
        listBranchItem=new JMenuItem("list");
        jMenu11.add(insertBranchItem);
        jMenu11.add(updateBranchItem);
        jMenu11.add(listBranchItem);

        JMenu jMenu12=new JMenu("Query(Q)");
        jMenuBar.add(jMenu12);

        cal1Item=new JMenuItem("borrow");
        cal2Item=new JMenuItem("reserve");
        cal3Item=new JMenuItem("publish");
        jMenu12.add(cal1Item);
        jMenu12.add(cal2Item);
        jMenu12.add(cal3Item);


        jPanel =new JPanel();
        jPanel.setBounds(0,0,1200,800);
        jPanel.setLayout(null);
        add(jPanel);
        setLayout(null);
        addListener();

    }

    public void readerInit(){
        /*
         * menus setting
         */
        JMenuBar jMenuBar = new JMenuBar();
        setJMenuBar(jMenuBar);

        JMenu jMenu = new JMenu("Setting(S)");
        jMenuBar.add(jMenu);
        JMenuItem jMenuItem = new JMenuItem("exit");
        jMenuItem.addActionListener(e -> System.exit(0));
        jMenu.add(jMenuItem);


        JMenu jMenu8 = new JMenu("Reserves(E)");
        jMenuBar.add(jMenu8);
        insertReserveItem=new JMenuItem("add");
        updateReserveItem=new JMenuItem("update");
        listReserveItem=new JMenuItem("list");
        jMenu8.add(insertReserveItem);
        jMenu8.add(updateReserveItem);
        jMenu8.add(listReserveItem);


        JMenu jMenu9=new JMenu("Borrow(B)");
        jMenuBar.add(jMenu9);
        insertBorrowItem=new JMenuItem("insert");
        updateBorrowItem=new JMenuItem("update");
        listBorrowItem=new JMenuItem("list");
        jMenu9.add(insertBorrowItem);
        jMenu9.add(updateBorrowItem);
        jMenu9.add(listBorrowItem);

        JMenu jMenu12=new JMenu("Query(Q)");
        jMenuBar.add(jMenu12);

        cal1Item=new JMenuItem("borrow");
        cal2Item=new JMenuItem("reserve");
        cal3Item=new JMenuItem("publish");
        jMenu12.add(cal1Item);
        jMenu12.add(cal2Item);
        jMenu12.add(cal3Item);


        jPanel =new JPanel();
        jPanel.setBounds(0,0,1200,800);
        jPanel.setLayout(null);
        add(jPanel);
        setLayout(null);
        addListener2();
    }


    private void addListener2(){
        cal1Item.addActionListener(e -> {
            QueryBorrowFrame  frame=new QueryBorrowFrame();
            frame.setLocation(50,50);
            jPanel.removeAll();
            jPanel.add(frame);
            frame.setVisible(true);
        });
        cal2Item.addActionListener(e -> {
            QueryReserveFrame frame=new QueryReserveFrame();
            frame.setLocation(50,50);
            jPanel.removeAll();
            jPanel.add(frame);
            frame.setVisible(true);
        });
        cal3Item.addActionListener(e -> {
            QueryPublishFrame frame=new QueryPublishFrame();
            frame.setLocation(50,50);
            jPanel.removeAll();
            jPanel.add(frame);
            frame.setVisible(true);
        });
        insertBorrowItem.addActionListener(e -> {
            InsertBorrowFrame frame=new InsertBorrowFrame();
            frame.setLocation(50,50);
            jPanel.removeAll();
            jPanel.add(frame);
            frame.setVisible(true);
        });
        updateBorrowItem.addActionListener(e -> {
            UpdateBorrowFrame frame=new UpdateBorrowFrame();
            frame.setLocation(50,50);
            jPanel.removeAll();
            jPanel.add(frame);
            frame.setVisible(true);
        });
        listBorrowItem.addActionListener(e -> {
            ListBorrowFrame frame=new ListBorrowFrame();
            frame.setLocation(50,50);
            jPanel.removeAll();
            jPanel.add(frame);
            frame.setVisible(true);
        });
        insertReserveItem.addActionListener(e -> {
            InsertReserveFrame frame=new InsertReserveFrame();
            frame.setLocation(50,50);
            jPanel.removeAll();
            jPanel.add(frame);
            frame.setVisible(true);
        });
        updateReserveItem.addActionListener(e -> {
            UpdateReserveFrame frame=new UpdateReserveFrame();
            frame.setLocation(50,50);
            jPanel.removeAll();
            jPanel.add(frame);
            frame.setVisible(true);
        });
        listReserveItem.addActionListener(e -> {
            ListReserveFrame frame=new ListReserveFrame();
            frame.setLocation(50,50);
            jPanel.removeAll();
            jPanel.add(frame);
            frame.setVisible(true);
        });
    }
    private void addListener(){
        insertPublisherItem.addActionListener(e ->{
            InsertPublisherFrame frame=new InsertPublisherFrame();
            frame.setLocation(50,50);
            jPanel.removeAll();
            jPanel.add(frame);
            frame.setVisible(true);
        });
        updatePublisherItem.addActionListener(e -> {
            UpdatePublisherFrame frame=new UpdatePublisherFrame();
            frame.setLocation(50,50);
            jPanel.removeAll();
            jPanel.add(frame);
            frame.setVisible(true);
        });
        listPublisherItem.addActionListener(e -> {
            ListPublisherFrame frame=new ListPublisherFrame();
            frame.setLocation(50,50);
            jPanel.removeAll();
            jPanel.add(frame);
            frame.setVisible(true);
        });
        insertReaderItem.addActionListener(e -> {
            InsertReaderFrame frame=new InsertReaderFrame();
            frame.setLocation(50,50);
            jPanel.removeAll();
            jPanel.add(frame);
            frame.setVisible(true);
        });
        updateReaderItem.addActionListener(e -> {
            UpdateReaderFrame frame=new UpdateReaderFrame();
            frame.setLocation(50,50);
            jPanel.removeAll();
            jPanel.add(frame);
            frame.setVisible(true);
        });
        listReaderItem.addActionListener(e -> {
            ListReaderFrame frame=new ListReaderFrame();
            frame.setLocation(50,50);
            jPanel.removeAll();
            jPanel.add(frame);
            frame.setVisible(true);
        });
        insertBookItem.addActionListener(e -> {
            InsertBookFrame frame=new InsertBookFrame();
            frame.setLocation(50,50);
            jPanel.removeAll();
            jPanel.add(frame);
            frame.setVisible(true);
        });
        updateBookItem.addActionListener(e -> {
            UpdateBookFrame frame=new UpdateBookFrame();
            frame.setLocation(50,50);
            jPanel.removeAll();
            jPanel.add(frame);
            frame.setVisible(true);
        });
        listBookItem.addActionListener(e -> {
            ListBookFrame frame=new ListBookFrame();
            frame.setLocation(50,50);
            jPanel.removeAll();
            jPanel.add(frame);
            frame.setVisible(true);
        });
        insertProceedingsItem.addActionListener(e -> {
            InsertProceedingsFrame frame=new InsertProceedingsFrame();
            frame.setLocation(50,50);
            jPanel.removeAll();
            jPanel.add(frame);
            frame.setVisible(true);
        });
        updateProceedingItem.addActionListener(e -> {
            UpdateProceedingsFrame frame=new UpdateProceedingsFrame();
            frame.setLocation(50,50);
            jPanel.removeAll();
            jPanel.add(frame);
            frame.setVisible(true);
        });
        listProceedingItem.addActionListener(e -> {
           ListProceedingsFrame frame=new ListProceedingsFrame();
           frame.setLocation(50,50);
           jPanel.removeAll();
           jPanel.add(frame);
           frame.setVisible(true);
       });
        insertCopyItem.addActionListener(e -> {
            InsertCopyFrame frame=new InsertCopyFrame();
            frame.setLocation(50,50);
            jPanel.removeAll();
            jPanel.add(frame);
            frame.setVisible(true);
        });
        updateCopyItem.addActionListener(e -> {
            UpdateCopyFrame frame=new UpdateCopyFrame();
            frame.setLocation(50,50);
            jPanel.removeAll();
            jPanel.add(frame);
            frame.setVisible(true);
        });
        listCopyItem.addActionListener(e -> {
           ListCopyFrame frame=new ListCopyFrame();
            frame.setLocation(50,50);
            jPanel.removeAll();
            jPanel.add(frame);
            frame.setVisible(true);
        });
        insertBorrowItem.addActionListener(e -> {
            InsertBorrowFrame frame=new InsertBorrowFrame();
            frame.setLocation(50,50);
            jPanel.removeAll();
            jPanel.add(frame);
            frame.setVisible(true);
        });
        updateBorrowItem.addActionListener(e -> {
            UpdateBorrowFrame frame=new UpdateBorrowFrame();
            frame.setLocation(50,50);
            jPanel.removeAll();
            jPanel.add(frame);
            frame.setVisible(true);
        });
        listBorrowItem.addActionListener(e -> {
           ListBorrowFrame frame=new ListBorrowFrame();
            frame.setLocation(50,50);
            jPanel.removeAll();
            jPanel.add(frame);
            frame.setVisible(true);
        });
        insertReserveItem.addActionListener(e -> {
            InsertReserveFrame frame=new InsertReserveFrame();
            frame.setLocation(50,50);
            jPanel.removeAll();
            jPanel.add(frame);
            frame.setVisible(true);
        });
        updateReserveItem.addActionListener(e -> {
            UpdateReserveFrame frame=new UpdateReserveFrame();
            frame.setLocation(50,50);
            jPanel.removeAll();
            jPanel.add(frame);
            frame.setVisible(true);
        });
        listReserveItem.addActionListener(e -> {
            ListReserveFrame frame=new ListReserveFrame();
            frame.setLocation(50,50);
            jPanel.removeAll();
            jPanel.add(frame);
            frame.setVisible(true);
        });
        insertJournalItem.addActionListener(e -> {
            InsertJournalFrame  frame=new InsertJournalFrame();
            frame.setLocation(50,50);
            jPanel.removeAll();
            jPanel.add(frame);
            frame.setVisible(true);
        });
        updateReserveItem.addActionListener(e -> {
            UpdateReserveFrame frame=new UpdateReserveFrame();
            frame.setLocation(50,50);
            jPanel.removeAll();
            jPanel.add(frame);
            frame.setVisible(true);
        });
        listReserveItem.addActionListener(e -> {
            ListReserveFrame frame=new ListReserveFrame();
            frame.setLocation(50,50);
            jPanel.removeAll();
            jPanel.add(frame);
            frame.setVisible(true);
        });
        insertJournalItem.addActionListener(e -> {
            InsertJournalFrame  frame=new InsertJournalFrame();
            frame.setLocation(50,50);
            jPanel.removeAll();
            jPanel.add(frame);
            frame.setVisible(true);
        });
        updateJournalItem.addActionListener(e -> {
            UpdateJournalFrame  frame=new UpdateJournalFrame();
            frame.setLocation(50,50);
            jPanel.removeAll();
            jPanel.add(frame);
            frame.setVisible(true);
        });
        listJournalItem.addActionListener(e -> {
            ListJournalFrame  frame=new ListJournalFrame();
            frame.setLocation(50,50);
            jPanel.removeAll();
            jPanel.add(frame);
            frame.setVisible(true);
        });
        insertBranchItem.addActionListener(e -> {
            InsertBranchFrame frame=new InsertBranchFrame();
            frame.setLocation(50,50);
            jPanel.removeAll();
            jPanel.add(frame);
            frame.setVisible(true);
        });
        updateBranchItem.addActionListener(e -> {
            UpdateBranchFrame  frame=new UpdateBranchFrame();
            frame.setLocation(50,50);
            jPanel.removeAll();
            jPanel.add(frame);
            frame.setVisible(true);
        });
        listBranchItem.addActionListener(e -> {
            ListBranchFrame  frame=new ListBranchFrame();
            frame.setLocation(50,50);
            jPanel.removeAll();
            jPanel.add(frame);
            frame.setVisible(true);
        });
        cal1Item.addActionListener(e -> {
            QueryBorrowFrame  frame=new QueryBorrowFrame();
            frame.setLocation(50,50);
            jPanel.removeAll();
            jPanel.add(frame);
            frame.setVisible(true);
        });
        cal2Item.addActionListener(e -> {
            QueryReserveFrame frame=new QueryReserveFrame();
            frame.setLocation(50,50);
            jPanel.removeAll();
            jPanel.add(frame);
            frame.setVisible(true);
        });
        cal3Item.addActionListener(e -> {
            QueryPublishFrame frame=new QueryPublishFrame();
            frame.setLocation(50,50);
            jPanel.removeAll();
            jPanel.add(frame);
            frame.setVisible(true);
        });

    }



}
