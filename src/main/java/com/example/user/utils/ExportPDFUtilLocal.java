 package com.example.user.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chapter;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Section;
import com.itextpdf.text.pdf.Barcode128;
import com.itextpdf.text.pdf.BarcodeQRCode;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

public class ExportPDFUtilLocal {  
     
     public static void exportPDF(String url) throws Exception, DocumentException {
          
         List<String> ponum=new ArrayList<String>();
         add(ponum, 26);
         List<String> line=new ArrayList<String>();
         add(line, 26);
         List<String> part=new ArrayList<String>();
         add(part, 26);
         List<String> description=new ArrayList<String>();
         add(description, 26);
         List<String> origin=new ArrayList<String>();
         add(origin, 26);
          
         //文档页面大小A4
         Document document=new Document(PageSize.A4,20f,10f,10f,10f);
          
         BaseFont bfChinese=BaseFont.createFont("STSong-Light", "UniGB-UCS2-H", BaseFont.NOT_EMBEDDED);          
         Font keyfont=new Font(bfChinese,8,Font.BOLD);
         Font textfont=new Font(bfChinese,8,Font.NORMAL);
          
         //Create Writer associated with document
         PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(new File(url)));
         document.open();
         document.addTitle("Hello mingri example");
         //作者
         document.addAuthor("wolf");
         //主题
         document.addSubject("This example explains how to add metadata.");
         document.addKeywords("iText, Hello mingri");
         document.addCreator("My program using iText");
         int recordPerPage=10;
         int fullPageRequired=ponum.size()/recordPerPage;
         int remainPage=ponum.size()%recordPerPage>1?1:0;
         int totalPage=fullPageRequired+remainPage;
          
         for(int j=0;j<totalPage;j++){
             
             document.newPage();  
             String pageNo=leftPad("页码: "+(j+1)+" / "+totalPage,615);
             Paragraph pageNumber=new Paragraph(pageNo, keyfont) ;
             document.add(pageNumber);
             
             //create title image
             Image jpeg=Image.getInstance("C:\\Users\\EDZ\\Desktop\\test file\\test.JPG");
             jpeg.setAlignment(Image.ALIGN_CENTER);
             jpeg.scaleAbsolute(330, 37);
             document.add(jpeg);             
             //header information
             PdfPTable pdfPTable=new PdfPTable(8);
             float[] widthsHeader={3f,3f,3f,3f,3f,3f,3f,3f};
             pdfPTable.setWidths(widthsHeader);
             pdfPTable.getDefaultCell().setBorder(PdfPCell.NO_BORDER);
             String[] columnNames = { "ID", "姓名","年龄", "性别","地址","组别","创建时间","更新时间" };
             for(int i=0;i<columnNames.length;i++) {
                 PdfPCell  cellHeader=new PdfPCell (new Paragraph(columnNames[i],keyfont));
                 pdfPTable.addCell(cellHeader);
             }            
              
             //calculate the real records within a page ,to calculate the last record number of every page
             int maxRecordInPage= j+1 ==totalPage ? (remainPage==0?recordPerPage:(ponum.size()%recordPerPage)):recordPerPage;
              
             for(int i=j*recordPerPage;i<((j*recordPerPage)+maxRecordInPage);i++){
                 PdfPCell  c2=new PdfPCell (new Paragraph("test Paragraph 0", textfont));
                 pdfPTable.addCell(c2);
                 c2=new PdfPCell(new Paragraph("test Paragraph 1", textfont));
                 pdfPTable.addCell(c2);
             }
             document.add(pdfPTable);
             PdfPTable pdfPTable2=new PdfPTable(3);
             float[] widthsHeader2={3f,3f,3f};
             pdfPTable2.setWidths(widthsHeader2);
             pdfPTable2.getDefaultCell().setBorder(PdfPCell.NO_BORDER);
             PdfPCell cells1[]= new PdfPCell[3];
             cells1[0] = new PdfPCell(new Paragraph("111"));//单元格内容
             cells1[0].setBorderColor(BaseColor.BLUE);//边框验证
             cells1[0].setPaddingLeft(20);//左填充20
             //设置水平对齐方式
             cells1[0].setHorizontalAlignment(Element.ALIGN_CENTER);
             //设置垂直对齐方式
             cells1[0].setVerticalAlignment(Element.ALIGN_MIDDLE);
             cells1[1] = new PdfPCell(new Paragraph("222"));
             cells1[2] = new PdfPCell(new Paragraph("333"));
             pdfPTable2.addCell(cells1[0]);
             pdfPTable2.addCell(cells1[1]);
             pdfPTable2.addCell(cells1[2]);
             document.add(pdfPTable2);
             
             String myString = "http://www.google.com";  
             PdfContentByte cb = writer.getDirectContent(); 
             Barcode128 code128 = new Barcode128();  
             code128.setCode(myString.trim());  
             code128.setCodeType(Barcode128.CODE128);  
             Image code128Image = code128.createImageWithBarcode(cb, null, null);  
             code128Image.setAbsolutePosition(10,700);  
             code128Image.scalePercent(125);  
             document.add(code128Image);  
               
             BarcodeQRCode qrcode = new BarcodeQRCode(myString.trim(), 1, 1, null);  
             Image qrcodeImage = qrcode.getImage();  
             qrcodeImage.setAbsolutePosition(10,600);  
             qrcodeImage.scalePercent(200);  
             document.add(qrcodeImage);
             
             Chapter chapter1 = new Chapter("chapter 1", 1);
             chapter1.setNumberDepth(0);
             Paragraph title11 = new Paragraph("This is Section 1 in Chapter 1",
             FontFactory.getFont(FontFactory.HELVETICA, 16, Font.BOLD,new BaseColor(255, 0, 0)));
             Section section1 = chapter1.addSection(title11);
             Paragraph someSectionText = new Paragraph("This text comes as part of section 1 of chapter 1.");
             section1.add(someSectionText);
             someSectionText = new Paragraph("Following is a 3 X 2 table.");
             section1.add(someSectionText);
             document.add(chapter1);
             if(j+1==totalPage){  
                 Paragraph foot11 = new Paragraph("文件只作  Foster 收貨用"+printBlank(150)+"__________________________",keyfont);
                 document.add(foot11);
                 Paragraph foot12 = new Paragraph("Printed from Foster supplier portal"+printBlank(134)+printBlank(40)+"版本: 1.0",keyfont);
                 document.add(foot12);

             }
         }
         document.close();
     }
      
     public static String leftPad(String str, int i) {
         int addSpaceNo = i-str.length();
         String space = "";
         for (int k=0; k<addSpaceNo; k++){
                 space= " "+space;
         };
         String result =space + str ;
         return result;
      }
      
     public static void add(List<String> list,int num){
         for(int i=0;i<num;i++){
             list.add("test"+i);
         }
     }
      
     public static String printBlank(int tmp){
           String space="";
           for(int m=0;m<tmp;m++){
               space=space+" ";
           }
           return space;
     }
  
 }
