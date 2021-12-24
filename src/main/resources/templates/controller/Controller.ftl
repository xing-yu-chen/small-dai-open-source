package ${basePackage};

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.ibatis.annotations.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;
import ${resultPackage};
import ${servicePackage}.${tableObj.dealingTableName}Service;
import ${entityPackage}.${tableObj.dealingTableName};

import java.util.List;

/**
* @Author: xing-yu-chen
* @Project: open-source
* @Description: ${tableObj.comment}Controller
* @Data:Created in 2021/12/21 10:15 下午
*/
@Api(tags = "${tableObj.comment}Controller")
@RestController
@RequestMapping("/${tableObj.dealingTableName?uncap_first}s")
public class ${tableObj.dealingTableName}Controller {

    @Autowired
    private ${tableObj.dealingTableName}Service ${tableObj.dealingTableName?uncap_first}Service;

    /**
    * @Author: xingyuchen
    * @Discription: list列出所有${tableObj.comment}
    * @param
    * @Date: 2021/12/24 6:41 下午
    */
    @ApiOperation(value = "${tableObj.comment}列表")
    @GetMapping("/")
    public Result listAll${tableObj.dealingTableName}s(){
        //列举所有的数据，此处可以配合使用vue的分页插件时使用
        List<${tableObj.dealingTableName}> list = ${tableObj.dealingTableName?uncap_first}Service.list();
        if(list.size()>0){
            //成功返回${tableObj.comment}列表
            return Result.succ(list);
        }
        //失败返回查询出来是空的
        return Result.fail(null,"empty");
    }

    /**
    * @Author: xingyuchen
    * @Discription: get某一${tableObj.comment}
    * @param id
    * @Date: 2021/12/24 8:21 下午
    */
    @ApiOperation(value = "获取某一个${tableObj.comment}")
    @GetMapping("/{id}")
    public Result get${tableObj.dealingTableName}ById(@PathVariable(name = "id") Long id){
        //获取某一个数据
        ${tableObj.dealingTableName} ${tableObj.dealingTableName?uncap_first} = ${tableObj.dealingTableName?uncap_first}Service.getById(id);
        //该数据对象存在
        if(${tableObj.dealingTableName?uncap_first} != null){
        //成功返回一个${tableObj.comment}对象
        return Result.succ(${tableObj.dealingTableName?uncap_first});
        }
        //失败就返回none
        return Result.fail(null,"none");
    }

    /**
    * @Author: xingyuchen
    * @Discription: insert某一${tableObj.comment}
    * @param ${tableObj.dealingTableName?uncap_first}
    * @Date: 2021/12/24 8:38 下午
    */
    @ApiOperation(value = "新增某一个${tableObj.comment}")
    @PostMapping
    public Result insert${tableObj.dealingTableName}(${tableObj.dealingTableName} ${tableObj.dealingTableName?uncap_first}){
        //新增一个${tableObj.comment}
        boolean save = ${tableObj.dealingTableName?uncap_first}Service.save(${tableObj.dealingTableName?uncap_first});
        //如果成功
        if(save){
            //返回success
            return Result.succ("success");
        }
        //失败返回fail
        return Result.fail(null,"fail");
    }

    /**
    * @Author: xingyuchen
    * @Discription: update某一${tableObj.comment}
    * @param
    * @Date: 2021/12/24 8:45 下午
    */
    @ApiOperation(value = "修改某一${tableObj.comment}")
    @PutMapping
    public Result update${tableObj.dealingTableName}ById(${tableObj.dealingTableName} ${tableObj.dealingTableName?uncap_first}){
        //更新该ID的${tableObj.comment}
        boolean b = ${tableObj.dealingTableName?uncap_first}Service.updateById(${tableObj.dealingTableName?uncap_first});
        //如果成功
        if(b){
            //返回success
            return Result.succ("success");
        }
        //失败返回fail
        return Result.fail(null,"fail");
    }

    /**
    * @Author: xingyuchen
    * @Discription: delete某一个${tableObj.comment}ID
    * @param id
    * @Date: 2021/12/24 9:02 下午
    */

    @ApiOperation(value = "删除某一个${tableObj.comment}")
    @Delete(value = "/{id}")
    public Result delete${tableObj.dealingTableName}ById(@PathVariable(name = "id") Long id){
        //根据ID删除${tableObj.comment}
        boolean b = ${tableObj.dealingTableName?uncap_first}Service.removeById(id);
        //如果成功
        if(b){
            //返回success
            return Result.succ("success");
        }
        //返回fail
        return Result.fail(null,"fail");
    }

    /**
    * @Author: xingyuchen
    * @Discription: 分页查询某一页${tableObj.comment}数据
    * @param num
    * @Date: 2021/12/24 9:59 下午
    */
    @ApiOperation(value = "分页查询某一页${tableObj.comment}数据")
    @GetMapping(value = "/{num}/page")
    public Result listRoleByPage(@PathVariable(name = "num")Integer num){
        //获取第n页的size条数据，current的值默认是1，从1开始，不是0。size是每一页的条数。
        Page<${tableObj.dealingTableName}> page = new Page<>(num, 4);
        Page<${tableObj.dealingTableName}> ${tableObj.dealingTableName?uncap_first}Page = ${tableObj.dealingTableName?uncap_first}Service.page(page);
        //如果数据条数大于0
        if(${tableObj.dealingTableName?uncap_first}Page.getSize()>0){
            //就返回数据
            return Result.succ(${tableObj.dealingTableName?uncap_first}Page);
        }
        //否则返回空
        return Result.fail(null,"empty");
    }
}
