package excel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class ReadExcelTest {
	private static final String FILE_NAME = "E:/textReadAndWriteExcel/readExcel.xls";

	public static List readExcel(String filename) {
		InputStream in = null;
		try {

			// 一，读取excel
			in = new FileInputStream(new File(filename).getAbsolutePath());
			// jxl提供的workbook类
			Workbook workbook = Workbook.getWorkbook(in);

			// 二，遍历excel的行与列
			// 页签数量
			int sheet_size = workbook.getNumberOfSheets();
			for (int i = 0; i < sheet_size; i++) {
				List rowList = new ArrayList();
				// 每个页签创建一个Sheet对象
				Sheet sheet = workbook.getSheet(i);
				// sheet.getRows()返回该页的总行数，获取行数据
				for (int j = 0; j < sheet.getRows(); j++) {
					List colList = new ArrayList();
					// sheet.getColumns()返回该页的总列数，获取列数据
					for (int k = 0; k < sheet.getColumns(); k++) {
						String content = sheet.getCell(k, j).getContents();
						if (content.isEmpty()) {
							continue;
						}
						colList.add(content);
					}
					rowList.add(j, colList);
				}

				return rowList;
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (BiffException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (in != null) {
				try {
					in.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

		return null;
	}

	public static void main(String[] args) {
		List excelList = readExcel(FILE_NAME);
		System.out.println("rows:" + excelList.size());
		for (int i = 0; i < excelList.size(); i++) {
			List rowList = (List) excelList.get(i);
			for (int j = 0; j < rowList.size(); j++) {
				System.out.print(rowList.get(j) + "\t");
			}
			System.out.println();
		}
	}
}
