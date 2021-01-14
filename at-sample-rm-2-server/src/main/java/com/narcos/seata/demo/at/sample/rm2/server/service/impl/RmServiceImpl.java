package com.narcos.seata.demo.at.sample.rm2.server.service.impl;

import com.narcos.seata.demo.at.sample.rm2.server.repository.AtTestRmRepository;
import com.narcos.seata.demo.at.sample.rm2.server.service.RmService;
import com.narcos.seata.demo.at.sample.rm2.server.spi.TmSpi;
import io.seata.core.context.RootContext;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author hbj
 * @date 2021/1/14 5:07 下午
 */
@Slf4j
@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class RmServiceImpl implements RmService {
    private final AtTestRmRepository atTestRmRepository;
    private final TmSpi tmSpi;

    @Override
    public void rmOperation(Long id) {
        log.info("rm2 receive xid:{}", RootContext.getXID());
        atTestRmRepository.lock(id, 1);
        tmSpi.testSendXid();
    }
}
