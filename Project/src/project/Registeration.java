package project;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import javax.sound.midi.MidiDevice;
import javax.swing.*;
import static javax.swing.JOptionPane.showMessageDialog;


public class Registeration extends JFrame {
                                    /* GUI Declarations */
        JPanel mainPanel= new JPanel();
        JTextField fnameField = new JTextField();
        JTextField lnameField = new JTextField();
        JTextField passwordfield = new JTextField();
        JTextField addressField = new JTextField();
        JTextField emailField = new JTextField();
        JTextField phoneField = new JTextField();
        JLabel fnameLabel = new JLabel("First name");
        JLabel lnameLabel = new JLabel("Last name");
        JLabel passwordLabel = new JLabel("Password");
        JLabel addressLabel = new JLabel("Address");
        JLabel emailLabel = new JLabel("E-mail");
        JLabel phoneLabel = new JLabel("Phone");
        JRadioButton RadioButton1 = new JRadioButton("Male");
        JRadioButton RadioButton2 = new JRadioButton("Female");
        ButtonGroup groupButton = new ButtonGroup();
        JButton submitButton = new JButton("Submit");
        Color color = new Color(51,153,255);
                                
        public static personInfo[] infoP = new personInfo[1000];
        static int counter = 0;
        
        public Registeration(){
                                    /* GUI Settings */
                                    
        mainPanel.setBackground(color);
        this.setTitle("Registeration");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setSize(800,800);
        this.setResizable(false);
        this.add(mainPanel);
        mainPanel.setLayout(null);
        fnameLabel.setFont(fnameLabel.getFont().deriveFont(19.0f));
        lnameLabel.setFont(lnameLabel.getFont().deriveFont(19.0f));
        passwordLabel.setFont(passwordLabel.getFont().deriveFont(19.0f));
        addressLabel.setFont(addressLabel.getFont().deriveFont(19.0f));
        emailLabel.setFont(emailLabel.getFont().deriveFont(19.0f));
        phoneLabel.setFont(phoneLabel.getFont().deriveFont(19.0f));
        RadioButton1.setFont(RadioButton1.getFont().deriveFont(17.0f));
        RadioButton2.setFont(RadioButton2.getFont().deriveFont(17.0f));
        submitButton.setFont(submitButton.getFont().deriveFont(18.0f));
        fnameLabel.setBounds(40,0,100,100);
        fnameField.setBounds(160,35,210,33);
        lnameLabel.setBounds(420,0,100,100);
        lnameField.setBounds(530,35,210,33);
        passwordLabel.setBounds(40,100,100,100);
        passwordfield.setBounds(160,135,210,33);
        
        addressLabel.setBounds(420,100,100,100);
        addressField.setBounds(530,135,210,33);
        
        emailLabel.setBounds(40,200,100,100);
        emailField.setBounds(160,235,210,33);
        
        phoneLabel.setBounds(420,200,100,100);
        phoneField.setBounds(530,235,210,33);
       
        RadioButton1.setBounds(280,335,100,100);
        RadioButton2.setBounds(420,335,100,103);
        submitButton.setBounds(335,470,130,50);
        RadioButton1.setBackground(color);
        RadioButton2.setBackground(color);
        lnameLabel.setForeground(Color.white);
        fnameLabel.setForeground(Color.white);
        passwordLabel.setForeground(Color.white);
        addressLabel.setForeground(Color.white);
        emailLabel.setForeground(Color.white);
        phoneLabel.setForeground(Color.white);
        RadioButton1.setForeground(Color.white);
        RadioButton2.setForeground(Color.white);
        groupButton.add(RadioButton1);
        groupButton.add(RadioButton2);
        mainPanel.add(fnameLabel);
        mainPanel.add(fnameField);
        mainPanel.add(lnameLabel);
        mainPanel.add(lnameField);
        mainPanel.add(passwordLabel);
        mainPanel.add(passwordfield);
        mainPanel.add(addressLabel);
        mainPanel.add(addressField);
        mainPanel.add(emailLabel);
        mainPanel.add(emailField);
        mainPanel.add(phoneLabel);
        mainPanel.add(phoneField);
        mainPanel.add(RadioButton1);
        mainPanel.add(RadioButton2);
        mainPanel.add(submitButton);
        
        Submit();
      
       }    
                                  /*  Functions */
        public void Submit()
        {
               submitButton.addActionListener(new ActionListener (){
            @Override
            public void actionPerformed(ActionEvent e) {
            if(fnameField.getText().isEmpty() || lnameField.getText().isEmpty() || passwordfield.getText().isEmpty() || addressField.getText().isEmpty() || emailField.getText().isEmpty() || phoneField.getText().isEmpty())
            {
                showMessageDialog(null, "Please enter all required data.");
            }
            else
            {               
            
                infoP[counter] = new personInfo();
                infoP[counter].fname =  fnameField.getText();
                infoP[counter].lname =  lnameField.getText();
                infoP[counter].password =  passwordfield.getText();
                infoP[counter].email =  emailField.getText();
                infoP[counter].address =  addressField.getText();
                infoP[counter].phone =  phoneField.getText();   
                counter++;
                close();
                Login log = new Login();
                
            }
            }             
         });
        }
       public void close()
       {
           setVisible(false);
       }
}
