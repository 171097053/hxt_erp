package com.jsh.erp.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.jsh.erp.constants.BusinessConstants;
import com.jsh.erp.constants.ExceptionConstants;
import com.jsh.erp.datasource.entities.Material;
import com.jsh.erp.datasource.entities.MaterialCategory;
import com.jsh.erp.datasource.entities.MaterialVo4Unit;
import com.jsh.erp.exception.BusinessRunTimeException;
import com.jsh.erp.service.depotItem.DepotItemService;
import com.jsh.erp.service.material.MaterialService;
import com.jsh.erp.service.materialCategory.MaterialCategoryService;
import com.jsh.erp.utils.*;
import jxl.Sheet;
import jxl.Workbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.math.BigDecimal;
import java.util.*;

import static com.jsh.erp.utils.ResponseJsonUtil.returnJson;

/**
 * @author ji|sheng|hua jshERP
 */
@RestController
@RequestMapping(value = "/material")
public class MaterialController {
    private Logger logger = LoggerFactory.getLogger(MaterialController.class);

    @Resource
    private MaterialService materialService;
    @Resource
    private MaterialCategoryService materialCategoryService;
    @Resource
    private DepotItemService depotItemService;


    //检验添加的商品是否存在
    @GetMapping(value = "/checkIsExist")
    public String checkIsExist(@RequestParam Long id,
                               @RequestParam(value = "name", required = false) String name,
                               @RequestParam(value = "companySku", required = false) String companySku,
                               @RequestParam(value = "fnsku", required = false) String fnsku,
                               HttpServletRequest request) throws Exception {
        Map<String, Object> objectMap = new HashMap<String, Object>();
        int exist = materialService.checkIsExist(id, name, companySku, fnsku);
        if (exist > 0) {
            objectMap.put("status", true);
        } else {
            objectMap.put("status", false);
        }
        return returnJson(objectMap, ErpInfo.OK.name, ErpInfo.OK.code);
    }

    /**
     * 批量设置状态-启用或者禁用
     * @param enabled
     * @param materialIDs
     * @param request
     * @return
     */
/*    @PostMapping(value = "/batchSetEnable")
    public String batchSetEnable(@RequestParam("enabled") Boolean enabled,
                                 @RequestParam("materialIDs") String materialIDs,
                                 HttpServletRequest request)throws Exception {
        Map<String, Object> objectMap = new HashMap<String, Object>();
        int res = materialService.batchSetEnable(enabled, materialIDs);
        if(res > 0) {
            return returnJson(objectMap, ErpInfo.OK.name, ErpInfo.OK.code);
        } else {
            return returnJson(objectMap, ErpInfo.ERROR.name, ErpInfo.ERROR.code);
        }
    }*/

    /**
     * 根据id来查询商品名称
     *
     * @param id
     * @param request
     * @return
     */
    @GetMapping(value = "/findById")
    public BaseResponseInfo findById(@RequestParam("id") Long id, HttpServletRequest request) throws Exception {
        BaseResponseInfo res = new BaseResponseInfo();
        try {
            List<MaterialVo4Unit> list = materialService.findById(id);
            res.code = 200;
            res.data = list;
        } catch (Exception e) {
            e.printStackTrace();
            res.code = 500;
            res.data = "获取数据失败";
        }
        return res;
    }

    /**
     * 根据meId来查询商品名称
     *
     * @param meId
     * @param request
     * @return
     */
    @GetMapping(value = "/findByIdWithBarCode")
    public BaseResponseInfo findByIdWithBarCode(@RequestParam("meId") Long meId, HttpServletRequest request) throws Exception {
        BaseResponseInfo res = new BaseResponseInfo();
        try {
            MaterialVo4Unit mu = new MaterialVo4Unit();
            List<MaterialVo4Unit> list = materialService.findByIdWithBarCode(meId);
            if (list != null && list.size() > 0) {
                mu = list.get(0);
            }
            res.code = 200;
            res.data = mu;
        } catch (Exception e) {
            e.printStackTrace();
            res.code = 500;
            res.data = "获取数据失败";
        }
        return res;
    }

    /**
     * 查找商品信息-下拉框
     * @param mpList
     * @param request
     * @return
     */
 /*   @GetMapping(value = "/findBySelect")
    public JSONObject findBySelect(@RequestParam(value = "q", required = false) String q,
                                  @RequestParam("mpList") String mpList,
                                  @RequestParam(value = "depotId", required = false) Long depotId,
                                  @RequestParam("page") Integer currentPage,
                                  @RequestParam("rows") Integer pageSize,
                                  HttpServletRequest request) throws Exception{
        JSONObject object = new JSONObject();
        try {
            Long tenantId = Long.parseLong(request.getSession().getAttribute("tenantId").toString());
            List<MaterialVo4Unit> dataList = materialService.findBySelectWithBarCode(q, (currentPage-1)*pageSize, pageSize);
            String[] mpArr = mpList.split(",");
            int total = materialService.findBySelectWithBarCodeCount(q);
            object.put("total", total);
            JSONArray dataArray = new JSONArray();
            //存放数据json数组
            if (null != dataList) {
                for (MaterialVo4Unit material : dataList) {
                    JSONObject item = new JSONObject();
                    item.put("Id", material.getMeId()); //商品扩展表的id
                    String ratio; //比例
                    if (material.getUnitId() == null || material.getUnitId().equals("")) {
                        ratio = "";
                    } else {
                        ratio = material.getUnitName();
                        if(ratio!=null) {
                            ratio = ratio.substring(ratio.indexOf("("));
                        }
                    }
                    //名称/型号/扩展信息/包装
                    String MaterialName = "";
                    String mBarCode = "";
                    if(material.getmBarCode()!=null) {
                        mBarCode = material.getmBarCode();
                        MaterialName = MaterialName + mBarCode + "_";
                    }
                    item.put("mBarCode", mBarCode);
                    MaterialName = MaterialName + " " + material.getName()
                            + ((material.getStandard() == null || material.getStandard().equals("")) ? "" : "(" + material.getStandard() + ")")
                            + ((material.getModel() == null || material.getModel().equals("")) ? "" : "(" + material.getModel() + ")");
                    String expand = ""; //扩展信息
                    for (int i = 0; i < mpArr.length; i++) {
                        if (mpArr[i].equals("制造商")) {
                            expand = expand + ((material.getMfrs() == null || material.getMfrs().equals("")) ? "" : "(" + material.getMfrs() + ")");
                        }
                        if (mpArr[i].equals("自定义1")) {
                            expand = expand + ((material.getOtherField1() == null || material.getOtherField1().equals("")) ? "" : "(" + material.getOtherField1() + ")");
                        }
                        if (mpArr[i].equals("自定义2")) {
                            expand = expand + ((material.getOtherField2() == null || material.getOtherField2().equals("")) ? "" : "(" + material.getOtherField2() + ")");
                        }
                        if (mpArr[i].equals("自定义3")) {
                            expand = expand + ((material.getOtherField3() == null || material.getOtherField3().equals("")) ? "" : "(" + material.getOtherField3() + ")");
                        }
                    }
                    MaterialName = MaterialName + expand + ((material.getCommodityUnit() == null || material.getCommodityUnit().equals("")) ? "" : "(" + material.getCommodityUnit() + ")") + ratio;
                    item.put("MaterialName", MaterialName);
                    item.put("name", material.getName());
                    item.put("expand", expand);
                    item.put("model", material.getModel());
                    item.put("standard", material.getStandard());
                    item.put("unit", material.getCommodityUnit() + ratio);
                    if(depotId!=null&& StringUtil.isNotEmpty(q)) {
                        BigDecimal stock = depotItemService.getStockByParam(depotId,material.getId(),null,null,tenantId);
                        item.put("stock", stock);
                    }
                    dataArray.add(item);
                }
            }
            object.put("rows", dataArray);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return object;
    }*/

    /**
     * 根据商品id查找商品信息
     * @param meId
     * @param request
     * @return
     * @throws Exception
     */
/*    @GetMapping(value = "/getMaterialByMeId")
    public JSONObject getMaterialByMeId(@RequestParam(value = "meId", required = false) Long meId,
                                        @RequestParam("mpList") String mpList,
                                        HttpServletRequest request) throws Exception{
        JSONObject item = new JSONObject();
        try {
            String[] mpArr = mpList.split(",");
            List<MaterialVo4Unit> materialList = materialService.getMaterialByMeId(meId);
            if(materialList!=null && materialList.size()!=1) {
                return item;
            } else if(materialList.size() == 1) {
                MaterialVo4Unit material = materialList.get(0);
                item.put("Id", material.getMeId()); //商品扩展表的id
                String ratio; //比例
                if (material.getUnitId() == null || material.getUnitId().equals("")) {
                    ratio = "";
                } else {
                    ratio = material.getUnitName();
                    ratio = ratio.substring(ratio.indexOf("("));
                }
                //名称/型号/扩展信息/包装
                String MaterialName = "";
                MaterialName = MaterialName + material.getmBarCode() + "_" + material.getName()
                        + ((material.getStandard() == null || material.getStandard().equals("")) ? "" : "(" + material.getStandard() + ")");
                String expand = ""; //扩展信息
                for (int i = 0; i < mpArr.length; i++) {
                    if (mpArr[i].equals("颜色")) {
                        expand = expand + ((material.getColor() == null || material.getColor().equals("")) ? "" : "(" + material.getColor() + ")");
                    }
                    if (mpArr[i].equals("制造商")) {
                        expand = expand + ((material.getMfrs() == null || material.getMfrs().equals("")) ? "" : "(" + material.getMfrs() + ")");
                    }
                    if (mpArr[i].equals("自定义1")) {
                        expand = expand + ((material.getOtherField1() == null || material.getOtherField1().equals("")) ? "" : "(" + material.getOtherField1() + ")");
                    }
                    if (mpArr[i].equals("自定义2")) {
                        expand = expand + ((material.getOtherField2() == null || material.getOtherField2().equals("")) ? "" : "(" + material.getOtherField2() + ")");
                    }
                    if (mpArr[i].equals("自定义3")) {
                        expand = expand + ((material.getOtherField3() == null || material.getOtherField3().equals("")) ? "" : "(" + material.getOtherField3() + ")");
                    }
                }
                MaterialName = MaterialName + expand + ((material.getUnit() == null || material.getUnit().equals("")) ? "" : "(" + material.getUnit() + ")") + ratio;
                item.put("MaterialName", MaterialName);
                item.put("name", material.getName());
                item.put("expand", expand);
                item.put("model", material.getModel());
                item.put("standard", material.getStandard());
                item.put("unit", material.getUnit() + ratio);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return item;
    }*/

    /**
     * 生成Excel模板
     */
    @GetMapping(value = "/excelTemplate")
    public void excelTemplate(@RequestParam("excelTitle") String excelTitle,
                              HttpServletRequest request,
                              HttpServletResponse response) {
        try {
            String[] names = excelTitle.split(",");
            String title = "Excel模板";
            List<String[]> objects = new ArrayList<String[]>();
            File file = ExcelUtils.exportObjectsWithoutTitle(title, names, title, objects);
            ExportExecUtil.showExec(file, file.getName(), response);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     * 生成excel表格
     *
     * @param name
     * @param request
     * @param response
     * @return
     */
    @GetMapping(value = "/exportExcel")
    public void exportExcel(@RequestParam("name") String name,
                            @RequestParam("requesTitle") String requesTitle,
                            @RequestParam("ids") String ids,
                            HttpServletRequest request,
                            HttpServletResponse response) {
        try {

          /*  String[] names = {"品名", "图片", "工厂号", "公司SKU", "平台SKU", "ASIN", "FNSKU",
                    "产品描述", "产品成本", "海关编码", "工厂成品库存", "包裝盒重量/kg", "包裝盒長度/m", "包裝盒寬度/m",
                    "包裝盒高度/m", "内盒产品数量(pcs)", "内盒体积/㎡", "箱容pcs/箱",
                    "箱长/m", "箱寬/m", "箱高/m", "箱重/kg箱"};*/
            List<Material> dataList = null;
            if (ids != null && ids.length() > 0) {
                dataList = materialService.getMaterialListByIds(ids);
            } else {
                dataList = materialService.findByAll(StringUtil.toNull(name));
            }
            String[] names = requesTitle.split(",");
            String title = "产品信息";
            List<String[]> objects = new ArrayList<String[]>();
            if (null != dataList) {
                for (Material m : dataList) {
                    String[] objs = new String[23];
                    int count = 0;

                    for (String s : names) {
                        if ("品名".equals(s)) {
                            objs[count] = m.getName() == null ? "" : m.getName();
                            count++;
                            continue;
                        }

                        if ("图片".equals(s)) {
                            objs[count] = m.getImage() == null ? "" : m.getImage();
                            count++;
                            continue;
                        }
                        if ("工厂号".equals(s)) {
                            objs[count] = m.getFactoryNumber() == null ? "" : m.getFactoryNumber();
                            count++;
                            continue;
                        }
                        if ("公司SKU".equals(s)) {
                            objs[count] = m.getCompanySku() == null ? "" : m.getCompanySku();
                            count++;
                            continue;
                        }
                        if ("平台SKU".equals(s)) {
                            objs[count] = m.getPlatformSku() == null ? "" : m.getPlatformSku();
                            count++;
                            continue;
                        }
                        if ("ASIN".equals(s)) {
                            objs[count] = m.getAsin() == null ? "" : m.getAsin();
                            count++;
                            continue;
                        }
                        if ("FNSKU".equals(s)) {
                            objs[count] = m.getFnsku() == null ? "" : m.getFnsku();
                            count++;
                            continue;
                        }
                        if ("备注".equals(s)) {
                            objs[count] = m.getRemark() == null ? "" : m.getRemark();
                            count++;
                            continue;
                        }
                        if ("产品成本".equals(s)) {
                            objs[count] = m.getProductCost() == null ? "" : m.getProductCost();
                            count++;
                            continue;
                        }
                        if ("品牌".equals(s)) {
                            objs[count] = m.getBrand() == null ? "" : m.getBrand();
                            count++;
                            continue;
                        }
                        if ("内盒重量/Kg".equals(s)) {
                            objs[count] = m.getKilogram() == null ?"" : m.getKilogram();
                            count++;
                            continue;
                        }
                        if ("最长边/cm".equals(s)) {
                            objs[count] = m.getAlong() == null ? "" : m.getAlong();
                            count++;
                            continue;
                        }
                        if ("次长边/cm".equals(s)) {
                            objs[count] = m.getWidth() == null ? "" : m.getWidth();
                            count++;
                            continue;
                        }
                        if ("最短边/cm".equals(s)) {
                            objs[count] = m.getHeight() == null ? "" :m.getHeight();
                            count++;
                            continue;
                        }
                        if ("内盒体积/c㎡".equals(s)) {
                            objs[count] = m.getNhQuantity() == null ? "" : m.getNhQuantity();
                            count++;
                            continue;
                        }
                        if ("内盒产品数量(pcs)".equals(s)) {
                            objs[count] = m.getInnerBoxArea() == null ? "" : m.getInnerBoxArea();
                            count++;
                            continue;
                        }
                        if ("箱容pcs/箱".equals(s)) {
                            objs[count] = m.getWxQuantity() == null ? "" : m.getWxQuantity();
                            count++;
                            continue;
                        }
                        if ("箱长/cm".equals(s)) {
                            objs[count] = m.getBoxLong() == null ? "" : m.getBoxLong();
                            count++;
                            continue;

                        }
                        if ("箱宽/cm".equals(s)) {
                            objs[count] = m.getBoxWidth() == null ? "" : m.getBoxWidth();
                            count++;
                            continue;

                        }
                        if ("箱高/cm".equals(s)) {
                            objs[count] = m.getBoxHeight() == null ? "" : m.getBoxHeight();
                            count++;
                            continue;

                        }
                        if ("箱重Kg/箱".equals(s)) {
                            objs[count] = m.getBoxHeavy() == null ? "" : m.getBoxHeavy();
                            count++;
                            continue;
                        }
                        if ("海关编码".equals(s)) {
                            objs[count] = m.getCustomsCode() == null ? "" : m.getCustomsCode();
                            count++;
                            continue;
                        }
                        if ("工厂成品库存".equals(s)) {
                            objs[count] = m.getFactoryFinishedGoodsInventory() == null ? "" : m.getFactoryFinishedGoodsInventory();
                            count++;
                            continue;
                        }
                        if ("类别".equals(s)) {
                            Long cid = Long.parseLong(m.getCategoryId());
                            List<MaterialCategory> categoryList = materialCategoryService.findById(cid);
                            objs[count] = categoryList.get(0).getName() == null ? "" : categoryList.get(0).getName() ;
                            count++;
                            continue;
                        }

                    }
                    objects.add(objs);
                }
            }
            File file = ExcelUtils.exportObjectsWithoutTitle(title, names, title, objects);
            ExportExecUtil.showExec(file, file.getName(), response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * excel表格导入产品（含初始库存）
     *
     * @param
     * @param
     * @param
     * @return
     */
    @PostMapping(value = "/importExcel")
    public void importExcel(@RequestParam("materialFile") MultipartFile materialFile,
                            HttpServletRequest request,
                            HttpServletResponse response) throws Exception {
        BaseResponseInfo info = new BaseResponseInfo();
        Map<String, Object> data = new HashMap<String, Object>();
        String message = "成功";
        try {
            Sheet src = null;
            //文件合法性校验
            try {
                Workbook workbook = Workbook.getWorkbook(materialFile.getInputStream());
                src = workbook.getSheet(0);
            } catch (Exception e) {
                message = "导入文件不合法，请检查";
                data.put("message", message);
                info.code = 400;
                info.data = data;
            }
            info = materialService.importExcel(src);
        } catch (Exception e) {
            e.printStackTrace();
            message = "导入失败";
            info.code = 500;
            data.put("message", message);
            info.data = data;
        }
        response.sendRedirect("../pages/materials/material.html");
    }

    public BigDecimal parseBigDecimalEx(String str) throws Exception {
        if (!StringUtil.isEmpty(str)) {
            return new BigDecimal(str);
        } else {
            return null;
        }
    }

    @GetMapping(value = "/getMaterialEnableSerialNumberList")
    public String getMaterialEnableSerialNumberList(@RequestParam(value = Constants.PAGE_SIZE, required = false) Integer pageSize,
                                                    @RequestParam(value = Constants.CURRENT_PAGE, required = false) Integer currentPage,
                                                    @RequestParam(value = Constants.SEARCH, required = false) String search) throws Exception {
        Map<String, Object> parameterMap = new HashMap<String, Object>();
        //查询参数
        JSONObject obj = JSON.parseObject(search);
        Set<String> key = obj.keySet();
        for (String keyEach : key) {
            parameterMap.put(keyEach, obj.getString(keyEach));
        }
        PageQueryInfo queryInfo = new PageQueryInfo();
        Map<String, Object> objectMap = new HashMap<String, Object>();
        List<Material> list = materialService.getMaterialEnableSerialNumberList(parameterMap);
        Long count = materialService.getMaterialEnableSerialNumberCount(parameterMap);
        objectMap.put("page", queryInfo);
        if (list == null) {
            queryInfo.setRows(new ArrayList<Object>());
            queryInfo.setTotal(BusinessConstants.DEFAULT_LIST_NULL_NUMBER);
            return returnJson(objectMap, "查找不到数据", ErpInfo.OK.code);
        }
        queryInfo.setRows(list);
        queryInfo.setTotal(count);
        return returnJson(objectMap, ErpInfo.OK.name, ErpInfo.OK.code);
    }

    /**
     * create by: qiankunpingtai
     * description:
     * 批量删除商品信息
     * create time: 2019/3/29 11:15
     *
     * @return java.lang.Object
     * @Param: ids
     */
    @PostMapping(value = "/batchDeleteMaterialByIds")
    public Object batchDeleteMaterialByIds(@RequestParam("ids") String ids, @RequestParam(value = "deleteType",
            required = false, defaultValue = BusinessConstants.DELETE_TYPE_NORMAL) String deleteType) throws Exception {
        JSONObject result = ExceptionConstants.standardSuccess();
        int i = 0;
        if (BusinessConstants.DELETE_TYPE_NORMAL.equals(deleteType)) {
            i = materialService.batchDeleteMaterialByIdsNormal(ids);
        } else if (BusinessConstants.DELETE_TYPE_FORCE.equals(deleteType)) {
            i = materialService.batchDeleteMaterialByIds(ids);
        } else {
            logger.error("异常码[{}],异常提示[{}],参数,ids[{}],deleteType[{}]",
                    ExceptionConstants.DELETE_REFUSED_CODE, ExceptionConstants.DELETE_REFUSED_MSG, ids, deleteType);
            throw new BusinessRunTimeException(ExceptionConstants.DELETE_REFUSED_CODE,
                    ExceptionConstants.DELETE_REFUSED_MSG);
        }
        if (i < 1) {
            logger.error("异常码[{}],异常提示[{}],参数,ids[{}]",
                    ExceptionConstants.MATERIAL_DELETE_FAILED_CODE, ExceptionConstants.MATERIAL_DELETE_FAILED_MSG, ids);
            throw new BusinessRunTimeException(ExceptionConstants.MATERIAL_DELETE_FAILED_CODE,
                    ExceptionConstants.MATERIAL_DELETE_FAILED_MSG);
        }
        return result;
    }

    @GetMapping(value = "/getMaxBarCode")
    public BaseResponseInfo getMaxBarCode() throws Exception {
        BaseResponseInfo res = new BaseResponseInfo();
        Map<String, Object> map = new HashMap<String, Object>();
        String barCode = materialService.getMaxBarCode();
        map.put("barCode", barCode);
        res.code = 200;
        res.data = map;
        return res;
    }

    /**
     * 商品名称模糊匹配
     *
     * @return
     * @throws Exception
     */
    @GetMapping(value = "/getMaterialNameList")
    public JSONArray getMaterialNameList() throws Exception {
        JSONArray arr = new JSONArray();
        try {
            List<String> list = materialService.getMaterialNameList();
            for (String s : list) {
                JSONObject item = new JSONObject();
                item.put("value", s);
                item.put("text", s);
                arr.add(item);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return arr;
    }

}