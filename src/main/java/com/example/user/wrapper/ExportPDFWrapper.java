package com.example.user.wrapper;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import javax.servlet.http.HttpServletResponse;
import com.example.user.utils.ExportPDFUtilRemote;
import com.itextpdf.text.DocumentException;
 
 
/**
 * <p>包装类</p>  
 * @author Joe
 *
 * @param <T>
 */
public class ExportPDFWrapper {
    /**
     * <p>导出带有头部标题行的Excel <br> 时间格式默认：yyyy-MM-dd hh:mm:ss <br></p>
     * @param title 表格标题
     * @param headers 头部标题集合
     * @param dataset 数据集合
     * @param out 输出流
     * @param version 2003 或者 2007，不传时默认生成2003版本
     * @throws Exception 
     * @throws DocumentException 
     */
    public void exportExcel(HttpServletResponse response){
        try {
            response.setContentType("application/pdf");
            response.setHeader("Content-Disposition","attachment; filename=" + URLEncoder.encode("test.pdf", "utf-8"));
            response.setCharacterEncoding("utf-8");
            ExportPDFUtilRemote.exportPDF(response);
        } catch (UnsupportedEncodingException e) {
             e.printStackTrace();
        } catch (DocumentException e) {
             e.printStackTrace();
        } catch (Exception e) {
             e.printStackTrace();
        }
        
    }
}
