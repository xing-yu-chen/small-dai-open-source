package top.smalldai.opensource.util.generator.utils;

import top.smalldai.opensource.util.generator.dao.ColumnDao;
import top.smalldai.opensource.util.generator.dao.DatabaseDao;
import top.smalldai.opensource.util.generator.dao.PermissionDao;
import top.smalldai.opensource.util.generator.dao.TableDao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Author: xing-yu-chen
 * @Project: open-source
 * @Description: 数据库工具类
 * @Data:Created in 2021/12/20 12:41 上午
 */
public class DbUtil {
    /**
     * @Author: xingyuchen
     * @Discription: 获取数据库连接
     * @param database 数据库实体类
     * @Date: 2021/12/20 12:44 上午
    */
    public static Connection getDbConnection(DatabaseDao database) throws ClassNotFoundException,SQLException{
        Properties properties = new Properties();
        properties.put("remarksReporting","true");//获取数据库的备注信息
        properties.put("useInformationSchema","true");//获取数据库表名备注
        properties.put("user",database.getUsername());
        properties.put("password",database.getPassword());
        // 获取连接
        Class.forName(database.getDriver());
        //此处需要使用properties配置文件的形式，不然获取备注的时候会为空
        Connection connection = DriverManager.getConnection(database.getUrl(),properties);
        return connection;
    }

    /**
     * @Author: xingyuchen
     * @Discription: 关闭数据库连接
     * @param connection
     * @Date: 2021/12/21 7:36 下午
    */
    public static void closeDbConnection(Connection connection) throws SQLException {
        connection.close();
    }

    /**
     * @Author: xingyuchen
     * @Discription: 获取数据库所有表信息
     * @param database
     * @param dbName
     * @Date: 2021/12/20 12:56 上午
    */
    public static List<TableDao> getTableBaseMsg(DatabaseDao database, String dbName){
        try {
            //数据库连接
            Connection connection = DbUtil.getDbConnection(database);
            //获取元数据
            DatabaseMetaData metaData = connection.getMetaData();
            //初始化返回对象
            List<TableDao> tableDaos = new ArrayList<>();
            //获取结果集
            ResultSet tables = metaData.getTables(dbName, null, null, new String[]{"TABLE"});
            //遍历
            while(tables.next()){
                //通过使用一个DAO对象去接收获取的信息
                TableDao tableDao = new TableDao();
                //设置表的名字
                tableDao.setTableName(tables.getString("TABLE_NAME"));
                //设置表的备注
                tableDao.setComment(NameStrUtil.deleteBiaoName(DbUtil.trimSpaceTag(tables.getString("REMARKS").trim())));
                //设置处理后表的名称
                tableDao.setDealingTableName(NameStrUtil.tableNameStringDealing(tableDao.getTableName()));
                //获取该表作为主键的字段
                String tablePrimaryKey = DbUtil.getTablePrimaryKey(metaData, dbName, tableDao.getTableName());
                //设置表的主键
                tableDao.setKey(tablePrimaryKey);
                //设置列集合
                tableDao.setColumns(DbUtil.getColumnBaseMsg(metaData,dbName,tableDao.getTableName()));
                //将封装的DTO对象追加到List中
                tableDaos.add(tableDao);
            }
            //关闭结果集
            tables.close();
            //关闭数据库连接
            DbUtil.closeDbConnection(connection);
            return tableDaos;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    /**
     * @Author: xingyuchen
     * @Discription: 获取某数据库某张表的信息
     * @param metaData
     * @param dbName
     * @param tableName
     * @Date: 2021/12/20 9:47 上午
    */
    public static List<ColumnDao> getColumnBaseMsg(DatabaseMetaData metaData, String dbName, String tableName) throws SQLException {
            //初始化一个List对象
            List<ColumnDao> columnDaos = new ArrayList<>();
            //获取结果集
            ResultSet columns = metaData.getColumns(dbName, null, tableName, null);
            //遍历
            while(columns.next()){
                //将返回结果封装到DTO对象中
                ColumnDao columnDao = new ColumnDao();
                //设置字段名
                columnDao.setColumnName(columns.getString("COLUMN_NAME"));
                //设置字段类型
                columnDao.setColumnType(DbUtil.getColumnClassType(columns.getString("TYPE_NAME")));
                //设置字段类型路径
                columnDao.setColumnDbType(DbUtil.getColumnClassTypePath(columnDao.getColumnType()));
                //设置字段别名,处理回车空格
                columnDao.setColumnComment(DbUtil.trimSpaceTag(columns.getString("REMARKS").trim()));
                //设置是否主键
                columnDao.setColumnKey(DbUtil.isPrimaryKey(metaData,dbName,tableName,columnDao.getColumnName()));
                //定义变量的时候的Java名称
                columnDao.setDealingColumnName(NameStrUtil.columnNameStringDealing(columnDao.getColumnName()));
                //将DTO对象追加到List集合中
                columnDaos.add(columnDao);
            }
            //关闭结果集连接
            columns.close();
            return columnDaos;
    }

    /**
     * @Author: xingyuchen
     * @Discription: 获取数据库主键
     * @param metaData
     * @param dbName
     * @param tableName
     * @Date: 2021/12/20 10:48 上午
    */
    public static String getTablePrimaryKey(DatabaseMetaData metaData,String dbName,String tableName) throws SQLException {
        //字符串主键字段初始化
        String primaryKey ="";
        ResultSet primaryKeys = metaData.getPrimaryKeys(dbName, null, tableName);
        //遍历得到主键的字符串
        while (primaryKeys.next()){
            //获取主键列的名称
             primaryKey=primaryKeys.getString("COLUMN_NAME");
        }
        //关闭结果集连接
        primaryKeys.close();
        //返回主键字符串
        return primaryKey;
    }

    /**
     * @Author: xingyuchen
     * @Discription: 获取Java类型对象
     * @param typeStr
     * @Date: 2021/12/21 2:50 下午
    */
    public static String getColumnClassType(String typeStr) {
        //通过字段的类型获取Java的类型
        switch (typeStr) {
            case "VARCHAR":
            case "LONGTEXT":
            case "TEXT":
                return "String";
            case "DOUBLE":
                return "Double";
            case "INT":
                return "Integer";
            case "TINYINT":
                return "Boolean";
            case "BIGINT":
                return "Long";
            case "DATETIME":
            case "TIMESTAMP":
                return "Date";
            case "DECIMAL":
                return "BigDecimal";
            default:
                return "";
        }
    }
    /**
     * @Author: xingyuchen
     * @Discription: 获取该对象的路径
     * @param typeStrPath
     * @Date: 2021/12/21 2:53 下午
    */
    public static String getColumnClassTypePath(String typeStrPath){
        if(typeStrPath.equals("String")){
            return "java.lang.String";
        }else if(typeStrPath.equals("Double")){
            return "java.lang.Double";
        }else if(typeStrPath.equals("Integer")){
            return "java.lang.Integer";
        }else if(typeStrPath.equals("Boolean")){
            return "java.lang.Boolean";
        }else if(typeStrPath.equals("Long")){
            return "java.lang.Long";
        }else if(typeStrPath.equals("Date")){
            return "java.util.Date";
        }else if(typeStrPath.equals("BigDecimal")){
            return "java.math.BigDecimal";
        }else {
            return "";
        }
    }

    /**
     * @Author: xingyuchen
     * @Discription: 判断该字段是否为数据库主键
     * @param metaData
     * @param dbName
     * @param tableName
     * @param column
     * @Date: 2021/12/21 3:15 下午
    */
    public static Boolean isPrimaryKey(DatabaseMetaData metaData,String dbName,String tableName,String column){
        try {
            String tablePrimaryKey = DbUtil.getTablePrimaryKey(metaData, dbName, tableName);
            if(tablePrimaryKey != null && column.equals(tablePrimaryKey)){
                return true;
            }
            return false;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    /**
     * @Author: xingyuchen
     * @Discription: 过滤掉备注中的所有回车信息
     * @param str
     * @Date: 2021/12/21 7:34 下午
    */
    public static String trimSpaceTag(String str) {
        //定义空格回车换行符
        String regEx_space = "\\s*|\t|\r|\n";
        Pattern p_space = Pattern.compile(regEx_space, Pattern.CASE_INSENSITIVE);
        Matcher m_space = p_space.matcher(str);
        // 过滤空格回车标签
        str = m_space.replaceAll("");
        return str.trim(); // 返回文本字符串
    }

    /**
     * @Author: xingyuchen
     * @Discription: 往角色权限表中填入数据
     * @param database
     * @Date: 2022/1/9 12:48 上午
    */
    public static String insertMsg(DatabaseDao database, List<PermissionDao> list){
        //数据库连接
        try {
            Connection connection = DbUtil.getDbConnection(database);
            for (PermissionDao permission:list) {
                //存在就修改，不存在就新增
                String selectSQL = "update t_permission set p_name_remark = ?,p_module = ? where p_name = ?";
                PreparedStatement ps1 = connection.prepareStatement(selectSQL);
                ps1.setString(1, permission.getPNameRemark());
                ps1.setString(2, permission.getPModule());
                ps1.setString(3, permission.getPName());
                int i = ps1.executeUpdate();
                if (i <= 0){
                    String insertSQL = "insert into t_permission(p_name,p_name_remark,p_module,gmt_create) values(?,?,?,?)";
                    PreparedStatement ps2 = connection.prepareStatement(insertSQL);
                    ps2.setString(1, permission.getPName());
                    ps2.setString(2, permission.getPNameRemark());
                    ps2.setString(3, permission.getPModule());
                    ps2.setObject(4, permission.getGmtCreate());
                    int i1 = ps2.executeUpdate();
                    ps2.close();
                }
                ps1.close();
            }


        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

}
