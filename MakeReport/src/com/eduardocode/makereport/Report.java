package com.eduardocode.makereport;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

/**
 * <h1> Make Report <h1>
 * Class to create a Report
 * <p>This class creates a File with the extension and the title specified which contains the text who is send by the user</p> 
 * @param nameFile contains the name of the file
 * @param title contains the title of the file 
 * @param content contains the whole content of the file
 * @param extension contains the extension of the file
 * @author Eduardo Zamarrón
 * @version 1.1
 * @since 2019
 * */
public class Report {

	private String nameFile;
	private String title;
	private String content;
	private String extension;
	
	public String getExtension() {
		return extension;
	}
	public void setExtension(String extension) {
		this.extension = extension;
	}
	public String getNameFile() {
		return nameFile;
	}
	public void setNameFile(String nameFile) {
		this.nameFile = nameFile;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	/**
	 * This method is the one who creates the file
	 * 
	 * */
	public void makeReport() {
		if (getNameFile() != null && getTitle() != null && getContent() != null) {
			//Create File
			try {
				File myfile = new File(getNameFile() + "." + getExtension());
				FileOutputStream fos =  new FileOutputStream(myfile);
				OutputStreamWriter osw = new OutputStreamWriter(fos);
				BufferedWriter bw = new BufferedWriter(osw);
				bw.write(getContent());
				bw.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else {
			System.out.println("Enter the file data");
		}
	}
}
