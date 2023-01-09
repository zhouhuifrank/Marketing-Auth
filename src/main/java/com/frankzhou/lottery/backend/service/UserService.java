package com.frankzhou.lottery.backend.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.frankzhou.lottery.backend.entity.User;

import java.util.List;

/**
* @Author: this.FrankZhou
* @Description: 用户相关操作，包括登录、注册、忘记密码、发送手机验证码
* @DateTime: 2023/1/8 0:44
*/
public interface UserService extends IService<User> {

    public User login(User user);

    public Boolean register(User user);

    public User forgetPassword(User user);
}
