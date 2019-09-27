package com.example.user.wrapper;

import java.net.URLEncoder;
import java.util.Collection; 
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.lang.StringUtils;

import com.example.user.utils.ExportExcelUtilRemote;
 
 
/**
 * <p>包装类</p>  
 * @author Joe
 *
 * @param <T>
 */
public class ExportExcelWrapper<T> extends ExportExcelUtilRemote<T> {
    /**
     * <p>导出带有头部标题行的Excel <br> 时间格式默认：yyyy-MM-dd hh:mm:ss <br></p>
     * @param title 表格标题
     * @param headers 头部标题集合
     * @param dataset 数据集合
     * @param out 输出流
     * @param version 2003 或者 2007，不传时默认生成2003版本
     */
    public void exportExcel(String fileName, String title, String[] headers, Collection<T> dataset, String version, HttpServletResponse response) {
        try {
            if(StringUtils.isBlank(version) || EXCEL_FILE_2003.equals(version.trim())){
                response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(fileName + ".xls", "utf-8"));
                response.setHeader("content-type", "application/vnd.ms-excel;charset=utf-8");
                response.setCharacterEncoding("utf-8");
                exportExcel2003(title, headers, dataset, response, "yyyy-MM-dd HH:mm:ss");
            }else{
                response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(fileName + ".xlsx", "utf-8"));
                response.setHeader("content-type", "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet;charset=utf-8");
                response.setCharacterEncoding("utf-8");
                exportExcel2007(title, headers, dataset, response, "yyyy-MM-dd HH:mm:ss");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
