package cn.yamon.readExcel;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFDataBarFormatting;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.List;

/**
 * Created by Intellij IDEA.
 * User:  陈亚萌
 * Date:  2019/8/4
 */
public class ReadExcel {
    private static XSSFSheet sheet;

    ReadExcel(String filePath, String sheetName) throws Exception {

        FileInputStream fileInputStream = null;
        //获取文件路径，并且获取文件
        fileInputStream = new FileInputStream(filePath);
        //将文件进行解析
        /*
        *   1.XSSFWorkbook(java.io.InputStream is)
		        构造一个XSSFWorkbook对象，通过缓冲整个输入流到内存中，然后为它打开一个OPCPackage对象。
		*   2. XSSFWorkbook(java.lang.String path)
				构建一个给定文件的完整路径的XSSFWorkbook对象。
		    3. XSSFWorkbook(java.io.File file)
				构造从给定文件中的XSSFWorkbook对象。
        * */
        XSSFWorkbook sheets = new XSSFWorkbook(fileInputStream);
        //获取sheet
        /*getSheet(java.lang.String name)
            获取具有给定名称的工作表（不区分大小写）
        * */
        sheet = sheets.getSheet(sheetName);
    }

    /**
     * 根据行和列的index来获取单元格数据
     *
     * @param row 行
     * @param col 列
     * @return String类型的获取值
     */
    public String getExcleDataByIndex(int row, int col) {
        //获取行值
        /*
        * getRow()
            返回此单元格所属的行*/
        XSSFRow row1 = sheet.getRow(row);
        String cell = row1.getCell(col).toString();
        return cell;
    }

    /**
     * 根据某一列值为****的这一行来获取该行的第某列的值
     *
     * @param caseName
     * @param currentCol 当前单元格的index
     * @param targetCol  目标单元格的index
     * @return
     */
    public String getCellByCaseName(String caseName, int currentCol, int targetCol) {
        String operateSteps = "";
        //获取行
        int rows = sheet.getPhysicalNumberOfRows();
        for (int i = 0; i < rows; i++) {
            XSSFRow row = sheet.getRow(i);
            String cell = row.getCell(currentCol).toString();
            if (cell.equals(caseName)) {
                operateSteps = row.getCell(targetCol).toString();
                break;
            }
        }
        return operateSteps;
    }

    /**
     * 输出Excel
     */
    public static void readExcelData() {
        int flag = 0;
        int rows = sheet.getPhysicalNumberOfRows();
        for (int i = 0; i < rows; i++) {
            flag++;
            XSSFRow row = sheet.getRow(i);
            int col = row.getPhysicalNumberOfCells();

            for (int j = 0; j < col; j++) {
                if ((j+1)% 5==0) {
                    System.out.println("");
                }
                String cell = row.getCell(j).toString();
                System.out.print("第" + (i + 1) + "行" + "第" + (j + 1) + "列" + ":" + cell + "    ");


            }


        }
    }

    //遍历出Excel中的所有数据
    public List<String> getAllData(String realPath) throws Exception {
        //创建输入流开始读取Excel
        InputStream is = new FileInputStream(realPath);
        return null;


    }

    public static void main(String[] args) throws Exception {
        //给定文件路径和表名儿
        ReadExcel sheet1 = new ReadExcel("E:\\1.xlsx", "username");
        //获取第二行第四列
        String cell2 = sheet1.getExcleDataByIndex(1, 0);


        //根据第三列值为customer23的这一行，来获取该行第二列的值
        String cell3 = sheet1.getCellByCaseName("custom22", 1, 2);
        System.out.println(cell2);

        System.out.println(cell3);
        readExcelData();
    }

}
