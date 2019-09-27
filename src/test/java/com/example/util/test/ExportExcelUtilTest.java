 package com.example.util.test;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.junit.Test;
import com.example.user.entity.User;
import com.example.user.utils.ExportExcelUtilLocal;

public class ExportExcelUtilTest {
         
     @Test
     public void exportWithoutHeaderTest() throws FileNotFoundException {
         ExportExcelUtilLocal<User> util = new ExportExcelUtilLocal<User>();
         List<User> list = new ArrayList<>();
         int j = 1;
         for (int i = 0; i < 10; i++) {
              list.add(new User((j++)+"","111",1,"1111","111111","11111111",new Date(),new Date()));
              list.add(new User((j++)+"","222",2,"2222","222222","22222222",new Date(),new Date()));
              list.add(new User((j++)+"","333",3,"3333","333333","33333333",new Date(),new Date()));
         }
         util.exportExcel("用户导出", list, new FileOutputStream("C:\\Users\\EDZ\\Desktop/exportWithoutHeaderTest1.xls"), ExportExcelUtilLocal.EXCEL_FILE_2003);
         util.exportExcel("用户导出", list, new FileOutputStream("C:\\Users\\EDZ\\Desktop/exportWithoutHeaderTest2.xls"), ExportExcelUtilLocal.EXCEl_FILE_2007);
     }
     @Test
     public void exportWithHeaderTest() throws FileNotFoundException {
         ExportExcelUtilLocal<User> util = new ExportExcelUtilLocal<User>();
         List<User> list = new ArrayList<>();
         int j = 1;
         for (int i = 0; i < 10; i++) {
              list.add(new User((j++)+"","111",1,"1111","111111","11111111",new Date(),new Date()));
              list.add(new User((j++)+"","222",2,"2222","222222","22222222",new Date(),new Date()));
              list.add(new User((j++)+"","333",3,"3333","333333","33333333",new Date(),new Date()));
         }
         String[] columnNames = { "ID", "姓名","年龄", "性别","地址","组别","创建时间","更新时间" };
         util.exportExcel("用户导出", columnNames, list, new FileOutputStream("C:\\Users\\EDZ\\Desktop/exportWithHeaderTest1.xls"), ExportExcelUtilLocal.EXCEL_FILE_2003);
         util.exportExcel("用户导出", columnNames, list, new FileOutputStream("C:\\Users\\EDZ\\Desktop/exportWithHeaderTest2.xls"), ExportExcelUtilLocal.EXCEl_FILE_2007);
     }

 }