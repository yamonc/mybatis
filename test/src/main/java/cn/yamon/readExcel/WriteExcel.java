package cn.yamon.readExcel;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.streaming.SXSSFRow;
import org.apache.poi.xssf.streaming.SXSSFSheet;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import static java.lang.System.*;

/**
 * Created by Intellij IDEA.
 * User:  陈亚萌
 * Date:  2019/8/16
 */

/**
 *
 */
public class WriteExcel {
    public static void main(String[] args) throws Exception {
        Scanner scanner= new Scanner(in);
        List<String> list=new ArrayList();
        out.println("输入的数据为：");
        while(true){
            String s = scanner.next();
            list.add(s);
            if (s=="-1"){
                break;
            }
        }

        //在内存中创建一个Excel文件
        SXSSFWorkbook workbook = new SXSSFWorkbook();
        //给Excel文件创建一张 Sheet1表
        SXSSFSheet sheet = workbook.createSheet("test");//table --》下面的Sheet1名


        //将list中的数据输出到excel表格中

        for (int i=0;i<list.size();i++){
            //将一行的数据传递给rowData这个list
            List<String> rowData= Collections.singletonList(list.get(i));
            //创建一行
            SXSSFRow row= sheet.createRow(i);
            for (int j = 0; j < rowData.size(); j++) {
                //创建单元格
                //开始换列

                row.createCell(j).setCellValue(rowData.get(j));
            }
        }
        //文件输出流--》把内存中的excel文件写到磁盘中
        FileOutputStream fos = new FileOutputStream("test.xlsx");
        workbook.write(fos);
        fos.close();

    }

    /**
     *
     * 获取一个list的集合，输出到Excel中
     * @param result 结果集
     * @param col 换行
     */
    public static void writeValue(Sheet sheet,List result,int col){
        if (result!=null){
            for (int i=0;i<result.size();i++){
                //将一行的数据传递给rowData这个list
                List rowData= (List) result.get(i);
                HSSFRow row= (HSSFRow) sheet.createRow(i+1);
                for (int j = 0; j < rowData.size(); j++) {
                    //创建单元格
                    row.createCell(j).setCellValue((String) rowData.get(j));
                }
            }
        }
    }

}
