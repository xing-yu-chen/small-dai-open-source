package top.smalldai.opensource.util.generator.utils;

import top.smalldai.opensource.util.generator.constant.Constant;

import java.io.File;

/**
 * @Author: xing-yu-chen
 * @Project: open-source
 * @Description: 文件相关工具类
 * @Data:Created in 2021/12/21 3:27 下午
 */
public class FileUtil {
    /**
     * @Author: xingyuchen
     * @Discription: 创建src里的文件夹
     * @param folderName
     * @Date: 2021/12/21 3:28 下午
    */
    public static void mkdirFolder(String folderName){
       FileUtil.mkdirFolder(Constant.BASE_JAVA_PATH,folderName);
    }

    /**
     * @Author: xingyuchen
     * @Discription: 创建resource里的文件夹
     * @param folderName
     * @Date: 2021/12/21 8:58 下午
    */
    public static void mkdirResourceFolder(String folderName){
        FileUtil.mkdirFolder(Constant.BASE_RESOURCE_PATH,folderName);
    }

    /**
     * @Author: xingyuchen
     * @Discription: 创建文件夹
     * @param basePath
     * @param folderName
     * @Date: 2021/12/21 8:58 下午
    */
    public static void mkdirFolder(String basePath,String folderName){
        File file=new File(basePath +folderName);
        //如果文件夹不存在
        if(!file.exists()){
            //创建文件夹
            file.mkdir();
        }
    }
}
