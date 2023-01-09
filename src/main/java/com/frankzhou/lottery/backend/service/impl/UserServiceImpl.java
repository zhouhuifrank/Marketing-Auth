package com.frankzhou.lottery.backend.service.impl;

import com.alibaba.druid.util.StringUtils;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.frankzhou.lottery.backend.entity.User;
import com.frankzhou.lottery.backend.mapper.UserMapper;
import com.frankzhou.lottery.backend.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Objects;

/**
* @Author: this.FrankZhou
* @Description: 用户登录操作，包括登录、注册、忘记密码、发送手机验证码
* @DateTime: 2023/1/8 0:45
*/
@Slf4j
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public User login(User user) {
        String account = user.getAccount();
        String phone = user.getPhone();
        String email = user.getEmail();
        LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(User::getAccount,account);
        wrapper.or().eq(User::getPhone,phone);
        wrapper.or().eq(User::getEmail,email);

        try {
            User dbUser = userMapper.selectOne(wrapper);
            String dbPassword = dbUser.getPassword();
            if (Objects.isNull(dbUser) || !user.getPassword().equals(dbPassword)) {
                return null;
            }
        } catch (Exception e) {
            log.info("UserService.login方法错误,msg:{}",e.getMessage());
        }

        return user;
    }

    @Override
    public Boolean register(User user) {
        if (StringUtils.isEmpty(user.getAccount()) || StringUtils.isEmpty(user.getPhone())) {
            return Boolean.FALSE;
        }

        // 账号和密码不能重复
        LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(User::getAccount,user.getAccount());
        wrapper.or().eq(User::getPhone,user.getPhone());
        try {
            User dbUser = userMapper.selectOne(wrapper);
            if (Objects.nonNull(dbUser)) {
                return Boolean.FALSE;
            }
        } catch (Exception e) {
            log.error("UserService.register方法错误,msg:{}",e.getMessage());
        }

        Integer insertCount = userMapper.insert(user);
        if (insertCount < 1) {
            return Boolean.FALSE;
        }

        return Boolean.TRUE;
    }

    @Override
    public User forgetPassword(User user) {
        return null;
    }
}
