package top.smalldai.opensource.util.generator.dao;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * @Author: xing-yu-chen
 * @Project: open-source
 * @Description: 用于接收权限的信息存储
 * @Data:Created in 2022/1/9 1:54 上午
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PermissionDao implements Serializable {
    /**
     * @Author: xingyuchen
     * @Discription: 权限名称
    */
    private String pName;

    /**
     * @Author: xingyuchen
     * @Discription: 权限名称解释
    */
    private String pNameRemark;

    /**
     * @Author: xingyuchen
     * @Discription: 模块
    */
    private String pModule;

    /**
     * @Author: xingyuchen
     * @Discription: 创建时间
    */
    private Date gmtCreate;
}
