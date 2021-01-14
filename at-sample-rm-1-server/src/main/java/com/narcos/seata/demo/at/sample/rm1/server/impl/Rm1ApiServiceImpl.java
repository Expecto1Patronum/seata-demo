package com.narcos.seata.demo.at.sample.rm1.server.impl;

import com.narcos.seata.demo.at.sample.rm1.api.Rm1Api;
import com.narcos.seata.demo.at.sample.rm1.server.repository.AtTestRmRepository;
import com.narcos.seata.demo.at.sample.rm2.feignclient.RmFeignClient;
import io.seata.core.context.RootContext;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author hbj
 * @date 2021/1/14 4:57 下午
 */
@Slf4j
@DubboService
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class Rm1ApiServiceImpl implements Rm1Api {
    private final AtTestRmRepository atTestRmRepository;
    private final RmFeignClient rmFeignClient;

    @Override
    public void rmOperation(Long id) {
        log.info("rm1 receive xid:{}", RootContext.getXID());
        atTestRmRepository.lock(id, 1);
        String result = rmFeignClient.test(id);
        log.info("rm2 result:{}", result);
    }
}
