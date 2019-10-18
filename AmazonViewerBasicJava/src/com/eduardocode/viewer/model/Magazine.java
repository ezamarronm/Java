package com.eduardocode.viewer.model;

import java.util.ArrayList;
import java.util.Date;

	public class Magazine extends Publication{
		private int id;

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
}
