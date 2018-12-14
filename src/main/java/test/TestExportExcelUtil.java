package test;

import test.utils.ExportExcelUtil;

import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;


/**
 * 测试文件导出
 * @author liuyazhuang
 *
 */
public class TestExportExcelUtil {

    public static void main(String[] args) throws Exception{
        ExportExcelUtil<Student> util = new ExportExcelUtil<Student>();
        // 准备数据
        List<Student> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(new Student(111,"张三asdf","男"));
            list.add(new Student(111,"李四asd","男"));
            list.add(new Student(111,"王五","女"));
        }
        String[] columnNames = { "ID", "姓名", "性别" };
        util.exportExcel("用户导出", columnNames, list, new FileOutputStream("E:/test.xls"), ExportExcelUtil.EXCEL_FILE_2003);
    }
}
