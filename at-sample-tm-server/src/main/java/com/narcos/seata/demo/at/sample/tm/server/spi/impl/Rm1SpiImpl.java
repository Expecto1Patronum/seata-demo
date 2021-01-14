package com.narcos.seata.demo.at.sample.tm.server.spi.impl;

import com.narcos.seata.demo.at.sample.rm1.api.Rm1Api;
import com.narcos.seata.demo.at.sample.tm.server.spi.Rm1Spi;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.stereotype.Service;

/**
 * @author hbj
 * @date 2021/1/14 5:12 下午
 */
@Service
public class Rm1SpiImpl implements Rm1Spi {
    @DubboReference
    private Rm1Api rm1Api;

    @Override
    public void rm1Operation(Long id) {
        rm1Api.rmOperation(id);
    }
}
