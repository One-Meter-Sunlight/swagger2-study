package com.imooc.controller;

import com.imooc.domain.User;
import com.imooc.service.UserService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 用户管理 Controller
 *
 * @author ck
 * @version 1.0
 * @since 2018-07-06
 */
@RestController
@RequestMapping("user")
@Api(value = "user", description = "用户管理")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 查询所有用户集合
     *
     * @return
     */
    @GetMapping("/list")
    @ApiOperation(value = "用户列表查询", notes = "用户列表查询")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful — 请求已完成"),
            @ApiResponse(code = 400, message = "请求中有语法问题，或不能满足请求"),
            @ApiResponse(code = 401, message = "未授权客户机访问数据"),
            @ApiResponse(code = 404, message = "服务器找不到给定的资源；文档不存在"),
            @ApiResponse(code = 500, message = "服务器不能完成请求")}
    )
    public List<User> list() {
        return userService.list();
    }

    /**
     * 根据ID查询用户信息
     *
     * @return
     */
    @GetMapping("/getUser/{id}")
    @ApiOperation(value = "根据ID查询用户信息", notes = "根据ID查询用户信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "String", paramType = "path",
                    defaultValue = "1")
    })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful — 请求已完成"),
            @ApiResponse(code = 400, message = "请求中有语法问题，或不能满足请求"),
            @ApiResponse(code = 403, message = "服务器拒绝请求"),
            @ApiResponse(code = 401, message = "未授权客户机访问数据"),
            @ApiResponse(code = 404, message = "服务器找不到给定的资源；文档不存在"),
            @ApiResponse(code = 500, message = "服务器不能完成请求")
    })
    public User getUser(@PathVariable(value = "id", required = true) Integer id) {
        return userService.selectEntity(id);
    }
}
