package javaprojectswings;


import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

abstract class Customermain {                                              /////abstract class
	 
    
	String  custphone, custName , custaddress ,custemail;
	Scanner input = new Scanner(System.in);

	abstract void getcust_details();                                      /////abstract methods
	abstract void displaycust_details();

}


class cphone extends Customermain {
	void getcust_details() {
		try {                                                           ////////exception handling
		System.out.println("Enter your phone number : ");                            ///try,catch
		custphone = input.nextLine();
		/* 
		 Regular Expressions or Regex (in short) is an API for defining String patterns // java regex
		 that can be used for searching, manipulating and editing a string in Java. 
		 Email validation and passwords are few areas of strings 
		 where Regex are widely used to define the constraints.
		 */
		final String regexStr = "^(1\\-)?[0-9]{3}\\-?[0-9]{3}\\-?[0-9]{4}$";
	    if (!Pattern.matches(regexStr, custphone)) 
	    {
	        throw new Exception("it doesnt have 10 digits!");                       ////throw
	    }
		}
	    	catch(Exception e)
	    	{
	    		System.out.println(e);
	    		e.printStackTrace();
	    		
	    	}
	    }
	
	  
	void displaycust_details()
	{
		
		
		System.out.println("            Phone number               :      "+custphone+"                ");
	       
	      
	}
}

class cname extends Customermain {
	
	void getcust_details() { 
		System.out.print("Enter your full name: ");
		custName = input.nextLine();
	}
	void displaycust_details() {
		
		System.out.println("            Customer name              :      "+custName+"                        ");
        
	}
}


class caddress extends Customermain {
	
	void getcust_details() {
		System.out.print("Enter your place: ");
	custaddress = input.nextLine();
	}
	void displaycust_details() {
		
	
		  
        System.out.println("            Address                    :      "+custaddress+"                ");
	}
}

class cemail extends Customermain {
	
	void getcust_details() {
		System.out.print("Enter your email address: ");
	custemail = input.nextLine(); 
	//Regular Expression                                                       ///used regex
    String regex = "^(.+)@(.+)$";  
    //Compile regular expression to get the pattern  
    Pattern pattern = Pattern.compile(regex);  
     //Create instance of matcher   
        Matcher matcher = pattern.matcher(custemail);  
        System.out.println( " : "+ matcher.matches()+"\n");  
	}
	void displaycust_details() {
		
		System.out.println("            Email                      :      "+custemail+"                      ");
        
        
	}
}

public class Customer {
	public static void main(String[] args) {
		
		
		
	}
}

