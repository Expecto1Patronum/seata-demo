package com.narcos.seata.demo.at.sample.tm.server.service.impl;

import com.narcos.seata.demo.at.sample.tm.api.TmApi;
import io.seata.core.context.RootContext;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.DubboService;

/**
 * @author hbj
 * @date 2021/1/14 5:15 下午
 */
@Slf4j
@DubboService
public class TmApiImpl implements TmApi {
    @Override
    public void checkXidReceive() {
        log.info("check spring cloud to dubbo xid :{}", RootContext.getXID());
    }
}
