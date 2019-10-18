package com.eduardocode.amazonviewer;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import com.eduardocode.makereport.Report;
import com.eduardocode.viewer.model.Book;
import com.eduardocode.viewer.model.Chapter;
//import com.eduardocode.viewer.model.Magazine;
import com.eduardocode.viewer.model.Movie;
import com.eduardocode.viewer.model.Series;
import com.eduardocode.util.AmazonUtil;;


public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("WELCOME TO AMAZON VIEWER");
		System.out.println("");
		showMenu();	}

	public static void showMenu() {
		 int optMenu;
		do {
			System.out.println("Select a number");
			System.out.println("1. Movies");
			System.out.println("2. Series");
			System.out.println("3. Books");
			System.out.println("4. Magazines");
			System.out.println("5. Report");
			System.out.println("6. Today's Report");
			System.out.println("0. Exit");
			optMenu = AmazonUtil.validateUserResponseMenu(0, 6);
			
			switch (optMenu) {
				case 1:
					showMovies();
					break;
				case 2:
					showSeries();
					break;
				case 3:
					showBooks();
					break;
				case 4:
					showMagazines();
					break;
				case 0:
					showExitMessage();
					break;
				case 5:
					makeReport();
					break;
				case 6:
					makeReport(new Date());
					break;
				default:
					System.out.println("Please select a valid option");
					break;					
			}
			
		}while(optMenu != 0);
		//scMenu.close();
	}
	static ArrayList<Movie> movies = Movie.makeMoviesList();
	public static void showMovies() {
		int opt;
		do {
			System.out.println();
			System.out.println(":: MOVIES ::");
			System.out.println();
			for (int i = 0; i < movies.size(); i++) {
				System.out.println(i+1 + ".- " + movies.get(i).getTitle() + " Watched: " + movies.get(i).isWatched());
				
			}
			System.out.println("0. Back to Menu");
			System.out.println();
			
			//Read user answer
			opt = AmazonUtil.validateUserResponseMenu(0, 6);
			
			if (opt != 0) {
			//Selecting movie
			Movie movieSelected = movies.get(opt-1);
			Date dateI = movieSelected.startToSee(new Date());
			
			for (int i = 0; i < 100; i++) {
				System.out.println("...---...");
				
			}
			
			//Movie Watched
			movieSelected.setWatched(true);
			
			//It finished to watch the movie
			movieSelected.stopToSee(dateI, new Date());
			System.out.println();
			System.out.println("You saw this movie: " + movieSelected);
			System.out.println("For " + movieSelected.getTimeWatched() + " miliseconds");
			}

		}while(opt !=0 );
	}
	
	public static void showSeries() {
		ArrayList<Series> series = Series.makeSeriesList();
		int opt = 0;
		do {
			System.out.println();
			System.out.println(":: SERIES ::");
			System.out.println();
			for(int i = 0; i < series.size(); i++) {
				System.out.println((i+1) + ".-" + series.get(i).getTitle() + " Watched: " + series.get(i).isWatched());
			}
			System.out.println("0 Regresar al Menu");
			
			//Read User Answer
			opt = AmazonUtil.validateUserResponseMenu(0, 6);
			
			if (opt != 0) {
				showChapters(series.get(opt).getChapters());
			}
		}while(opt !=0 );
	}
	
	public static void showBooks() {
		int opt;
		ArrayList<Book> books = Book.makeBooksList();
		do {
			
			//Show Books
			System.out.println();
			System.out.println(":: BOOKS ::");
			System.out.println();
			for (int i = 0; i < books.size(); i++) {
				System.out.println((i+1) + ".- " + books.get(i).getTitle() + " Read: " + books.get(i).isRead());
				
			}
			System.out.println("0. Back to Menu");
			System.out.println();
			
			//Read user Answer
			opt = AmazonUtil.validateUserResponseMenu(0, 6);
			
			if (opt != 0) {
				//Selecting Book
				Book bookSelected = books.get(opt-1);
				Date dateI = bookSelected.startToSee(new Date());
				
				for (int i = 0; i < 100 ; i++)
					System.out.println(i+"%");
				
			//Book Read
				bookSelected.setRead(true);
			//It finished to read book
				bookSelected.stopToSee(dateI, new Date());
				
				System.out.println();
				System.out.println("You saw this book: " + bookSelected);
				System.out.println("For " + bookSelected.getTimeRead() + " miliseconds");
			}
			
			
		}while(opt !=0 );
	}
	
	public static void showMagazines() {
		int opt = 0;
		do {
			System.out.println();
			System.out.println(":: MAGAZINES ::");
			System.out.println();
		}while(opt !=0 );
	}
	
	public static void showExitMessage() {
		System.out.println("See you...");
	}
	public static void showChapters(ArrayList<Chapter> chaptersOfSerieSelected) {
		int opt = 0;
		do {
			System.out.println();
			System.out.println(":: CHAPTERS::");
			System.out.println();
			for (int i = 0; i < chaptersOfSerieSelected.size(); i++) {
				System.out.println((i+1) + ".-" + chaptersOfSerieSelected.get(i).getTitle() + " Watched: " + chaptersOfSerieSelected.get(i).isWatched());
			}
			System.out.println("Back to Menu");
			
			//Read user answer
			opt = AmazonUtil.validateUserResponseMenu(0, 6);
			
			if (opt != 0) {
				//Selecting Chapter
				Chapter chapterSelected = chaptersOfSerieSelected.get(opt-1);
				chapterSelected.setWatched(true);
				Date dateI = chapterSelected.startToSee(new Date());
				for (int i = 0; i < 101; i++) {
					System.out.println(i+"%");
				}
				
				//It finished to watched the chapter
				chapterSelected.stopToSee(dateI, new Date());
				System.out.println("You watched "+ chapterSelected);
				System.out.println("For " + chapterSelected.getTimeWatched() + "miliseconds");
			}
		}while (opt != 0);
	}
	
	public static void makeReport() {
		Report report = new Report();
		report.setNameFile("Reporte");
		report.setTitle("::WATCHED::");
		report.setExtension("txt");
		String contentReport = "";
		for (Movie movie : movies) {
			if (movie.getIsWatched() == true)
				contentReport += movie.toString()+ "\n";
		}		
		report.setContent(contentReport);
		report.makeReport();
	}
	
	public static void makeReport(Date date) {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		String dateString = df.format(date);
		Report report = new Report();

		report.setNameFile("reporte" + dateString);
		report.setTitle("::WATCHED::");
		report.setExtension("txt");
		String contentReport = "";
		for (Movie movie : movies) {
			if (movie.getIsWatched() == true)
				contentReport += movie.toString()+ "\n";
		}		
		report.setContent(contentReport);
		report.makeReport();
	}
	

}
