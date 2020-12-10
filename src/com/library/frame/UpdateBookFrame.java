package com.library.frame;

import com.library.pojo.Book;
import com.library.pojo.Reader;
import com.library.service.BookService;
import com.library.service.ReaderService;

import javax.swing.*;

/**
 * @author MSI-NB
 */
public class UpdateBookFrame extends JInternalFrame {
    private JSpinner spinner;
    private JTextField textField;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;
    private JButton jButton;
    private JButton jButton2;
    public UpdateBookFrame(){
        setIconifiable(true);
        setClosable(true);
        setTitle("book information update");
        setSize(800,600);
        setLayout(null);
        init();
        addListener();
    }

    private void init(){
        JLabel jLabel=new JLabel("document id:");
        jLabel.setBounds(50,50,150,30);
        add(jLabel);

        spinner=new JSpinner();
        spinner.setBounds(150,50,150,25);
        add(spinner);

        JLabel jLabel1=new JLabel("title:");
        jLabel1.setBounds(50,150,150,30);
        add(jLabel1);

        textField= new JTextField();
        textField.setBounds(150,150,150,25);
        add(textField);

        JLabel jLabel2=new JLabel("date:");
        jLabel2.setBounds(50,250,150,30);
        add(jLabel2);

        textField2=new JTextField();
        textField2.setBounds(150,250,150,25);
        add(textField2);

        JLabel jLabel3=new JLabel("publisher Id:");
        jLabel3.setBounds(50,350,150,30);
        add(jLabel3);

        textField3=new JTextField();
        textField3.setBounds(150,350,150,25);
        add(textField3);

        JLabel jLabel4=new JLabel("isbn:");
        jLabel4.setBounds(50,450,150,30);
        add(jLabel4);

        textField4=new JTextField();
        textField4.setBounds(150,450,150,25);
        add(textField4);


        jButton=new JButton("update");
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
            textField3.setText("");
            textField4.setText("");
        });
        jButton.addActionListener(e -> {
            Book book=new Book();
            book.setDocId((Integer) spinner.getValue());
            book.setTitle(textField.getText());
            book.setpDate(textField2.getText());
            book.setPublishId(Integer.parseInt(textField3.getText()));
            book.setIsbn(textField4.getText());
            BookService service=new BookService();
            if(service.update(book)){
                JOptionPane.showMessageDialog(null,
                        "update book success");
            }else{
                JOptionPane.showMessageDialog(null,
                        "update book fail");
            }
        });
    }
}
