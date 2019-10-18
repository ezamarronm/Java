package com.eduardocode.amazonviewer.model;

import java.util.ArrayList;
import java.util.Date;

import com.eduardocode.amazonviewer.dao.BookDAO;
import com.eduardocode.util.AmazonUtil;

public class Book extends Publication implements IViewable, BookDAO{
	private int  			id;
	private String			isbn;
	private boolean			read;
	private int				timeRead;
	private ArrayList<Page> pages;
	
	public Book() {};
	public Book(String title, Date editionDate, String editorial, ArrayList<String> authors, ArrayList<Page> pages) {
		super(title, editionDate, editorial, authors);
		this.pages = pages;
		// TODO Auto-generated constructor stub
	}	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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
	
	public ArrayList<Page> getPages() {
		return pages;
	}

	public void setPages(ArrayList<Page> pages) {
		this.pages = pages;
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
	public Date startToWatch(Date dateI) {
		// TODO Auto-generated method stub
		return dateI;
	}

	@Override
	public void stopToWatch(Date dateI, Date dateF) {
		// TODO Auto-generated method stub
		int result = dateF.getTime() > dateI.getTime() ? (int) (dateF.getTime() - dateI.getTime()) : 0;
		  this.setTimeRead(result);
		
	}
	
	public static ArrayList<Book> makeBooksList(){
		/*ArrayList<Book> books = new ArrayList<Book>();
		ArrayList<Page> pages = new ArrayList<Book.Page>();
		int page;
		for (int i = 0; i < 3; i++) {
			page = i+1;
			pages.add(new Book.Page(page, "Content of the Page " + page));
			
		}
		for (int i = 0; i < 5; i++) {
			books.add(new Book("Book " + (i+1), new Date(), "Editorial " + (i+1), makeAuthorsList(), pages));
		}*/
		Book books = new Book();
		return books.read();
	}
	
	public void watch() {
		Date dateI = startToWatch(new Date());
		int i=0;
		Book book = new Book();
		book.setBookRead(this);
		do {
			int response;
			System.out.println("Page " + getPages().get(i).getNumber()); //Shows the current page
			System.out.println(getPages().get(i).getContent()); //Shows content
			if(i == 0 ) {
				System.out.println();
				System.out.println("0. Close Book");
				System.out.println("1. Next Page");
				response = AmazonUtil.validateUserResponseMenu(0, 1);

			}else {
			System.out.println();
			System.out.println("0. Close book");
			System.out.println("1. Next Page");
			System.out.println("2. Previous Page");
			System.out.println();
			response = AmazonUtil.validateUserResponseMenu(0, 2);

			}
			
			if (response == 2) {
				i--;
				
			}else if(response == 1) {
				i++;
			}else {
				break;
			}
			

		} while (i < getPages().size());
		
		
	//Book Read
		setRead(true);
	//It finished to read book
		stopToWatch(dateI, new Date());
		
		System.out.println();
		System.out.println("You saw this book: " + toString());
		System.out.println("For " + getTimeRead() + " miliseconds");
	}
	
	public static class Page{
		private int id;
		private int number;
		private String content;

		public Page() {}

		public Page(int number, String content) {
			super();
			this.number = number;
			this.content = content;
		}
		
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public int getNumber() {
			return number;
		}
		public void setNumber(int number) {
			this.number = number;
		}
		public String getContent() {
			return content;
		}
		public void setContent(String content) {
			this.content = content;
		}
			
	}
	
}
