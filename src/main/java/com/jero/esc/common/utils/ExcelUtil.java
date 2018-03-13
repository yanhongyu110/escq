package com.jero.esc.common.utils;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

public class ExcelUtil {
	/**
	 * 字段之间的分隔符
	 */
	public static final String FIELD_SPLITE = "##";

	/**
	 * 生成导出的EXCEL文件流
	 * 
	 * @param sheetName导出EXCEL文件sheet名
	 * @param headerTexts标题名称
	 * @param dataFields显示的数据字段
	 * @param objectList数据集
	 * @return
	 * @throws Exception
	 */
	public static ByteArrayOutputStream getExcelFile(String sheetName, String headerTexts, String dataFields, List<?> objectList) throws Exception {

		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		HSSFWorkbook wb = new HSSFWorkbook();
		HSSFCellStyle cs = wb.createCellStyle();
		HSSFSheet sheet = null;
		int rownum = 0;
		int sheetIndex = 1;
		for (Object object : objectList) {
			rownum++;
			if (rownum % 60000 == 1) {
				sheet = wb.createSheet(sheetName + sheetIndex);
				sheetIndex++;
				setDefaultHighWidth(sheet);
				HSSFFont font = getFont(wb, HSSFFont.BOLDWEIGHT_NORMAL);
				cs.setFont(font);
				cs.setAlignment(HSSFCellStyle.ALIGN_CENTER);

				// 创建表头(标题栏)
				HSSFRow row = sheet.createRow(0);
				HSSFCell indexCell = row.createCell(0);
				indexCell.setCellStyle(cs);
				indexCell.setCellValue("序号");
				String[] titles = headerTexts.split(ExcelUtil.FIELD_SPLITE);
				for (short i = 0; i < titles.length; i++) {
					HSSFCell cell = row.createCell((i + 1));
					setCellValues(titles[i], cell);
					cell.setCellStyle(cs);
				}
			}

			// 创建列表内容
			String[] dataFieldNames = dataFields.split(ExcelUtil.FIELD_SPLITE);
			HSSFRow detailRow = null;
			if (rownum % 60000 == 0)
				detailRow = sheet.createRow(60000);
			else
				detailRow = sheet.createRow(rownum % 60000);
			HSSFCell noCell = detailRow.createCell(0);
			noCell.setCellValue(rownum);
			noCell.setCellStyle(cs);
			for (int i = 0; i < dataFieldNames.length; i++) {
				HSSFCell cell = detailRow.createCell((i + 1));
				Object obj = null;
				if ((dataFieldNames[i]).indexOf(".") == -1) {
					obj = getDataValuesOfMethod(object, getMethodName(dataFieldNames[i]));
				} else {// 如果是级联对象
					String[] dataFieldNamesArr = (dataFieldNames[i].toString()).split("\\.");
					for (int j = 0; j < dataFieldNamesArr.length; j++) {
						if (j == 0) {
							obj = getDataValuesOfMethod(object, getMethodName(dataFieldNamesArr[j]));
						} else {
							obj = getDataValuesOfMethod(obj, getMethodName(dataFieldNamesArr[j]));
						}
					}
				}
				setCellValues(obj, cell);
				cell.setCellStyle(cs);
			}
		}
		wb.write(baos);
		return baos;
	}

	/**
	 * 设置Excel单元格默认行高、列宽
	 */
	public static void setDefaultHighWidth(HSSFSheet sheet) {
		sheet.setDefaultRowHeightInPoints(18);
		sheet.setDefaultColumnWidth(18);
	}

	/**
	 * 设置EXCEL字体样式
	 */
	public static HSSFFont getFont(HSSFWorkbook wb, short fontBold) {
		HSSFFont fontStyle = wb.createFont();
		fontStyle.setFontName("宋体");
		fontStyle.setFontHeightInPoints((short) 11);
		fontStyle.setBoldweight(fontBold);
		return fontStyle;
	}

	/**
	 * 设置单元格的值
	 */
	public static void setCellValues(Object obj, HSSFCell cell) {
		if (obj instanceof String) {
			cell.setCellValue((String) obj);
		} else if (obj instanceof Integer) {
			cell.setCellValue((Integer) obj);
		} else if (obj instanceof Double) {
			cell.setCellValue((Double) obj);
		} else if (obj instanceof Long) {
			cell.setCellValue((Long) obj);
		} else if (obj instanceof Short) {
			cell.setCellValue((Short) obj);
		} else if (obj instanceof Float) {
			cell.setCellValue((Float) obj);
		}
	}

	/**
	 * 根据对象和方法名称通过反射机制动态得到属性值
	 */
	public static Object getDataValuesOfMethod(Object object, String methodName) throws Exception {
		if (object == null) {
			return "";
		}
		Class<?> parameterTypes[] = new Class[0];
		Method method = object.getClass().getMethod(methodName, parameterTypes);
		Object[] parameters = new Object[0];
		Object value = method.invoke(object, parameters);
		return value;
	}

	/**
	 * 拼装方法名称
	 */
	private static String getMethodName(String fieldName) {
		if (fieldName == null) {
			return null;
		} else {
			StringBuffer ret = new StringBuffer();
			ret.append("get");
			ret.append(fieldName.substring(0, 1).toUpperCase());
			ret.append(fieldName.substring(1));
			return ret.toString();
		}
	}

	/**
	 * 
	 * @Title: processFileName
	 * 
	 * @Description: ie,chrom,firfox下处理文件名显示乱码
	 */
	public static String processFileName(HttpServletRequest request, String fileName) {
		String codedfilename = "";
		try {
			String agent = request.getHeader("USER-AGENT");
			if (null != agent && -1 != agent.indexOf("MSIE") || null != agent && -1 != agent.indexOf("Trident")) {// ie
				String name = java.net.URLEncoder.encode(fileName, "UTF8");
				codedfilename = name;
			} else if (null != agent && -1 != agent.indexOf("Mozilla")) {// 火狐,chrome等
				codedfilename = new String(fileName.getBytes("UTF-8"), "iso-8859-1");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		codedfilename += DateUtil.getCurrentDate(DateUtil.DATE_FORMAT_FILE_SUFFIX) + ".xls";
		return codedfilename;
	}

	public static void exportExcel(HttpServletRequest request, HttpServletResponse response, String fileName, String headerTexts, String dataFields, List<?> objectList) throws Exception {
		ByteArrayOutputStream os = ExcelUtil.getExcelFile(fileName, headerTexts, dataFields, objectList);
		InputStream is = new ByteArrayInputStream(os.toByteArray());
		// 设置response参数，可以打开下载页面
		response.reset();
		response.setContentType("application/vnd.ms-excel;charset=utf-8");
		response.setHeader("Content-Disposition", "attachment;filename=" + ExcelUtil.processFileName(request, fileName));
		ServletOutputStream out = response.getOutputStream();
		BufferedInputStream bis = null;
		BufferedOutputStream bos = null;
		try {
			bis = new BufferedInputStream(is);
			bos = new BufferedOutputStream(out);
			byte[] buff = new byte[2048];
			int bytesRead;
			while (-1 != (bytesRead = bis.read(buff, 0, buff.length))) {
				bos.write(buff, 0, bytesRead);
			}
		} catch (final IOException e) {
			throw e;
		} finally {
			if (bis != null)
				bis.close();
			if (bos != null)
				bos.close();
		}

	}

	/**
	 * read the Excel file
	 * 
	 * @param path
	 *            the path of the Excel file
	 * @return
	 * @throws IOException
	 */
	public static List<Map<String, Object>> readExcel(MultipartFile excelFile) throws IOException {
		if (excelFile == null || excelFile.isEmpty()) {
			return null;
		} else {
			String postfix = excelFile.getOriginalFilename();
			postfix = postfix.substring(postfix.lastIndexOf(".") + 1, postfix.length());
			if (!"".equals(postfix)) {
				if ("xls".equals(postfix)) {
					return readXls(excelFile);
				} else if ("xlsx".equals(postfix)) {
					return readXlsx(excelFile);
				}
			} else {
				System.out.println("文件错误！");
			}
		}
		return null;
	}

	/**
	 * Read the Excel 2010
	 * 
	 * @param path
	 *            the path of the excel file
	 * @return
	 * @throws IOException
	 */
	public static List<Map<String, Object>> readXlsx(MultipartFile excelFile) throws IOException {
		InputStream is = excelFile.getInputStream();
		XSSFWorkbook xssfWorkbook = new XSSFWorkbook(is);
		Map<String, Object> map = null;
		List<Map<String, Object>> list = null;
		// Read the Sheet
		for (int numSheet = 0; numSheet < xssfWorkbook.getNumberOfSheets(); numSheet++) {
			XSSFSheet xssfSheet = xssfWorkbook.getSheetAt(numSheet);
			if (xssfSheet == null || xssfSheet.getLastRowNum() < 1) {
				continue;
			}
			if (list == null) {
				list = new ArrayList<Map<String, Object>>();
			}
			// Read the Row
			int cellNum = 0;
			XSSFRow xssfRow = xssfSheet.getRow(0);
			if (xssfRow != null && xssfRow.getLastCellNum() > 0) {// 具有标题行的数据才会做读取
				cellNum = xssfRow.getLastCellNum();// 列
				String[] titles = new String[cellNum];
				for (int i = 0; i < cellNum; i++) {
					XSSFCell cell = xssfRow.getCell(i);
					titles[i] = cell.getStringCellValue();
				}
				for (int rowNum = 1; rowNum <= xssfSheet.getLastRowNum(); rowNum++) {
					xssfRow = xssfSheet.getRow(rowNum);
					if (xssfRow != null) {
						map = new HashMap<String, Object>();
						cellNum = xssfRow.getLastCellNum();// 列
						for (int i = 0; i < cellNum; i++) {
							XSSFCell cell = xssfRow.getCell(i);
							map.put(titles[i], getValue(cell));
						}
						list.add(map);
					}
				}
			}
		}
		return list;
	}

	/**
	 * Read the Excel 2003-2007
	 * 
	 * @param path
	 *            the path of the Excel
	 * @return
	 * @throws IOException
	 */
	public static List<Map<String, Object>> readXls(MultipartFile excelFile) throws IOException {
		InputStream is = excelFile.getInputStream();
		HSSFWorkbook hssfWorkbook = new HSSFWorkbook(is);
		Map<String, Object> map = null;
		List<Map<String, Object>> list = null;// new ArrayList<Map>();
		// Read the Sheet
		for (int numSheet = 0; numSheet < hssfWorkbook.getNumberOfSheets(); numSheet++) {
			HSSFSheet hssfSheet = hssfWorkbook.getSheetAt(numSheet);
			if (hssfSheet == null || hssfSheet.getLastRowNum() < 1) {
				continue;
			}
			if (list == null) {
				list = new ArrayList<Map<String, Object>>();
			}
			// Read the Row
			int cellNum = 0;
			HSSFRow hssfRow = hssfSheet.getRow(0);
			if (hssfRow != null && hssfRow.getLastCellNum() > 0) {// 具有标题行的数据才会做读取
				cellNum = hssfRow.getLastCellNum();// 列
				String[] titles = new String[cellNum];
				for (int i = 0; i < cellNum; i++) {
					HSSFCell cell = hssfRow.getCell(i);
					titles[i] = cell.getStringCellValue();
				}
				for (int rowNum = 1; rowNum <= hssfSheet.getLastRowNum(); rowNum++) {
					hssfRow = hssfSheet.getRow(rowNum);
					if (hssfRow != null) {
						map = new HashMap<String, Object>();
						cellNum = hssfRow.getLastCellNum();// 列
						for (int i = 0; i < cellNum; i++) {
							HSSFCell cell = hssfRow.getCell(i);
							map.put(titles[i], getValue(cell));
						}
						list.add(map);
					}
				}
			}
		}
		return list;
	}

	@SuppressWarnings("static-access")
	private static String getValue(XSSFCell xssfRow) {
		if (xssfRow == null) {
			return "";
		}
		if (xssfRow.getCellType() == xssfRow.CELL_TYPE_BOOLEAN) {
			return String.valueOf(xssfRow.getBooleanCellValue());
		} else if (xssfRow.getCellType() == xssfRow.CELL_TYPE_NUMERIC) {
			return String.valueOf(new DecimalFormat("#").format(xssfRow.getNumericCellValue()));
			// return String.valueOf(xssfRow.getNumericCellValue());
		} else {
			return String.valueOf(xssfRow.getStringCellValue());
		}
	}

	@SuppressWarnings("static-access")
	private static String getValue(HSSFCell hssfCell) {
		if (hssfCell == null) {
			return "";
		}
		if (hssfCell.getCellType() == hssfCell.CELL_TYPE_BOOLEAN) {
			return String.valueOf(hssfCell.getBooleanCellValue());
		} else if (hssfCell.getCellType() == hssfCell.CELL_TYPE_NUMERIC) {
			return String.valueOf(new DecimalFormat("#").format(hssfCell.getNumericCellValue()));
			// return String.valueOf(hssfCell.getNumericCellValue());
		} else {
			return String.valueOf(hssfCell.getStringCellValue());
		}
	}

}
