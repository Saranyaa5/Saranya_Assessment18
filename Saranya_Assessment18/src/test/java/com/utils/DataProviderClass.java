package com.utils;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
public class DataProviderClass {
    @DataProvider(name="LoginData",parallel=true)
    public Object[][] excelDP() throws IOException {
        String loc = "C:\\Users\\saran\\git\\Saranya_Assessment18\\Saranya_Assessment18\\src\\test\\resources\\LoginExcel.xlsx";
        return getData(loc, "Sheet1");
    }
    public String[][] getData(String file, String sheet) throws IOException {
        String[][] data = null;
        try (FileInputStream fis=new FileInputStream(file);
             XSSFWorkbook wrkBk=new XSSFWorkbook(fis)) {
            XSSFSheet sht=wrkBk.getSheet(sheet);
            int r=sht.getPhysicalNumberOfRows();
            int c=sht.getRow(0).getLastCellNum();
            data=new String[r][c];
            for (int i=0;i<r; i++) {
                XSSFRow row=sht.getRow(i);
                if (row !=null) {
                    for (int j=0; j < c; j++) {
                        Cell cell=row.getCell(j);
                        if (cell == null) {
                        	data[i][j]="";
                        } else {
                        	data[i][j]=cell.getStringCellValue();
                        }
                        
                        
                    }
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return data;
    }
}

