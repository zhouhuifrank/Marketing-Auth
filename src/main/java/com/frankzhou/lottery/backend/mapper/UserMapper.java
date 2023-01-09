package com.frankzhou.lottery.backend.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.frankzhou.lottery.backend.entity.User;
import org.apache.ibatis.annotations.Mapper;

/**
* @Author: FrankZhou
* @Description: 用户表Mapper
* @DateTime: 2023/1/8 0:52
* @Params:
* @Return
*/
@Mapper
public interface UserMapper extends BaseMapper<User> {

}
