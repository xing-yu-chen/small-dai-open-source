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
import top.smalldai.opensource.service.BookService;
import top.smalldai.opensource.entity.Book;

import java.util.List;

/**
* @Author: xing-yu-chen
* @Project: open-source
* @Description: 书本Controller
* @Data:Created in 2021/12/21 10:15 下午
*/
@Api(tags = "书本Controller")
@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookService bookService;

    /**
    * @Author: xingyuchen
    * @Discription: list列出所有书本
    * @param
    * @Date: 2021/12/24 6:41 下午
    */
    @ApiOperation(value = "书本列表")
    @GetMapping("/")
    public Result listAllBooks(){
        //列举所有的数据，此处可以配合使用vue的分页插件时使用
        List<Book> list = bookService.list();
        if(list.size()>0){
            //成功返回书本列表
            return Result.succ(list);
        }
        //失败返回查询出来是空的
        return Result.fail(null,"empty");
    }

    /**
    * @Author: xingyuchen
    * @Discription: get某一书本
    * @param id
    * @Date: 2021/12/24 8:21 下午
    */
    @ApiOperation(value = "获取某一个书本")
    @GetMapping("/{id}")
    public Result getBookById(@PathVariable(name = "id") Long id){
        //获取某一个数据
        Book book = bookService.getById(id);
        //该数据对象存在
        if(book != null){
        //成功返回一个书本对象
        return Result.succ(book);
        }
        //失败就返回none
        return Result.fail(null,"none");
    }

    /**
    * @Author: xingyuchen
    * @Discription: insert某一书本
    * @param book
    * @Date: 2021/12/24 8:38 下午
    */
    @ApiOperation(value = "新增某一个书本")
    @PostMapping
    public Result insertBook(Book book){
        //新增一个书本
        boolean save = bookService.save(book);
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
    * @Discription: update某一书本
    * @param
    * @Date: 2021/12/24 8:45 下午
    */
    @ApiOperation(value = "修改某一书本")
    @PutMapping
    public Result updateBookById(Book book){
        //更新该ID的书本
        boolean b = bookService.updateById(book);
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
    * @Discription: delete某一个书本ID
    * @param id
    * @Date: 2021/12/24 9:02 下午
    */

    @ApiOperation(value = "删除某一个书本")
    @Delete(value = "/{id}")
    public Result deleteBookById(@PathVariable(name = "id") Long id){
        //根据ID删除书本
        boolean b = bookService.removeById(id);
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
    * @Discription: 分页查询某一页书本数据
    * @param num
    * @Date: 2021/12/24 9:59 下午
    */
    @ApiOperation(value = "分页查询某一页书本数据")
    @GetMapping(value = "/{num}/page")
    public Result listRoleByPage(@PathVariable(name = "num")Integer num){
        //获取第n页的size条数据，current的值默认是1，从1开始，不是0。size是每一页的条数。
        Page<Book> page = new Page<>(num, 4);
        Page<Book> bookPage = bookService.page(page);
        //如果数据条数大于0
        if(bookPage.getSize()>0){
            //就返回数据
            return Result.succ(bookPage);
        }
        //否则返回空
        return Result.fail(null,"empty");
    }
}
