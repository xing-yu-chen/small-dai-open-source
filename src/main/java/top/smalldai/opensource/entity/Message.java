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
* @Description: 留言表实体类
* @Data:Created in 2021/12/21 5:44 下午
*/
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("t_message")
@ApiModel(value="Message对象", description="留言表")
public class Message implements Serializable{
    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "ID")
    @TableId(value = "id")
    private Long id;

    @ApiModelProperty(value = "内容")
    @TableField(value = "content")
    private String content;

    @ApiModelProperty(value = "评论人")
    @TableField(value = "username")
    private String username;

    @ApiModelProperty(value = "评论时间")
    @TableField(value = "time")
    private String time;

    @ApiModelProperty(value = "父ID")
    @TableField(value = "parent_id")
    private Long parentId;

    @ApiModelProperty(value = "关联id")
    @TableField(value = "foreign_id")
    private Long foreignId;


}
