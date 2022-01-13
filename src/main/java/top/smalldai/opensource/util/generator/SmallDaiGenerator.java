package top.smalldai.opensource.util.generator;

import lombok.extern.slf4j.Slf4j;
import top.smalldai.opensource.util.generator.constant.Constant;
import top.smalldai.opensource.util.generator.dao.*;
import top.smalldai.opensource.util.generator.utils.DbUtil;
import top.smalldai.opensource.util.generator.utils.FileUtil;
import top.smalldai.opensource.util.generator.utils.FreemarkerUtil;
import top.smalldai.opensource.util.generator.utils.NameStrUtil;

import java.util.*;

/**
 * @Author: xing-yu-chen
 * @Project: open-source
 * @Description: 小呆代码生成器
 * @Data:Created in 2021/12/20 12:15 上午
 */
@Slf4j
public class SmallDaiGenerator implements Runnable{

    //设置服务端口
    private static String serverPort = "80";
    //数据库相关配置,根据数据库修改配置
    //用户名
    private static String username = "root";
    //密码
    private static String password = "123456";
    //数据库名称
    private static String dbName = "small-dai-open-source";

    //数据库类型，此处为oracle准备,默认MySQL
    private static String dbType = "MYSQL";
    //服务器IP
    private static String ip = "";
    //数据库端口
    private static String port ="";

    //用于定义构造函数的参数数据库信息
    private DatabaseDao database;

    //用户定义构造函数的参数数据库名
    private String databaseName;

    public SmallDaiGenerator() {
    }

    public SmallDaiGenerator(DatabaseDao database) {
        this.database = database;
    }

    public SmallDaiGenerator(DatabaseDao database, String databaseName) {
        this.database = database;
        this.databaseName = databaseName;
    }

    public void generatorFile(DatabaseDao database){
        //1.生成yml配置文件
        this.generatorYmlFile(database);
    }
    public void generatorFile(){
        //2.生成common包
        this.generatorCommonFile();
        //3.生成config配置文件
        this.generatorConfigFile();
    }
    public void generatorFile(DatabaseDao database,String databaseName){
        //3.生成该库所有表相关配置文件
        this.generatorDbFile(database,databaseName);
    }

    public static void main(String[] args) {
        /* ---此处如果是本地3306端口的mysql就不需要更改,如果使用ip情况下注释第一行，释放第二行即可--- */
        DatabaseDao database = new DatabaseDao(dbName,username,password);
        //DatabaseDao databaseDao = new DatabaseDao(dbType, ip, port, dbName, username, password);
        /*-------------------------------------------*/

        SmallDaiGenerator commonAndConfigSmallDaiGenerator = new SmallDaiGenerator();
        SmallDaiGenerator ymlSmallDaiGenerator = new SmallDaiGenerator(database);
        SmallDaiGenerator dbSmallDaiGenerator = new SmallDaiGenerator(database, dbName);

        new Thread(commonAndConfigSmallDaiGenerator).start();
        new Thread(ymlSmallDaiGenerator).start();
        new Thread(dbSmallDaiGenerator).start();


    }

    /**
     * @Author: xingyuchen
     * @Discription: 生成yml配置文件
     * @param database
     * @Date: 2021/12/21 3:50 下午
     */
    public void generatorYmlFile(DatabaseDao database) {

        log.info("======================开始生成application.yml配置文件============================");
        //构造yml的数据模型
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("serverPort",serverPort);
        hashMap.put("pathVersion",Constant.pathVersion);
        hashMap.put("jdbcUrl",database.getUrl());
        hashMap.put("jdbcUsername",database.getUsername());
        hashMap.put("jdbcPassword",database.getPassword());
        FreemarkerUtil.fileFreemarker(hashMap,Constant.BASE_TEMPLATE_PATH,"application.ftl", Constant.YML_FILE_PATH);
        log.info("application.yml生成完毕,路径:"+Constant.YML_FILE_PATH);
    }
    /**
     * @Author: xingyuchen
     * @Discription: 生成与数据库相关文件
     * @param database
     * @param dbName
     * @Date: 2021/12/21 3:50 下午
    */
    public void generatorDbFile(DatabaseDao database,String dbName){
        log.info("================开始生成Entity、Mapper、XML、Service、ServiceImpl=============");
        //创建entity文件夹->判断是否存在
        FileUtil.mkdirFolder(Constant.FOLDER_ENTITY_NAME);
        log.info("entity文件夹更新完毕，路径:" + Constant.ENTITY_BASE_PATH);
        //创建mapper文件夹->判断是否存在
        FileUtil.mkdirFolder(Constant.FOLDER_MAPPER_NAME);
        log.info("mapper文件夹更新完毕，路径:"+ Constant.MAPPER_BASE_PATH);
        //创建存放mapper的xml文件夹->判断是否村子啊
        FileUtil.mkdirResourceFolder(Constant.FOLDER_MAPPER_XML_NAME);
        log.info("mappers文件夹更新完毕，存放XML文件，路径:"+ Constant.MAPPER_XML_BASE_PATH);
        //创建存放service文件夹->判断是否存在
        FileUtil.mkdirFolder(Constant.FOLDER_SERVICE_NAME);
        log.info("service文件夹更新完毕，路径:" + Constant.SERVICE_BASE_PATH);
        //创建存放serviceImpl文件夹->判断是否存在
        FileUtil.mkdirFolder(Constant.FOLDER_SERVICE_NAME+"/"+Constant.FOLDER_SERVICE_IMPL_NAME);
        log.info("serviceImpl文件夹更新完毕，路径:" + Constant.SERVICE_IMPL_BASE_PATH);
        //创建存放controller文件夹->判断是否存在
        FileUtil.mkdirFolder(Constant.FOLDER_CONTROLLER_NAME);
        log.info("controller文件夹更新完毕，路径:" + Constant.CONTROLLER_BASE_PATH);

        //遍历所有表和表中的字段
        List<TableDao> tableBaseMsg = DbUtil.getTableBaseMsg(database, dbName);
        HashMap<String, Object> html = new HashMap<>();
        HashMap<String, Object> controller = new HashMap<>();
        HashMap<String, Object> service = new HashMap<>();
        HashMap<String, Object> serviceImpl = new HashMap<>();
        HashMap<String, Object> mapper = new HashMap<>();
        HashMap<String, Object> mapperXml = new HashMap<>();
        HashMap<String, Object> entity = new HashMap<>();

        html.put("daoList",tableBaseMsg);
        List<PermissionDao> permissionDaos = new ArrayList<>();
        PermissionDao panel = new PermissionDao();
        panel.setPName("visitedPanel");
        panel.setPNameRemark("访问数据面板");
        panel.setPModule("Panel");
        panel.setGmtCreate(new Date());
        permissionDaos.add(panel);

        for (TableDao tableDao:tableBaseMsg) {
            log.info("======================开始往数据库中插入所有的权限信息============================");
            PermissionDao visited = new PermissionDao();
            visited.setPName("visited" + tableDao.getDealingTableName());
            visited.setPNameRemark("访问" + tableDao.getComment() + "管理");
            visited.setPModule(tableDao.getDealingTableName());
            visited.setGmtCreate(new Date());
            PermissionDao save = new PermissionDao();
            save.setPName("save" + tableDao.getDealingTableName());
            save.setPNameRemark("新增" + tableDao.getComment());
            save.setPModule(tableDao.getDealingTableName());
            save.setGmtCreate(new Date());
            PermissionDao delete = new PermissionDao();
            delete.setPName("delete" + tableDao.getDealingTableName());
            delete.setPNameRemark("删除" + tableDao.getComment());
            delete.setPModule(tableDao.getDealingTableName());
            delete.setGmtCreate(new Date());
            PermissionDao update = new PermissionDao();
            update.setPName("update" + tableDao.getDealingTableName());
            update.setPNameRemark("修改" + tableDao.getComment());
            update.setPModule(tableDao.getDealingTableName());
            update.setGmtCreate(new Date());
            PermissionDao deletedAll = new PermissionDao();
            deletedAll.setPName("clear" + tableDao.getDealingTableName());
            deletedAll.setPNameRemark("批量删除" + tableDao.getComment());
            deletedAll.setPModule(tableDao.getDealingTableName());
            deletedAll.setGmtCreate(new Date());
            permissionDaos.add(visited);
            permissionDaos.add(save);
            permissionDaos.add(delete);
            permissionDaos.add(update);
            permissionDaos.add(deletedAll);
            DbUtil.insertMsg(database, permissionDaos);

            log.info("======================开始生成"+ tableDao.getDealingTableName() +"Entity============================");

            entity.put("basePackage",Constant.IMPORT_ENTITY_PACKAGE_PATH);
            entity.put("tableObj",tableDao);
            FreemarkerUtil.fileFreemarker(entity,Constant.BASE_TEMPLATE_PATH,"entity/Entity.ftl",Constant.ENTITY_BASE_PATH + tableDao.getDealingTableName() + ".java");
            log.info(tableDao.getDealingTableName()+"实体类生成完毕");

            log.info("======================开始生成"+ tableDao.getDealingTableName() +"Mapper============================");

            mapper.put("basePackage",Constant.IMPORT_MAPPER_PACKAGE_PATH);
            mapper.put("entityPackage",Constant.IMPORT_ENTITY_PACKAGE_PATH);
            mapper.put("tableObj",tableDao);
            FreemarkerUtil.fileFreemarker(mapper,Constant.BASE_TEMPLATE_PATH,"mapper/Mapper.ftl",Constant.MAPPER_BASE_PATH + tableDao.getDealingTableName() + "Mapper.java");
            log.info(tableDao.getDealingTableName()+"Mapper生成完毕");

            log.info("====================开始生成"+ tableDao.getDealingTableName() +"Mapper XML==========================");

            mapperXml.put("mapperPackage",Constant.IMPORT_MAPPER_PACKAGE_PATH);
            mapperXml.put("entityName",tableDao.getDealingTableName());
            FreemarkerUtil.fileFreemarker(mapperXml,Constant.BASE_TEMPLATE_PATH,"mappers_xml/MapperXml.ftl",Constant.MAPPER_XML_BASE_PATH + tableDao.getDealingTableName() + "Mapper.xml");
            log.info(tableDao.getDealingTableName()+"MapperXML生成完毕");

            log.info("======================开始生成"+ tableDao.getDealingTableName() +"Service============================");

            service.put("basePackage",Constant.IMPORT_SERVICE_PACKAGE_PATH);
            service.put("entityPackage",Constant.IMPORT_ENTITY_PACKAGE_PATH);
            service.put("tableObj",tableDao);
            FreemarkerUtil.fileFreemarker(service,Constant.BASE_TEMPLATE_PATH,"service/Service.ftl",Constant.SERVICE_BASE_PATH + tableDao.getDealingTableName() + "Service.java");
            log.info(tableDao.getDealingTableName()+"Service生成完毕");

            log.info("======================开始生成" + tableDao.getDealingTableName() + "ServiceImpl============================");

            serviceImpl.put("basePackage",Constant.IMPORT_SERVICE_IMPL_PACKAGE_PATH);
            serviceImpl.put("entityPackage",Constant.IMPORT_ENTITY_PACKAGE_PATH);
            serviceImpl.put("mapperPackage",Constant.IMPORT_MAPPER_PACKAGE_PATH);
            serviceImpl.put("servicePackage",Constant.IMPORT_SERVICE_PACKAGE_PATH);
            serviceImpl.put("tableObj",tableDao);
            FreemarkerUtil.fileFreemarker(serviceImpl,Constant.BASE_TEMPLATE_PATH,"service/impl/ServiceImpl.ftl",Constant.SERVICE_IMPL_BASE_PATH + tableDao.getDealingTableName() + "ServiceImpl.java");
            log.info(tableDao.getDealingTableName()+"ServiceImpl生成完毕");

            log.info("======================开始生成" + tableDao.getDealingTableName() + "Controller============================");

            controller.put("basePackage",Constant.IMPORT_CONTROLLER_PACKAGE_PATH);
            controller.put("servicePackage",Constant.IMPORT_SERVICE_PACKAGE_PATH);
            controller.put("entityPackage",Constant.IMPORT_ENTITY_PACKAGE_PATH);
            controller.put("resultPackage",Constant.IMPORT_COMMON_LANG_RESULT_PACKAGE_PATH);
            controller.put("tableObj",tableDao);

            for (ColumnDao columnDao : tableDao.getColumns()) {
                //判断备注是否是ID
                if(columnDao.getColumnComment().equals("ID")) {
                    controller.put("IDComment", columnDao.getDealingColumnName());
                }
            }
            FreemarkerUtil.fileFreemarker(controller,Constant.BASE_TEMPLATE_PATH,"controller/Controller.ftl",Constant.CONTROLLER_BASE_PATH + tableDao.getDealingTableName() + "Controller.java");
            log.info(tableDao.getDealingTableName()+"Controller生成完毕");

            //判断是不是用户表(User)，如果是用户表的话，就生成Account
            if(tableDao.getDealingTableName().equals("User")){
                log.info("======================开始生成AccountController============================");
                String uid = "id";
                String uname = "username";
                String upassword = "password";
                String unamecolumn = "username";
                String uRoleId = "role";
                AccountTableDao accountTableDao = new AccountTableDao();
                for (ColumnDao column: tableDao.getColumns()) {
                    //判断是不是用户名字段
                    if(column.getColumnComment().equals("用户名")){
                        uname = column.getDealingColumnName();
                        unamecolumn = column.getColumnName();
                    }
                    //判断是不是密码字段
                    if(column.getColumnComment().equals("密码")){
                        upassword = column.getDealingColumnName();
                    }
                    //判断是不是ID字段
                    if(column.getColumnComment().equals("ID")){
                        uid = column.getDealingColumnName();
                    }
                    //判断是不是角色ID
                    if(column.getColumnComment().equals("角色")){
                        uRoleId = column.getDealingColumnName();
                    }
                }
                accountTableDao.setUId(uid);
                accountTableDao.setUName(uname);
                accountTableDao.setUPassword(upassword);
                accountTableDao.setURoleId(uRoleId);
                accountTableDao.setUNameColumn(unamecolumn);
                HashMap<String, Object> accountController = new HashMap<>();
                accountController.put("basePackage",Constant.IMPORT_CONTROLLER_PACKAGE_PATH);
                accountController.put("loginDtoPackage",Constant.IMPORT_COMMON_LOGIN_DTO_PACKAGE_PATH);
                accountController.put("resultPackage",Constant.IMPORT_COMMON_LANG_RESULT_PACKAGE_PATH);
                accountController.put("entityPackage",Constant.IMPORT_ENTITY_PACKAGE_PATH);
                accountController.put("servicePackage",Constant.IMPORT_SERVICE_PACKAGE_PATH);
                accountController.put("userDaoClass",tableDao.getDealingTableName());
                accountController.put("accountDaoClass",accountTableDao);
                FreemarkerUtil.fileFreemarker(accountController,Constant.BASE_TEMPLATE_PATH,"controller/AccountController.ftl",Constant.CONTROLLER_BASE_PATH + "AccountController.java");
                log.info("AccountController生成完毕");
            }
            log.info("======================开始生成前端============================");
            html.put("dao",tableDao);
            log.info("======================生成组件============================");
            FreemarkerUtil.fileFreemarker(html,Constant.BASE_TEMPLATE_PATH,"static/Manager.ftl", Constant.HTML_BASE_PATH + NameStrUtil.lowerCaseName(tableDao.getDealingTableName()) + "Manager.html");
            log.info("======================开始生成数据面板============================");
            FreemarkerUtil.fileFreemarker(html,Constant.BASE_TEMPLATE_PATH,"static/Panel.ftl", Constant.HTML_BASE_PATH +  "panel.html");
        }
    }

    /**
     * @Author: xingyuchen
     * @Discription: 生成config相关文件
     * @Date: 2021/12/21 3:50 下午
    */
    public void generatorConfigFile(){
        log.info("=============================开始生成配置文件==================================");
        FileUtil.mkdirFolder(Constant.FOLDER_CONFIG_NAME);
        log.info("文件夹config更新完成,位置是:" + Constant.BASE_JAVA_PATH+Constant.FOLDER_CONFIG_NAME);

        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("basePackage",Constant.IMPORT_CONFIG_PACKAGE_PATH);
        FreemarkerUtil.fileFreemarker(hashMap,Constant.BASE_TEMPLATE_PATH,"config/MybatisPlusConfig.ftl",Constant.MYBATIS_PLUS_CONFIG_PATH);
        log.info("mybatis-plus配置文件生成完毕,路径是:"+ Constant.MYBATIS_PLUS_CONFIG_PATH);

        FreemarkerUtil.fileFreemarker(hashMap,Constant.BASE_TEMPLATE_PATH,"config/DruidConfig.ftl",Constant.DRUID_CONFIG_PATH);
        log.info("Druid配置文件生成完毕，路径是:" + Constant.DRUID_CONFIG_PATH);

        HashMap<String, Object> swaggerMap = new HashMap<>();
        swaggerMap.put("basePackage",Constant.IMPORT_CONFIG_PACKAGE_PATH);
        //此处有需要可修改value值
        swaggerMap.put("swaggerTitle","小呆代码生成器-开源版-Swagger");
        swaggerMap.put("swaggerDescription","这是小呆代码生成器的开源版本，欢迎大家加入我们学习了解，同时我们提供一个性价比极高的个性化生成器平台。");
        swaggerMap.put("swaggerVersion","v1.0");
        FreemarkerUtil.fileFreemarker(swaggerMap,Constant.BASE_TEMPLATE_PATH,"config/SwaggerConfig.ftl",Constant.SWAGGER_CONFIG_PATH);
        log.info("Swagger配置文件生成完毕，路径:"+Constant.SWAGGER_CONFIG_PATH);

        FreemarkerUtil.fileFreemarker(hashMap,Constant.BASE_TEMPLATE_PATH,"config/CorsConfig.ftl",Constant.CORS_CONFIG_PATH);
        log.info("Cors跨域问题配置文件生成完毕,路径:"+Constant.CORS_CONFIG_PATH);

    }

    /**
     * @Author: xingyuchen
     * @Discription: 生成common文件夹相关内容
     * @Date: 2021/12/22 4:07 下午
    */
    public void generatorCommonFile(){
        log.info("==========================开始生成common文件夹=============================");
        FileUtil.mkdirFolder(Constant.FOLDER_COMMON_NAME);
        log.info("文件夹common更新完成,位置是:" + Constant.BASE_JAVA_PATH + Constant.FOLDER_COMMON_NAME);

        log.info("==========================开始生成lang文件夹===============================");
        FileUtil.mkdirFolder(Constant.FOLDER_COMMON_LANG_NAME);
        log.info("文件夹lang更新完成,位置是:" + Constant.BASE_JAVA_PATH + Constant.FOLDER_COMMON_LANG_NAME);
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("basePackage",Constant.IMPORT_COMMON_LANG_PACKAGE_PATH);
        FreemarkerUtil.fileFreemarker(hashMap,Constant.BASE_TEMPLATE_PATH,"common/lang/Result.ftl",Constant.RESULT_FILE_PATH);
        log.info("Result.java文件生成完毕,路径:"+Constant.RESULT_FILE_PATH);

        log.info("==========================开始生成dto文件夹===============================");
        FileUtil.mkdirFolder(Constant.FOLDER_COMMON_DTO_NAME);
        log.info("文件夹dto更新完成,位置是:" + Constant.BASE_JAVA_PATH + Constant.FOLDER_COMMON_DTO_NAME);
        HashMap<String, Object> loginDto = new HashMap<>();
        loginDto.put("basePackage",Constant.IMPORT_COMMON_DTO_PACKAGE_PATH);
        FreemarkerUtil.fileFreemarker(loginDto,Constant.BASE_TEMPLATE_PATH,"common/dto/LoginDto.ftl",Constant.LOGIN_DTO_FILE_PATH);
        log.info("LoginDto.java文件生成完毕,路径:"+Constant.LOGIN_DTO_FILE_PATH);

    }

    @Override
    public void run() {
        if (this.database != null && this.databaseName != null) {
            System.out.println(this.databaseName+"==="+this.database);
            this.generatorFile(this.database,this.databaseName);
        }
        if (this.database != null && this.databaseName == null) {
            System.out.println(this.databaseName+"==="+this.database);
            this.generatorFile(this.database);
        }
        if (this.database == null && this.databaseName == null){
            System.out.println(this.databaseName+"==="+this.database);
            this.generatorFile();
        }
    }
}
