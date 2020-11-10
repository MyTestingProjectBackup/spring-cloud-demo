package com.mtx.controller;

import com.mtx.util.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;


@RestController
public class UserController {
    @Autowired
    private RestTemplate restTemplate;

    private static final String URL="http://CLIENT-POWER";



    @RequestMapping("/getUser.do")
    public R getUser(String name) {
        Map<String, Object> result = new HashMap<>();
        result.put("key", "用户数据");
        System.err.println("============================");
        return R.success("返回成功", result);
    }

    @RequestMapping("/getPower.do")
    public R getPower(String name) {
        return R.success("操作成功", restTemplate.getForObject("http://localhost:7000/getPower.do", Object.class));
    }

}
