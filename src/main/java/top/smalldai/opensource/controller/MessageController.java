package top.smalldai.opensource.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.ibatis.annotations.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;
import top.smalldai.opensource.common.lang.Result;
import top.smalldai.opensource.service.MessageService;
import top.smalldai.opensource.entity.Message;

import java.util.List;

/**
* @Author: xing-yu-chen
* @Project: open-source
* @Description: 留言表Controller
* @Data:Created in 2021/12/21 10:15 下午
*/
@Api(tags = "留言表Controller")
@RestController
@RequestMapping("/messages")
public class MessageController {

    @Autowired
    private MessageService messageService;

    /**
    * @Author: xingyuchen
    * @Discription: list列出所有留言表
    * @param
    * @Date: 2021/12/24 6:41 下午
    */
    @ApiOperation(value = "留言表列表")
    @GetMapping("/")
    public Result listAllMessages(){
        //列举所有的数据，此处可以配合使用vue的分页插件时使用
        List<Message> list = messageService.list();
        if(list.size()>0){
            //成功返回留言表列表
            return Result.succ(list);
        }
        //失败返回查询出来是空的
        return Result.fail(null,"empty");
    }

    /**
    * @Author: xingyuchen
    * @Discription: get某一留言表
    * @param id
    * @Date: 2021/12/24 8:21 下午
    */
    @ApiOperation(value = "获取某一个留言表")
    @GetMapping("/{id}")
    public Result getMessageById(@PathVariable(name = "id") Long id){
        //获取某一个数据
        Message message = messageService.getById(id);
        //该数据对象存在
        if(message != null){
        //成功返回一个留言表对象
        return Result.succ(message);
        }
        //失败就返回none
        return Result.fail(null,"none");
    }

    /**
    * @Author: xingyuchen
    * @Discription: insert某一留言表
    * @param message
    * @Date: 2021/12/24 8:38 下午
    */
    @ApiOperation(value = "新增某一个留言表")
    @PostMapping
    public Result insertMessage(Message message){
        //新增一个留言表
        boolean save = messageService.save(message);
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
    * @Discription: update某一留言表
    * @param
    * @Date: 2021/12/24 8:45 下午
    */
    @ApiOperation(value = "修改某一留言表")
    @PutMapping
    public Result updateMessageById(Message message){
        //更新该ID的留言表
        boolean b = messageService.updateById(message);
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
    * @Discription: delete某一个留言表ID
    * @param id
    * @Date: 2021/12/24 9:02 下午
    */

    @ApiOperation(value = "删除某一个留言表")
    @Delete(value = "/{id}")
    public Result deleteMessageById(@PathVariable(name = "id") Long id){
        //根据ID删除留言表
        boolean b = messageService.removeById(id);
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
    * @Discription: 分页查询某一页留言表数据
    * @param num
    * @Date: 2021/12/24 9:59 下午
    */
    @ApiOperation(value = "分页查询某一页留言表数据")
    @GetMapping(value = "/{num}/page")
    public Result listRoleByPage(@PathVariable(name = "num")Integer num){
        //获取第n页的size条数据，current的值默认是1，从1开始，不是0。size是每一页的条数。
        Page<Message> page = new Page<>(num, 4);
        Page<Message> messagePage = messageService.page(page);
        //如果数据条数大于0
        if(messagePage.getSize()>0){
            //就返回数据
            return Result.succ(messagePage);
        }
        //否则返回空
        return Result.fail(null,"empty");
    }
}
