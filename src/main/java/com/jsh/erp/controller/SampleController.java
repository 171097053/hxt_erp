package com.jsh.erp.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.jsh.erp.constants.BusinessConstants;
import com.jsh.erp.constants.ExceptionConstants;
import com.jsh.erp.datasource.entities.Material;
import com.jsh.erp.datasource.entities.Sample;
import com.jsh.erp.exception.BusinessRunTimeException;
import com.jsh.erp.service.material.MaterialService;
import com.jsh.erp.service.sample.SampleService;
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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.jsh.erp.utils.ResponseJsonUtil.returnJson;

@RestController
@RequestMapping(value = "/sample")
public class SampleController {
    private Logger logger = LoggerFactory.getLogger(SampleController.class);
    @Resource
    private SampleService sampleService;

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
            i = sampleService.batchDeleteSampleByIdsNormal(ids);
        } else if (BusinessConstants.DELETE_TYPE_FORCE.equals(deleteType)) {
            i = sampleService.batchDeleteSampleByIds(ids);
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

    @PostMapping(value = "follYes")
    public Object follYes(@RequestParam("id") String id) throws Exception {
        JSONObject result = ExceptionConstants.standardSuccess();
        sampleService.follYes(id);
        return  result;
    }

    /**
     * 商品名称模糊匹配
     *
     * @return
     * @throws Exception
     */
    @GetMapping(value = "/getSampleNameList")
    public JSONArray getSampleNameList() throws Exception {
        JSONArray arr = new JSONArray();
        try {
            List<String> list = sampleService.getSampleNameList();
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
    /**
     * 品牌模糊匹配
     *
     * @return
     * @throws Exception
     */
    @GetMapping(value = "/getSampleBrandList")
    public JSONArray getSampleBrandList() throws Exception {
        JSONArray arr = new JSONArray();
        try {
            List<String> list = sampleService.getSampleBrandList();
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
            List<Sample> dataList = null;
            if (ids != null && ids.length() > 0) {
                dataList = sampleService.getMaterialListByIds(ids);
            } else {
                dataList = sampleService.findByAll(StringUtil.toNull(name));
            }
            String[] names = requesTitle.split(",");
            String title = "样品信息";
            List<String[]> objects = new ArrayList<String[]>();
            if (null != dataList) {
                for (Sample m : dataList) {
                    String[] objs = new String[11];
                    objs[0] = m.getBrand() == null ? "" : m.getBrand();
                    objs[1] = m.getFactoryNumber() == null ? "" : m.getFactoryNumber();
                    objs[2] = m.getGoodsName() == null ? "" : m.getGoodsName();
                    objs[3] = m.getImges() == null ? "" : m.getImges();
                    objs[4] = m.getSpecDesc() == null ? "" : m.getSpecDesc();
                    objs[5] = m.getDemaQuan() == null ? "" : m.getDemaQuan();
                    objs[6] = m.getStatrData() == null ? "" : m.getStatrData();
                    objs[7] = m.getEndData() == null ? "" : m.getEndData();
                    objs[8] = m.getSjendData() == null ? "" : m.getSjendData();
                    objs[9] = m.getRemarks() == null ? "" : m.getRemarks();
                    objs[10] = m.getState().equals("0") ? "未完成" : "已完成";
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
    public void importExcel(@RequestParam("sampleFile") MultipartFile sampleFile,
                            HttpServletRequest request,
                            HttpServletResponse response) throws Exception {
        BaseResponseInfo info = new BaseResponseInfo();
        Map<String, Object> data = new HashMap<String, Object>();
        String message = "成功";
        try {
            Sheet src = null;
            //文件合法性校验
            try {
                Workbook workbook = Workbook.getWorkbook(sampleFile.getInputStream());
                src = workbook.getSheet(0);
            } catch (Exception e) {
                message = "导入文件不合法，请检查";
                data.put("message", message);
                info.code = 400;
                info.data = data;
            }
            info = sampleService.importExcel(src);
        } catch (Exception e) {
            e.printStackTrace();
            message = "导入失败";
            info.code = 500;
            data.put("message", message);
            info.data = data;
        }
        response.sendRedirect("../pages/materials/sample.html");
    }
}
