package coursework;

import java.io.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.*;

public class Data {
	private double[][] trainingData = new double[870][6];
	private double[][] validationData = new double[290][6];
	private double[][] testingData = new double [291][6];
	public Data() throws IOException {
		// Firstly randomly assigns values to the different sets
		double value;
		Integer[] array = new Integer[1451];
		for (int i = 1; i < 1452; i++) {
			array[i - 1] = i;
		}
		List<Integer> list = Arrays.asList(array);
		Collections.shuffle(list);
		FileInputStream fis = new FileInputStream("DataSet.xlsx");
		Sheet sheet = new XSSFWorkbook(fis).getSheetAt(0);
		// Standardises the data in the training set
		for (int i = 0; i < 870; i++) {
			for (int j = 1; j < 7; j++) {
				Row row = sheet.getRow(array[i]);
				Cell cell = row.getCell(j);
				if (j == 1) {
					value = 0.8 * ((cell.getNumericCellValue() - 7.2) / (28.9 - 7.2)) + 0.1;
				} else if (j == 2) {
					value = 0.8 * ((cell.getNumericCellValue() - 96.1) / (1089.7 - 96.1)) + 0.1;
				} else if (j == 3) {
					value = 0.8 * ((cell.getNumericCellValue() - 78.4) / (743.2 - 78.4)) + 0.1;
				} else if (j == 4) {
					value = 0.8 * ((cell.getNumericCellValue() - 100.2) / (102.8 - 100.2)) + 0.1;
				} else if (j == 5) {
					value = 0.8 * ((cell.getNumericCellValue() - 10) / (95 - 10)) + 0.1;
				} else {
					value = 0.8 * ((cell.getNumericCellValue() - 0.07) / (1.28 - 0.07)) + 0.1;
				}
				trainingData[i][j-1] = value;
			}
		}
		// Standardises the data in the validation set
		for (int i = 0; i < 290; i++) {
			for (int j = 1; j < 7; j++) {
				Row row = sheet.getRow(array[i + 870]);
				Cell cell = row.getCell(j);
				if (j == 1) {
					value = 0.8 * ((cell.getNumericCellValue() - 7.2) / (28.9 - 7.2)) + 0.1;
				} else if (j == 2) {
					value = 0.8 * ((cell.getNumericCellValue() - 96.1) / (1089.7 - 96.1)) + 0.1;
				} else if (j == 3) {
					value = 0.8 * ((cell.getNumericCellValue() - 78.4) / (743.2 - 78.4)) + 0.1;
				} else if (j == 4) {
					value = 0.8 * ((cell.getNumericCellValue() - 100.2) / (102.8 - 100.2)) + 0.1;
				} else if (j == 5) {
					value = 0.8 * ((cell.getNumericCellValue() - 10) / (95 - 10)) + 0.1;
				} else {
					value = 0.8 * ((cell.getNumericCellValue() - 0.07) / (1.28 - 0.07)) + 0.1;
				}
				validationData[i][j-1] = value;
			}
		}
		// Standardises the data in the testing set
		for (int i = 0; i < 291; i++) {
			for (int j = 1; j < 7; j++) {
				Row row = sheet.getRow(array[i + 1160]);
				Cell cell = row.getCell(j);
				if (j == 1) {
					value = 0.8 * ((cell.getNumericCellValue() - 7.2) / (28.9 - 7.2)) + 0.1;
				} else if (j == 2) {
					value = 0.8 * ((cell.getNumericCellValue() - 96.1) / (1089.7 - 96.1)) + 0.1;
				} else if (j == 3) {
					value = 0.8 * ((cell.getNumericCellValue() - 78.4) / (743.2 - 78.4)) + 0.1;
				} else if (j == 4) {
					value = 0.8 * ((cell.getNumericCellValue() - 100.2) / (102.8 - 100.2)) + 0.1;
				} else if (j == 5) {
					value = 0.8 * ((cell.getNumericCellValue() - 10) / (95 - 10)) + 0.1;
				} else {
					value = 0.8 * ((cell.getNumericCellValue() - 0.07) / (1.28 - 0.07)) + 0.1;
				}
				testingData[i][j-1] = value;
			}
		}
	}
	public double[][] getTrnData() {
		// Returns the training set
		return this.trainingData;
	}
	public double[][] getValData() {
		// Returns the validation set
		return this.validationData;
	}
	public double[][] getTstData() {
		// Returns the testing set
		return this.testingData;
	}
}