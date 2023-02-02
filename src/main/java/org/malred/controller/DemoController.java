package org.malred.controller;

import org.malred.Base.BaseController;
import org.malred.pojo.User;
import org.malred.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/demo")
public class DemoController extends BaseController<User> {
    @Autowired
    DemoService demoService;
    @Override
    public List<User> findAll() {
        return demoService.findAll();
    }
    @Override
    public User findById(@PathVariable Long id) {// 不加@PathVariable,获取不到id
        return demoService.findById(id);
    }
    @Override
    public User insert(@RequestBody User user) {// 不加@RequestBody,获取不到对象
        return demoService.save(user);
    }
    @Override
    public User update(@RequestBody User user) {
        return demoService.save(user);
    }
    @Override
    public void delete(@PathVariable Long id) {
        demoService.delete(id);
    }
}
