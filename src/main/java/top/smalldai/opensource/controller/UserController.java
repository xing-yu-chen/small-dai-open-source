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
import top.smalldai.opensource.service.UserService;
import top.smalldai.opensource.entity.User;

import java.util.List;

/**
* @Author: xing-yu-chen
* @Project: open-source
* @Description: 用户表Controller
* @Data:Created in 2021/12/21 10:15 下午
*/
@Api(tags = "用户表Controller")
@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    /**
    * @Author: xingyuchen
    * @Discription: list列出所有用户表
    * @param
    * @Date: 2021/12/24 6:41 下午
    */
    @ApiOperation(value = "用户表列表")
    @GetMapping("/")
    public Result listAllUsers(){
        //列举所有的数据，此处可以配合使用vue的分页插件时使用
        List<User> list = userService.list();
        if(list.size()>0){
            //成功返回用户表列表
            return Result.succ(list);
        }
        //失败返回查询出来是空的
        return Result.fail(null,"empty");
    }

    /**
    * @Author: xingyuchen
    * @Discription: get某一用户表
    * @param id
    * @Date: 2021/12/24 8:21 下午
    */
    @ApiOperation(value = "获取某一个用户表")
    @GetMapping("/{id}")
    public Result getUserById(@PathVariable(name = "id") Long id){
        //获取某一个数据
        User user = userService.getById(id);
        //该数据对象存在
        if(user != null){
        //成功返回一个用户表对象
        return Result.succ(user);
        }
        //失败就返回none
        return Result.fail(null,"none");
    }

    /**
    * @Author: xingyuchen
    * @Discription: insert某一用户表
    * @param user
    * @Date: 2021/12/24 8:38 下午
    */
    @ApiOperation(value = "新增某一个用户表")
    @PostMapping
    public Result insertUser(User user){
        //新增一个用户表
        boolean save = userService.save(user);
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
    * @Discription: update某一用户表
    * @param
    * @Date: 2021/12/24 8:45 下午
    */
    @ApiOperation(value = "修改某一用户表")
    @PutMapping
    public Result updateUserById(User user){
        //更新该ID的用户表
        boolean b = userService.updateById(user);
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
    * @Discription: delete某一个用户表ID
    * @param id
    * @Date: 2021/12/24 9:02 下午
    */

    @ApiOperation(value = "删除某一个用户表")
    @Delete(value = "/{id}")
    public Result deleteUserById(@PathVariable(name = "id") Long id){
        //根据ID删除用户表
        boolean b = userService.removeById(id);
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
    * @Discription: 分页查询某一页用户表数据
    * @param num
    * @Date: 2021/12/24 9:59 下午
    */
    @ApiOperation(value = "分页查询某一页用户表数据")
    @GetMapping(value = "/{num}/page")
    public Result listRoleByPage(@PathVariable(name = "num")Integer num){
        //获取第n页的size条数据，current的值默认是1，从1开始，不是0。size是每一页的条数。
        Page<User> page = new Page<>(num, 4);
        Page<User> userPage = userService.page(page);
        //如果数据条数大于0
        if(userPage.getSize()>0){
            //就返回数据
            return Result.succ(userPage);
        }
        //否则返回空
        return Result.fail(null,"empty");
    }
}
