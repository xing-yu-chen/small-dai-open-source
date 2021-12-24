package top.smalldai.opensource.util.generator.constant;

/**
 * @Author: xing-yu-chen
 * @Project: open-source
 * @Description: 常量设置
 * @Data:Created in 2021/12/19 11:48 下午
 */
public class Constant {

    /**
     * @Author: xingyuchen
     * @Discription: API版本号
     * @Date: 2021/12/22 4:47 下午
    */
    public static final String pathVersion = "v1";

    /**
     * @Author: xingyuchen
     * @Discription: 模版根路径
     * @Date: 2021/12/19 11:49 下午
    */
    public static final String BASE_TEMPLATE_PATH = "src/main/resources/templates/";
    public static final String BASE_JAVA_PATH="src/main/java/top/smalldai/opensource/";
    public static final String BASE_RESOURCE_PATH = "src/main/resources/";

    /**
     * @Author: xingyuchen
     * @Discription: yml文件路径
     * @Date: 2021/12/19 11:56 下午
    */
    public static final String YML_FILE_PATH = "src/main/resources/application.yml";

    /**
     * @Author: xingyuchen
     * @Discription: Result文件路径
     * @Date: 2021/12/22 4:24 下午
    */
    public static final String RESULT_FILE_PATH = "src/main/java/top/smalldai/opensource/common/lang/Result.java";

    public static final String LOGIN_DTO_FILE_PATH = "src/main/java/top/smalldai/opensource/common/dto/LoginDto.java";

    /**
     * @Author: xingyuchen
     * @Discription: Mybatis-Plus配置文件路径
     * @Date: 2021/12/21 4:25 下午
    */
    public static final String MYBATIS_PLUS_CONFIG_PATH = "src/main/java/top/smalldai/opensource/config/MybatisPlusConfig.java";

    /**
     * @Author: xingyuchen
     * @Discription: Druid配置文件路径
     * @Date: 2021/12/21 4:38 下午
    */
    public static final String DRUID_CONFIG_PATH = "src/main/java/top/smalldai/opensource/config/DruidConfig.java";

    /**
     * @Author: xingyuchen
     * @Discription: Swagger配置文件路径
     * @Date: 2021/12/21 5:29 下午
    */
    public static final String SWAGGER_CONFIG_PATH = "src/main/java/top/smalldai/opensource/config/SwaggerConfig.java";

    /**
     * @Author: xingyuchen
     * @Discription: 跨域配置文件
     * @Date: 2021/12/21 5:31 下午
    */
    public static final String CORS_CONFIG_PATH = "src/main/java/top/smalldai/opensource/config/CorsConfig.java";
    /**
     * @Author: xingyuchen
     * @Discription: entity文件生成路径
     * @Date: 2021/12/21 7:22 下午
    */
    public static final String ENTITY_BASE_PATH = Constant.BASE_JAVA_PATH + Constant.FOLDER_ENTITY_NAME + "/";

    /**
     * @Author: xingyuchen
     * @Discription: mapper文件生成路径
     * @Date: 2021/12/21 9:05 下午
    */
    public static final String MAPPER_BASE_PATH = Constant.BASE_JAVA_PATH + Constant.FOLDER_MAPPER_NAME + "/";

    /**
     * @Author: xingyuchen
     * @Discription: mapper XML文件生成路径
     * @Date: 2021/12/21 9:05 下午
    */
    public static final String MAPPER_XML_BASE_PATH = Constant.BASE_RESOURCE_PATH + Constant.FOLDER_MAPPER_XML_NAME +"/";

    /**
     * @Author: xingyuchen
     * @Discription: service文件生成路径
     * @Date: 2021/12/21 9:06 下午
    */
    public static final String SERVICE_BASE_PATH = Constant.BASE_JAVA_PATH + Constant.FOLDER_SERVICE_NAME + "/";

    /**
     * @Author: xingyuchen
     * @Discription: serviceImpl文件生成路径
     * @Date: 2021/12/21 9:08 下午
    */
    public static final String SERVICE_IMPL_BASE_PATH = Constant.BASE_JAVA_PATH + Constant.FOLDER_SERVICE_NAME + "/" + Constant.FOLDER_SERVICE_IMPL_NAME + "/";

    /**
     * @Author: xingyuchen
     * @Discription: controller文件生成路径
     * @Date: 2021/12/21 9:10 下午
    */
    public static final String CONTROLLER_BASE_PATH = Constant.BASE_JAVA_PATH + Constant.FOLDER_CONTROLLER_NAME + "/";

    /**
     * @Author: xingyuchen
     * @Discription: 创建文件夹名称
     * @Date: 2021/12/21 3:31 下午
    */
    public static final String FOLDER_COMMON_NAME = "common";

    public static final String FOLDER_COMMON_LANG_NAME = Constant.FOLDER_COMMON_NAME + "/lang";

    public static final String FOLDER_COMMON_DTO_NAME = Constant.FOLDER_COMMON_NAME + "/dto";

    public static final String FOLDER_CONFIG_NAME = "config";

    public static final String FOLDER_ENTITY_NAME = "entity";

    public static final String FOLDER_MAPPER_NAME = "mapper";

    //创建在resource中
    public static final String FOLDER_MAPPER_XML_NAME = "mappers";

    public static final String FOLDER_SERVICE_NAME = "service";

    //创建在service包里
    public static final String FOLDER_SERVICE_IMPL_NAME = "impl";

    public static final String FOLDER_CONTROLLER_NAME = "controller";


    /**
     * @Author: xingyuchen
     * @Discription: 模版引用的包路径
     * @Date: 2021/12/21 3:52 下午
    */
    public static final String IMPORT_COMMON_PACKAGE_PATH = "top.smalldai.opensource.common";
    public static final String IMPORT_COMMON_LANG_PACKAGE_PATH = Constant.IMPORT_COMMON_PACKAGE_PATH + ".lang";
    public static final String IMPORT_COMMON_LANG_RESULT_PACKAGE_PATH = Constant.IMPORT_COMMON_LANG_PACKAGE_PATH + ".Result";
    public static final String IMPORT_COMMON_DTO_PACKAGE_PATH = Constant.IMPORT_COMMON_PACKAGE_PATH + ".dto";
    public static final String IMPORT_COMMON_LOGIN_DTO_PACKAGE_PATH = Constant.IMPORT_COMMON_DTO_PACKAGE_PATH + ".LoginDto";

    public static final String IMPORT_CONFIG_PACKAGE_PATH = "top.smalldai.opensource.config";

    public static final String IMPORT_ENTITY_PACKAGE_PATH = "top.smalldai.opensource.entity";

    public static final String IMPORT_MAPPER_PACKAGE_PATH = "top.smalldai.opensource.mapper";

    public static final String IMPORT_SERVICE_PACKAGE_PATH = "top.smalldai.opensource.service";

    public static final String IMPORT_SERVICE_IMPL_PACKAGE_PATH = "top.smalldai.opensource.service.impl";

    public static final String IMPORT_CONTROLLER_PACKAGE_PATH = "top.smalldai.opensource.controller";



}
