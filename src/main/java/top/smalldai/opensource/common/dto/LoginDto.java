package top.smalldai.opensource.common.dto;

import lombok.Data;
import java.lang.*;

/**
* @Author: xing-yu-chen
* @Project: open-source
* @Description: 登录DTO接收
* @Data:Created in 2021/12/22 5:49 下午
*/
@Data
public class LoginDto {
    /**
    * @Author: xingyuchen
    * @Discription: 用户名
    */
    private String userName;

    /**
    * @Author: xingyuchen
    * @Discription: 密码
    */
    private String password;

}
