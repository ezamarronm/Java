package com.eduardocode.amazonviewer.model;

/**
 * <h1> Film</h1>
 * Film is an abstract parent class
 * <p>
 * This class is the base class of the Film's family, As it is abstract we cannot create instances of it.
 * It contains the abtract method 
 * {@code watch()} which is mandatory to implement to every member of the family
 * 
 * @author Eduardo Zamarrón
 * @version 1.1
 * @since 2019
 * 
 * */
public abstract class Film {
	private String 	title;
	private String	genre; 
	private String 	creator;
	private int 	duration;
	private short	year;
	private boolean watched;
	
	
	public Film() {}
	public Film(String title, String genre, String creator, int duration) {
		super();
		this.title = title;
		this.genre = genre;
		this.creator = creator;
		this.duration = duration;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public String getCreator() {
		return creator;
	}
	public void setCreator(String creator) {
		this.creator = creator;
	}
	public int getDuration() {
		return duration;
	}
	public void setDuration(int duration) {
		this.duration = duration;
	}
	public short getYear() {
		return year;
	}
	public void setYear(short year) {
		this.year = year;
	}
	public String isWatched() {
		/*if (watched == true)
			return "Yes";
		else
			return "No";
		*/
		return watched ? "Yes" : "No";
	}
	
	public boolean getIsWatched() {
		return watched;
	}
	public void setWatched(boolean watched) {
		this.watched = watched;
	}
	/**
	 * {@code watch()} is an abstract method mandatory to implement
	 * */
	public abstract void watch();
}

