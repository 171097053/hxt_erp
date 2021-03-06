package com.jsh.erp.service.material;

import com.jsh.erp.service.ICommonQuery;
import com.jsh.erp.service.depot.DepotResource;
import com.jsh.erp.service.depot.DepotService;
import com.jsh.erp.utils.Constants;
import com.jsh.erp.utils.QueryUtils;
import com.jsh.erp.utils.StringUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@Service(value = "material_component")
@MaterialResource
public class MaterialComponent implements ICommonQuery {

    @Resource
    private MaterialService materialService;

    @Override
    public Object selectOne(Long id) throws Exception {
        return materialService.getMaterial(id);
    }

    @Override
    public List<?> select(Map<String, String> map)throws Exception {
        return getMaterialList(map);
    }

    private List<?> getMaterialList(Map<String, String> map) throws Exception{
        String search = map.get(Constants.SEARCH);

        String name = StringUtil.getInfo(search, "name");
        String companySku = StringUtil.getInfo(search, "companySku");
        String fnsku = StringUtil.getInfo(search, "fnsku");
        String brand = StringUtil.getInfo(search, "brand");
        String categoryId = StringUtil.getInfo(search, "categoryId");
                                  //加上參數
        return materialService.select(name,companySku,fnsku,brand,categoryId,QueryUtils.offset(map), QueryUtils.rows(map));
    }

    @Override
    public Long counts(Map<String, String> map)throws Exception {
        String search = map.get(Constants.SEARCH);
        String name = StringUtil.getInfo(search, "name");
        String companySku = StringUtil.getInfo(search, "companySku");
        String fnsku = StringUtil.getInfo(search, "fnsku");
        String brand = StringUtil.getInfo(search, "brand");
        String categoryId = StringUtil.getInfo(search, "categoryId");
        return materialService.countMaterial(name,companySku,fnsku,brand,categoryId);
    }

    @Override
    public int insert(String beanJson, HttpServletRequest request) throws Exception{
       return materialService.insertMaterial(beanJson, request);

    }
    @Override
    public int update(String beanJson, Long id, HttpServletRequest request)throws Exception {
        return materialService.updateMaterial(beanJson, id, request);
    }

    @Override
    public int delete(Long id, HttpServletRequest request)throws Exception {
        return materialService.deleteMaterial(id, request);
    }

    @Override
    public int batchDelete(String ids, HttpServletRequest request)throws Exception {
        return materialService.batchDeleteMaterial(ids, request);
    }

    @Override
    public int checkIsNameExist(Long id, String name) throws Exception {
        return 0;
    }


    public int checkIsNameExist(Long id, String name,String companySku,String fnsku)throws Exception {
        return materialService.checkIsNameExist(id, name,companySku, fnsku);
    }

}
