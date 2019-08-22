package com.eduardocode.viewer.model;

import java.util.ArrayList;
import java.util.Date;

public class Book extends Publication implements IViewable{
	private int  		id;
	private String		isbn;
	private boolean		read;
	private int		timeRead;
	
	public Book(String title, Date editionDate, String editorial, ArrayList<String> authors) {
		super(title, editionDate, editorial, authors);
		// TODO Auto-generated constructor stub
	}	
	
	public int getId() {
		return id;
	}

	public String getIsbn() {
		return isbn;
	}


	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}


	public String isRead() {
		return read ? "Yes" : "No";
	}


	public void setRead(boolean read) {
		this.read = read;
	}


	public int getTimeRead() {
		return timeRead;
	}


	public void setTimeRead(int timeRead) {
		this.timeRead = timeRead;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		String detailBook = "Title: " + getTitle() +
				"\n Edition Date:" + getEditionDate() +
				"\n Editorial: " + getEditorial() + 
				"\n Authors: \n";
		for (int i = 0; i < getAuthors().size(); i++) {
			detailBook += "\t" + getAuthors().get(i);
		}
		return detailBook;
	}

	@Override
	public Date startToSee(Date dateI) {
		// TODO Auto-generated method stub
		return dateI;
	}

	@Override
	public void stopToSee(Date dateI, Date dateF) {
		// TODO Auto-generated method stub
		int result = dateF.getTime() > dateI.getTime() ? (int) (dateF.getTime() - dateI.getTime()) : 0;
		  this.setTimeRead(result);
		
	}
	
	public static ArrayList<Book> makeBooksList(){
		ArrayList<Book> books = new ArrayList<Book>();
		for (int i = 0; i < 5; i++) {
			books.add(new Book("Book " + (i+1), new Date(), "Editorial " + (i+1), makeAuthorsList()));
		}
		return books;
	}
}
