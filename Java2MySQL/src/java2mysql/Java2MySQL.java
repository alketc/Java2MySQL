package java2mysql;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;



public class Java2MySQL {

		
		public static void  main (String [] args) throws Exception {
		
			System.out.println("-------- MySQL JDBC Connection Testing, Table Creation and Insertion of data------------");
		
			Class.forName("com.mysql.jdbc.Driver");
		    Connection connection  = DriverManager.getConnection("jdbc:mysql://localhost:3306","root", "root");
		    String create_db = "create database test4";
		    Statement statement3 = connection.createStatement();
			 
			statement3.execute(create_db);
			System.out.println("DB test4 created");
			String use = "USE test4";
			System.out.println("database to "+use);
			// I already have a database called test. 
			// here I create a table called books
			String createTableSQL = "CREATE TABLE books2 ("
					
					+ " title VARCHAR(50),"
					+ " price INT,"
					+ "qty INT)";
			
			Statement statement = connection.createStatement();
			 
			statement.execute(use);
			statement.execute(createTableSQL);
		    String file2read = "file2read.txt";
		    
			BufferedReader br = new BufferedReader(new FileReader(new File(file2read)));
			String line;
			int counter = 0;
			while((line = br.readLine())!= null){
				
			String [] r = line.split(",");
			String title = r[0];
			int price = Integer.parseInt(r[1]);
			int qty = Integer.parseInt(r[2]);
			String insert = "INSERT INTO books2 (title, price, qty)"
					 +" VALUES ('"+title+"', '"+price+"', '"+qty+"')";
             
			Statement statement2 = connection.createStatement();

			statement2.executeUpdate(insert);
			System.out.println("inserted record "+counter);
			counter++;
			}br.close();
			System.out.println("query executed");
			// close connection
			connection.close();
			
	    }
	}

