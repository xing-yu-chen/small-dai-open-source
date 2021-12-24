package ${basePackage};

import lombok.Data;
import java.lang.*;
import java.io.Serializable;



/**
* @Author: xing-yu-chen
* @Project: open-source
* @Description: 请求返回数据统一封装格式
* @Data:Created in 2021/12/22 5:01 下午
*/
@Data
public class Result implements Serializable {
    //状态码
    private Integer code;

    //返回API说明地址
    private String href;

    //返回前端的提示信息
    private String msg;

    //返回的数据
    private Object data;

    /**
    * @Author: xingyuchen
    * @Discription: 成功请求底层封装
    * @param code
    * @param msg
    * @param data
    * @Date: 2021/12/22 5:02 下午
    */
    public static Result succ(int code, String msg, Object data) {
        Result result = new Result();
        result.setCode(code);
        result.setHref("http://localhost/api");
        result.setMsg(msg);
        result.setData(data);
        return result;
    }

    /**
    * @Author: xingyuchen
    * @Discription: 成功的封装
    * @param data
    * @Date: 2021/12/22 5:02 下午
    */
    public static Result succ(Object data) {
        return succ(200 , "操作成功", data);
    }

    /**
    * @Author: xingyuchen
    * @Discription: 失败的底层封装
    * @param code
    * @param msg
    * @param data
    * @Date: 2021/12/22 5:03 下午
    */
    public static Result fail(int code,String msg,Object data){
        Result result=new Result();
        result.setCode(code);
        result.setMsg(msg);
        result.setData(data);
        return result;
    }

    /**
    * @Author: xingyuchen
    * @Discription: 500错误，服务器响应失败
    * @param msg
    * @param data
    * @Date: 2021/12/22 5:04 下午
    */
    public static Result fail(String msg,Object data){
        return fail(500,msg,data);
    }

    /**
    * @Author: xingyuchen
    * @Discription: 404错误，资源已经丢失
    * @param msg
    * @Date: 2021/12/22 5:05 下午
    */
    public static Result fail(String msg){
        return fail(404, msg ,null);
    }
}
