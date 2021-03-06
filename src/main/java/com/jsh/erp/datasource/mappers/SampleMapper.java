package com.jsh.erp.datasource.mappers;


import com.jsh.erp.datasource.entities.Sample;
import com.jsh.erp.datasource.entities.SampleExample;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface SampleMapper {
    long countByExample(SampleExample example);

    int deleteByExample(SampleExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Sample record);

    int insertSelective(Sample record);

    List<Sample> selectByExample(SampleExample example);

    Sample selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Sample record, @Param("example") SampleExample example);

    int updateByExample(@Param("record") Sample record, @Param("example") SampleExample example);

    int updateByPrimaryKeySelective(Sample record);

    int updateByPrimaryKey(Sample record);

    List<Sample> selectByConditionSample(@Param("name") String name, @Param("brand")String brand, int offset, int rows);

    Long countsBySample(String name, String brand);

    void batchDeleteMaterialByIds(@Param("updateTime") Date updateTime, @Param("updater") Long updater, @Param("ids") String ids[]);

    void follYes(@Param("updateTime") Date date,@Param("updater") Long aLong,@Param("id") Long id);

    void follNo(@Param("updateTime") Date date,@Param("updater") Long aLong,@Param("id") Long id);

    List<String> getSampleNameList();

    List<String> getSampleBrandList();

    List<Sample> findByAll(@Param("name") String name);
}