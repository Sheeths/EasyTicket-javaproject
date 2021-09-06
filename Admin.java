package javaprojectswings;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import java.awt.Insets;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.SwingUtilities;

import javaprojectswings.UserRegistration;


public class Admin extends JFrame {


private static final long serialVersionUID = -     8307105427074441939L;

     JButton buttonOK = new JButton("OK");

     JRadioButton optionLinux = new JRadioButton("1.Admin Registration");
     JRadioButton optionWin = new JRadioButton("2.Login and Add movie details");
     JRadioButton optionMac = new JRadioButton("3.Show movies which are there in system");
     JRadioButton optionUnix = new JRadioButton("4.return to terminal");



    public Admin() {
        super("SystemUpdate ;0");
        //Set ID and add to group
     
      
        ButtonGroup group = new ButtonGroup();
        optionLinux.setActionCommand ( "1" );
        group.add(optionLinux);
        optionWin.setActionCommand ( "2" );
        group.add(optionWin);
        optionMac.setActionCommand ( "3" );
        group.add(optionMac);
        optionUnix.setActionCommand ( "4" );
        group.add(optionUnix);
        
        optionWin.setSelected(true);
        setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.anchor = GridBagConstraints.CENTER;
        constraints.insets = new Insets(20, 20, 20, 20);

        add(optionLinux, constraints);
        constraints.gridy = 1;
        add(optionWin, constraints);
        constraints.gridy = 2;
        add(optionMac, constraints);
        constraints.gridy = 3;
        add(optionUnix, constraints);
       // constraints.gridx = 0;
        constraints.gridy = 4;
        constraints.gridwidth = 4;
        constraints.gridheight = 2;
        
        constraints.gridy = 4;
        add(buttonOK, constraints);

    RadioButtonActionListener actionListener = new  RadioButtonActionListener();
        optionLinux.addActionListener(actionListener);
        optionWin.addActionListener(actionListener);
        optionMac.addActionListener(actionListener);
        optionLinux.addActionListener(actionListener);

        buttonOK.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent event) {
                //Get "ID"
            String selectedOption = group.getSelection (     ).getActionCommand ( );
                //Switch on "IDS"
                switch(selectedOption) {
                    case "1":
                    JOptionPane.showMessageDialog(    Admin.this,
                            "You selected: admin registration with id: " +     selectedOption);
                    EventQueue.invokeLater(new Runnable() {
                        public void run() {
                           try {
                               UserRegistration frame = new UserRegistration();
                               frame.setVisible(true);
                               setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                               setLocationRelativeTo(null);
                           } catch (Exception e) {
                               e.printStackTrace();
                           }
                       }
                   });
                        break;
                    case "2":
                    JOptionPane.showMessageDialog(     Admin.this,
                            "You selected: Add movie details with id: " +     selectedOption);
                    
            	    EventQueue.invokeLater(new Runnable() {
                    public void run() {
                        try {
                            UserLogin frame = new UserLogin();
                            frame.setVisible(true);
                            frame.setLocationRelativeTo(null);
                            setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                });      
                        break;
                    
                    case "3":
                    JOptionPane.showMessageDialog(     Admin.this,
                            "You selected to view movies available with id: " +     selectedOption);
                    String title = "MOVIES AVAILABLE IN OUR SYSTEM ";

            		Datafetch df = new Datafetch(title);

            		//System.out.println(df);
            		
                        break;
                        
                    case "4":    
                    	 JOptionPane.showMessageDialog(     Admin.this,
                                 "You selected Return to previous menu with id: " +selectedOption);
                    	 dispose();
                    	 break;
                }
            }

        });

        pack();
       // setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    class RadioButtonActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent event) {
            JRadioButton button = (JRadioButton) event.getSource();
          /*  if (button == optionLinux) {

                System.out.println ( "Linux" );

            } else if (button == optionWin) {

                System.out.println ( "Windows" );

            } else if (button == optionMac) {

                System.out.println ( "Mac" );
            }else if (button == optionUnix) {
            	
                System.out.println ( "returned to terminal" );
            } */
        }
    }

    public static void main(String[] args) {
    	
    	SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                new Admin().setVisible(true);
            }
        });
    }
}