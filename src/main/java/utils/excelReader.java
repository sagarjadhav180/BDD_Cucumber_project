package utils;

import groovy.lang.GString;
import io.cucumber.java.it.Ma;
import org.apache.poi.hssf.usermodel.HSSFRangeCopier;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class excelReader {

    private static String dataPath = PropertyReader.getProperty("test.data.path");
    private static String excelFilePath = dataPath + PropertyReader.getProperty("excel.file.name");
    private static Workbook workbook;
    private static String sheetName = "data";
    private static Row row;
    private static Cell cell;
    private static Sheet sheet; 
    

    private static void setExcelFile(){
        try {
            File file = new File(excelFilePath);
            FileInputStream fileInputStream = null;
            fileInputStream = new FileInputStream(file);
            System.out.println("========="+excelFilePath+"=============");
            workbook = new XSSFWorkbook(fileInputStream);
            sheet = workbook.getSheet(sheetName);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    private static int getRowData(String rowName, int column){
        int rowCount = sheet.getLastRowNum();
        int row = 0;
        for(int i=0;i<=rowCount;i++){
            if(sheet.getRow(i).getCell(column).getStringCellValue().equalsIgnoreCase(rowName))
                row = i;
        }
        return row;
    }
    
    private static String getCellData(int rowNumber, int cellNumber){
        Cell cellData = sheet.getRow(rowNumber).getCell(cellNumber);
        return cellData.getStringCellValue();
    }
    
    public static Map getData(String scenarioName){
//        System.out.println("POI version: " + org.apache.poi.poifs.common.POIFSConstants.class.getPackage().getImplementationVersion());
        setExcelFile();
        Map<String, String> dataMap = new HashMap<String, String>();
        int rowNumber = getRowData(scenarioName, 0);
        int cellCount = sheet.getRow(rowNumber).getLastCellNum();

        for(int i=0;i<cellCount;i++){
            cell = sheet.getRow(rowNumber).getCell(i);
            if(cell.getCellType() == CellType.STRING)
                dataMap.put(getCellData(0, i), cell.getStringCellValue());
        }
        return dataMap;
    }
    
    public static void testMethod()  {
        File file = new File(excelFilePath);
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream(file);

        Workbook workbook1 = new XSSFWorkbook(fileInputStream);
        Sheet sheetName1 = workbook1.getSheet(sheetName);}
        catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

}
