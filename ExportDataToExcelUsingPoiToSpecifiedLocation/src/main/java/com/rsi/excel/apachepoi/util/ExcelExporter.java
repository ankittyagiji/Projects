package com.rsi.excel.apachepoi.util;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.rsi.excel.apachepoi.model.User;

public class ExcelExporter {

	private XSSFWorkbook xSSFWorkbook;
	private XSSFSheet xSSFSheet;
	private List<User> list;
    private User user;
	
	public ExcelExporter(User user1){
		this.user = user1;
		xSSFWorkbook = new XSSFWorkbook();
	}

	// create header line
	private void headerLine() {
		xSSFSheet = xSSFWorkbook.createSheet("All User Details");
		Row row = xSSFSheet.createRow(0);

		CellStyle cellStyle = xSSFWorkbook.createCellStyle();
		XSSFFont font = xSSFWorkbook.createFont();
		font.setBold(true);
		font.setFontHeight(16);
		cellStyle.setFont(font);
		createCell(row, 0, "Id", cellStyle);
		createCell(row, 1, "FirstName", cellStyle);
		createCell(row, 2, "LastName", cellStyle);
		createCell(row, 3, "Address", cellStyle);
	}

	private void createCell(Row row, int countColumn, Object value, CellStyle cellStyle) {
		xSSFSheet.autoSizeColumn(countColumn);
		Cell cell = row.createCell(countColumn);
		if (value instanceof Integer) {
			cell.setCellValue((Integer) value);
		} else if (value instanceof Boolean) {
			cell.setCellValue((Boolean) value);
		} else {
			cell.setCellValue((String) value);
		}
		cell.setCellStyle(cellStyle);
	}

	// create Data which comes from DB
	private void writeDataLines() {
		int rowCount = 1;

		CellStyle style = xSSFWorkbook.createCellStyle();
		XSSFFont font = xSSFWorkbook.createFont();
		font.setFontHeight(18);
		style.setFont(font);

		//for (User user : list) {
			Row row = xSSFSheet.createRow(rowCount++);
			int countColumn = 0;

			createCell(row, countColumn++, user.getId(), style);
			createCell(row, countColumn++, user.getFirstName(), style);
			createCell(row, countColumn++, user.getLastName(), style);
			createCell(row, countColumn++, user.getAddress(), style);
		//}
	}

	public void exportData(String fileName) throws IOException {
		headerLine();
		writeDataLines();
		FileOutputStream out = new FileOutputStream("C:\\Users\\Ankit\\Desktop\\Files\\"+fileName);
		xSSFWorkbook.write(out);
		xSSFWorkbook.close();
        out.close();
	}

}
