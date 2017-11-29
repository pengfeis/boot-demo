package com.pengfeis.spr.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author supengfei
 */
@Controller
@RequestMapping("/demo")
public class DemoController {
    @ResponseBody
    @RequestMapping("/hello")
    public String greeting(String name) {
        return "Greeting " + name;
    }
}
