 package com.example.util.test;

import org.junit.Test;
import com.example.user.utils.ExportPDFUtilLocal;
import com.example.user.utils.ExportPDFUtilLocal2;
import com.itextpdf.text.DocumentException;

public class ExportPDFUtilTest {
         
     @Test
     public void exportPDFTest() throws DocumentException, Exception {
         ExportPDFUtilLocal.exportPDF("C:\\Users\\EDZ\\Desktop\\1POReceiveReport.pdf");
     }
     @Test
     public void exportPDF2Test() throws DocumentException, Exception {
         ExportPDFUtilLocal2.exportPDF("C:\\Users\\EDZ\\Desktop\\2POReceiveReport.pdf");
     }

 }