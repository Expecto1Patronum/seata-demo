package com.narcos.seata.demo.at.sample.tm.server.service.impl;

import com.narcos.seata.demo.at.sample.tm.server.entity.AtTestTmPO;
import com.narcos.seata.demo.at.sample.tm.server.repository.AtTestTmRepository;
import com.narcos.seata.demo.at.sample.tm.server.service.AtTransactionService;
import com.narcos.seata.demo.at.sample.tm.server.spi.Rm1Spi;
import io.seata.core.context.RootContext;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author hbj
 * @date 2021/1/14 4:49 下午
 */
@Slf4j
@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class AtTransactionServiceImpl implements AtTransactionService {
    private final AtTestTmRepository atTestTmRepository;
    private final Rm1Spi rm1Spi;

    @Override
    @GlobalTransactional(timeoutMills = 300000, name = "at-transaction-test", rollbackFor = Exception.class)
    public boolean beginTransaction() {
        AtTestTmPO test = new AtTestTmPO();
        test.setXid(RootContext.getXID());
        atTestTmRepository.save(test);
        rm1Spi.rm1Operation(1L);
        return true;
    }
}
