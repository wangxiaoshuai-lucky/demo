package cn.wzy.demo.service;

import cn.wzy.demo.model.User;

import java.util.Date;
import java.util.List;

/**
 * @ClassName UserService
 * @Author WangZY
 * @Date 2019/6/5 11:43
 * @Version 1.0
 **/
public interface UserService {

    String method1(User user, List<User> users, Date date, String name, Long time);
}
