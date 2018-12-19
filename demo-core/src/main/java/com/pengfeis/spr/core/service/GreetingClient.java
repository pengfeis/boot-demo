package com.pengfeis.spr.core.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "spring-cloud-producer")
public interface GreetingClient {

    /**
     * 调用远程服务
     *
     * @param name
     * @return
     */
    @RequestMapping(value = "/hello")
    String say(@RequestParam(value = "name") String name);

}
