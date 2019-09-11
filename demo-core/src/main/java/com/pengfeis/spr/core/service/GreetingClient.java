package com.pengfeis.spr.core.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author pengfeisu
 */
@FeignClient(name = "spring-cloud-producer")
public interface GreetingClient {

    /**
     * 调用远程服务
     *
     * @param name
     * @param mobile
     * @param idNum
     * @return
     */
    @RequestMapping(value = "/hello/{name}/{mobile}/{idNum}")
    String say(@PathVariable("name") String name, @PathVariable("mobile") String mobile, @PathVariable("idNum") String idNum);

}
