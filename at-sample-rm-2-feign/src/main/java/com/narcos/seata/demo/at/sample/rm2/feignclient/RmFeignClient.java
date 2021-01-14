package com.narcos.seata.demo.at.sample.rm2.feignclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author hbj
 * @date 2021/1/14 5:05 下午
 */
@FeignClient("seata-demo-at-sample-rm2")
public interface RmFeignClient {
    @PostMapping("/api/test")
    @ResponseBody
    String test(@RequestParam("id") Long id);
}
