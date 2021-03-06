package com.jsh.erp.datasource.mappers;

import java.util.List;

import com.jsh.erp.datasource.entities.Material;
import com.jsh.erp.datasource.entities.MaterialExample;
import org.apache.ibatis.annotations.Param;

public interface MaterialMapper {

    long countByExample(MaterialExample example);

    int deleteByExample(MaterialExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Material record);

    int insertSelective(Material record);

    List<Material> selectByExample(MaterialExample example);

    Material selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Material record, @Param("example") MaterialExample example);

    int updateByExample(@Param("record") Material record, @Param("example") MaterialExample example);

    int updateByPrimaryKeySelective(Material record);

    int updateByPrimaryKey(Material record);

    List<Material> selectByConditionMaterial(String name, String companySku, String fnsku, String brand,String categoryId, int offset, int rows);

    Long countsByMaterial(@Param("categoryId") String categoryId, @Param("name") String name, @Param("companySku") String companySku, @Param("fnsku") String fnsku, @Param("brand") String brand);

    List<Material> findByAll( @Param("name")String name);
}