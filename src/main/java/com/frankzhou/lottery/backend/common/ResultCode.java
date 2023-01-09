package com.frankzhou.lottery.backend.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: this.FrankZhou
 * @Description: 系统响应码
 * @DateTime: 2023/1/8 2:11
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResultCode {

    private String code;

    private String msg;
}
