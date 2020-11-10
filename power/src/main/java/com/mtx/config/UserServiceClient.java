package com.mtx.config;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient("server-user")
public interface UserServiceClient {

    // 绑定对应的url
    @RequestMapping("/getUser.do")
    public Object getUser();
}
