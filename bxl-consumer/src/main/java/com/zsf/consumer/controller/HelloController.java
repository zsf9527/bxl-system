package com.zsf.consumer.controller;

import com.zsf.consumer.ProducerApi.ProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class HelloController {

    @Autowired
    private RestTemplate template;

    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @Autowired
    private ProducerService producerService;

    @RequestMapping("hello")
    public String hello(){
        String s = template.getForObject("http://bxl-producer/hello", String.class);
        return s;
    }
    @RequestMapping("loadBalancerClient")
    public String hello1(){
        ServiceInstance serviceInstance = loadBalancerClient.choose("bxl-producer");
        return serviceInstance.getHost()+serviceInstance.getUri();
    }
    @RequestMapping("feign")
    public String hello3(){
        return producerService.getHello();
    }
}
