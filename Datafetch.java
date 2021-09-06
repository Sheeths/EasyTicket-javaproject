package javaprojectswings;

import java.awt.BorderLayout;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;


public class Datafetch {
	
	private boolean status;

	public Datafetch (String title) {

		// Creating Window using JFrame
		JFrame frame = new JFrame();
		frame.setTitle(title);
		frame.setSize(800, 500);

		// Adding Table View
		frame.add(getTablePanel());
        frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setVisible(true);
	}

	private JPanel getTablePanel() {

		JPanel tableJPanel = new JPanel();
		
		tableJPanel.setLayout(new BorderLayout());
		
		// Column Header
		String[] columns = {

		"Movie name", "Language", "Show_timings",
				"No_of_tickets", "Cost_of_tickets" };

		// Getting Data for Table from Database
		Object[][] data = getEmployeeDetails();

		// Creating JTable object passing data and header
		JTable mTable = new JTable(data, columns);
		
		
		tableJPanel.add(mTable.getTableHeader(), BorderLayout.NORTH);
		tableJPanel.add(mTable, BorderLayout.CENTER);
		
		return tableJPanel;
	}

	private Object[][] getEmployeeDetails() {

		Object[][] data = null;

	final String DRIVER_NAME = "com.mysql.cj.jdbc.Driver";
	/*	final String CONNECTION_URL = "jdbc:mysql://localhost:3306/ems";
		final String USERNAME = "root";
		final String PASSWORD = "";*/

		//final String QUERY = "Select empId, empName, empAge, empQualification, empAddress from employee_details";

		try {

			// Loading the Driver
			Class.forName(DRIVER_NAME);

			// Getting Database Connection Object by Passing URL, Username and Password
			//Connection connection = DriverManager.getConnection(CONNECTION_URL, USERNAME, PASSWORD);

			Connection connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/swing",
                     "root", "Sharadha@2019");
			 
			String query = "Select movie_name,language,show_timings ,no_of_tickets,cost_of_tickets from movie";
            Statement statement = connection.createStatement(  ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_UPDATABLE);
             
            
			ResultSet rs = statement.executeQuery(query);

			int rowCount = getRowCount(rs); // Row Count
			int columnCount = getColumnCount(rs); // Column Count

			data = new Object[rowCount][columnCount];

			// Starting from First Row for Iteration
			rs.beforeFirst();

			int i = 0;
			
			while (rs.next()) {

				int j = 0;

				data[i][j++] = rs.getString("movie_name");
				data[i][j++] = rs.getString("language");
				data[i][j++] = rs.getString("show_timings");
				data[i][j++] = rs.getInt("no_of_tickets");
				data[i][j++] = rs.getInt("cost_of_tickets");

				i++;
			}

			status = true;
			
			// Closing the Resources;
			statement.close();
			connection.close();
			
		} catch (Exception e) {

			e.printStackTrace();
		}

		return data;
	}

	// Method to get Row Count from ResultSet Object
	private int getRowCount(ResultSet rs) {

		try {
			
			if(rs != null) {
				
				rs.last();
				
				return rs.getRow(); 
			}
			
		} catch (SQLException e) {

			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		
		return 0;
	}

	// Method to get Column Count from ResultSet Object
	private int getColumnCount(ResultSet rs) {

		try {

			if(rs != null)
				return rs.getMetaData().getColumnCount();

		} catch (SQLException e) {

			System.out.println(e.getMessage());
			e.printStackTrace();
		}

		return 0;
	}

	/*@Override
	public String toString() {
		
		return (status) ? "Data Listed Successfully" : "Application Error Occured";
	}*/
	
	public static void main(String[] args) {

		
	}
}