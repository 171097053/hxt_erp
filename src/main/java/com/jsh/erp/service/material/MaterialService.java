package com.jsh.erp.service.material;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.jsh.erp.constants.BusinessConstants;
import com.jsh.erp.constants.ExceptionConstants;
import com.jsh.erp.datasource.entities.*;
import com.jsh.erp.datasource.mappers.*;
import com.jsh.erp.exception.BusinessRunTimeException;
import com.jsh.erp.exception.JshException;
import com.jsh.erp.service.materialExtend.MaterialExtendService;
import com.jsh.erp.service.depot.DepotService;
import com.jsh.erp.service.depotItem.DepotItemService;
import com.jsh.erp.service.log.LogService;
import com.jsh.erp.service.materialCategory.MaterialCategoryService;
import com.jsh.erp.service.unit.UnitService;
import com.jsh.erp.service.user.UserService;
import com.jsh.erp.utils.BaseResponseInfo;
import com.jsh.erp.utils.ExcelUtils;
import com.jsh.erp.utils.StringUtil;
import jxl.Cell;
import jxl.Sheet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.util.*;

@Service
public class MaterialService {
    private Logger logger = LoggerFactory.getLogger(MaterialService.class);

    @Resource
    private MaterialMapper materialMapper;
    @Resource
    private MaterialExtendMapper materialExtendMapper;
    @Resource
    private MaterialMapperEx materialMapperEx;
    @Resource
    private MaterialCategoryMapper categoryMapper;
    @Resource
    private MaterialExtendMapperEx materialExtendMapperEx;
    @Resource
    private LogService logService;
    @Resource
    private UserService userService;
    @Resource
    private DepotItemMapperEx depotItemMapperEx;
    @Resource
    private DepotItemService depotItemService;
    @Resource
    private MaterialCategoryService materialCategoryService;
    @Resource
    private UnitService unitService;
    @Resource
    private MaterialInitialStockMapper materialInitialStockMapper;
    @Resource
    private DepotService depotService;
    @Resource
    private MaterialExtendService materialExtendService;

    public Material getMaterial(long id) throws Exception {
        Material result = null;
        try {
            result = materialMapper.selectByPrimaryKey(id);
        } catch (Exception e) {
            JshException.readFail(logger, e);
        }
        return result;
    }

    public List<Material> getMaterialListByIds(String ids) throws Exception {
        List<Long> idList = StringUtil.strToLongList(ids);
        List<Material> list = new ArrayList<>();
        try {
            MaterialExample example = new MaterialExample();
            example.createCriteria().andIdIn(idList);
            list = materialMapper.selectByExample(example);
        } catch (Exception e) {
            JshException.readFail(logger, e);
        }
        return list;
    }

    public List<Material> getMaterial() throws Exception {
        MaterialExample example = new MaterialExample();
        example.createCriteria().andDeleteFlagNotEqualTo(BusinessConstants.DELETE_FLAG_DELETED);
        List<Material> list = null;
        try {
            list = materialMapper.selectByExample(example);
        } catch (Exception e) {
            JshException.readFail(logger, e);
        }
        return list;
    }

    public List<Material> select(String name, String companySku, String fnsku, String brand, String categoryId, int offset, int rows)
            throws Exception {
        List<Material> list = null;
        try {
            list = materialMapper.selectByConditionMaterial(name, companySku, fnsku, brand, categoryId, offset, rows);
            for (Material material : list) {
                List<MaterialCategory> mIds
                        = materialCategoryService.findById(Long.parseLong(material.getCategoryId()));
                material.setCategoryId(mIds.get(0).getName());
            }
        } catch (Exception e) {
            JshException.readFail(logger, e);
        }
        return list;
    }

    /**
     * 根據條件查詢總條數
     *
     * @param name
     * @return
     * @throws Exception
     */
    public Long countMaterial(String name, String companySku, String fnsku, String brand, String categoryId) throws Exception {
        Long result = null;
        try {
            result = materialMapper.countsByMaterial(name, companySku, fnsku, brand, categoryId);
        } catch (Exception e) {
            JshException.readFail(logger, e);
        }
        return result;
    }

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    public int insertMaterial(String beanJson,
                              HttpServletRequest request) throws Exception {
        Material m = JSONObject.parseObject(beanJson, Material.class);
        /*m.setEnabled(true);*/
        try {
            // Long mId = null;
            materialMapper.insertSelective(m);
          /*  List<Material> materials = getMaterialListByParam(m.getName(),m.getModel(),m.getColor(),
                    m.getStandard(), m.getMfrs(),m.getUnit(),m.getUnitId());
            if(materials!=null && materials.size()>0) {
                mId = materials.get(0).getId();
            }*/
           /* JSONObject mObj = JSON.parseObject(beanJson);
            materialExtendService.saveDetials(mObj.getString("inserted"), mObj.getString("deleted"), mObj.getString("updated"),mObj.getString("sortList"), mId);
            if(mObj.get("stock")!=null) {
                String stockStr = mObj.getString("stock");
                JSONArray stockArr = JSONArray.parseArray(stockStr);
                for(Object object: stockArr) {
                    JSONObject jsonObj = (JSONObject)object;
                    if(jsonObj.get("depotId")!=null && jsonObj.get("number")!=null) {
                        String number = jsonObj.getString("number");
                        Long depotId = jsonObj.getLong("depotId");
                        if(number!=null && Double.valueOf(number)>0) {
                            insertStockByMaterialAndDepot(depotId, mId, parseBigDecimalEx(number));
                        }
                    }
                }
            }*/
            logService.insertLog("商品",
                    new StringBuffer(BusinessConstants.LOG_OPERATION_TYPE_ADD).append(m.getName()).toString(), request);
            return 1;
        } catch (Exception e) {
            JshException.writeFail(logger, e);
            return 0;
        }
    }

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    public int updateMaterial(String beanJson, Long id, HttpServletRequest request) throws Exception {
        Material material = JSONObject.parseObject(beanJson, Material.class);
        material.setId(id);
        try {
            materialMapper.updateByPrimaryKeySelective(material);
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
            logService.insertLog("商品",
                    new StringBuffer(BusinessConstants.LOG_OPERATION_TYPE_EDIT).append(material.getName()).toString(), request);
            return 1;
        } catch (Exception e) {
            JshException.writeFail(logger, e);
            return 0;
        }
    }

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    public int deleteMaterial(Long id, HttpServletRequest request) throws Exception {
        int result = 0;
        try {
            result = materialMapper.deleteByPrimaryKey(id);
            logService.insertLog("商品",
                    new StringBuffer(BusinessConstants.LOG_OPERATION_TYPE_DELETE).append(id).toString(), request);
        } catch (Exception e) {
            JshException.writeFail(logger, e);
        }
        return result;
    }

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    public int batchDeleteMaterial(String ids, HttpServletRequest request) throws Exception {
        List<Long> idList = StringUtil.strToLongList(ids);
        MaterialExample example = new MaterialExample();
        example.createCriteria().andIdIn(idList);
        int result = 0;
        try {
            result = materialMapper.deleteByExample(example);
            logService.insertLog("商品", "批量删除,id集:" + ids, request);
        } catch (Exception e) {
            JshException.writeFail(logger, e);
        }
        return result;
    }

    public int checkIsNameExist(Long id, String name, String companySku, String fnSku) throws Exception {
        MaterialExample example = new MaterialExample();
        example.createCriteria().andIdNotEqualTo(id)
                .andNameEqualTo(name)
                .andCompanySkuEqualTo(companySku)
                .andFnskuEqualTo(fnSku)
                .andDeleteFlagNotEqualTo(BusinessConstants.DELETE_FLAG_DELETED);
        List<Material> list = null;
        try {
            list = materialMapper.selectByExample(example);
        } catch (Exception e) {
            JshException.readFail(logger, e);
        }
        return list == null ? 0 : list.size();
    }

    private List<Material> selectByExample(MaterialExample example) {
        return materialMapper.selectByExample(example);
    }

    public int checkIsExist(Long id, String name, String companySku, String fnsku) throws Exception {
        MaterialExample example = new MaterialExample();
        MaterialExample.Criteria criteria = example.createCriteria();
        criteria.andNameEqualTo(name)
                .andDeleteFlagNotEqualTo(BusinessConstants.DELETE_FLAG_DELETED);
        if (id > 0) {
            criteria.andIdNotEqualTo(id);
        }
        List<Material> list = null;
        try {
            list = selectByExample(example);
            if (list != null && list.size() > 0) {
                criteria.andCompanySkuEqualTo(companySku);
                list = selectByExample(example);
                if (list != null && list.size() > 0) {
                    criteria.andFnskuEqualTo(fnsku);
                    list = selectByExample(example);
                    return list.size();
                }
            }
        } catch (Exception e) {
            JshException.readFail(logger, e);
        }
        return 0;
    }

/*    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    public int batchSetEnable(Boolean enabled, String materialIDs)throws Exception {
        logService.insertLog("商品",
                new StringBuffer(BusinessConstants.LOG_OPERATION_TYPE_EDIT).append(materialIDs).toString(),
                ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest());
        List<Long> ids = StringUtil.strToLongList(materialIDs);
        Material material = new Material();
        material.setEnabled(enabled);
        MaterialExample example = new MaterialExample();
        example.createCriteria().andIdIn(ids);
        int result =0;
        try{
            result=  materialMapper.updateByExampleSelective(material, example);
        }catch(Exception e){
            JshException.readFail(logger, e);
        }
        return result;
    }*/

    public String findUnitName(Long mId) throws Exception {
        String result = null;
        try {
            result = materialMapperEx.findUnitName(mId);
        } catch (Exception e) {
            JshException.readFail(logger, e);
        }
        return result;
    }

    public List<MaterialVo4Unit> findById(Long id) throws Exception {
        List<MaterialVo4Unit> list = null;
        try {
            list = materialMapperEx.findById(id);
        } catch (Exception e) {
            JshException.readFail(logger, e);
        }
        return list;
    }

    public List<MaterialVo4Unit> findByIdWithBarCode(Long meId) throws Exception {
        List<MaterialVo4Unit> list = null;
        try {
            list = materialMapperEx.findByIdWithBarCode(meId);
        } catch (Exception e) {
            JshException.readFail(logger, e);
        }
        return list;
    }

    public List<MaterialVo4Unit> findBySelectWithBarCode(String q, Integer offset, Integer rows) throws Exception {
        List<MaterialVo4Unit> list = null;
        try {
            if (StringUtil.isNotEmpty(q)) {
                q = q.replace("'", "");
            }
            list = materialMapperEx.findBySelectWithBarCode(q, offset, rows);
        } catch (Exception e) {
            JshException.readFail(logger, e);
        }
        return list;
    }

    public int findBySelectWithBarCodeCount(String q) throws Exception {
        int result = 0;
        try {
            if (StringUtil.isNotEmpty(q)) {
                q = q.replace("'", "");
            }
            result = materialMapperEx.findBySelectWithBarCodeCount(q);
        } catch (Exception e) {
            logger.error("异常码[{}],异常提示[{}],异常[{}]",
                    ExceptionConstants.DATA_READ_FAIL_CODE, ExceptionConstants.DATA_READ_FAIL_MSG, e);
            throw new BusinessRunTimeException(ExceptionConstants.DATA_READ_FAIL_CODE,
                    ExceptionConstants.DATA_READ_FAIL_MSG);
        }
        return result;
    }

    public List<Material> findByAll(String name) throws Exception {
        List<Material> resList = new ArrayList<Material>();
        List<Material> list = null;
        try {
            list = materialMapper.findByAll(name);
        } catch (Exception e) {
            JshException.readFail(logger, e);
        }
        if (null != list) {
            for (Material m : list) {
                resList.add(m);
            }
        }
        return resList;
    }

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    public BaseResponseInfo importExcel(Sheet src) throws Exception {
       /* List<Depot> depotList= depotService.getDepot();
        int depotCount = depotList.size();*/
        List<String> list = new ArrayList();
        String columns = "";
        Cell[] row = src.getRow(0);
        for (int j = 0; j < row.length; j++) {
            columns = ExcelUtils.getContent(src, 0, j).replace("\n", "").replace(" ", "");//品名
            list.add(columns);
        }
        List<Material> mList = new ArrayList<>();
        String name = "";
        String brand = "";
        String image = "";
        String factnumer = "";
        String csku = "";
        String psku = "";
        String asin = "";
        String fnsku = "";
        String remark = "";
        String procust = "";
        int count = 0;
        for (int i = 1; i < src.getRows(); i++) {
            if (list.contains("品名")) {
                name = ExcelUtils.getContent(src, i, count); //品名
                count++;
            }
            if (list.contains("图片")) {
                image = ExcelUtils.getContent(src, i, count); //圖片鏈接
                count++;
            }
            if (list.contains("工厂号")) {
                factnumer = ExcelUtils.getContent(src, i, count); //工廠好
                count++;
            }
            if (list.contains("公司SKU")) {
                csku = ExcelUtils.getContent(src, i, count); //公司SKU
                count++;
            }
            if (list.contains("平台SKU")) {
                psku = ExcelUtils.getContent(src, i, count); //平台SKU
                count++;
            }
            if (list.contains("ASIN")) {
                asin = ExcelUtils.getContent(src, i, count); //ASIN
                count++;
            }
            if (list.contains("FNSKU")) {
                fnsku = ExcelUtils.getContent(src, i, count); //FNSKU
                count++;
            }
            if (list.contains("备注")) {
                remark = ExcelUtils.getContent(src, i, count); //產品描述
                count++;
            }
            if (list.contains("产品成本")) {
                procust = ExcelUtils.getContent(src, i, count); //產品成本
                count++;
            }
            if (list.contains("品牌")) {
                brand = ExcelUtils.getContent(src, i, count); //品牌
                count++;
            }

            //检验品名和公司SKU是否存在
            if (StringUtil.isNotEmpty(name) && StringUtil.isNotEmpty(csku)
                    && StringUtil.isNotEmpty(fnsku)) {
                Material m = new Material();
                m.setName(name);
                m.setBrand(brand);
                m.setImage(image);
                m.setFactoryNumber(factnumer);
                m.setCompanySku(csku);
                m.setPlatformSku(psku);
                m.setAsin(asin);
                m.setFnsku(fnsku);
                m.setRemark(remark);
                m.setProductCost(procust);
                String kg = "";
                String along = "";
                String width = "";
                String height = "";
                String nhq = "";
                String iba = "";
                String wxq = "";
                String boxl = "";
                String boxw = "";
                String boxh = "";
                String boxkg = "";
                String ccode= "";
                String ffgi = "";
                String categroyName = "";
                List<MaterialCategory> cateNameList = null;
                if (list.contains("包装盒重量/kg")) {
                    kg = ExcelUtils.getContent(src, i, count); //包裝盒重量
                    count++;
                }
                if (list.contains("包装盒长度/m")) {
                    along = ExcelUtils.getContent(src, i, count); //包裝盒長度
                    count++;
                }
                if (list.contains("包装盒宽度/m")) {
                    width = ExcelUtils.getContent(src, i, count); //包裝盒寬度
                    count++;
                }
                if (list.contains("包装盒高度/m")) {
                    height = ExcelUtils.getContent(src, i, count); //包裝盒高度
                    count++;
                }
                if (list.contains("内盒体积/㎡")) {
                    iba = ExcelUtils.getContent(src, i, count); //内盒体积
                    count++;
                }
                if (list.contains("内盒产品数量(pcs)")) {
                    nhq = ExcelUtils.getContent(src, i, count); // 内盒产品数量(pcs)
                    count++;
                }
                if (list.contains("箱容pcs/箱")) {
                    wxq = ExcelUtils.getContent(src, i, count); //箱容pcs/箱
                    count++;
                }
                if (list.contains("箱长/cm")) {
                    boxl = ExcelUtils.getContent(src, i, count); //箱长/m
                    count++;
                }
                if (list.contains("箱宽/cm")) {
                    boxw = ExcelUtils.getContent(src, i, count);//箱寬
                    count++;
                }
                if (list.contains("箱高/cm")) {
                    boxh = ExcelUtils.getContent(src, i, count);//箱高
                    count++;
                }
                if (list.contains("箱重/Kg箱")) {
                    boxkg = ExcelUtils.getContent(src, i, count);//箱重
                }

                if (list.contains("海关编码")) {
                    ccode = ExcelUtils.getContent(src, i, count); //海關編碼
                    count++;
                }

                if (list.contains("工厂成品库存")) {
                    ffgi = ExcelUtils.getContent(src, i, count); //工廠成品庫存
                    count++;
                }
                if (list.contains("类别")) {
                    categroyName = ExcelUtils.getContent(src, i, count); //类别
                    cateNameList  = materialCategoryService.getCategoryIdByName(categroyName);
                    count++;
                }
                count = 0;
/*JSONObject materialExObj = new JSONObject();
                JSONObject basicObj = new JSONObject();
                basicObj.put("barCode", barCode);
                basicObj.put("commodityUnit", unit);
                basicObj.put("purchaseDecimal", purchaseDecimal);
                basicObj.put("commodityDecimal", commodityDecimal);
                basicObj.put("wholesaleDecimal", wholesaleDecimal);
                basicObj.put("lowDecimal", lowDecimal);
                materialExObj.put("basic", basicObj);*/

                m.setKilogram(kg);
                m.setAlong(along);
                m.setWidth(width);
                m.setHeight(height);
                m.setInnerBoxArea(iba);
                m.setNhQuantity(nhq);
                m.setWxQuantity(wxq);
                m.setBoxLong(boxl);
                m.setBoxWidth(boxw);
                m.setBoxHeight(boxh);
                m.setBoxHeavy(boxkg);
                m.setCustomsCode(ccode);
                m.setFactoryFinishedGoodsInventory(ffgi);
                if (cateNameList != null && cateNameList.size() > 0){
                    Long id = cateNameList.get(0).getId();
                    m.setCategoryId(id.toString());
                }else {
                    MaterialCategory mc = new MaterialCategory();
                    if (categroyName !=null || categroyName !=""){
                       mc.setName(categroyName);
                        //没有给定父级目录的id，默认设置父级目录为根目录的父目录
                        mc.setParentId(BusinessConstants.MATERIAL_CATEGORY_ROOT_PARENT_ID);
                        mc.setStatus(BusinessConstants.MATERIAL_CATEGORY_STATUS_ENABLE);
                        Date date=new Date();
                        User userInfo=userService.getCurrentUser();
                        //创建时间
                        mc.setCreateTime(date);
                        //创建人
                        mc.setCreator(userInfo==null?null:userInfo.getId());
                        //更新时间
                        mc.setUpdateTime(date);
                        //更新人
                        mc.setUpdater(userInfo==null?null:userInfo.getId());
                    }
                    try{
                        categoryMapper.insertSelective(mc);
                    }catch(Exception e){
                        JshException.writeFail(logger, e);
                    }
                    List<MaterialCategory> categoryIdByName
                            = materialCategoryService.getCategoryIdByName(categroyName);
                    Long id = categoryIdByName.get(0).getId();
                    m.setCategoryId(id.toString());
                }
                /*if(StringUtil.isNotEmpty(manyUnit.trim())){ //多单位
                    String manyUnitAll = unit + "," + manyUnit + "(1:" + ratio + ")";
                    Long unitId = unitService.getUnitIdByName(manyUnitAll);
                    m.setUnitId(unitId);
                    JSONObject otherObj = new JSONObject();
                    otherObj.put("barCode", manyBarCode);
                    otherObj.put("commodityUnit", manyUnit);
                    otherObj.put("purchaseDecimal", parsePrice(purchaseDecimal,ratio));
                    otherObj.put("commodityDecimal", parsePrice(commodityDecimal,ratio));
                    otherObj.put("wholesaleDecimal", parsePrice(wholesaleDecimal,ratio));
                    otherObj.put("lowDecimal", parsePrice(lowDecimal,ratio));
                    materialExObj.put("other", otherObj);
                } else {
                    m.setUnit(unit);
                }*/
                /*m.setMaterialExObj(materialExObj);
                String enabled = ExcelUtils.getContent(src, i, 15); //状态
                m.setEnabled(enabled.equals("1")? true: false);*/
                //缓存各个仓库的库存信息
                /*Map<Long, BigDecimal> stockMap = new HashMap<Long, BigDecimal>();
                for(int j=1; j<=depotCount;j++) {
                    int col = 15+j;
                    if(col < src.getColumns()){
                        String depotName = ExcelUtils.getContent(src, 1, col); //获取仓库名称
                        Long depotId = depotService.getIdByName(depotName);
                        if(depotId!=0L){
                            String stockStr = ExcelUtils.getContent(src, i, col);
                            if(StringUtil.isNotEmpty(stockStr)) {
                                stockMap.put(depotId, parseBigDecimalEx(stockStr));
                            }
                        }
                    }
                }*/
                // m.setStockMap(stockMap);
                mList.add(m);
            }
        }

        logService.insertLog("商品",
                new StringBuffer(BusinessConstants.LOG_OPERATION_TYPE_IMPORT).append(mList.size()).append(BusinessConstants.LOG_DATA_UNIT).toString(),
                ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest());
        BaseResponseInfo info = new BaseResponseInfo();
        Map<String, Object> data = new HashMap<String, Object>();
        try {
            Long mId = 0L;
            for (Material m : mList) {
                //判断该商品是否存在，如果不存在就新增，如果存在就更新
                List<Material> materials = getMaterialListByParam(m.getName(), m.getCompanySku(), m.getFnsku());
                if (materials.size() == 0) {
                    materialMapper.insertSelective(m);
                } else {
                    mId = materials.get(0).getId();
                    String materialJson = JSON.toJSONString(m);
                    Material material = JSONObject.parseObject(materialJson, Material.class);
                    material.setId(mId);
                    materialMapper.updateByPrimaryKeySelective(material);
                }
                //给商品新增条码与价格相关信息
             /*   User user = userService.getCurrentUser();
                JSONObject materialExObj = m.getMaterialExObj();
                if(StringUtil.isExist(materialExObj.get("basic"))){
                    String basicStr = materialExObj.getString("basic");
                    MaterialExtend basicMaterialExtend = JSONObject.parseObject(basicStr, MaterialExtend.class);
                    basicMaterialExtend.setMaterialId(mId);
                    basicMaterialExtend.setDefaultFlag("1");
                    basicMaterialExtend.setCreateTime(new Date());
                    basicMaterialExtend.setUpdateTime(System.currentTimeMillis());
                    basicMaterialExtend.setCreateSerial(user.getLoginName());
                    basicMaterialExtend.setUpdateSerial(user.getLoginName());
                    Long meId = materialExtendService.selectIdByMaterialIdAndDefaultFlag(mId, "1");
                    if(meId==0L){
                        materialExtendMapper.insertSelective(basicMaterialExtend);
                    } else {
                        basicMaterialExtend.setId(meId);
                        materialExtendMapper.updateByPrimaryKeySelective(basicMaterialExtend);
                    }
                }
                if(StringUtil.isExist(materialExObj.get("other"))) {
                    String otherStr = materialExObj.getString("other");
                    MaterialExtend otherMaterialExtend = JSONObject.parseObject(otherStr, MaterialExtend.class);
                    otherMaterialExtend.setMaterialId(mId);
                    otherMaterialExtend.setDefaultFlag("0");
                    otherMaterialExtend.setCreateTime(new Date());
                    otherMaterialExtend.setUpdateTime(System.currentTimeMillis());
                    otherMaterialExtend.setCreateSerial(user.getLoginName());
                    otherMaterialExtend.setUpdateSerial(user.getLoginName());
                    Long meId = materialExtendService.selectIdByMaterialIdAndDefaultFlag(mId, "0");
                    if(meId==0L){
                        materialExtendMapper.insertSelective(otherMaterialExtend);
                    } else {
                        otherMaterialExtend.setId(meId);
                        materialExtendMapper.updateByPrimaryKeySelective(otherMaterialExtend);
                    }
                }*/
                //给商品初始化库存
              /*  Map<Long, BigDecimal> stockMap = m.getStockMap();
                Long depotId = null;
                for(Depot depot: depotList){
                    BigDecimal stock = stockMap.get(depot.getId());
                    //先清除再插入
                    MaterialInitialStockExample example = new MaterialInitialStockExample();
                    example.createCriteria().andMaterialIdEqualTo(mId).andDepotIdEqualTo(depot.getId());
                    materialInitialStockMapper.deleteByExample(example);
                    if(stock!=null && stock.compareTo(BigDecimal.ZERO)!=0) {
                        depotId = depot.getId();
                        insertStockByMaterialAndDepot(depotId, mId, stock);
                    }
                }*/
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
    private List<Material> getMaterialListByParam(String name, String csku, String fnsku) {
        MaterialExample example = new MaterialExample();
        MaterialExample.Criteria criteria = example.createCriteria();
        criteria.andNameEqualTo(name);
        if (StringUtil.isNotEmpty(csku)) {
            criteria.andCompanySkuEqualTo(csku);
        }
        if (StringUtil.isNotEmpty(fnsku)) {
            criteria.andFnskuEqualTo(fnsku);
        }
        criteria.andDeleteFlagNotEqualTo(BusinessConstants.DELETE_FLAG_DELETED);
        List<Material> list = materialMapper.selectByExample(example);
        return list;
    }

    /**
     * 写入初始库存
     *
     * @param depotId
     * @param mId
     * @param stock
     */
    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    public void insertStockByMaterialAndDepot(Long depotId, Long mId, BigDecimal stock) {
        MaterialInitialStock materialInitialStock = new MaterialInitialStock();
        materialInitialStock.setDepotId(depotId);
        materialInitialStock.setMaterialId(mId);
        materialInitialStock.setNumber(stock);
        materialInitialStockMapper.insertSelective(materialInitialStock); //存入初始库存
    }

    public List<Material> getMaterialEnableSerialNumberList(Map<String, Object> parameterMap) throws Exception {
        List<Material> list = null;
        try {
            list = materialMapperEx.getMaterialEnableSerialNumberList(parameterMap);
        } catch (Exception e) {
            JshException.readFail(logger, e);
        }
        return list;
    }

    public Long getMaterialEnableSerialNumberCount(Map<String, Object> parameterMap) throws Exception {
        Long count = null;
        try {
            count = materialMapperEx.getMaterialEnableSerialNumberCount(parameterMap);
        } catch (Exception e) {
            JshException.readFail(logger, e);
        }
        return count;
    }

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    public int batchDeleteMaterialByIds(String ids) throws Exception {
        StringBuffer sb = new StringBuffer();
        sb.append(BusinessConstants.LOG_OPERATION_TYPE_DELETE);
        List<Material> list = getMaterialListByIds(ids);
        for (Material material : list) {
            sb.append("[").append(material.getName()).append("]");
        }
        logService.insertLog("商品", sb.toString(),
                ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest());
        User userInfo = userService.getCurrentUser();
        String[] idArray = ids.split(",");
        try {
            //逻辑删除商品
            materialMapperEx.batchDeleteMaterialByIds(new Date(), userInfo == null ? null : userInfo.getId(), idArray);
          /*  //逻辑删除商品价格扩展
            materialExtendMapperEx.batchDeleteMaterialExtendByMIds(idArray);*/
            return 1;
        } catch (Exception e) {
            JshException.writeFail(logger, e);
            return 0;
        }
    }

    /**
     * create by: qiankunpingtai
     * website：https://qiankunpingtai.cn
     * description:
     * 正常删除，要考虑数据完整性，进行完整性校验
     * create time: 2019/4/10 18:00
     *
     * @return int
     * @Param: ids
     */
    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    public int batchDeleteMaterialByIdsNormal(String ids) throws Exception {
        /**
         * 校验
         * 1、单据子表	jsh_depot_item
         * 是否有相关数据
         * */
        int deleteTotal = 0;
        if (StringUtils.isEmpty(ids)) {
            return deleteTotal;
        }
        String[] idArray = ids.split(",");

        /**
         * 校验单据子表	jsh_depot_item
         * */
        List<DepotItem> depotItemList = null;
        try {
            depotItemList = depotItemMapperEx.getDepotItemListListByMaterialIds(idArray);
        } catch (Exception e) {
            JshException.readFail(logger, e);
        }
        if (depotItemList != null && depotItemList.size() > 0) {
            logger.error("异常码[{}],异常提示[{}],参数,MaterialIds[{}]",
                    ExceptionConstants.DELETE_FORCE_CONFIRM_CODE, ExceptionConstants.DELETE_FORCE_CONFIRM_MSG, ids);
            throw new BusinessRunTimeException(ExceptionConstants.DELETE_FORCE_CONFIRM_CODE,
                    ExceptionConstants.DELETE_FORCE_CONFIRM_MSG);
        }
        /**
         * 校验通过执行删除操作
         * */
        deleteTotal = batchDeleteMaterialByIds(ids);
        return deleteTotal;

    }

    public BigDecimal parseBigDecimalEx(String str) throws Exception {
        if (!StringUtil.isEmpty(str)) {
            return new BigDecimal(str);
        } else {
            return null;
        }
    }

    public BigDecimal parsePrice(String price, String ratio) throws Exception {
        if (StringUtil.isEmpty(price) || StringUtil.isEmpty(ratio)) {
            return BigDecimal.ZERO;
        } else {
            BigDecimal pr = new BigDecimal(price);
            BigDecimal r = new BigDecimal(ratio);
            return pr.multiply(r);
        }
    }

    /**
     * 根据产品和仓库获取初始库存
     *
     * @param materialId
     * @param depotId
     * @return
     */
    public BigDecimal getInitStock(Long materialId, Long depotId) {
        BigDecimal stock = BigDecimal.ZERO;
        MaterialInitialStockExample example = new MaterialInitialStockExample();
        example.createCriteria().andMaterialIdEqualTo(materialId).andDepotIdEqualTo(depotId)
                .andDeleteFlagNotEqualTo(BusinessConstants.DELETE_FLAG_DELETED);
        List<MaterialInitialStock> list = materialInitialStockMapper.selectByExample(example);
        if (list != null && list.size() > 0) {
            stock = list.get(0).getNumber();
        }
        return stock;
    }

    /**
     * 根据产品获取初始库存
     *
     * @param materialId
     * @return
     */
    public BigDecimal getInitStockByMid(Long depotId, Long materialId) {
        BigDecimal stock = BigDecimal.ZERO;
        MaterialInitialStockExample example = new MaterialInitialStockExample();
        if (depotId != null) {
            example.createCriteria().andMaterialIdEqualTo(materialId).andDepotIdEqualTo(depotId)
                    .andDeleteFlagNotEqualTo(BusinessConstants.DELETE_FLAG_DELETED);
        } else {
            example.createCriteria().andMaterialIdEqualTo(materialId)
                    .andDeleteFlagNotEqualTo(BusinessConstants.DELETE_FLAG_DELETED);
        }
        List<MaterialInitialStock> list = materialInitialStockMapper.selectByExample(example);
        if (list != null && list.size() > 0) {
            for (MaterialInitialStock ms : list) {
                if (ms != null) {
                    stock = stock.add(ms.getNumber());
                }
            }
        }
        return stock;
    }

    public List<MaterialVo4Unit> getMaterialByMeId(Long meId) {
        List<MaterialVo4Unit> result = new ArrayList<MaterialVo4Unit>();
        try {
            if (meId != null) {
                result = materialMapperEx.getMaterialByMeId(meId);
            }
        } catch (Exception e) {
            JshException.readFail(logger, e);
        }
        return result;
    }

    public String getMaxBarCode() {
        String maxBarCodeOld = materialMapperEx.getMaxBarCode();
        return Long.parseLong(maxBarCodeOld) + "";
    }

    public List<String> getMaterialNameList() {
        return materialMapperEx.getMaterialNameList();
    }


}
