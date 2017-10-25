/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ActivitiesToRole;

/**
 *
 * @author chandan.shanbhag
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.File;
import java.io.FileInputStream;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author chandan.shanbhag
 */
public class ReadExcel {

 
  

    public void Read(String filename) {
        try {
            FileInputStream fs = new FileInputStream(new File(filename));
            XSSFWorkbook wb = new XSSFWorkbook(fs);
            XSSFSheet sheet = wb.getSheetAt(0);
            XSSFRow row;
            XSSFCell cell;

            int rows; // No of rows
            rows = sheet.getPhysicalNumberOfRows();

            int cols = 0; // No of columns
            int tmp = 0;

            // This trick ensures that we get the data properly even if it doesn't start from first few rows
            for (int i = 0; i < 10 || i < rows; i++) {
                row = sheet.getRow(i);
                if (row != null) {
                    tmp = sheet.getRow(i).getPhysicalNumberOfCells();
                    if (tmp > cols) {
                        cols = tmp;
                    }
                }
            }

            for (int r = 0; r < rows; r++) {
                row = sheet.getRow(r);
                if (row != null) {
                    for (int c = 0; c < cols; c++) {
                        cell = row.getCell((short) c);
                        if (cell != null) {

//                    CellStyle cs=wb.createCellStyle();
//                    CreationHelper ch=wb.getCreationHelper();
//                    cs.setDataFormat(ch.createDataFormat().getFormat("mm/DD/YYY"));
//                    
//                    cell.setCellStyle(cs);
//                    cell.setCellFormula("mm/dd/yyy");
                            /*  if (cell.getCellStyle().getDataFormat() == 14) {

                                SimpleDateFormat df = new SimpleDateFormat("MM/dd/yyyy");
                                String s = df.format(new java.util.Date(cell.toString()));
                                System.out.print(s + "\n");

                            } else {
                                System.out.println("Not in format");
                            }*/
                            System.out.println(cell.toString());
                        }

                    }
                }
            }

        } catch (Exception ioe) {
            ioe.toString();
        }

    }
    
    
      public static void main(String[] args) {
        // TODO code application logic here
        ReadExcel r = new ReadExcel();
        r.Read("E:\\Excel\\test.xlsx");

    }

}
