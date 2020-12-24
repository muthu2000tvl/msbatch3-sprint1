package com.sl.ms.sprint1;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;


public class ReadFileStream {

	public static void main(String[] args) throws IOException {
		
		//Creating a File object for directory and placing the files to be read
	      File directoryPath = new File("D:\\Read");
	      
	      //List of all files and directories
	      File filesList[] = directoryPath.listFiles();
	      System.out.println("List of files and directories in the specified directory:");
	      Scanner sc = null;
	      for(File file : filesList) {
	         System.out.println("File name: "+file.getName());
	         
	         //Instantiating the Scanner class
	         sc= new Scanner(file);
	         String input;
	         StringBuffer sb = new StringBuffer();
	         while (sc.hasNextLine()) {
	            input = sc.nextLine();
	            sb.append(input+" ");
	         }
	         System.out.println("Contents of the file: "+sb.toString());
	         System.out.println(" ");
	      }
	}

}
