package javaprojectswings;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import javaprojectswings.Admin;
import javaprojectswings.Admin.RadioButtonActionListener;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.SwingUtilities;

import com.mysql.cj.xdevapi.Statement;

import javaprojectswings.UserRegistration;

class parentdata /// base
{
	void datafirst() {
		System.out.println("#  EasyTicket -  \n");
		System.out.println("#  MOVIE  \n");
		System.out.println("#  TICKET  \n");
	}
}

class Child1data extends parentdata // child1
{
	void datamid() {
		System.out.println("#  BOOKING  \n");
	}
}

class Child2data extends Child1data /// inherited from child1 executing multilevel inheritance here
{
	void datalast() {
		System.out.println("#  SYSTEM  \n");
	}
}

class Mainfile  {

	public static void main(String[] args)
   {
	
	   Scanner sc=new Scanner(System.in);
	   int status=1;
	   Child2data d = new Child2data();
	   d.datafirst();
	   d.datamid();
	   d.datalast(); 
	   
   
   do{ System.out.println("__________________________________________________________________________________________________");
       System.out.println("||-----------------------------------------EasyTicket-------------------------------------------||");
       System.out.println("||----------------------------------------------------------------------------------------------||");
	   System.out.println("||--------------------------WELCOME TO MOVIE TICKET BOOKING SYSTEM------------------------------||");
	   System.out.println("||                                                                                              ||");
       System.out.println("||----------------------------------------------------------------------------------------------||");
       System.out.println("||------------------------- 1. SYSTEM UPDATE                        ----------------------------||");
       System.out.println("||------------------------- 2. ADD MOVIE DETAILS                    ----------------------------||");
       System.out.println("||------------------------- 3. SEARCH AND BOOK A TICKET             ----------------------------||");
       System.out.println("||------------------------- 4. VIEW ALL MOVIES AVAILABLE            ----------------------------||");
       System.out.println("||------------------------- 5. EXIT FROM SYSTEM                     ----------------------------||");
       System.out.println("||----------------------------------------------------------------------------------------------||");
       System.out.println("__________________________________________________________________________________________________");
 	   
      
       System.out.println("Enter  your choice :");
       int ch=sc.nextInt();
       switch(ch)
       {
       

        
       case 1:

   		SwingUtilities.invokeLater(new Runnable() {
   			@Override
   	         public void run() {
   	            new Admin().setVisible(true);
   	        }
   	    });
	
           break;  

case 2:    
	 
	
	  EventQueue.invokeLater(new Runnable() {
          public void run() {
              try {
                  UserLogin frame = new UserLogin();
                  frame.setVisible(true);
                  frame.setLocationRelativeTo(null);
                  frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
              } catch (Exception e) {
                  e.printStackTrace();
              }
          }
      });      

           
           
          break;
	       
        
case 3:    
	
	Connection connection = null;

	    try {
	        connection = DriverManager
	                .getConnection("jdbc:mysql://localhost:3306/swing",
	                        "root", "Sharadha@2019");
	    } catch (SQLException e) {
	        for(Throwable ex : e) { System.err.println("Error occurred " + ex);}
	      e.printStackTrace();}

	   
	   try {
	        java.sql.Statement stmt = connection.createStatement();
	        String query = "select * from movie ;";
	        ResultSet rs = stmt.executeQuery(query);
	        System.out.println("__________________________________________________________________________________________________");
	        System.out.println("||----------------------------------------------------------------------------------------------||");
	        System.out.printf("||%10s %20s %20s %20s %20s||", "MOVIE NAME", "LANGUAGE", "SHOW-TIMINGS", "NO-OF-TICKETS", "COST-OF-TICKETS");
	        System.out.println();
	        System.out.println("||----------------------------------------------------------------------------------------------||");
	         while (rs.next()) {
	        	String movie_name = rs.getObject(1).toString();
	            String language = rs.getObject(2).toString();
	            String show_timings= rs.getObject(3).toString();
	            String no_of_tickets = rs.getObject(4).toString();
	            String cost_of_tickets = rs.getObject(5).toString();
	            System.out.format("||%10s %20s %20s %20s %20s||",movie_name,language,show_timings,no_of_tickets,cost_of_tickets);
	            System.out.println();
	            System.out.println("||----------------------------------------------------------------------------------------------||");
	            System.out.println("__________________________________________________________________________________________________");
	      	         
	         }
	            sc.nextLine();
	            System.out.println("Enter the movie name which you want to book:"); 
	            String moviename=sc.nextLine();
	            
	            System.out.println("Do you want to continue (1.yes /2.No) : ");
	            status=sc.nextInt();
	            
	            PreparedStatement st = (PreparedStatement) connection
                        .prepareStatement("Select * from movie where movie_name = ?");

                    st.setString(1, moviename);
                    
                    ResultSet rs1 = st.executeQuery();
                    
                    if(rs1.next())
                    	{   
                    	System.out.println("You have selected the movie");
                    	System.out.println("__________________________________________________________________________________________________");
                    	System.out.println("||----------------------------------------------------------------------------------------------||");
        	            System.out.printf("||%10s %20s %20s %20s %20s||", "MOVIE NAME", "LANGUAGE", "SHOW-TIMINGS", "NO-OF-TICKETS", "COST-OF-TICKETS");
        	            System.out.println();
        	            System.out.println("----------------------------------------------------------------------------------------------");
                    	String movie_name = rs1.getObject(1).toString();
        	            String language = rs1.getObject(2).toString();
        	            String show_timings= rs1.getObject(3).toString();
        	            String no_of_tickets = rs1.getObject(4).toString();
        	            String cost_of_tickets = rs1.getObject(5).toString();
        	            System.out.format("||%10s %20s %20s %20s %20s||",movie_name,language,show_timings,no_of_tickets,cost_of_tickets);
        	            System.out.println();
        	            System.out.println("||----------------------------------------------------------------------------------------------||");
        	            System.out.println("__________________________________________________________________________________________________");
                    System.out.println("Would you like to book tickets for this movie?:");
	                System.out.println("Enter 1 to book and 2 to exit:");
	                int c=sc.nextInt();
	                if(c==2)
	                {   
	                    System.out.println("Have a good day :') signing off EasyTicket.");
	                    System.exit(0);
	                	return;
	                }
	                if(c==1)
	                {
	                 System.out.println("Enter the no. of tickets you want to book:");
	                 int tick=sc.nextInt();
	                 if(tick<Integer.parseInt(no_of_tickets))
	 		        	{
	                 int tc = tick * Integer.parseInt(cost_of_tickets);  
	             
	                 System.out.println("The bill comes up to:"+tc); 
	                 System.out.println("Do you want to continue (1.yes /2.No) : ");
	                 status=sc.nextInt(); 
	                 
	                cphone a4 = new cphone();
	         		cname a1 = new cname();
	         		caddress a2 = new caddress();
	         		cemail a3 = new cemail();
	                  
	         		a1.getcust_details();
	         		a2.getcust_details();
	         		a3.getcust_details();
	         		a4.getcust_details();
	         		
	         		 System.out.println("Do you want to continue (1.yes /2.No) : ");
	                 status=sc.nextInt(); 
	                 
	         	System.out.println("______________________________________________________________________");
                System.out.println("*********************************************************************");
                System.out.println("--------------------------MOVIE TICKET-------------------------------");
                
               
                
                a1.displaycust_details();
         		a2.displaycust_details();
         		a3.displaycust_details();
         		a4.displaycust_details();
                
                System.out.println("            Movie                      :      "+movie_name+"                      ");
                System.out.println("            Language                   :      "+language+"                        ");
                System.out.println("            Show Timings               :      "+show_timings+"                ");
                System.out.println("            No of tickets booked       :      "+tick+"                ");
                System.out.println("            Total cost of your bill    :      "+tc+"               ");
                System.out.println("-------------------------------------------------------------------");
                
    	           	// System.out.println("||                                                                   ||");	
		         		
	         	System.out.println("                                                                    ");	
	            System.out.println("---------------Thanks for booking ticket in EasyTicket--------------");
	            System.out.println("*********************************************************************");
	            System.out.println("______________________________________________________________________");
	            System.out.println("\n\n");
	            System.out.println("Check your registered email for more details.");
	            System.out.println("Have a goood day <3");
	       
	            
	            
	            
		        PreparedStatement st22 = (PreparedStatement) connection
                        .prepareStatement("UPDATE movie set no_of_tickets=no_of_tickets-? where movie_name = ?" );

		        try{
		        	if(tick<Integer.parseInt(no_of_tickets))
		        	{
		        		st22.setInt(1, tick); 
		        		st22.setString(2, moviename);
		 		        st22.executeUpdate();   
		        	}
		        }catch(Exception e) {e.printStackTrace();}   
		      
	                
	            }
	                 else
		                {
		                	System.out.println("sorry, the number of tickets available are only "
		                			+Integer.parseInt(no_of_tickets));
		                }
	                }
	                
	                
	        	}
       } catch (SQLException e) {
	        e.printStackTrace(); }
	    
	   break;
                    
	        
	  
       

case 4:  
	Connection connection1 = null;

    try {
        connection1 = DriverManager
                .getConnection("jdbc:mysql://localhost:3306/swing",
                        "root", "Sharadha@2019");
    } catch (SQLException e) {
        for(Throwable ex : e) { System.err.println("Error occurred " + ex);}
      e.printStackTrace();}

	try {
    java.sql.Statement stmt = connection1.createStatement();
    String query = "select * from movie ;";
    ResultSet rs = stmt.executeQuery(query);
    
    System.out.println("__________________________________________________________________________________________________");
    System.out.println("||----------------------------------------------------------------------------------------------||");
    System.out.printf("||%10s %20s %20s %20s %20s||", "MOVIE NAME", "LANGUAGE", "SHOW-TIMINGS", "NO-OF-TICKETS", "COST-OF-TICKETS");
    System.out.println();
    System.out.println("||----------------------------------------------------------------------------------------------||");
     while (rs.next()) {
    	String movie_name = rs.getObject(1).toString();
        String language = rs.getObject(2).toString();
        String show_timings= rs.getObject(3).toString();
        String no_of_tickets = rs.getObject(4).toString();
        String cost_of_tickets = rs.getObject(5).toString();
        System.out.format("||%10s %20s %20s %20s %20s||",movie_name,language,show_timings,no_of_tickets,cost_of_tickets);
        System.out.println();
        System.out.println("||----------------------------------------------------------------------------------------------||");
        System.out.println("__________________________________________________________________________________________________");
  	         
  /* if(movie_name!=null)
 	       {
 	    	   for(int i=0;i<movie_name.length();i++)
                {
                    movie_name[i].viewAllDetails();
                }*/	   
          /*else{
         	   System.out.println("we are sorry, movies are not available come back later :/");
            }*/
     }
} catch (SQLException e) {
    e.printStackTrace(); }
    
//default:System.out.println("Wrong choice...");
	    
      System.out.println("Do you want to continue (1.yes /2.No) : ");
      status=sc.nextInt();
      break;
      
case 5: 
	 
System.out.println("Have a good day :') signing off");  
System.exit(0);
return;
       }
	    }
    while(status==1);
   System.exit(0);
  
    System.out.println("Have a good day :') signing off");
    
   }


 }
	



	
