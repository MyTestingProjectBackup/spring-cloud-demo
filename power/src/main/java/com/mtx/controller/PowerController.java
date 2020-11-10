package com.mtx.controller;


import com.mtx.config.UserServiceClient;
import com.mtx.util.R;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;


@RestController
public class PowerController {

    private static final String URL="http://CLIENT-USER";

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private UserServiceClient userServiceClient;

    @RequestMapping("/getPower.do")
    public R getPower(String name) {
        Map<String, Object> result = new HashMap<>();
        result.put("key", "power数据");
        System.out.println("我被访问了");
        return R.success("返回成功", result);
    }

    @RequestMapping("/getPower1.do")
    @HystrixCommand(fallbackMethod = "fallbackMethod")
    public R getPower1(String name) {
        Map<String, Object> result = new HashMap<>();
        System.err.println("进入getPower1.do");
        result.put("key", "power1111111");
        System.err.println("我被访问了");
        return R.success("返回成功", result);
    }


    @RequestMapping("/getUser.do")
    public R getUser(String name) {
        System.out.println("xxxxxxxx");
        return R.success("操作成功", restTemplate.getForObject("http://localhost:5000/getUser.do", Object.class));
    }

    @RequestMapping("/getUser1.do")
    public Object getUser1(String name) {
        System.out.println("getPower to getUser with feign");
        return  userServiceClient.getUser();
    }

    public R fallbackMethod(String name){
        return R.error("调用失败，返回降级信息");
    }

}
