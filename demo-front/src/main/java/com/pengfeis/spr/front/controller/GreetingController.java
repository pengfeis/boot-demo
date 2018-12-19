package com.pengfeis.spr.front.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

/***
 * 打招呼的restful服务
 * @author pengfeisu
 */
@RestController
public class GreetingController {
    @RequestMapping("/hello")
    public String say(@RequestParam String name) {
        return "Hello " + Optional.ofNullable(name).orElse("Someone");
    }
}
