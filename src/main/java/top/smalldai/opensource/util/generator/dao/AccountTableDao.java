package top.smalldai.opensource.util.generator.dao;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @Author: xing-yu-chen
 * @Project: open-source
 * @Description: 登录相关即用户dao的表名的获取
 * @Data:Created in 2021/12/24 2:35 下午
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AccountTableDao {
    private String uId;
    private String uName;
    private String uNameColumn;
    private String uPassword;
    private String uRoleId;
}
