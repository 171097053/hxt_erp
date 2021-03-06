package com.jsh.erp.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.jsh.erp.datasource.entities.Column;
import com.jsh.erp.service.column.ColumnService;
import com.jsh.erp.utils.ParamUtils;
import com.jsh.erp.utils.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/column")
public class ColumnController {
    @Autowired
    private ColumnService columnService;

    /**
     * 动态获取列
     * @return
     */
    @GetMapping("/getcolumn")
    public List<Column> getColumn(){
        List<Column> columns = columnService.getcolumnList();
        List tm_list = new ArrayList<>();
        Column column;
        for (Column columnss : columns) {
            String jsons  = JSON.toJSONString(columnss);
            JSONObject jsonObject = JSON.parseObject(jsons);
            tm_list.add(jsonObject);
        }
        return tm_list.size() > 0 || tm_list!=null ? tm_list : null;
    }

}
