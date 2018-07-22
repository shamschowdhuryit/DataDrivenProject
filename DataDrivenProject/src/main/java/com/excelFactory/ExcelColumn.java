package com.excelFactory;

import java.io.FileInputStream;
import java.util.ArrayList;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelColumn {

	

	public static ArrayList<String> columnValue(String path,int columnNumber) throws Throwable
    {
		
		
		FileInputStream file= new FileInputStream(path);
		XSSFWorkbook workbook=new XSSFWorkbook(file);
		XSSFSheet sheet= workbook.getSheetAt(0);

		ArrayList<String> columnValue= new ArrayList<String>();
		
		int RowCount= sheet.getPhysicalNumberOfRows();
		
		System.out.println("Total Rows Number::"+ RowCount);
		for(int rowindex=0;rowindex<RowCount;rowindex++) {
			Row row=sheet.getRow(rowindex);
			System.out.println("Total Column Number::"+ row.getLastCellNum());
			if (row!=null) {
				
				
		for(int colmindex=0;colmindex<row.getLastCellNum();colmindex++) {	
			if(colmindex==columnNumber) {
				Cell cell=row.getCell(colmindex);
				if(cell!=null) {
					
					DataFormatter df= new DataFormatter();
					columnValue.add(df.formatCellValue(cell));

	               
				}
				
			}
		}
		
	}
	}
	
	
		return columnValue;	
		
	}

}
