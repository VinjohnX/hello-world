package com.Sample_Prep.PreparationCodes;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Sampleexcel {

	public static void main(String[] args) throws IOException {
		// method stubTODO Auto-generated 
		FileInputStream fin = new FileInputStream("C:\\Users\\DELL\\eclipse-workspace\\PreparationCodes\\Resources\\Data_InputSheet.xlsx");
		XSSFWorkbook xbook1 = new XSSFWorkbook(fin);
		XSSFSheet xheet = xbook1.getSheetAt(0);
		XSSFRow xrow = xheet.getRow(1);
		int lastcolumn = xrow.getLastCellNum();
		int lastrow = xheet.getLastRowNum();
		System.out.println(lastcolumn+" "+lastrow);

	}

}
