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
* @Description: 权限菜单表实体类
* @Data:Created in 2021/12/21 5:44 下午
*/
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("t_permission")
@ApiModel(value="Permission对象", description="权限菜单表")
public class Permission implements Serializable{
    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "")
    @TableId(value = "id")
    private Long id;

    @ApiModelProperty(value = "名称")
    @TableField(value = "name")
    private String name;

    @ApiModelProperty(value = "描述")
    @TableField(value = "description")
    private String description;

    @ApiModelProperty(value = "菜单路径")
    @TableField(value = "path")
    private String path;

    @ApiModelProperty(value = "图标")
    @TableField(value = "icon")
    private String icon;


}
