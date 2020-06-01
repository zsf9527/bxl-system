package com.zsf.consumer.controller;

import com.zsf.consumer.ProducerApi.ProducerService;
import org.springframework.stereotype.Component;

@Component
public class HelloHystixController implements ProducerService {
    @Override
    public String getHello() {
        return "请稍后再调用，系统繁忙";
    }
}
