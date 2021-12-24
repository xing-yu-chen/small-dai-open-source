package top.smalldai.opensource.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.lang.Long;
import java.lang.String;
import java.lang.Integer;
/**
* @Author: xing-yu-chen
* @Project: open-source
* @Description: 用户表实体类
* @Data:Created in 2021/12/21 5:44 下午
*/
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("t_user")
@ApiModel(value="User对象", description="用户表")
public class User implements Serializable{
    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "id")
    @TableId(value = "id")
    private Long id;

    @ApiModelProperty(value = "用户名")
    @TableField(value = "username")
    private String username;

    @ApiModelProperty(value = "密码")
    @TableField(value = "password")
    private String password;

    @ApiModelProperty(value = "昵称")
    @TableField(value = "nick_name")
    private String nickName;

    @ApiModelProperty(value = "邮箱")
    @TableField(value = "email")
    private String email;

    @ApiModelProperty(value = "手机号")
    @TableField(value = "phone")
    private String phone;

    @ApiModelProperty(value = "头像")
    @TableField(value = "avatar")
    private String avatar;

    @ApiModelProperty(value = "角色")
    @TableField(value = "role")
    private String role;

    @ApiModelProperty(value = "地址")
    @TableField(value = "address")
    private String address;

    @ApiModelProperty(value = "年龄")
    @TableField(value = "age")
    private Integer age;


}
