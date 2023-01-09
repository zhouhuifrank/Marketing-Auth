package com.frankzhou.lottery.backend;

import com.frankzhou.lottery.backend.entity.User;
import com.frankzhou.lottery.backend.mapper.UserMapper;
import com.frankzhou.lottery.backend.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
public class UserServiceTest {

    @Resource
    private UserService userService;

    @Resource
    private UserMapper userMapper;

    @Test
    public void testInsert() {
        User user = new User();
        user.setAccount("frankzhou");
        user.setPassword("123456");
        user.setEmail("123456@qq.com");
        user.setPhone("15000228149");
        Integer count = userMapper.insert(user);
        System.out.println(count);
    }
}
