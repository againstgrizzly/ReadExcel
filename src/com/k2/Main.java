package com.k2;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/*

 */
public class Main {
    static XSSFRow row;

    public static void main(String[] args) {
        // write your code here

        //Read the excel sheet in
        String excelFilePath = System.getProperty("user.dir") + "/resources/test2.xlsx";

        //Plain old object for reflecting each row of data
        List<MilconDataObject> milconDataObjects = new ArrayList<>();

        try {
            milconDataObjects = readMilconDataFromExcelFile(excelFilePath);

        } catch (IOException e) {
            e.printStackTrace();
        }

        //Print out the list of objects
        for (MilconDataObject milconDataObject : milconDataObjects) {
            System.out.println(milconDataObject);
        }


    }

    private static Object getCellValue(Cell cell, Workbook wb) {

        FormulaEvaluator evaluator = wb.getCreationHelper().createFormulaEvaluator();
        switch (cell.getCellType()) {
            case Cell.CELL_TYPE_STRING:
                return cell.getStringCellValue();

            case Cell.CELL_TYPE_BOOLEAN:
                return cell.getBooleanCellValue();

            case Cell.CELL_TYPE_NUMERIC:
                return cell.getNumericCellValue();
            case Cell.CELL_TYPE_FORMULA:
                Cell cell2 = evaluator.evaluateInCell(cell);
                return cell2.getNumericCellValue();

        }

        return null;
    }

    public static List<MilconDataObject> readMilconDataFromExcelFile(String excelFilePath) throws IOException {
        List<MilconDataObject> milconDataObjects = new ArrayList<>();
        FileInputStream inputStream = new FileInputStream(new File(excelFilePath));

        Workbook workbook = new XSSFWorkbook(inputStream);
        Sheet firstSheet = workbook.getSheetAt(0);
        Iterator<Row> iterator = firstSheet.iterator();

        //Used to skip the column titles which is the first row
        boolean hasSkippedFirstRow = false;

        while (iterator.hasNext()) {
            Row nextRow = iterator.next();
            Iterator<Cell> cellIterator = nextRow.cellIterator();
            MilconDataObject milconDataObject = new MilconDataObject();


            if (hasSkippedFirstRow) {
                while (cellIterator.hasNext()) {
                    Cell nextCell = cellIterator.next();
                    int columnIndex = nextCell.getColumnIndex();

                    switch (columnIndex) {
                        case 0: {
                            double project = (double) getCellValue(nextCell, workbook);
                            milconDataObject.setProject((int) project);
                        }
                        break;
                        case 1:
                            milconDataObject.setValue((double) getCellValue(nextCell, workbook));
                            break;
                        case 2:
                            milconDataObject.setMust_fund((String) getCellValue(nextCell, workbook));
                            break;
                        case 3:
                            milconDataObject.setNet((String) getCellValue(nextCell, workbook));
                            break;
                        case 4: {
                            double prerequisite = (double) getCellValue(nextCell, workbook);
                            milconDataObject.setPrerequisite((int) prerequisite);
                        }
                        break;
                        case 5:
                            milconDataObject.setLast_pom((String) getCellValue(nextCell, workbook));
                            break;
                        case 6:
                            milconDataObject.setCost((double) getCellValue(nextCell, workbook));
                            break;
                        case 7:
                            double setup = (double) getCellValue(nextCell, workbook);
                            milconDataObject.setSetup((int) setup);
                            break;
                        case 8:
                            milconDataObject.setSetup_cost((double) getCellValue(nextCell, workbook));
                            break;
                        case 9:
                            double post = (double) getCellValue(nextCell, workbook);
                            milconDataObject.setPost((int) post);
                            break;
                        case 10:
                            milconDataObject.setPost_cost((double) getCellValue(nextCell, workbook));
                            break;
                    }
                }

            } else {
                //don't read first row
                hasSkippedFirstRow = true;
            }
            milconDataObjects.add(milconDataObject);
        }

        workbook.close();
        inputStream.close();

        return milconDataObjects;
    }


}

