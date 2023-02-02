package org.malred.service.impl;

import org.malred.dao.UserDao;
import org.malred.pojo.User;
import org.malred.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DemoServiceImpl implements DemoService {
    @Autowired
    private UserDao userDao;

    // @Cacheable ->　将该方法查询结果存放在springboot默认缓存中
    // cacheNames -> 起一个缓存命名空间,对应缓存唯一标识
    // springboot缓存的map结构 ->
    //      value: 缓存结果;
    //      key: 默认只有一个参数情况下,key值就是方法参数值,如果没有参数或多个参数,会自动生成(simpleKeyGenerate类)
    @Cacheable(
            cacheNames = "user",
            // 如果结果为空就不缓存
            unless = "#result==null"
    )
    @Override
    public List<User> findAll() {
        return userDao.findAll();
    }

    @Cacheable(
            cacheNames = "user",
            // 如果结果为空就不缓存
            unless = "#result==null"
    )
    @Override
    public User findById(Long id) {
        return userDao.findById(id).get();
    }

    // 更新方法,会把变更同步到缓存
    @CachePut(
            cacheNames = "user",
            // 将修改结果的id作为缓存的key
            key = "#result.id"
    )
    @Override
    public User save(User user) {
        return userDao.save(user);
    }

    // 删除方法,会删除缓存
    @Override
    @CacheEvict(
            cacheNames = "user"
    )
    public void delete(Long id) {
        userDao.deleteById(id);
    }
}
