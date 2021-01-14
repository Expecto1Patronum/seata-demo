package com.narcos.seata.demo.at.sample.rm1.server.repository;

import com.narcos.seata.demo.at.sample.rm1.server.entity.AtTestRmPO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * @author hbj
 * @date 2021/1/14 4:41 下午
 */
public interface AtTestRmRepository extends JpaRepository<AtTestRmPO, Long> {
    @Modifying
    @Query("update AtTestRmPO rm set rm.lockNum = rm.lockNum + :num , rm.num = rm.num - :num where rm.id = :id")
    void lock(@Param(value = "id") Long id, @Param(value = "num") Integer num);
}
