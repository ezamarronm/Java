package com.eduardocode.amazonviewer.model;

import java.util.ArrayList;
import java.util.Date;

/**
 * Inherits from {@link Movie}
 * @see Film
 * */
public class Chapter extends Movie implements IViewable{
	private int 	id;
	private int seasonNumber;
	private Series series;
	
	public Chapter(String title, String genre, String creator, int duration, int year, int seasonNumber, Series series) {
		super(title, genre, creator, duration, year);
		this.setSeasonNumber(seasonNumber);
		this.setSeries(series);
		// TODO Auto-generated constructor stub
	}



	@Override
	public int getId() {
		// TODO Auto-generated method stub
		return this.id;
	}
	public int getSeasonNumber() {
		return seasonNumber;
	}
	public void setSeasonNumber(int seasonNumber) {
		this.seasonNumber = seasonNumber;
	}
	public Series getSeries() {
		return series;
	}

	public void setSeries(Series series) {
		this.series = series;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Title: " + getTitle() +
				"\n Genre: " + getGenre() +
				"\n Creator: " + getCreator() +
				"\n Duration: " + getDuration() +
				"\n Year: " + getYear();
	}
	
	public static ArrayList<Chapter> makeChaptersList(Series series){
		ArrayList<Chapter> chapters = new ArrayList<Chapter>();
		for (int i = 0; i < 4; i++) {
			chapters.add(new Chapter("Chapter " + (i+1), "Genre " + (i+1), "Creator" + (i+1), 23, (short)2019, i+1, series));
		}
		return chapters;
	}
	
	@Override
	public void watch() {
		// TODO Auto-generated method stub
		super.watch();
		setWatched(true);
		Date dateI = startToWatch(new Date());
		for (int i = 0; i < 101; i++) {
			System.out.println(i+"%");
		}
		
		//It finished to watched the chapter
		stopToWatch(dateI, new Date());
		System.out.println("You watched "+ toString());
		System.out.println("For " + getTimeWatched() + "miliseconds");
		
		ArrayList<Chapter> chapters = getSeries().getChapters();
		int chapterWatchedCounter = 0;
		for (Chapter chapter : chapters) {
			if (chapter.getIsWatched()) {
				chapterWatchedCounter++; 
			}			
		}
		if (chapterWatchedCounter == chapters.size()) {
			getSeries().watch();
		}
	}
}
