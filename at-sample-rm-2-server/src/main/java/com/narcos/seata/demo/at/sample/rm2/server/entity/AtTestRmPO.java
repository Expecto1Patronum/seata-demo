package com.narcos.seata.demo.at.sample.rm2.server.entity;

import lombok.Data;

import javax.persistence.*;

/**
 * @author hbj
 * @date 2021/1/14 4:38 下午
 */
@Data
@Entity
@Table(name = "at_test_rm_1")
public class AtTestRmPO {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, unique = true, columnDefinition = "bigint(20) COMMENT '主键'")
    private Long id;
    @Column(nullable = false, columnDefinition = "bigint(20) COMMENT '可用数量'")
    private Integer num;
    @Column(nullable = false, columnDefinition = "bigint(20) COMMENT '锁定数量'")
    private Integer lockNum;
}
