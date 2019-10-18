package com.eduardocode.amazonviewer.db;


import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;
public interface IDBConnection {
	default Connection connectToDB() {
		Connection connection = null;
		try(FileInputStream fis=new FileInputStream ("connection.prop");) {

			Properties p=new Properties ();
	        p.load (fis); 
	        String DB= (String) p.get ("DB"); 
	        String URL= (String) p.get ("URL"); 
	        String USER= (String) p.get ("USER"); 
	        String PASSWORD= (String) p.get ("PASSWORD"); 
			Class.forName("com.mysql.jdbc.Driver"); //To call the driver
			connection = DriverManager.getConnection(URL + DB, USER, PASSWORD); //Using class DriverManager
			if (connection != null) {
				//System.out.println("The connection has been stablished");
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace(); //Only for debugging
		}finally {
			return connection;
		}
	}
}
