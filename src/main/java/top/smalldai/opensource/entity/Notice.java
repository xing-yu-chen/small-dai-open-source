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
* @Description: 实体类
* @Data:Created in 2021/12/21 5:44 下午
*/
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("t_notice")
@ApiModel(value="Notice对象", description="")
public class Notice implements Serializable{
    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "ID")
    @TableId(value = "id")
    private Long id;

    @ApiModelProperty(value = "标题")
    @TableField(value = "title")
    private String title;

    @ApiModelProperty(value = "内容")
    @TableField(value = "content")
    private String content;

    @ApiModelProperty(value = "发布时间")
    @TableField(value = "time")
    private String time;


}
