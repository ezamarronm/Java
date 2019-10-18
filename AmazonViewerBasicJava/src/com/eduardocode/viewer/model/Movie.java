package com.eduardocode.viewer.model;

import java.util.ArrayList;
import java.util.Date;

public class Movie extends Film implements IViewable {
	private int		id;
	private int 	timeWatched;
	
	
	public Movie(String title, String genre, String creator, int duration, int year) {
		super(title, genre, creator, duration);
		setYear((short)year);
	}	
	public void showData() {
		//System.out.println("Title: " + title);
		//System.out.println("Genre: " + genre);
		//System.out.println("Year: " + year);
	}

	public int getId() {
		return id;
	}

	public int getTimeWatched() {
		return timeWatched;
	}


	public void setTimeWatched(int timeWatched) {
		this.timeWatched = timeWatched;
	} 
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "\nTitle: " + getTitle() +
				"\n Genre: "+ getGenre() + 
				"\n Year: " + getYear() + 
				"\n Creator: " + getCreator() +
				"\n Duration: " + getDuration();
	}
	@Override
	public Date startToSee(Date dateI) {
		// TODO Auto-generated method stub
		return dateI;
	}
	@Override
	public void stopToSee(Date dateI, Date dateF) {
		// TODO Auto-generated method stub
		/*if (dateF.getSeconds() > dateI.getSeconds() )
			setTimeWatched(dateF.getSeconds() - dateI.getSeconds());
		else
			setTimeWatched(0);
		*/
		//Usando el operador ternario y sin getseconds que estrá obsoleto
		int result = dateF.getTime() > dateI.getTime() ? (int) (dateF.getTime() - dateI.getTime()) : 0;
		  this.setTimeWatched(result);
	}
	
	public static ArrayList<Movie> makeMoviesList(){
		ArrayList<Movie> movies = new ArrayList<Movie>();
		
		for (int i = 1; i <= 5; i++) {
			movies.add(new Movie("Movie " + i, "Genre " + i, "Creator " + i, 120+1, (short)(2019+1)));
 			
		}
		
		return movies;
	}
	
	
}
