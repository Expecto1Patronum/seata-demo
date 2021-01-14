package com.narcos.seata.demo.at.sample.tm.server.repository;

import com.narcos.seata.demo.at.sample.tm.server.entity.AtTestTmPO;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author hbj
 * @date 2021/1/14 4:40 下午
 */
public interface AtTestTmRepository extends JpaRepository<AtTestTmPO, Long> {
}
