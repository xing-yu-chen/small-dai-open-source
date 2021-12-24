package ${basePackage};

import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
<#list tableObj.columns as column1>
<#list tableObj.columns as column2>
<#if column1.columnDbType==column2.columnDbType>
<#if column1_index==column2_index>
import ${column1.columnDbType};
<#else>
    <#break>
</#if>
</#if>
</#list>
</#list>
/**
* @Author: xing-yu-chen
* @Project: open-source
* @Description: ${tableObj.comment}实体类
* @Data:Created in 2021/12/21 5:44 下午
*/
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("${tableObj.tableName}")
@ApiModel(value="${tableObj.dealingTableName}对象", description="${tableObj.comment}")
public class ${tableObj.dealingTableName} implements Serializable{
    private static final long serialVersionUID=1L;

<#list tableObj.columns as column>
    @ApiModelProperty(value = "${column.columnComment}")
<#if column.columnKey=true>
    @TableId(value = "${column.columnName}")
<#else>
    @TableField(value = "${column.columnName}")
</#if>
    private ${column.columnType} ${column.dealingColumnName};

</#list>

}
