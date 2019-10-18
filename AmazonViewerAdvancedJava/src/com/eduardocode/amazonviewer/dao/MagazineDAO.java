package com.eduardocode.amazonviewer.dao;

import static com.eduardocode.amazonviewer.db.DataBase.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.eduardocode.amazonviewer.db.IDBConnection;
import com.eduardocode.amazonviewer.model.Magazine;
import com.eduardocode.amazonviewer.model.Movie;

public interface MagazineDAO extends IDBConnection{
	default ArrayList<Magazine> read(){
		ArrayList<Magazine> magazines = new ArrayList<Magazine>();
		try(Connection connection = connectToDB()) {
			String query = "SELECT * FROM " + TMAGAZINE;
			PreparedStatement preperedStatemaent = connection.prepareStatement(query);
			ResultSet rs = preperedStatemaent.executeQuery();
			while (rs.next()) {
				Magazine magazine= new Magazine();
				magazine.setTitle(rs.getString(TMAGAZINE_TITLE)); 
				magazine.setEditionDate(rs.getDate(TMAGAZINE_EDITIONDATE));
				magazine.setEditorial(rs.getString(TMAGAZINE_EDITORIAL));
				magazines.add(magazine);
			}
			
		} catch (SQLException e) {
			// TODO: handle exception
		}
		return magazines;
	} 

}
