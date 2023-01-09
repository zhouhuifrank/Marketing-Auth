package com.frankzhou.lottery.backend.controller;

import cn.hutool.core.collection.CollectionUtil;
import com.frankzhou.lottery.backend.common.Result;
import com.frankzhou.lottery.backend.common.constants.ResultCodeConstants;
import com.frankzhou.lottery.backend.entity.User;
import com.frankzhou.lottery.backend.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Objects;

/**
* @Author: this.FrankZhou
* @Description: 用户行为控制器
* @DateTime: 2023/1/8 0:55
*/
@Slf4j
@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserService userService;

    @GetMapping("/list")
    public Result<List<User>> queryUserList() {
        List<User> userList = userService.list();
        if (CollectionUtil.isEmpty(userList)) {
            return Result.error(ResultCodeConstants.DB_QUERY_NO_DATA);
        }

        return Result.success(userList);
    }

    @PostMapping("/login")
    public Result<User> login(@RequestBody User user) {
        if (Objects.isNull(user)) {
            return Result.error(ResultCodeConstants.REQUEST_PARAMS_ERROR);
        }

        return Result.success(userService.login(user));
    }

    @PostMapping("/register")
    public Result<Boolean> register(@RequestBody User user) {
        if (Objects.isNull(user)) {
            return Result.error(ResultCodeConstants.REQUEST_PARAMS_ERROR);
        }

        return Result.success(userService.register(user));
    }

    @PostMapping("/forgetPassword")
    public Result<User> forgetPassowrd(@RequestBody User user) {
        if (Objects.isNull(user)) {
            return Result.error(ResultCodeConstants.REQUEST_PARAMS_ERROR);
        }

        return Result.success(userService.forgetPassword(user));
    }
}
