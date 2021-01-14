package com.narcos.seata.demo.at.sample.tm.server.controller;

import com.narcos.seata.demo.at.sample.tm.server.service.AtTransactionService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author hbj
 * @date 2021/1/14 5:08 下午
 */
@Slf4j
@RestController
@RequestMapping(value = "/api/test")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class TmController {
    private final AtTransactionService atTransactionService;

    @GetMapping
    public String test() {
        atTransactionService.beginTransaction();
        return "success";
    }
}
