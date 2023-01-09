package com.frankzhou.lottery.backend.common.constants;

import com.frankzhou.lottery.backend.common.Result;
import com.frankzhou.lottery.backend.common.ResultCode;

/**
* @Author: this.FrankZhou
* @Description: 系统响应码定义
* @DateTime: 2023/1/8 2:15
*/
public class ResultCodeConstants {

    public static final ResultCode SUCCESS =  new ResultCode(HttpCode.OK,"请求成功");
    public static final ResultCode USER_UNAUTHORIZED = new ResultCode(HttpCode.UNAUTHORIZED,"用户为授权");
    public static final ResultCode SERVER_ERROR = new ResultCode(HttpCode.INTERNAL_SERVER_ERROR,"系统异常");

    public static final ResultCode DB_QUERY_NO_DATA = new ResultCode("600","数据库未查询到数据");
    public static final ResultCode DB_INSERT_COUNT_ERROR = new ResultCode("601","数据库插入数据错误");
    public static final ResultCode DB_UPDATE_COUNT_ERROR = new ResultCode("602","数据库更新数据错误");
    public static final ResultCode DB_DELETE_COUNT_ERROR = new ResultCode("603","数据库删除数据错误");


    public static final ResultCode REQUEST_PARAMS_ERROR = new ResultCode("700","请求参数错误");
    public static final ResultCode REQUEST_PARAMS_NULL = new ResultCode("701","请求参数为空");
}
