package test.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import test.Student;
import test.utils.ExportExcelUtil;
import test.utils.ExportExcelWrapper;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/api")
public class TestController {
    @GetMapping(value = "/getExcel")
    public void getExcel(HttpServletRequest request, HttpServletResponse response) throws Exception {
        // 准备数据
        List<Student> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(new Student(111,"张三asdf","男"));
            list.add(new Student(111,"李四asd","男"));
            list.add(new Student(111,"王五","女"));
        }
        String[] columnNames = { "ID", "姓名", " 性别"};
        String fileName = "excel1";
        ExportExcelWrapper<Student> util = new ExportExcelWrapper<Student>();
        util.exportExcel(fileName, fileName, columnNames, list, response, ExportExcelUtil.EXCEl_FILE_2007);
    }
}
