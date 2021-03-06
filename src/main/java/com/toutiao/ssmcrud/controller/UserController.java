package com.toutiao.ssmcrud.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.toutiao.ssmcrud.common.ResultData;
import com.toutiao.ssmcrud.entity.User;
import com.toutiao.ssmcrud.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = "/user")
public class UserController {
    @Autowired
    private UserService userService;

    /**
     * 这里统一返回ResultData封装的json数据格式，不在用Map<String,Object>形式了
     *
     * @return
     */
    @RequestMapping(value = "/getAllUser", method = RequestMethod.GET)
    @ResponseBody
    public ResultData getAllUser(@RequestParam(defaultValue = "1", required = true, value = "pn") Integer pn) {
        Map<String, Object> map = new HashMap<>();
        /**
         * 每页显示记录数
         *
         */
        Integer pageSize = 5;
        /**
         * 分页查询，注意顺序，startPage()方法放前面
         */
        PageHelper.startPage(pn, pageSize);
        /**
         * 获取所用用户信息
         */
        List<User> allUser = userService.getAllUser();
        /**
         * 使用pageInfo包装查询后的结果，只需要将pageInfo交给页面就行了。
         * 封装了详细的分页信息,传入连续显示的页数
         */

        PageInfo<User> pageInfo = new PageInfo(allUser);
        // map.put("code",100);
        // map.put("msg","成功");
        // map.put("pageInfo",pageInfo);
        //return map;
        return ResultData.success(pageInfo);
    }

    /**
     * 校验用户名
     *
     * @param username
     * @return
     */
    @RequestMapping(value = "/checkUser/{username}", method = RequestMethod.POST)
    @ResponseBody
    public ResultData checkUserName(@PathVariable("username") String username) {
        //校验用户名
        User user = userService.checkUserName(username);
        System.out.println(user);
        return ResultData.success(user);
    }

    /**
     * 保存用户信息
     *
     * @param user
     * @return
     */
    @RequestMapping(value = "/saveUser", method = RequestMethod.POST)
    @ResponseBody
    public ResultData saveUser(@RequestBody User user) {
        int i = userService.saveUser(user);
        return ResultData.success();
    }

    /**
     * 修改员工信息（更新）
     */
    @RequestMapping(value = "/updateUser", method = RequestMethod.POST)
    @ResponseBody
    public ResultData updateUser(@RequestBody User user) {
        System.out.print(user);
        userService.updateUser(user);
        return ResultData.success();
    }

    /**
     * 根据id删除用户
     */
    @RequestMapping(value = "/deleteUser/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public ResultData deleteUser(@PathVariable("id") Integer id) {
        //保存用户
        int i = userService.deleteUser(id);
        System.out.println(i);
        return ResultData.success();
    }
}
