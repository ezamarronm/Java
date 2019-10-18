package com.eduardocode.amazonviewer.model;

import java.util.ArrayList;
import java.util.Date;

import com.eduardocode.amazonviewer.dao.MagazineDAO;

	public class Magazine extends Publication implements MagazineDAO{
		private int id;

		public Magazine() {}
		public Magazine(String title, Date editionDate, String editorial, ArrayList<String> authors) {
			super(title, editionDate, editorial, authors);
			// TODO Auto-generated constructor stub
		}		
		public int getId() {
			return id;
		}

		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return "Title: " + getTitle() +
					"\n Edition Date:" + getEditionDate() +
					"\n Editorial: " + getEditorial() + 
					"\n Authors: " + getAuthors();
		}
		
		public static ArrayList<Magazine> makeMagazineList(){
			ArrayList<Magazine> magazines = new ArrayList<Magazine>();
			Magazine magazine = new Magazine();
			return magazine.read();
		}
		
}
