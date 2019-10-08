 package com.example.user.controller;

import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.user.wrapper.ExportPDFWrapper;

@RestController
@RequestMapping("/api/pdf")
@CrossOrigin(origins = {"http://localhost:8000","http://localhost:8001","http://localhost:8002","http://localhost:8003","http://localhost:8004"},maxAge = 3600)
public class PDFController {
 
     @RequestMapping("/get/pdf")
     public void getExcel(HttpServletResponse response) throws Exception {
         ExportPDFWrapper wrapper = new ExportPDFWrapper();
         wrapper.exportExcel(response);
     }
 }
