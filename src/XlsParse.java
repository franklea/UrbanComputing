import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;


public class XlsParse {

	class Type{
		private String type;
		private String name;
		Type(String t,String name){
			this.type = t;
			this.name = name;
		}
		public void setType(String t){
			type = t;
		}
		public String getType(){
			return type;
		}
		public void setName(String n){
			name = n;
		}
		public String getName(){
			return name;
		}
	}
	/*
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String file = "POIYP.xls";
		XlsParse parser = new XlsParse();
		String[][] resPoi = null;
		try {
			resPoi = parser.readXls(file);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		parser.printRes(resPoi);
	}
	*/
	String[][] readXls(String fileName) throws IOException{
		InputStream is = new FileInputStream( fileName);  
		String[][] poiRes = new String[668][6];
	    @SuppressWarnings("resource")
		HSSFWorkbook hssfWorkbook = new HSSFWorkbook( is);   
	      
	    // 循环工作表Sheet  
	    for(int numSheet = 0; numSheet < hssfWorkbook.getNumberOfSheets(); numSheet++){  
	      HSSFSheet hssfSheet = hssfWorkbook.getSheetAt(numSheet);  
	      if(hssfSheet == null){  
	        continue;  
	      }
	      
	      // 循环行Row   
	      for(int rowNum = 0; rowNum < 668/*hssfSheet.getLastRowNum()*/; rowNum++){  
	        HSSFRow hssfRow = hssfSheet.getRow( rowNum);  
	        if(hssfRow == null){  
	          continue;  
	        }  
	          
	        // 循环列Cell    
	        for(int cellNum = 0; cellNum < hssfRow.getLastCellNum(); cellNum++){  
	          HSSFCell hssfCell = hssfRow.getCell( cellNum);  
	          if(hssfCell == null){
	            continue;  
	          }
	          if (getValue( hssfCell) == ""){
	        	  int offset = 1;
	        	  while(getValue(hssfSheet.getRow(rowNum-offset).getCell(cellNum)) == "")
	        	  {
	        		  offset ++;
	        	  }
	        	  //System.out.print(getValue(hssfSheet.getRow(rowNum-offset).getCell(cellNum))+"    ");
	        	  poiRes[rowNum][cellNum] = getValue(hssfSheet.getRow(rowNum-offset).getCell(cellNum)).toString();
	          }else{
	        	  //System.out.print(getValue( hssfCell)+"    "); 
	        	  poiRes[rowNum][cellNum] = getValue( hssfCell).toString();
	          }
	        }
	        
	        //System.out.println("\n--------------------");  
	      }  
	    }
	    return poiRes;
	}
	/**
     * 得到Excel表中的值
     * 
     * @param hssfCell
     *            Excel中的每一个格子
     * @return Excel中每一个格子中的值
     */
    @SuppressWarnings("static-access")
    private String getValue(HSSFCell hssfCell) {
    	
        if (hssfCell.getCellType() == hssfCell.CELL_TYPE_BOOLEAN) {
            // 返回布尔类型的值
            return String.valueOf(hssfCell.getBooleanCellValue());
        } else if (hssfCell.getCellType() == hssfCell.CELL_TYPE_NUMERIC) {
            // 返回数值类型的值
            return String.valueOf(hssfCell.getNumericCellValue());
        } else {
            // 返回字符串类型的值
            return String.valueOf(hssfCell.getStringCellValue());
        }
    }
    
    void printRes(String[][] res){
    	for (int i=0; i< res.length; i++){
    		for (int j =0; j< 6; j++){
    			System.out.println(res[i][j]);
    		}
    		System.out.print("------------------\n");
    	}
    }

}
