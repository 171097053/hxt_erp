package com.jsh.erp.config;



import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @Description 映射路径配置
 * @Author DongPo
 */
@Configuration
public class FileConfig implements WebMvcConfigurer {
    /**
     * 图片保存路径，自动从properties文件中获取数据
     * 示例：D:/ref/pic/images/
     */
    @Value("${file-save-path}")
    private String fileSavePath;

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        /**
         * 配置资源映射
         * 意思是：如果访问的资源路径是以“/images/”开头的，
         * 就给我映射到本机的“D:/ref/pic/images/”这个文件夹内，去找你要的资源
         * 注意：D:/ref/pic/images/ 后面的 “/”一定要带上
         */
        registry.addResourceHandler("/images/**")
                .addResourceLocations("file:" + fileSavePath);
    }
}


