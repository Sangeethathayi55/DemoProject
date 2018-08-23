package generic;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Excel {
	public static String getcellValue(String path,String sheet,int r,int c){//to get any row,sheet
																//,any row,any column
		String v="";
		try{
			Workbook wb=WorkbookFactory.create(new FileInputStream(path));
			v=wb.getSheet(sheet).getRow(r).getCell(c).toString();//tostring to convert to string not
															//address
		}
		catch(Exception e){
			
		}
		return v;
}
public static int getRowCount(String path,String sheet){
	int row=0;
	try{
		FileInputStream fis = new FileInputStream(path);
		Workbook wb=WorkbookFactory.create(fis);
		row=wb.getSheet(sheet).getLastRowNum();
		
	}
	catch(Exception e){
	}
	return row;
	}



		
  }	
		
		
  	
  
	
