package com.demo.util;

public class DataProviderHelper {
	
	public static ExcelReader excelReader;
	
	public static Object[][] getData(String excelPathKey, String sheetName, int startRow, int totalColumn)
	{
		excelReader = new ExcelReader(ConfigLoader.getInstance().getExcelPath(excelPathKey));
		
		int lastRow = excelReader.getLastRow(sheetName);
		int TotalCases = lastRow - startRow + 1;
		int TotalColumns = totalColumn + 1;
	
		Object[][] Data = new Object[TotalCases][TotalColumns];
	
		for (int i = 0, k = startRow; i < TotalCases; i++, k++) 
		{
			for (int j = 0, l = 0; j < TotalColumns; j++, l++) 
			{
				Data[i][j] = excelReader.getAny(sheetName,k,l);
			}
		}
		return Data;
	}

}
