 package com.example.user.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.user.entity.User;
import com.example.user.service.UserService;
import com.example.user.utils.ExportExcelUtilLocal;
import com.example.user.wrapper.ExportExcelWrapper;

@RestController
@RequestMapping("/api/excel")
@CrossOrigin(origins = {"http://localhost:8000","http://localhost:8001","http://localhost:8002","http://localhost:8003","http://localhost:8004"},maxAge = 3600)
public class ExcelController {
    
     private Logger logger = LoggerFactory.getLogger(this.getClass());
    
     @Autowired
     private UserService userService;
 
     @RequestMapping("/get/user/{version}")
     public void getExcel( @PathVariable("version") String version, HttpServletResponse response) throws Exception {
         List<User> list = userService.findAllUser(null, null);
         String[] columnNames = { "ID", "姓名","年龄", "性别","地址","组别","创建时间","更新时间" };
         String fileName = "excel1";
         ExportExcelWrapper<User> util = new ExportExcelWrapper<User>();
         if(version.equals("2003")) {
             util.exportExcel(fileName, "2003-title", columnNames, list, ExportExcelUtilLocal.EXCEL_FILE_2003, response);
         }else if(version.equals("2007")) {
             util.exportExcel(fileName, "2007-title", columnNames, list, ExportExcelUtilLocal.EXCEl_FILE_2007, response);
         }else {
             util.exportExcel(fileName, "2007-title", columnNames, list, ExportExcelUtilLocal.EXCEl_FILE_2007, response);
         }
         logger.info(response.getOutputStream().toString());
     }
 }
