package top.smalldai.opensource.util.generator.utils;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;

/**
 * @Author: xing-yu-chen
 * @Project: open-source
 * @Description: freemarker使用工具类
 * @Data:Created in 2021/12/19 11:29 下午
 */
public class FreemarkerUtil {
    /**
     * @Author: xingyuchen
     * @Discription:
     * @Date: 2021/12/19 11:31 下午
    */
    public static void fileFreemarker(HashMap<String, Object> map,String basePath,String inputPath,String outputPath){
        //创建FreeMarker配置类
        Configuration configuration = new Configuration();
        //初始化模版
        Template template =null;
        try {
            //指定模版加载器
            configuration.setDirectoryForTemplateLoading(new File(basePath));
            configuration.setDefaultEncoding("UTF-8");   //设置编码
            //获取模板文件
            template=configuration.getTemplate(inputPath);
            /*构造数据模型留给传入*/
            //模型处理，输出为文件
            template.process(map,new FileWriter(outputPath));
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("文件传输出错");
        } catch (TemplateException e) {
            e.printStackTrace();
            System.out.println("模版语法出错");
        }
    }
}
