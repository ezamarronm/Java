 package com.eduardocode.amazonviewer;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Consumer;
import java.util.function.Predicate;

import com.eduardocode.amazonviewer.model.Book;
import com.eduardocode.amazonviewer.model.Chapter;
import com.eduardocode.amazonviewer.model.Magazine;
import com.eduardocode.amazonviewer.model.Movie;
import com.eduardocode.amazonviewer.model.Series;
import com.eduardocode.makereport.Report;
import com.eduardocode.util.AmazonUtil;;

/**
 * <h1>Project AmazonViewer</h1>
 * Amazon Viewer is a program who allows to watch movies, series and their chapters,
 * books and magazines, it also allows to create daily and general reports  
 * <p>There are some rules such as all the elements can be watched or read except the magazines
 * they can be shown as a catalog but  not  read
 * </p>
 * @author Eduardo Zamarrón
 * @version 1.1
 * @since 2019
 * */
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
	static ArrayList<Movie> movies = new ArrayList<Movie>();
	public static void showMovies() {
		movies =  Movie.makeMoviesList();
		int opt;
		do {
			System.out.println();
			System.out.println(":: MOVIES ::");
			System.out.println();
			
			AtomicInteger atomicInteger = new AtomicInteger(1);
			movies.forEach( m -> System.out.println(atomicInteger.getAndIncrement() + ".- "+ m.getTitle() + " Watched: " + m.isWatched()));
			
			/*for (int i = 0; i < movies.size(); i++) {
				System.out.println(i+1 + ".- " + movies.get(i).getTitle() + " Watched: " + movies.get(i).isWatched());
				
			}*/
			System.out.println("0. Back to Menu");
			System.out.println();
			
			//Read user answer
			opt = AmazonUtil.validateUserResponseMenu(0, 6);
			
			if (opt != 0) {
			//Selecting movie
				Movie movieSelected = movies.get(opt-1);
				movieSelected.watch();
			}

		}while(opt !=0 );
	}
	static ArrayList<Series> series = Series.makeSeriesList();
	public static void showSeries() {
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
				showChapters(series.get(opt-1).getChapters());
			}
		}while(opt !=0 );
	}
	
	static ArrayList<Book> books = Book.makeBooksList();
	public static void showBooks() {
		int opt;
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
			opt = AmazonUtil.validateUserResponseMenu(0, 5);
			
			if (opt != 0) {
				//Selecting Book
				Book bookSelected = books.get(opt-1);
				bookSelected.watch();
			}
			
			
		}while(opt !=0 );
	}
	
	static ArrayList<Magazine> magazines = new ArrayList<Magazine>();
	public static void showMagazines() {
		int opt = 0;
		do {
			System.out.println();
			System.out.println(":: MAGAZINES ::");
			magazines =  Magazine.makeMagazineList();
			for (int i = 0; i < magazines.size(); i++) {
				System.out.println(magazines.get(i).getTitle());
				
			}
			System.out.println("0. Back to Menu");

			opt= AmazonUtil.validateUserResponseMenu(0, 0);
			
			if (opt != 0) {
				System.out.println("Please select a valid option");
				System.out.println("Try Again");
			}

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
			opt = AmazonUtil.validateUserResponseMenu(0, 4);
			
			if (opt != 0) {
				//Selecting Chapter
				Chapter chapterSelected = chaptersOfSerieSelected.get(opt-1);
				chapterSelected.watch();
				
			}
		}while (opt != 0);
	}
	
	public static void makeReport() {
		Report report = new Report();
		report.setNameFile("Reporte");
		report.setTitle("::WATCHED::");
		report.setExtension("txt");
		StringBuilder contentReport = new StringBuilder();
		
		movies.stream().filter( m -> m.getIsWatched()).forEach(m -> contentReport.append(m.toString()+ "\n") );
		//books.stream().filter( b -> b.getIsRead()).forEach(b -> contentReport.append(b.toString()+ "\n") );

		//Predicate<Series> predicate = s -> s.getIsWatched();
		//series.stream().filter(predicate);
		//Consumer<Series> seriesEach = s -> contentReport.append(s.toString()+ "\n");
		Consumer<Series> seriesEach = s -> {
			ArrayList<Chapter> chapters = s.getChapters();
			chapters.stream().filter(c -> c.getIsWatched()).forEach( c ->contentReport.append(c.toString()+ "\n"));
		};
		series.stream().forEach(seriesEach);
		report.setContent(contentReport.toString());
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
