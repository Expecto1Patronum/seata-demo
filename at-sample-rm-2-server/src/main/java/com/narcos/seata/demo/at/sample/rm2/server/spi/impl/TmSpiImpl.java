package com.narcos.seata.demo.at.sample.rm2.server.spi.impl;

import com.narcos.seata.demo.at.sample.rm2.server.spi.TmSpi;
import com.narcos.seata.demo.at.sample.tm.api.TmApi;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.stereotype.Service;

/**
 * @author hbj
 * @date 2021/1/14 5:17 下午
 */
@Service
public class TmSpiImpl implements TmSpi {
    @DubboReference
    private TmApi tmApi;

    @Override
    public void testSendXid() {
        tmApi.checkXidReceive();
    }
}
