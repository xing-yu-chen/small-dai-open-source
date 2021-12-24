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
import top.smalldai.opensource.service.NoticeService;
import top.smalldai.opensource.entity.Notice;

import java.util.List;

/**
* @Author: xing-yu-chen
* @Project: open-source
* @Description: Controller
* @Data:Created in 2021/12/21 10:15 下午
*/
@Api(tags = "Controller")
@RestController
@RequestMapping("/notices")
public class NoticeController {

    @Autowired
    private NoticeService noticeService;

    /**
    * @Author: xingyuchen
    * @Discription: list列出所有
    * @param
    * @Date: 2021/12/24 6:41 下午
    */
    @ApiOperation(value = "列表")
    @GetMapping("/")
    public Result listAllNotices(){
        //列举所有的数据，此处可以配合使用vue的分页插件时使用
        List<Notice> list = noticeService.list();
        if(list.size()>0){
            //成功返回列表
            return Result.succ(list);
        }
        //失败返回查询出来是空的
        return Result.fail(null,"empty");
    }

    /**
    * @Author: xingyuchen
    * @Discription: get某一
    * @param id
    * @Date: 2021/12/24 8:21 下午
    */
    @ApiOperation(value = "获取某一个")
    @GetMapping("/{id}")
    public Result getNoticeById(@PathVariable(name = "id") Long id){
        //获取某一个数据
        Notice notice = noticeService.getById(id);
        //该数据对象存在
        if(notice != null){
        //成功返回一个对象
        return Result.succ(notice);
        }
        //失败就返回none
        return Result.fail(null,"none");
    }

    /**
    * @Author: xingyuchen
    * @Discription: insert某一
    * @param notice
    * @Date: 2021/12/24 8:38 下午
    */
    @ApiOperation(value = "新增某一个")
    @PostMapping
    public Result insertNotice(Notice notice){
        //新增一个
        boolean save = noticeService.save(notice);
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
    * @Discription: update某一
    * @param
    * @Date: 2021/12/24 8:45 下午
    */
    @ApiOperation(value = "修改某一")
    @PutMapping
    public Result updateNoticeById(Notice notice){
        //更新该ID的
        boolean b = noticeService.updateById(notice);
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
    * @Discription: delete某一个ID
    * @param id
    * @Date: 2021/12/24 9:02 下午
    */

    @ApiOperation(value = "删除某一个")
    @Delete(value = "/{id}")
    public Result deleteNoticeById(@PathVariable(name = "id") Long id){
        //根据ID删除
        boolean b = noticeService.removeById(id);
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
    * @Discription: 分页查询某一页数据
    * @param num
    * @Date: 2021/12/24 9:59 下午
    */
    @ApiOperation(value = "分页查询某一页数据")
    @GetMapping(value = "/{num}/page")
    public Result listRoleByPage(@PathVariable(name = "num")Integer num){
        //获取第n页的size条数据，current的值默认是1，从1开始，不是0。size是每一页的条数。
        Page<Notice> page = new Page<>(num, 4);
        Page<Notice> noticePage = noticeService.page(page);
        //如果数据条数大于0
        if(noticePage.getSize()>0){
            //就返回数据
            return Result.succ(noticePage);
        }
        //否则返回空
        return Result.fail(null,"empty");
    }
}
