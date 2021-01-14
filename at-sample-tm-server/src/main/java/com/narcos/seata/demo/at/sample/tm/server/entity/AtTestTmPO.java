package com.narcos.seata.demo.at.sample.tm.server.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 * @author hbj
 * @date 2021/1/14 4:34 下午
 */
@Data
@Entity
@Table(name = "at_test_tm")
public class AtTestTmPO {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, unique = true, columnDefinition = "bigint(20) COMMENT '主键'")
    private Long id;
    @Column(nullable = false, columnDefinition = "varchar(100) COMMENT '当前分布式事务xid'")
    private String xid;
    @Column(nullable = false, columnDefinition = "datetime COMMENT '创建时间'")
    private Date createTime;
    @Column(nullable = false, columnDefinition = "datetime COMMENT '更新时间'")
    private Date updateTime;

    @PrePersist
    public void prePersist() {
        this.createTime = new Date();
        this.updateTime = new Date();
    }

    @PreUpdate
    public void preUpdate() {
        this.updateTime = new Date();
    }
}
