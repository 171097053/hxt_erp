package com.jsh.erp.service.column;

import com.jsh.erp.datasource.entities.Column;
import com.jsh.erp.datasource.entities.ColumnExample;
import com.jsh.erp.datasource.mappers.ColumnMapper;
import com.jsh.erp.exception.JshException;
import com.jsh.erp.service.material.MaterialService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ColumnService {
    private Logger logger = LoggerFactory.getLogger(ColumnService.class);
    @Autowired
    ColumnMapper columnMapper;

    public List<Column> getcolumnList() {
        ColumnExample columnExample = new ColumnExample();
        ColumnExample.Criteria criteria = columnExample.createCriteria();
        List<Column> columns = columnMapper.selectByExample(columnExample);
        return columns;
    }



}
