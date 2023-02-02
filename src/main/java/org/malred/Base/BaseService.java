package org.malred.Base;

import org.malred.pojo.User;

import java.util.List;

/**
 * 基础service类,对应baseController的crud
 */
public interface BaseService<T> {
    /**
     * 查询表中所有数据
     * @return
     */
    List<T> findAll();
    /**
     * 根据id获取表中数据
     * @param id
     * @return
     */
    T findById(Long id);

    /**
     * 保存或更新(有id是更新,没id是保存)
     * @param t
     * @return
     */
    T save(T t);

    /**
     * 根据id删除表内数据
     * @param id
     */
    void delete(Long id);
}
