package top.smalldai.opensource.util.generator.dao;

import lombok.Data;

/**
 * @Author: xing-yu-chen
 * @Project: open-source
 * @Description: 数据库实体类
 * @Data:Created in 2021/12/19 11:14 下午
 */
@Data
public class DatabaseDao {
    //数据库类型
    private String dbType;
    //驱动
    private String driver;

    private String username;

    private String password;

    private String url;

    public DatabaseDao(String db,String username,String password) {
        this("MYSQL",db,username,password);
    }

    public DatabaseDao(String dbType,String db,String username,String password){
        this(dbType,"127.0.0.1","3306",db,username,password);
    }


    public DatabaseDao(String dbType,String ip,String port,String db,String username,String password){
        this.dbType = dbType;
        this.username = username;
        this.password = password;
        if("MYSQL".endsWith(dbType.toUpperCase())){
            this.driver = "com.mysql.cj.jdbc.Driver";
            this.url = "jdbc:mysql://"+ip+":"+port+"/"+db+"?useUnicode=true&characterEncoding=utf8&useSSL=false";
        }else {
            this.driver = "oracle.jdbc.driver.OracleDriver";
            this.url = "jdbc:oracle:thin:@"+ip+":"+port+":"+db;
        }
    }
}
