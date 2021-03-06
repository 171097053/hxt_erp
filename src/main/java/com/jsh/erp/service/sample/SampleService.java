package com.jsh.erp.service.sample;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.jsh.erp.constants.BusinessConstants;
import com.jsh.erp.datasource.entities.*;
import com.jsh.erp.datasource.mappers.SampleMapper;
import com.jsh.erp.exception.JshException;
import com.jsh.erp.service.log.LogService;
import com.jsh.erp.service.material.MaterialService;
import com.jsh.erp.service.user.UserService;
import com.jsh.erp.utils.BaseResponseInfo;
import com.jsh.erp.utils.ExcelUtils;
import com.jsh.erp.utils.StringUtil;
import jxl.Sheet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.*;

@Service
public class SampleService {

    private Logger logger = LoggerFactory.getLogger(SampleService.class);


    @Resource
    private SampleMapper sampleMapper;

    @Resource
    private LogService logService;
    @Resource
    private UserService userService;

    public List<Sample> select(String name, String brand, int offset, int rows) {

        return sampleMapper.selectByConditionSample(name, brand, offset, rows);

    }

    public Long countSample(String name, String brand) {
        return sampleMapper.countsBySample(name, brand);
    }

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    public int insertSample(String beanJson, HttpServletRequest request) {
        Sample s = JSONObject.parseObject(beanJson, Sample.class);

        sampleMapper.insertSelective(s);

        try {
            logService.insertLog("样品",
                    new StringBuffer(BusinessConstants.LOG_OPERATION_TYPE_ADD).append(s.getGoodsName()).toString(), request);
            return 1;
        } catch (Exception e) {
            JshException.writeFail(logger, e);
            return 0;
        }
    }

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    public int batchDeleteSampleByIdsNormal(String ids) throws Exception {
        int deleteTotal = 0;
        if (StringUtils.isEmpty(ids)) {
            return deleteTotal;
        }
        String[] idArray = ids.split(",");


        StringBuffer sb = new StringBuffer();
        sb.append(BusinessConstants.LOG_OPERATION_TYPE_DELETE);
        List<Sample> list = getMaterialListByIds(ids);
        for (Sample sample : list) {
            sb.append("[").append(sample.getGoodsName()).append("]");
        }
        logService.insertLog("样品", sb.toString(),
                ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest());
        User userInfo = userService.getCurrentUser();
        try {
            //逻辑删除商品
            sampleMapper.batchDeleteMaterialByIds(new Date(), userInfo == null ? null : userInfo.getId(), idArray);
          /*  //逻辑删除商品价格扩展
            materialExtendMapperEx.batchDeleteMaterialExtendByMIds(idArray);*/
            return 1;
        } catch (Exception e) {
            JshException.writeFail(logger, e);
            return 0;
        }
    }

    public List<Sample> getMaterialListByIds(String ids) throws Exception {
        List<Long> idList = StringUtil.strToLongList(ids);
        List<Sample> list = new ArrayList<>();
        try {
            SampleExample example = new SampleExample();
            example.createCriteria().andIdIn(idList);
            list = sampleMapper.selectByExample(example);
        } catch (Exception e) {
            JshException.readFail(logger, e);
        }
        return list;
    }

    public int batchDeleteSampleByIds(String ids) {
        return 0;
    }

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    public int updateSample(String beanJson, Long id, HttpServletRequest request) {
        Sample sample = JSONObject.parseObject(beanJson, Sample.class);
        sample.setId(id);
        try {
            sampleMapper.updateByPrimaryKeySelective(sample);
            /*JSONObject mObj = JSON.parseObject(beanJson);
            materialExtendService.saveDetials(mObj.getString("inserted"),mObj.getString("deleted"),mObj.getString("updated"),mObj.getString("sortList"),id);
            if(mObj.get("stock")!=null) {
                String stockStr = mObj.getString("stock");
                JSONArray stockArr = JSONArray.parseArray(stockStr);
                for (Object object : stockArr) {
                    JSONObject jsonObj = (JSONObject) object;
                    if (jsonObj.get("depotId") != null && jsonObj.get("number") != null) {
                        String number = jsonObj.getString("number");
                        Long depotId = jsonObj.getLong("depotId");
                        //先清除再插入
                        MaterialInitialStockExample example = new MaterialInitialStockExample();
                        example.createCriteria().andMaterialIdEqualTo(id).andDepotIdEqualTo(depotId);
                        materialInitialStockMapper.deleteByExample(example);
                        if (number != null && Double.valueOf(number) > 0) {
                            insertStockByMaterialAndDepot(depotId, id, parseBigDecimalEx(number));
                        }
                    }
                }
            }*/
            logService.insertLog("样品",
                    new StringBuffer(BusinessConstants.LOG_OPERATION_TYPE_EDIT).append(sample.getGoodsName()).toString(), request);
            return 1;
        } catch (Exception e) {
            JshException.writeFail(logger, e);
            return 0;
        }

    }

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    public void follYes(String id) throws Exception {
        StringBuffer sb = new StringBuffer();
        sb.append("跟进");
        List<Sample> list = getMaterialListByIds(id);
        for (Sample sample : list) {
            sb.append("[").append(sample.getGoodsName()).append("]");
        }
        logService.insertLog("样品", sb.toString(),
                ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest());
        User userInfo = userService.getCurrentUser();
        Long lid = Long.parseLong(id);
        for (Sample sample : list) {
            if (sample.getState().equals("0")) {
                sampleMapper.follYes(new Date(), userInfo == null ? null : userInfo.getId(), lid);
            } else {
                sampleMapper.follNo(new Date(), userInfo == null ? null : userInfo.getId(), lid);
            }
        }
    }


    public List<String> getSampleNameList() {

        return sampleMapper.getSampleNameList();
    }

    public List<String> getSampleBrandList() {
        return sampleMapper.getSampleBrandList();
    }

    public int checkIsExist(Long id, String name) {
        SampleExample sample = new SampleExample();
        SampleExample.Criteria criteria = sample.createCriteria();

        criteria.andGoodsNameEqualTo(name)
                .andDeleteFlagNotEqualTo(BusinessConstants.DELETE_FLAG_DELETED);
        if (id > 0) {
            criteria.andIdNotEqualTo(id);
        }

        return sampleMapper.selectByExample(sample).size();
    }

    public List<Sample> findByAll(String name) {

        List<Sample> resList = new ArrayList<Sample>();
        List<Sample> list = null;
        try {
            list = sampleMapper.findByAll(name);
        } catch (Exception e) {
            JshException.readFail(logger, e);
        }
        if (null != list) {
            for (Sample m : list) {
                resList.add(m);
            }
        }
        return resList;
    }

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    public BaseResponseInfo importExcel(Sheet src) throws Exception {

        List<String> list = new ArrayList();

        List<Sample> sList = new ArrayList<>();
        for (int i = 1; i < src.getRows(); i++) {

            String brand = ExcelUtils.getContent(src, i, 0); //品牌


            String factoryNumber = ExcelUtils.getContent(src, i, 1); //工厂号


            String goodsName = ExcelUtils.getContent(src, i, 2); //品名


            String specDesc = ExcelUtils.getContent(src, i, 4); //规格描述


            String demaQuan = ExcelUtils.getContent(src, i, 5); //需求数量


            String statrData = ExcelUtils.getContent(src, i, 6); //立项日期


            String endData = ExcelUtils.getContent(src, i, 7); //预计交付日期

            String sjendData = ExcelUtils.getContent(src, i, 8); //实际交付日期


            String remarks = ExcelUtils.getContent(src, i, 9); //备注


            String state = ExcelUtils.getContent(src, i, 10); //状态


            //校验名称、型号、单位是否为空
            if (StringUtil.isNotEmpty(goodsName)) {
               Sample s = new Sample();
                s.setBrand(brand);
                s.setFactoryNumber(factoryNumber);
                s.setGoodsName(goodsName);
                s.setSpecDesc(specDesc);
                s.setDemaQuan(demaQuan);
                s.setStatrData(statrData);
                s.setEndData(endData);
                s.setSjendData(sjendData);
                s.setRemarks(remarks);
                s.setState(state.equals("未完成") ? "0":"1");
                sList.add(s);
            }
        }

        logService.insertLog("样品",
                new StringBuffer(BusinessConstants.LOG_OPERATION_TYPE_IMPORT).append(sList.size()).append(BusinessConstants.LOG_DATA_UNIT).toString(),
                ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest());
        BaseResponseInfo info = new BaseResponseInfo();
        Map<String, Object> data = new HashMap<String, Object>();
        try {
            Long mId = 0L;
            for (Sample  s: sList) {
                //判断该商品是否存在，如果不存在就新增，如果存在就更新
                List<Sample> samples = getMaterialListByParam(s.getGoodsName());
                if (samples.size() == 0) {
                    sampleMapper.insertSelective(s);
                    List<Sample> newList = getMaterialListByParam(s.getGoodsName());
                    if (newList != null && newList.size() > 0) {
                        mId = newList.get(0).getId();
                    }
                } else {
                    mId = samples.get(0).getId();
                    String sampleJson = JSON.toJSONString(s);
                    Sample sample = JSONObject.parseObject(sampleJson, Sample.class);
                    sample.setId(mId);
                    sampleMapper.updateByPrimaryKeySelective(sample);
                }

            }
            info.code = 200;
            data.put("message", "成功");
        } catch (Exception e) {
            e.printStackTrace();
            info.code = 500;
            data.put("message", e.getMessage());
        }
        info.data = data;
        return info;
    }

    /**
     * 根据条件返回产品列表
     *
     * @param name
     * @param csku
     * @param fnsku
     * @return
     */
    private List<Sample> getMaterialListByParam(String name) {
        SampleExample example = new SampleExample();
        SampleExample.Criteria criteria = example.createCriteria();
        criteria.andGoodsNameEqualTo(name);

        criteria.andDeleteFlagNotEqualTo(BusinessConstants.DELETE_FLAG_DELETED);
        List<Sample> list = sampleMapper.selectByExample(example);
        return list;
    }
}
