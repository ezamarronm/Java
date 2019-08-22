package com.eduardocode.viewer.model;

import java.util.ArrayList;

public class Chapter extends Movie implements IViewable{
	private int 	id;
	private int seasonNumber;
	
	public Chapter(String title, String genre, String creator, int duration, int year, int seasonNumber) {
		super(title, genre, creator, duration, year);
		this.setSeasonNumber(seasonNumber);
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
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Title: " + getTitle() +
				"\n Genre: " + getGenre() +
				"\n Creator: " + getCreator() +
				"\n Duration: " + getDuration() +
				"\n Year: " + getYear();
	}
	
	public static ArrayList<Chapter> makeChaptersList(){
		ArrayList<Chapter> chapters = new ArrayList<Chapter>();
		for (int i = 0; i < 10; i++) {
			chapters.add(new Chapter("Chapter " + (i+1), "Genre " + (i+1), "Creator" + (i+1), 23, (short)2019, i+1));
		}
		return chapters;
	}
}
