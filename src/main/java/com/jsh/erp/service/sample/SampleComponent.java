package com.jsh.erp.service.sample;

import com.jsh.erp.service.ICommonQuery;
import com.jsh.erp.utils.Constants;
import com.jsh.erp.utils.QueryUtils;
import com.jsh.erp.utils.StringUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@Service(value = "sample_component")
@SampleResource
public class SampleComponent implements ICommonQuery {
    @Resource
    private  SampleService sampleService;

    @Override
    public Object selectOne(Long id) throws Exception {
        return null;
    }

    @Override
    public List<?> select(Map<String, String> parameterMap) throws Exception {
        return getSampleList(parameterMap);
    }

    private List<?> getSampleList(Map<String, String> parameterMap) {
        String search = parameterMap.get(Constants.SEARCH);
        String name = StringUtil.getInfo(search, "name");
        String brand = StringUtil.getInfo(search, "brand");
        return sampleService.select(name,brand,QueryUtils.offset(parameterMap), QueryUtils.rows(parameterMap));
    }

    @Override
    public Long counts(Map<String, String> parameterMap) throws Exception {
        String search = parameterMap.get(Constants.SEARCH);
        String name = StringUtil.getInfo(search, "name");
        String brand = StringUtil.getInfo(search, "brand");
        return sampleService.countSample(name,brand);
    }

    @Override
    public int insert(String beanJson, HttpServletRequest request) throws Exception {
        return sampleService.insertSample(beanJson,request);
    }

    @Override
    public int update(String beanJson, Long id, HttpServletRequest request) throws Exception {
         return sampleService.updateSample(beanJson, id, request);
    }

    @Override
    public int delete(Long id, HttpServletRequest request) throws Exception {
        return 0;
    }

    @Override
    public int batchDelete(String ids, HttpServletRequest request) throws Exception {
        return 0;
    }

    @Override
    public int checkIsNameExist(Long id, String name) throws Exception {
        return sampleService.checkIsExist(id, name);
    }
}
