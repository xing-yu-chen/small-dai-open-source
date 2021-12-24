package ${basePackage};

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ${loginDtoPackage};
import ${resultPackage};
import ${entityPackage}.${userDaoClass};
import ${servicePackage}.${userDaoClass}Service;

import javax.servlet.http.HttpServletRequest;

/**
* @Author: xing-yu-chen
* @Project: open-source
* @Description: 登录/注册/退出功能的实现
* @Data:Created in 2021/12/22 4:53 下午
*/
@RestController
@RequestMapping("/")
@Api(tags = "信息校验Controller")
public class AccountController {

    @Autowired
    private ${userDaoClass}Service ${userDaoClass?uncap_first}Service;

    /**
    * @Author: xingyuchen
    * @Discription: 用户登录
    * @param loginDto
    * @Date: 2021/12/22 6:20 下午
    */
    @PostMapping("login")
    @ApiOperation(value = "用户登录")
    public Result login(@RequestBody LoginDto loginDto, HttpServletRequest request){
        //用户名和密码都不为空的时候执行
        if(loginDto.getUserName().length() != 0 && loginDto.getPassword().length() != 0){
            //通过用户名获取用户信息
            ${userDaoClass} user = ${userDaoClass?uncap_first}Service.getOne(new QueryWrapper<${userDaoClass}>().eq("username", loginDto.getUserName()));
            //通过比对密码
            if(user != null & user.get${accountDaoClass.UPassword?cap_first}().equals(loginDto.getPassword())){
                //设置session
                request.getSession().setAttribute("userDto",user.get${accountDaoClass.UId?cap_first}());
                //返回用户角色
                return Result.succ(user.get${accountDaoClass.URoleId?cap_first}());
            }
            //用户信息异常报错信息返回
            return Result.fail(null,"用户信息异常");
        }
        //校验用户名和密码返回
        return Result.fail("请校验您输入的内容。");
    }

    /**
    * @Author: xingyuchen
    * @Discription: 用户注册
    * @param user
    * @Date: 2021/12/23 2:47 上午
    */
    @PostMapping("register")
    @ApiOperation(value = "用户注册")
    public Result register(${userDaoClass} user){
        //新增用户信息
        boolean save = ${userDaoClass?uncap_first}Service.save(user);
        //如果新增成功
        if( save == true ){
            return Result.succ("新增成功");
        }
        //用户新增失败
        return Result.fail(null,"新增失败");
    }

    /**
    * @Author: xingyuchen
    * @Discription: 用户退出
    * @param id
    * @param request
    * @Date: 2021/12/23 3:07 上午
    */
    @GetMapping("logout")
    @ApiOperation(value = "用户退出")
    public Result logout(@RequestParam("id") Long id,HttpServletRequest request){
        //判断Session是否有这个ID
        if(request.getSession().getAttribute("userDto") == id){
            //退出
            request.getSession().removeAttribute("userDto");
            //成功退出
            return Result.succ("退出成功");
        }
        //返回退出失败
        return Result.fail(null,"退出失败");
    }
}
