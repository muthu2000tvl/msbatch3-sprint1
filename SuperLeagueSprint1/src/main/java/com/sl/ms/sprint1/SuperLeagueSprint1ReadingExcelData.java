package com.sl.ms.sprint1;

import java.io.File;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import java.util.Iterator;





public class SuperLeagueSprint1ReadingExcelData {
	
	public static final String SAMPLE_XLSX_FILE_PATH = "./sample-xls-file.xls";

	public static void main(String[] args) throws IOException, InvalidFormatException {
		
		// Creating a Workbook from an Excel file (.xls or .xlsx)
        Workbook workbook = WorkbookFactory.create(new File(SAMPLE_XLSX_FILE_PATH));

        // Retrieving the number of sheets in the Workbook
        System.out.println("Workbook has " + workbook.getNumberOfSheets() + " Sheets : ");

       
       //use a Java 8 forEach with lambda
        System.out.println("Retrieving Sheets using Java 8 forEach with lambda");
        workbook.forEach(sheet -> {
            System.out.println("=> " + sheet.getSheetName());
        });
        
        

     // Getting the Sheet at index zero
     Sheet sheet = workbook.getSheetAt(0);

     // Create a DataFormatter to format and get each cell's value as String
     DataFormatter dataFormatter = new DataFormatter();
    
     
     // for-each loop to iterate over the rows and columns
     System.out.println("\n\nIterating over Rows and Columns using for-each loop\n");
     for (Row row: sheet) {
         for(Cell cell: row) {
             String cellValue = dataFormatter.formatCellValue(cell);
             System.out.print(cellValue + "\t");
         }
         System.out.println();
     }
  

  // Closing the workbook
     workbook.close();


	}

}
