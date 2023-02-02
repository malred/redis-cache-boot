package org.malred.Base;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;
import java.util.Date;

/**
 * 基础实体类
 * T是主键的数据类型(Long?String?)
 */
@Data
@MappedSuperclass // 表示是实体类的父类,jpa会识别子类里的父类属性,作为表字段
public class BaseEntity<T extends Serializable>{
    /**
     * 主键
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public T id;
    /**
     * 创建时间
     */
    @CreationTimestamp
    public Date createTime;
    /**
     * 更新时间
     */
    @UpdateTimestamp
    public Date updateTime;
}
