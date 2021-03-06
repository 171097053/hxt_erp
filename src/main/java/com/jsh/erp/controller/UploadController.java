package com.jsh.erp.controller;




import com.jsh.erp.utils.Result;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * @Description 上传图片
 * @Author DongPo
 */
@Controller
@RequestMapping("upload")
public class UploadController {
    /**
     * 时间格式化，用来创建文件夹
     */
    private static final SimpleDateFormat SDF = new SimpleDateFormat("yyyy/MM/dd/");

    /**
     * 设置最大文件限制 单位bit
     */
    private static final int FILE_MAX_SIZE = 1 * 1024 * 1024;

    /**
     * 文件类型限制
     */
    private static final List<String> FILE_CONTENT_TYPES = new ArrayList<>();

    static {
        FILE_CONTENT_TYPES.add("image/jpeg");
        FILE_CONTENT_TYPES.add("image/jpg");
        FILE_CONTENT_TYPES.add("image/png");
    }

    /**
     * 图片保存路径，自动从properties文件中获取数据
     * 示例：D:/ref/pic/images/
     */
    @Value("${file-save-path}")
    private String fileSavePath;

    @PostMapping("uploadFile")
    @ResponseBody
    public Result uploadFile(@RequestParam(value = "file",required = false) MultipartFile file, HttpServletRequest request) {
        // 0.文件检查
        // 检查大小
        long size = file.getSize();
        if (size > FILE_MAX_SIZE) {
            return new Result(false, "文件大小不能超过" + (FILE_MAX_SIZE / 1024) + "KB");
        }
 /*       // 检查类型
        String contentType = file.getContentType();
        if (!FILE_CONTENT_TYPES.contains(contentType)) {
            return new Result(false, "只支持以下类型的文件格式：" + FILE_CONTENT_TYPES);
        }*/

        // 1.后半段目录：2020/06/07/
        String directory = SDF.format(new Date());

        /**
         *  2.文件保存目录  D:/ref/pic/images/2020/06/17/
         *  如果目录不存在，则创建
         */

        File dir = new File(fileSavePath + directory);
        if (!dir.exists()) {
            dir.mkdirs();
        }
        System.out.println("图片上传，保存位置：" + fileSavePath + directory);

        // 3.给文件重新设置一个名字
        // 截取后缀
       /* String suffix = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
        String newFileName = UUID.randomUUID().toString().replaceAll("-", "") + suffix;*/

        // 4.创建这个新文件
        File newFile = new File(fileSavePath + directory + file.getOriginalFilename());

        // 5.复制操作
        try {
            file.transferTo(newFile);
            //	协议 :// ip地址 ：端口号 / 文件目录(/images/2020/06/07/xxx.jpg)
            String url = request.getScheme() + "://" + request.getServerName()+":"+request.getServerPort() + "/images/" + directory + file.getOriginalFilename();
            System.out.println("图片上传，访问URL：" + url);

            return new Result(true, url);
        } catch (IOException e) {
            return new Result(false, "上传异常");
        }
    }
}

