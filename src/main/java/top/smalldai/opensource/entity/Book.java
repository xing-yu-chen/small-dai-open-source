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
import java.math.BigDecimal;
/**
* @Author: xing-yu-chen
* @Project: open-source
* @Description: 书本实体类
* @Data:Created in 2021/12/21 5:44 下午
*/
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("book")
@ApiModel(value="Book对象", description="书本")
public class Book implements Serializable{
    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "序号")
    @TableId(value = "id")
    private Long id;

    @ApiModelProperty(value = "名称")
    @TableField(value = "name")
    private String name;

    @ApiModelProperty(value = "价格")
    @TableField(value = "price")
    private BigDecimal price;


}
