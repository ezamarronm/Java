 package com.eduardocode.amazonviewer.db;

public class DataBase {
	//public static final String URL 			= "jdbc:mysql://localhost:3306/";
	//public static final String DB 			= "amazonviewer";
	//public static final String USER 		= "amazonvieweruser";
	//public static final String PASSWORD 	= "amazonviewer";
	

	public static final String TAUTHOR				= "author";
	public static final String TAUTHOR_ID			= "author_id";
	public static final String TAUTHOR_AUTHOR		= "author";
	public static final String TAUTHOR_BOOKID		= "book_id";



	public static final String TBOOK				= "book";
	public static final String TBOOK_ID				= "id";
	public static final String TBOOK_TITLE			= "title";
	public static final String TBOOK_EDITIONDATE	= "editionDate";
	public static final String TBOOK_EDITORIAL		= "editorial";
	public static final String TBOOK_ISBN			= "isbn";
	public static final String TBOOK_READ			= "read";
	public static final String TBOOK_TIMEREAD		= "timeread";
	public static final String TBOOK_PAGES			= "page";

	public static final String TCHAPTER				= "chapter"; 
	public static final String TCHAPTER_ID			= "chapter_id";
	public static final String TCHAPTER_TITLE		= "title";
	public static final String TCHAPTER_GENRE		= "genre";
	public static final String TCHAPTER_CREATOR		= "creator";
	public static final String TCHAPTER_DURATION	= "duration";
	public static final String TCHAPTER_YEAR		= "year";
	public static final String TCHAPTER_SERIES		= "series";

	public static final String TMAGAZINE				= "magazine";
	public static final String TMAGAZINE_ID				= "magazine_id";
	public static final String TMAGAZINE_TITLE			= "title";
	public static final String TMAGAZINE_EDITIONDATE	= "editionDate";
	public static final String TMAGAZINE_EDITORIAL		= "editorial";
	public static final String TMAGAZINE_AUTHOR			= "author";

	public static final String TMATERIAL			= "material"; 
//	public static final String TMATERIAL_ID			= "id";
	public static final int[] TMATERIAL_ID			= {1,2,3,4,5};

	public static final String TMOVIE				= "movie"; 
	public static final String TMOVIE_ID			= "id";
	public static final String TMOVIE_TITLE			= "title";
	public static final String TMOVIE_GENRE			= "genre";
	public static final String TMOVIE_CREATOR		= "creator";
	public static final String TMOVIE_DURATION		= "duration";
	public static final String TMOVIE_YEAR			= "year";
	
	public static final String TPAGE				= "page";
	public static final String TPAGE_ID				= "page_id";
	public static final String TPAGE_PAGE			= "page";
	public static final String TPAGE_BOOKID			= "book_id";
	public static final String TPAGE_PAGENUMBER		= "page_number";

	public static final String TSERIES				= "series"; 
	public static final String TSERIES_ID			= "series_id";
	public static final String TSERIES_SEASONQUANTITY= "seasonquantity";
	
	public static final int TUSER_ID				= 1;
	public static final String TUSER_NAME			= "name";
		
	public static final String TWATCHED				= "watched";
	public static final String TWATCHED_ID			= "id";
	public static final String TWATCHED_ID_MATERIAL	= "id_material";
	public static final String TWATCHED_ID_ELEMENT	= "id_element";
	public static final String TWATCHED_ID_USER		= "id_user";
	


}
