package com.eduardocode.amazonviewer.model;

import java.util.Date;

public interface IViewable {
	/**
	 * This method records the exact time of the start of the playing 
	 * @param dateI is an object {@code Date} with the exact time
	 * @return Returns the date and hour recorded
	 * */
	Date startToWatch(Date dateI);
	/**
	 * This method records the exact time of the start and end of the playing
	 * @param dateI is an object {@code Date} with the exact starting time
	 * @param dateF is an object {@code Date} with the exact ending time
	 * @return Returns {@code void} 
	 * */
	void stopToWatch(Date dateI,Date dateF);
}
