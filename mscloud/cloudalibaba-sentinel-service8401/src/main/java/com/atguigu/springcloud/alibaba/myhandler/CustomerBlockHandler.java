package com.atguigu.springcloud.alibaba.myhandler;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.atguigu.springcloud.alibaba.alibaba.entities.CommonResult;

public class CustomerBlockHandler {
    public static CommonResult handleException2(BlockException exception){
        return new CommonResult(2020, "自定义限流处理信息....CustomerBlockHandler");
    }
}
