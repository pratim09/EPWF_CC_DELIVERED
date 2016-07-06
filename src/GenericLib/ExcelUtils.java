package GenericLib;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * *******************************************************************************************
 * This class includes all the Test data related methods
 ********************************************************************************************/
public class ExcelUtils {
	
	//******************************String declaration start heres****************************************

	public static String location = new File("src/TestData").getAbsolutePath();

	static File testDataExcelFile = new File(location + "\\TestData_EPWF.xlsx");

	//******************************Method declaration start heres****************************************
	
	/**
	 * @return String
	 * @definition fetch the cell values from the excel file
	 * @param sheetName
	 *            stores the sheet name of the excel file from where to fetch
	 *            the data
	 * @param RowNum
	 *            stores the row number of the sheet
	 * @param ColNum
	 *            stores the column number of the sheet
	 */
	public static String getCellData(String sheetName, int RowNum, int ColNum)
			throws Exception {
		try {
			FileInputStream fileIn = new FileInputStream(testDataExcelFile);
			Workbook wbook = WorkbookFactory.create(fileIn);
			Sheet esheet = wbook.getSheet(sheetName);
			String CellData = esheet.getRow(RowNum).getCell(ColNum).toString();

			return CellData;
		} catch (Exception e) {
			return "";
		}
	}
	
	

	/**
	 * @return void
	 * @definition fetch the cell values from the excel file
	 * @param Result
	 *            stores the string value to be set in the excel cell value
	 * @param RowNum
	 *            stores the row number of the sheet
	 * @param ColNum
	 *            stores the column number of the sheet
	 */
	public static void setCellData(String Result, String sheetName, int RowNum,
			int ColNum) throws Exception {
		try {
			FileInputStream fileIn = new FileInputStream(testDataExcelFile);
			Workbook wbook = WorkbookFactory.create(fileIn);
			Sheet esheet = wbook.getSheet(sheetName);
			Cell ecell = esheet.getRow(RowNum).createCell(ColNum);
			ecell.setCellType(Cell.CELL_TYPE_STRING);

			FileOutputStream fileOut = new FileOutputStream(testDataExcelFile);
			ecell.setCellValue(Result);
			wbook.write(fileOut);
			fileOut.flush();
			fileOut.close();
		} catch (Exception e) {
			throw (e);
		}
	}

}