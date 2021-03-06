package com.jsh.erp.datasource.mappers;


import com.jsh.erp.datasource.entities.Column;
import com.jsh.erp.datasource.entities.ColumnExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ColumnMapper {
    long countByExample(ColumnExample example);

    int deleteByExample(ColumnExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Column record);

    int insertSelective(Column record);

    List<Column> selectByExample(ColumnExample example);

    Column selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Column record, @Param("example") ColumnExample example);

    int updateByExample(@Param("record") Column record, @Param("example") ColumnExample example);

    int updateByPrimaryKeySelective(Column record);

    int updateByPrimaryKey(Column record);
}