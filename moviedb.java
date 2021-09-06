package javaprojectswings;



import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;


public class moviedb extends JFrame {
    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField mname;
    private JTextField mlanguage;
    private JTextField mtimings;
    private JTextField mnooftickets;
    private JTextField mcostoftickets;
    private JButton btnNewButton;
  
    public static void main(String[] args) {
    EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    moviedb frame = new moviedb();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    

    }

    private void clearfields() 
    {
    	 mname.setText(null); 
    	 mlanguage.setText(null); 
    	 mtimings.setText(null); 
    	 mnooftickets.setText(null); 
    	 mcostoftickets.setText(null); 
         
    }
   

    public moviedb() {
        setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\User\\Desktop\\STDM.jpg"));
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setBounds(350, 200, 1000, 600);
        setResizable(false);
        setTitle("add new movies :^)");
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblNewUserRegister = new JLabel("welcome to cinemahall");
        lblNewUserRegister.setFont(new Font("Serif", Font.BOLD+Font.ITALIC, 42));
        lblNewUserRegister.setBounds(300, 50, 500, 60);
        contentPane.add(lblNewUserRegister);

        JLabel lblName = new JLabel("Enter movie name");
        lblName.setFont(new Font("Serif", Font.BOLD+Font.ITALIC,20));
        lblName.setBounds(58, 152, 200, 43);
        contentPane.add(lblName);

        JLabel lblNewLabel = new JLabel("Language available");
        lblNewLabel.setFont(new Font("Serif", Font.BOLD+Font.ITALIC, 20));
        lblNewLabel.setBounds(58, 243, 400, 29);
        contentPane.add(lblNewLabel);

        JLabel lblEmailAddress = new JLabel("Enter timings of show");
        lblEmailAddress.setFont(new Font("Serif", Font.BOLD+Font.ITALIC,20));
        lblEmailAddress.setBounds(58, 324, 300, 36);
        contentPane.add(lblEmailAddress);

        mname = new JTextField();
        mname.setFont(new Font("Serif", Font.BOLD+Font.ITALIC,32));
        mname.setBounds(290, 151, 228, 50);
        contentPane.add( mname);
        mname.setColumns(10);

        mlanguage = new JTextField();
        mlanguage .setFont(new Font("Serif", Font.BOLD+Font.ITALIC,32));
        mlanguage .setBounds(290, 235, 228, 50);
        contentPane.add(mlanguage );
        mlanguage .setColumns(10);

        mtimings = new JTextField();
        mtimings.setFont(new Font("Serif", Font.BOLD+Font.ITALIC, 32));
        mtimings.setBounds(290, 320, 228, 50);
        contentPane.add( mtimings);
        mtimings.setColumns(10);

        mnooftickets = new JTextField();
        mnooftickets.setFont(new Font("Serif", Font.BOLD+Font.ITALIC,32));
        mnooftickets.setBounds(690, 151, 228, 50);
        contentPane.add(mnooftickets);
        mnooftickets.setColumns(10);
        
        
        JLabel lblUsername = new JLabel("No of tickets");
        lblUsername.setFont(new Font("Serif", Font.BOLD+Font.ITALIC,20));
        lblUsername.setBounds(560, 159, 350, 29);
        contentPane.add(lblUsername);

        JLabel lblPassword = new JLabel("Cost per ticket");
        lblPassword.setFont(new Font("Serif", Font.BOLD+Font.ITALIC, 20));
        lblPassword.setBounds(560, 245, 350, 24);
        contentPane.add(lblPassword);

        /*JLabel lblMobileNumber = new JLabel("Mobile number");
        lblMobileNumber.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblMobileNumber.setBounds(542, 329, 139, 26);
        contentPane.add(lblMobileNumber);

        mob = new JTextField();
        mob.setFont(new Font("Tahoma", Font.PLAIN, 32));
        mob.setBounds(707, 320, 228, 50);
        contentPane.add(mob);
        mob.setColumns(10);

        */
        mcostoftickets = new JTextField();
        mcostoftickets.setFont(new Font("Serif", Font.BOLD+Font.ITALIC,32));
        mcostoftickets.setBounds(690, 235, 228, 50);
        contentPane.add(mcostoftickets);

        
        btnNewButton = new JButton("Add");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String movie_name = mname.getText();
                String language = mlanguage.getText();
                String show_timings = mtimings.getText();
                String no_of_tickets = mnooftickets.getText();
                String cost_of_tickets = mcostoftickets.getText();
                //int len = mobileNumber.length();
                //String password = passwordField.getText();
                
                
 /*               String msg = "" + firstName;
                msg += " \n";
                if (len != 10) {
                    JOptionPane.showMessageDialog(btnNewButton, "Enter a valid mobile number");
                }
*/              
                String msg = "";
                
                try {
                    Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/swing", "root", "Sharadha@2019");

                    String query = "INSERT INTO movie values('" + movie_name + "','" + language + "','" + show_timings + "','" +
                        no_of_tickets  + "','" + cost_of_tickets + "')";

                    Statement sta = connection.createStatement();
                    int x = sta.executeUpdate(query);
                    if (x == 0) {
                        JOptionPane.showMessageDialog(btnNewButton, "This is already exist");
                    } else {
                        JOptionPane.showMessageDialog(btnNewButton,
                            "Welcome, " + msg + "Your movie is added successfully");
                        clearfields();
                    }
                    connection.close();     /////it should close window by itself after the work
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
            }
        });
        btnNewButton.setFont(new Font("Serif", Font.BOLD+Font.ITALIC,22));
        btnNewButton.setBounds(399, 447, 259, 74);
        contentPane.add(btnNewButton);
    }
}