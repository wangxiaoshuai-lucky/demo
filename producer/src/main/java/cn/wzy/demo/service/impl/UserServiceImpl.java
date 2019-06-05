package cn.wzy.demo.service.impl;

import cn.wzy.demo.aspect.annotation.Verify;
import cn.wzy.demo.model.User;
import cn.wzy.demo.service.UserService;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @ClassName UserServiceImpl
 * @Author WangZY
 * @Date 2019/6/5 11:43
 * @Version 1.0
 **/
@Service
public class UserServiceImpl implements UserService {


    @Override
    @Verify(
            NotNull = {"user", "user.username", "date", "name", "time"},
            SizeLimit = {"user.username [3,10]", "user.password [5, 10]", "userss [0, 10]"}
    )
    public String method1(User user, List<User> users, Date date, String name, Integer time) {
        return "SUCCESS";
    }
}
