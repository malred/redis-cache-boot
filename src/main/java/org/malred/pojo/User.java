package org.malred.pojo;

import lombok.Data;
import org.malred.Base.BaseEntity;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * 测试用实体类
 */
@Data
@Entity
@Table(name = "user")
// 要使用非默认缓存方式,需要实现序列号接口!
public class User extends BaseEntity<Long> implements Serializable {
    private String name;
    private String password;
    private String address;
    private String phone;

    // 需要重写tostring,包含上父类的属性
    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", createTime='" + createTime + '\'' +
                ", updateTime='" + updateTime + '\'' +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
