package com.pengfeis.spr.core.controller;


import com.pengfeis.spr.core.service.GreetingClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class BizController {
    @Resource
    GreetingClient greetingClient;

    @RequestMapping("/hello/{name}")
    public String index(@PathVariable("name") String name) {
        return greetingClient.say(name);
    }
}
