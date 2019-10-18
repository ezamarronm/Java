package com.eduardocode.amazonviewer.model;

import java.util.ArrayList;
import java.util.Date;

import com.eduardocode.amazonviewer.dao.MovieDAO;
/**
 * Movie inherits from {@link Film} class and implements from the {@link IViewable} interface 
 * */
public class Movie extends Film implements IViewable, MovieDAO {
	private int		id;
	private int 	timeWatched;
	
	public Movie(){}
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

	public void setId(int id) {
		this.id = id;
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
	/**
	 * {@inheritDoc}}
	 * */
	@Override
	public Date startToWatch(Date dateI) {
		// TODO Auto-generated method stub
		return dateI;
	}
	/**
	 * {@inheritDoc}}
	 * */
	@Override
	public void stopToWatch(Date dateI, Date dateF) {
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
		Movie movies = new Movie();
		return movies.read();
	}
	/**
	 * {@inheritDoc}}
	 * */
	@Override
	public void watch() {
		// TODO Auto-generated method stub
		Date dateI = startToWatch(new Date());
		Movie movie = new Movie();
		movie.setMovieWatched(this);
		for (int i = 0; i < 100; i++) {
			System.out.println("...---...");
		
		}
	
		//Movie Watched
		setWatched(true);
	
		//It finished to watch the movie
		stopToWatch(dateI, new Date());
		System.out.println();
		System.out.println("You saw this movie: " + toString());
		System.out.println("For " + getTimeWatched() + " miliseconds");
	}
	
	
}
