package com.frankzhou.lottery.backend.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
* @Author: this.FrankZhou
* @Description: 健康检查，心跳检测！
* @DateTime: 2023/1/8 0:56
*/
@Slf4j
@RestController
@RequestMapping("/health")
public class HealthController {

    @GetMapping("/test")
    public String healthTest() {
        return "Lottery backend SSO is OK!";
    }
}
