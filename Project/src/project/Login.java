package project;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import static javax.swing.JOptionPane.showMessageDialog;


public class Login extends JFrame {
                                             /* GUI Declarations */
    JFrame viewframe = new JFrame();
    JTextField emailField = new JTextField();
    JPasswordField PasswordField = new JPasswordField();
    JPanel mainPanel = new JPanel();
    JLabel emailLabel = new JLabel("Email");
    JLabel passwordLabel = new JLabel("Password");
    JButton loginButton = new JButton("Login");
    JButton registerButton = new JButton("Register");
    Color color = new Color(51,153,255);
    Border border = new LineBorder(Color.white,1,true);
    
    public Login()
    {
                                            /* GUI Settings */
        this.setTitle("Login");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setSize(800,800);
        this.add(mainPanel);
        this.setResizable(false);
        mainPanel.setLayout(null);
        mainPanel.setBackground(color);
        loginButton.setBackground(color);
        loginButton.setForeground(Color.white);
        registerButton.setBackground(color);       
        registerButton.setForeground(Color.white);
        emailLabel.setForeground(Color.white);
        passwordLabel.setForeground(Color.white);
        emailLabel.setBounds(190, 123, 100, 100);
        emailField.setBounds(360,160,210,33);
        passwordLabel.setBounds(190, 215, 100, 100);
        PasswordField.setBounds(360,250,210,33);
        emailLabel.setFont(emailLabel.getFont().deriveFont(19.0f));
        passwordLabel.setFont(passwordLabel.getFont().deriveFont(19.0f));
        loginButton.setFont(loginButton.getFont().deriveFont(16.0f));
        registerButton.setFont(registerButton.getFont().deriveFont(16.0f));
        loginButton.setBounds(300,328,150,40);
        registerButton.setBounds(300,378,150,40);
        loginButton.setBorder(border);
        registerButton.setBorder(border);
        mainPanel.add(emailLabel);
        mainPanel.add(emailField);    
        mainPanel.add(passwordLabel);
        mainPanel.add(PasswordField);  
        mainPanel.add(loginButton);
        mainPanel.add(registerButton);        
                                        
            login();
            Register();          
    }   
                              /*  Functions */
    
   public void login()
   {
      loginButton.addActionListener(new ActionListener (){
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean found = false;               
                if(emailField.getText().equals("admin") && PasswordField.getText().equals("admin"))
                {
                    close();
                    Admin admin = new Admin();
                    admin.mainAdmin();
                }                
                else
                {
                   for(int i = 0 ; i < Registeration.counter ; i++)
                   {
                       if( Registeration.infoP[i].email.equals(emailField.getText()) &&  Registeration.infoP[i].password.equals(PasswordField.getText()))
                       {                           
                           found = true;
                           close();
                           user user = new user();                           
                           break;
                       }
                   }
                   if(!found)
                   {
                       showMessageDialog(null, "Enter a valid data");
                   }
                }
            }             
         });  
   }
   public void Register()
   {
       registerButton.addActionListener(new ActionListener (){
            @Override
            public void actionPerformed(ActionEvent e) {
                close();
                Registeration h = new Registeration();
            }             
         });  
   }   
   public void close()
   {
       setVisible(false);
   }
}
