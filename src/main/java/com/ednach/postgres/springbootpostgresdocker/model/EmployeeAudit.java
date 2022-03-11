package com.ednach.postgres.springbootpostgresdocker.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"created_at, updated_at"}, allowGetters = true)
public class EmployeeAudit {

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_at", nullable = false, updatable = false)
    @CreatedDate
    private Date createdAt;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "update_at", nullable = false)
    @LastModifiedDate
    private Date updateAt;

    @Column(name = "created_by", nullable = false)
    @CreatedBy
    private String createBy;

    @Column(name = "update_by", nullable = false)
    @LastModifiedBy
    private String updatedBy;


}
