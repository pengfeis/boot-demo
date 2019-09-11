package com.pengfeis.spr.front.controller;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.web.bind.annotation.PathVariable;
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
    @RequestMapping("/hello/{name}/{mobile}/{idNum}")
    public SayResp threeMajorInfo(@PathVariable("name") String name,
                                  @PathVariable("mobile") String mobile,
                                  @PathVariable("idNum") String idNum) {
        return new SayResp(1, mobile + ":" + idNum, "Greeting " + name);
    }


    @Getter
    @Setter
    @ToString
    static class SayResp {

        public SayResp(Integer resultCode, String resultMsg, Object data) {
            this.resultCode = resultCode;
            this.resultMsg = resultMsg;
            this.data = data;
        }

        private Integer resultCode;
        private String resultMsg;
        private Object data;
    }
}
