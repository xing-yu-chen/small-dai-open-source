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
@TableName("t_log")
@ApiModel(value="Log对象", description="")
public class Log implements Serializable{
    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "序号")
    @TableId(value = "id")
    private Long id;

    @ApiModelProperty(value = "操作内容")
    @TableField(value = "content")
    private String content;

    @ApiModelProperty(value = "操作时间")
    @TableField(value = "time")
    private String time;

    @ApiModelProperty(value = "操作人")
    @TableField(value = "user")
    private String user;

    @ApiModelProperty(value = "ip")
    @TableField(value = "ip")
    private String ip;


}
