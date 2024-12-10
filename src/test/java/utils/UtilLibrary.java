package utils;

import base.WebDriverBase;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.*;
import java.util.Objects;
import java.util.Properties;

public class UtilLibrary extends WebDriverBase {

    static XSSFWorkbook book;
    static XSSFSheet sheet;
    public static Properties configProperties;

    public static void readExcelData(String testcase, String sheetPath, String sheetName) {
        FileInputStream fileInputStream;

        try {
            fileInputStream = new FileInputStream(sheetPath);
            book = new XSSFWorkbook(fileInputStream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        sheet = book.getSheet(sheetName);

        for(int i=0; i<=sheet.getLastRowNum(); i++) {
            System.out.println(sheet.getLastRowNum() + " " + sheet.getRow(i).getLastCellNum());
            String testName = sheet.getRow(i).getCell(0).getStringCellValue();
            if(!Objects.equals(testName, "")){
                System.out.println(testName + " " + testcase);
                if(testName.equalsIgnoreCase(testcase)){
                    for(int j=0; j< sheet.getRow(i).getLastCellNum(); j++){
                        String param = sheet.getRow(0).getCell(j).getStringCellValue();
                        String value = sheet.getRow(i).getCell(j).getStringCellValue();
                        System.out.println(param + " " + value);
                        configProperties.put(param, value);
                    }
                    writeToConfigDataFile();
                    break;
                }
            }
        }
    }

    public static void readConfigDataFile(String propertiesFilePath) {

        configProperties = new Properties();
        try {
            FileInputStream fileInputStream = new FileInputStream(System.getProperty("user.dir") + propertiesFilePath);
            configProperties.load(fileInputStream);
            fileInputStream.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void writeToConfigDataFile() {

        FileOutputStream fileOutputStream = null;
        try {
            fileOutputStream = new FileOutputStream(System.getProperty("user.dir") + "\\src\\test\\resources\\config.properties");
            configProperties.store(fileOutputStream, "Configuration and test data updated");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
