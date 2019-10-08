 package com.example.user.utils;

import java.io.FileOutputStream;
import com.itextpdf.text.Anchor;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chapter;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.List;
import com.itextpdf.text.ListItem;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.Section;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.draw.DottedLineSeparator;
import com.itextpdf.text.pdf.draw.LineSeparator;

public class ExportPDFUtilLocal2 {  
     
     public static void exportPDF(String url) throws Exception, DocumentException {
         
         //页面大小  
         Rectangle rect = new Rectangle(PageSize.A4.rotate());  
         //页面背景色  
         rect.setBackgroundColor(BaseColor.YELLOW);
         //create one document
         Document document = new Document(rect);  
         //Step 2—Get a PdfWriter instance.  
         PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(url));
         
         //设置pdf版本  PDF版本(默认1.4)  
         writer.setPdfVersion(PdfWriter.PDF_VERSION_1_4);  
           
         //文档属性  
         document.addTitle("Title@sample");  
         document.addAuthor("Author@rensanning");  
         document.addSubject("Subject@iText sample");  
         document.addKeywords("Keywords@iText");  
         document.addCreator("Creator@iText");  
           
         //页边空白  
         document.setMargins(20, 10, 10, 10); 
         //设置密码
//         writer.setEncryption("hello".getBytes(), "world".getBytes(),  PdfWriter.ALLOW_SCREENREADERS,  PdfWriter.STANDARD_ENCRYPTION_128);  
         //Step 3—Open the Document.  
         document.open();
         //添加第一页
         document.add(new Paragraph("First page"));
         Anchor destHome = new Anchor("Home", new Font(Font.FontFamily.HELVETICA, 14, Font.BOLD, BaseColor.BLUE));
         destHome.setName("Home");
         document.add(destHome);
         // China
         document.add(new Chunk("China"));  
         Font font = new Font(Font.FontFamily.HELVETICA, 6, Font.BOLD, BaseColor.WHITE);  
         Chunk id = new Chunk("chinese", font);  
         id.setBackground(BaseColor.BLACK, 1f, 0.5f, 1f, 1.5f);  
         id.setTextRise(6);  
         document.add(id);
         // Japan          
         document.add(new Chunk("Japan"));  
         Font font2 = new Font(Font.FontFamily.HELVETICA, 6, Font.BOLD, BaseColor.WHITE);  
         Chunk id2 = new Chunk("japanese", font2);  
         id2.setBackground(BaseColor.BLACK, 1f, 0.5f, 1f, 1.5f);  
         id2.setTextRise(6);  
         id2.setUnderline(0.2f, -2f);  
         document.add(id2);
         //chunk换行
         document.add(Chunk.NEWLINE);
         //添加外网链接
         Paragraph countryChina = new Paragraph();  
         Anchor destChina = new Anchor("china", new Font(Font.FontFamily.HELVETICA, 14, Font.BOLD, BaseColor.BLUE));  
         destChina.setName("CN");  
         destChina.setReference("http://www.china.com");  
         countryChina.add(destChina);  
         countryChina.add(String.format(": %d sites", 10000));  
         document.add(countryChina);
         
         Paragraph countryJapan = new Paragraph();  
         Anchor destJapan = new Anchor("japan", new Font(Font.FontFamily.HELVETICA, 14, Font.BOLD, BaseColor.BLUE));  
         destJapan.setName("JP");  
         destJapan.setReference("http://www.japan.com");  
         countryJapan.add(destJapan);  
         countryJapan.add(String.format(": %d sites", 8000));  
         document.add(countryJapan);
         document.add(new Chunk("Chapter 1").setLocalDestination("1"));
         
         //添加第二页
         document.newPage();
         Anchor toHome = new Anchor("Go to first page.", new Font(Font.FontFamily.HELVETICA, 14, Font.BOLD, BaseColor.BLUE));  
         toHome.setReference("#Home");  
         document.add(toHome);
         document.add(new Paragraph("Second page"));
         writer.setPageEmpty(false);  
         //第二页第一行
         Phrase phrase1 = new Phrase();  
         Chunk name = new Chunk("China");  
         name.setUnderline(0.2f, -2f);  
         phrase1.add(name);  
         phrase1.add(new Chunk("chinese      "));  
         phrase1.setLeading(24);  
         document.add(phrase1);
         //第二页第二行
         Phrase phrase2 = new Phrase();  
         Chunk name2 = new Chunk("Japan");  
         name2.setUnderline(0.2f, -2f);  
         phrase2.add(name2);   
         phrase2.add(new Chunk("japanese"));  
         phrase2.setLeading(24);  
         document.add(phrase2);
         document.add(new Chunk("Chapter 2").setLocalDestination("2"));  
         document.add(new Paragraph(new Chunk("Sub 2.1").setLocalDestination("2.1")));  
         document.add(new Paragraph(new Chunk("Sub 2.2").setLocalDestination("2.2")));
         
         //添加第三页
         document.newPage(); 
         document.add(new Paragraph("Third page"));
         document.add(new Chunk("Chapter 3").setLocalDestination("3"));
         document.add(new Paragraph("Paragraph page"));  
         
         Paragraph info = new Paragraph();  
         info.add(new Chunk("China "));  
         info.add(new Chunk("chinese"));  
         info.add(Chunk.NEWLINE);  
         info.add(new Phrase("Japan "));  
         info.add(new Phrase("japanese"));
         
         Paragraph title = new Paragraph("Title");  
         Chapter chapter = new Chapter(title, 1);  
           
         title = new Paragraph("Section A");  
         Section section = chapter.addSection(title);  
         section.setBookmarkTitle("bmk");  
         section.setIndentation(30);  
         section.setBookmarkOpen(false);  
         section.setNumberStyle(  
         Section.NUMBERSTYLE_DOTTED_WITHOUT_FINAL_DOT);  
           
         Section subsection = section.addSection(new Paragraph("Sub Section A"));  
         subsection.setIndentationLeft(20);  
         subsection.setNumberDepth(1);  
           
         document.add(chapter);
         document.add(info);
         
         //直线  
         Paragraph p1 = new Paragraph("LEFT");  
         p1.add(new Chunk(new LineSeparator()));  
         p1.add("R");  
         document.add(p1);  
         //点线  
         Paragraph p2 = new Paragraph("LEFT");  
         p2.add(new Chunk(new DottedLineSeparator()));  
         p2.add("R");  
         document.add(p2);  
         //下滑线  
         LineSeparator UNDERLINE = new LineSeparator(1, 100, null, Element.ALIGN_CENTER, -2);  
         Paragraph p3 = new Paragraph("NNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNN");  
         p3.add(UNDERLINE);  
         document.add(p3);

         document.newPage();  
         List list = new List(List.ORDERED);  
         for (int i = 0; i < 10; i++) {  
             ListItem item = new ListItem(String.format("%s: %d movies",  
                     "country" + (i + 1), (i + 1) * 100), new Font(  
                     Font.FontFamily.HELVETICA, 6, Font.BOLD, BaseColor.WHITE));  
             List movielist = new List(List.ORDERED, List.ALPHABETICAL);  
             movielist.setLowercase(List.LOWERCASE);  
             for (int j = 0; j < 5; j++) {  
                 ListItem movieitem = new ListItem("Title" + (j + 1));  
                 List directorlist = new List(List.UNORDERED);  
                 for (int k = 0; k < 3; k++) {  
                     directorlist.add(String.format("%s, %s", "Name1" + (k + 1),  
                             "Name2" + (k + 1)));  
                 }  
                 movieitem.add(directorlist);  
                 movielist.add(movieitem);  
             }  
             item.add(movielist);  
             list.add(item);  
         }  
         //Step 5—Close the Document.  
         document.close();
     }
  
 }
