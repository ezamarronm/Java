package com.eduardocode.amazonviewer.model;

import java.util.ArrayList;

public class Series extends Film{


	private int 	id;
	private int 	seasonQuantity;
	private ArrayList<Chapter> chapters;
	
	public Series(String title, String genre, String creator, int duration, int seasonQuantity) {
		super(title, genre, creator, duration);
		this.seasonQuantity = seasonQuantity;
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}
	

	public int getSeasonQuantity() {
		return seasonQuantity;
	}


	public void setSeasonQuantity(int seasonQuantity) {
		this.seasonQuantity = seasonQuantity;
	}

	public ArrayList<Chapter> getChapters() {
		return chapters;
	}

	public void setChapters(ArrayList<Chapter> chapters) {
		this.chapters = chapters;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Title: " + getTitle() + 
				"\n Genre: " + getGenre() +
				"\n Creator: " + getCreator() +
				"\n Duration: " + getDuration() +
				"\n Season Quantity" + getSeasonQuantity();
	}
	
	public static ArrayList<Series> makeSeriesList(){
		ArrayList<Series> series = new ArrayList<Series>();
		for (int i = 0; i < 5; i++) {
			Series newSeries = new Series("Series " + (i+1), "Genre " + (i+1), "Creator" + (i+1), 1200+i, i);
			newSeries.setChapters(Chapter.makeChaptersList(newSeries));
			series.add(newSeries);			
		}
		return series;
	}

	@Override
	public void watch() {
		// TODO Auto-generated method stub
		setWatched(true);
	}
}
