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
/**
* @Author: xing-yu-chen
* @Project: open-source
* @Description: 角色表实体类
* @Data:Created in 2021/12/21 5:44 下午
*/
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("t_role")
@ApiModel(value="Role对象", description="角色表")
public class Role implements Serializable{
    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "ID")
    @TableId(value = "id")
    private Long id;

    @ApiModelProperty(value = "名称")
    @TableField(value = "name")
    private String name;

    @ApiModelProperty(value = "描述")
    @TableField(value = "description")
    private String description;

    @ApiModelProperty(value = "权限列表")
    @TableField(value = "permission")
    private String permission;


}
