package org.malred.Base;

import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 通用controller,定义通用crud方法
 */
public abstract class BaseController<T>  {
    /**
     * 获取表中所有数据
     * @return
     */
    @GetMapping("/findAll")
    public abstract List<T> findAll();

    /**
     * 根据id获取表中数据
     * @param id
     * @return
     */
    @GetMapping("/find/{id}")
    public abstract T findById(@PathVariable Long id);

    /**
     * 插入数据(没有id字段)
     * @param t
     * @return
     */
    @PostMapping("/save")
    public abstract T insert(@RequestBody T t);

    /**
     * 修改数据(要有id字段)
     * @param t
     * @return
     */
    @PutMapping("/save")
    public abstract T update(@RequestBody T t);

    /**
     * 根据id删除数据
     * @param id
     */
    @DeleteMapping("/delete/{id}")
    public abstract void delete(@PathVariable Long id);
}
