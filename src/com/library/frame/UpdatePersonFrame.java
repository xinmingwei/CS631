package com.library.frame;

import com.library.pojo.Person;
import com.library.pojo.Publisher;
import com.library.service.PersonService;
import com.library.service.PublisherService;

import javax.swing.*;

/**
 * @author MSI-NB
 */
public class UpdatePersonFrame extends JInternalFrame{
    private JSpinner spinner;
    private JTextField textField;
    private JButton jButton;
    private JButton jButton2;
    public UpdatePersonFrame(){
        setIconifiable(true);
        setClosable(true);
        setTitle("author information update");
        setSize(800,400);
        setLayout(null);
        init();
        addListener();
    }

    private void init(){
        JLabel jLabel=new JLabel("author id:");
        jLabel.setBounds(50,50,150,30);
        add(jLabel);

        spinner=new JSpinner();
        spinner.setBounds(150,50,150,25);
        add(spinner);

        JLabel jLabel1=new JLabel("author name:");
        jLabel1.setBounds(50,150,150,30);
        add(jLabel1);

        textField= new JTextField();
        textField.setBounds(150,150,150,25);
        add(textField);


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
            textField.setText("");
        });
        jButton.addActionListener(e -> {
            Person person = new Person();
            person.setPname(textField.getText());
            person.setPid((Integer) spinner.getValue());
            PersonService service=new PersonService();
            if(service.update(person)){
                JOptionPane.showMessageDialog(null,
                        "update author success");
            }else{
                JOptionPane.showMessageDialog(null,
                        "update author fail");
            }
        });
    }
}
