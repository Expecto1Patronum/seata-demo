package com.narcos.seata.demo.at.sample.rm2.server.controller;

import com.narcos.seata.demo.at.sample.rm2.server.service.RmService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author hbj
 * @date 2021/1/14 5:08 下午
 */
@Slf4j
@RestController
@RequestMapping(value = "/api/test")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class RmController {

    private final RmService rmService;

    @PostMapping
    public String testC(@RequestParam("id") Long id) {
        rmService.rmOperation(id);
        return "success";
    }
}
