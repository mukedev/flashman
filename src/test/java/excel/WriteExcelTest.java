package excel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

// 测试向excel写入内容(暂时不能写入到.xlsx文件中)
public class WriteExcelTest {
	private static final String EXCEL_XLS = "xls";
	private static final String EXCEL_XLSX = "xlsx";
	private static final String FILE_NAME = "E:/textReadAndWriteExcel/writeExcel.xls";

	// 怎么写？写入前的准备
	// 写到哪？获取excel
	// 怎么写？什么方法，可以写什么内容？ 用什么流
	public static void writeToExcel(List<Map> dataList, String fileName) {
		OutputStream out = null;
		// 总列数
		int colCount = dataList.size();

		try {
			// 读取excel
			File file = new File(fileName);
			Workbook workbook = getWorkbook(file);
			// Sheet对应一个工作页
			Sheet sheet = workbook.getSheetAt(0);

			// 删除excel原有的数据(循环从1开始，防止删除标题行)
			int oldDataRow = sheet.getLastRowNum();
			for (int i = 1; i <= oldDataRow; i++) {
				Row row = sheet.getRow(i);
				sheet.removeRow(row);
			}

			// 保存删除操作
			out = new FileOutputStream(file);
			workbook.write(out);

			// 向excel写入数据
			for (int i = 0; i < dataList.size(); i++) {
				Row row = sheet.createRow(i + 1);
				Cell cell = row.createCell(i);// 此处i代表列
				cell.setCellValue(dataList.get(i).toString());
			}
			// 需要一个新的实例保存操作，（还不知道原因！--2018/04/25）
			out = new FileOutputStream(file);
			workbook.write(out);

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (out != null) {
				try {
					out.flush();
					out.close();
					System.out.println("数据导出成功！");
				} catch (IOException e) {
					e.printStackTrace();
				}

			}
		}

	}

	// workbook分为两种情况，xls:2003/xlsx:2007
	public static Workbook getWorkbook(File file) throws IOException {

		Workbook workbook = null;
		FileInputStream fis = new FileInputStream(file);
		if (file.getName().endsWith(EXCEL_XLS)) {
			workbook = new HSSFWorkbook(fis);
		} else if (file.getName().endsWith(EXCEL_XLSX)) {
			workbook = new XSSFWorkbook(fis);
		}
		return workbook;
	}

	public static void main(String[] args) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("name", "张三");
		map.put("gender", "男");
		map.put("age", 18);
		List<Map> dataList = new ArrayList<Map>();
		dataList.add(map);
		writeToExcel(dataList, FILE_NAME);
	}
}
