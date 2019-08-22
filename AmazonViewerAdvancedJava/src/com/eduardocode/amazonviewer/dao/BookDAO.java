package com.eduardocode.amazonviewer.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.eduardocode.amazonviewer.db.IDBConnection;
import com.eduardocode.amazonviewer.model.Book;
import com.eduardocode.amazonviewer.model.Book.Page;

import static com.eduardocode.amazonviewer.db.DataBase.*;


public interface BookDAO extends IDBConnection {
	default Book setBookRead(Book book) {
		try(Connection connection = connectToDB()) {
			Statement statement = connection.createStatement();
			String query = "INSERT INTO " + TWATCHED + 
					" (" + TWATCHED_ID_MATERIAL + ", " + TWATCHED_ID_ELEMENT + ", " + TWATCHED_ID_USER + ")" +
					" VALUES ("+ TMATERIAL_ID[3] + ", " + book.getId() + ", " + TUSER_ID + ")";
			if(statement.executeUpdate(query) > 0 ) {
				 System.out.println( book.getTitle() + " was set as Watched");
			}

		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return book; 
		//
	}

	default ArrayList<Book> read(){ 
		ArrayList<Book> books = new ArrayList<Book>();

		try (Connection connection = connectToDB()){
			String query = "SELECT * FROM " + TBOOK;

			PreparedStatement ps = connection.prepareStatement(query);

			ResultSet rs = ps.executeQuery();

			while(rs.next()) {	
				//ArrayList<Page> pages = new ArrayList<Page>();
				ArrayList<String> authors = new ArrayList<String>();
				ArrayList<Page> pages = new ArrayList<Page>();

				Book book = new Book();
				book.setId(Integer.valueOf(rs.getString(TBOOK_ID)));
				book.setTitle(rs.getString(TBOOK_TITLE));
				book.setEditionDate(rs.getDate(TBOOK_EDITIONDATE));
				book.setEditorial(rs.getString(TBOOK_EDITORIAL));
				
				//Authors
				String query2 = "SELECT * FROM " + TAUTHOR + " WHERE " + TAUTHOR_BOOKID + "=" + book.getId();
				PreparedStatement ps2 = connection.prepareStatement(query2);
				ResultSet rs2 = ps2.executeQuery();
				while(rs2.next()) {
					authors.add(rs2.getString(TAUTHOR_AUTHOR));
				}
				
				//Pages
				query2 = "SELECT * FROM " + TPAGE + " WHERE " + TPAGE_BOOKID + "=" + book.getId();
				ps2 = connection.prepareStatement(query2);
				rs2 = ps2.executeQuery();
				while(rs2.next()) {
					Page page = new Page();
					page.setNumber(Integer.valueOf(rs2.getString(TPAGE_PAGENUMBER)));
					page.setContent(rs2.getString(TPAGE_PAGE));
					page.setId(Integer.valueOf(rs2.getString(TPAGE_ID)));
					pages.add(page);
				}
				//Add
				book.setAuthors(authors);
				book.setPages(pages);
				book.setRead(getBookRead(ps, connection,book.getId() ));

				books.add(book);
			}
			
		} catch (SQLException e) {
			
			// TODO: handle exception
		}

		return books;
	}
	
	private boolean getBookRead(PreparedStatement ps, Connection connection, int id_book){
		boolean read = false;
		String query = "SELECT * FROM " + TWATCHED + 
				" WHERE " + TWATCHED_ID_MATERIAL + " = ?" +
				" AND " + TWATCHED_ID_ELEMENT + " = ?" +
				" AND " + TWATCHED_ID_USER + " = ?";
		ResultSet rs = null;
		try {
			ps = connection.prepareStatement(query);
			ps.setInt(1, TMATERIAL_ID[3]);
			ps.setInt(2, id_book);
			ps.setInt(3, TUSER_ID);
			
			rs = ps.executeQuery();
			
			
			read = rs.next();
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return read;
		
	}


}
