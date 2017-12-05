package com.pengfeis.spr.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pengfeis.spr.domain.RealOrder;
import com.pengfeis.spr.mapper.RealOrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

/**
 * @author supengfei
 */
@RestController
@RequestMapping("/demo")
public class DemoController {

    @Autowired
    private RealOrderMapper realOrderMapper;

    @Autowired
    private StringRedisTemplate template;

    private ObjectMapper om = new ObjectMapper();

    @ResponseBody
    @RequestMapping("/hello")
    public String greeting(String name) {
        return "Greeting " + name;
    }

    @ResponseBody
    @RequestMapping("/peek")
    public String peekDb(Long id) {
        try {
            List<RealOrder> result = realOrderMapper.getAllRealOrders();
            return om.writeValueAsString(result);
        } catch (JsonProcessingException e) {
            return "Error!";
        }
    }

    @RequestMapping("/save")
    public String saveOrder(@RequestBody RealOrder realOrder) {
        try {
            realOrder.setCreateDate(new Date());
            realOrder.setUpdateDate(new Date());
            Integer saved = realOrderMapper.insertRealOrder(realOrder);
            System.out.println(saved);
            return om.writeValueAsString(realOrder);
        } catch (JsonProcessingException e) {
            return "Error" + e.getMessage();
        }
    }

    @RequestMapping("/redis/set/{key}/{val}")
    public String redisSet(@PathVariable String key, @PathVariable String val) {
        try {
            ValueOperations<String, String> vo = this.template.opsForValue();
            vo.set(key, val);
        } catch (Exception e) {
            return "set failed";
        }
        return "su";
    }

    @RequestMapping("/redis/get/{key}")
    public String redisGet(@PathVariable String key) {
        try {
            ValueOperations<String, String> vo = this.template.opsForValue();
            return vo.get(key);
        } catch (Exception e) {
            return "get failed";
        }
    }

}
