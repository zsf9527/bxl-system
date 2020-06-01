package com.zsf.consumer.ProducerApi;

import com.zsf.consumer.controller.HelloHystixController;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name = "bxl-producer",fallback = HelloHystixController.class)
public interface ProducerService {

    @RequestMapping("hello")
    String getHello();
}
