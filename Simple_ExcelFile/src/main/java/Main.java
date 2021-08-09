import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Employee> employeeList = new ArrayList<>();
        Employee employee1 = new Employee("Adam", "White", 45, "Accountant");
        Employee employee2 = new Employee("Bob", "Black", 23, "Cook");
        Employee employee3 = new Employee("Clementine", "Brown", 34, "Manager");
        employeeList.add(employee1);
        employeeList.add(employee2);
        employeeList.add(employee3);
        writeInXlsxResource(employeeList, "employees.xlsx");

        readFromXlsxResource("employees.xlsx");
    }

    public static void readFromXlsxResource(String filename){
        try{
            FileInputStream fileInputStream = new FileInputStream(filename);
            XSSFWorkbook xssfWorkbook = new XSSFWorkbook(fileInputStream);

            Iterator<Sheet> xssfSheetIterator = xssfWorkbook.iterator();
            while (xssfSheetIterator.hasNext()){
                Sheet currentSheet = xssfSheetIterator.next();

                Iterator<Row> rowIterator = currentSheet.iterator();
                while (rowIterator.hasNext()){
                    Row currentRow = rowIterator.next();

                    Iterator<Cell> cellIterator = currentRow.iterator();
                    while (cellIterator.hasNext()){
                        Cell currentCell = cellIterator.next();
                        System.out.print(currentCell + "\t");
                    }
                    System.out.println();
                }
            }
        }
        catch (FileNotFoundException ex){
            System.out.println("File not found");
        }
        catch (IOException ex){
            System.out.println("Can't instantiate something: " + ex.getMessage());
        }
        catch (IllegalArgumentException ex){
            System.out.println("Illegal argument, for example, list doesn't exists: " + ex.getMessage());
        }
    }

    private static void writeInXlsxResource(List<Employee> employeeList, String filename) {
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet();

        //ячейки заголовки
        Row row = sheet.createRow(0);
        row.createCell(0).setCellValue("firstname");
        row.createCell(1).setCellValue("lastname");
        row.createCell(2).setCellValue("age");
        row.createCell(3).setCellValue("positon");

        int rowCount = 1;
        for(Employee employee : employeeList){
            //создание строки для каждого объекта коллекции
            row = sheet.createRow(rowCount++);
            //заполнении ячеек строки информацией из объекта
            writeEmployeeToCells(employee, row);
        }

        //запись заполненной книги в файловую систему
        try (FileOutputStream outputStream = new FileOutputStream(filename)) {
            workbook.write(outputStream);
        }
        catch (IOException ex){
            ex.printStackTrace();
        }

    }

    private static void writeEmployeeToCells(Employee employee, Row row){
        Cell cell = row.createCell(0);
        cell.setCellValue(employee.getFirstname());
        cell = row.createCell(1);
        cell.setCellValue(employee.getLastname());
        cell = row.createCell(2);
        cell.setCellValue(employee.getAge());
        cell = row.createCell(3);
        cell.setCellValue(employee.getPosition());
    }
}
