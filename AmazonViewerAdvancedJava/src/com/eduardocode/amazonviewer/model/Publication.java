package com.eduardocode.amazonviewer.model;

import java.util.ArrayList;
import java.util.Date;

public abstract class Publication {
	private String 	title;
	private Date 	editionDate;
	private String	editorial;
	private ArrayList<String> authors;
	
	public Publication() {}
	public Publication(String title, Date editionDate, String editorial, ArrayList<String> authors) {
		super();
		this.title = title;
		this.editionDate = editionDate;
		this.editorial = editorial;
		this.authors = authors;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Date getEditionDate() {
		return editionDate;
	}

	public void setEditionDate(Date editionDate) {
		this.editionDate = editionDate;
	}

	public String getEditorial() {
		return editorial;
	}

	public void setEditorial(String editorial) {
		this.editorial = editorial;
	}

	public ArrayList<String> getAuthors() {
		return authors;
	}

	public void setAuthors(ArrayList<String> authors) {
		this.authors = authors;
	}
	
	public static ArrayList<String> makeAuthorsList(){
		ArrayList<String> authors = new ArrayList<String>();
		for (int i = 0; i < 2 ; i++) {
			authors.add("Author" + (i+1));
		}
		return authors;
	}
	
	
}
