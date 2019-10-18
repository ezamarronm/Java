package com.eduardocode.amazonviewer.dao;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.eduardocode.amazonviewer.db.IDBConnection;
import com.eduardocode.amazonviewer.model.Movie;

import static com.eduardocode.amazonviewer.db.DataBase.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
public interface MovieDAO extends IDBConnection{
	
	default Movie setMovieWatched(Movie movie) { //
		try(Connection connection = connectToDB()) {
			Statement statement = connection.createStatement();
			String query = "INSERT INTO " + TWATCHED + 
					" (" + TWATCHED_ID_MATERIAL + ", " + TWATCHED_ID_ELEMENT + ", " + TWATCHED_ID_USER + ")" +
					" VALUES ("+ TMATERIAL_ID[0] + ", " + movie.getId() + ", " + TUSER_ID + ")";
			if(statement.executeUpdate(query) > 0 ) {
				 System.out.println( movie.getTitle() + " was set as Watched");
			}

		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return movie; 
  	}
	
	default ArrayList<Movie> read(){ //READ
		ArrayList<Movie> movies = new ArrayList<Movie>();
		try(Connection connection = connectToDB()) {
			String query = "SELECT * FROM " + TMOVIE;
			PreparedStatement preperedStatemaent = connection.prepareStatement(query);
			ResultSet rs = preperedStatemaent.executeQuery();
			while (rs.next()) {
				Movie movie = new Movie(
						rs.getString(TMOVIE_TITLE), 
						rs.getString(TMOVIE_GENRE), 
						rs.getString(TMOVIE_CREATOR), 
						Integer.valueOf(rs.getString(TMOVIE_DURATION)), 
						Short.valueOf(rs.getString(TMOVIE_YEAR)));
				movie.setId(Integer.valueOf(rs.getString(TMOVIE_ID)));
				movie.setWatched(getMovieWatched(preperedStatemaent, connection,movie.getId() ));
				movies.add(movie);
			}
			
		} catch (SQLException e) {
			// TODO: handle exception
		}
		return movies;
	}
	
	
	
	private boolean getMovieWatched(PreparedStatement ps, Connection connection, int id_movie){ 
		boolean watched = false;
		String query = "SELECT * FROM " + TWATCHED + 
				" WHERE " + TWATCHED_ID_MATERIAL + " = ?" +
				" AND " + TWATCHED_ID_ELEMENT + " = ?" +
				" AND " + TWATCHED_ID_USER + " = ?";
		ResultSet rs = null;
		try {
			ps = connection.prepareStatement(query);
			ps.setInt(1, TMATERIAL_ID[0]);
			ps.setInt(2, id_movie);
			ps.setInt(3, TUSER_ID);
			
			rs = ps.executeQuery();
			
			
			watched = rs.next();
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return watched;
	}

}
