package cn.wzy.demo.service.impl;

import cn.wzy.demo.model.User;
import cn.wzy.demo.service.UserService;
import com.seewo.utils.annotation.Verify;
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
            SizeLimit = {"user.username [3,10]", "user.password [5, 10]", "users [0,20]"}
    )
    public String method1(User user, List<User> users, Date date, String name, Long time) {
        System.out.println("AOP参数校验完成:" + (System.currentTimeMillis() - time) + "ms");
        long start = System.currentTimeMillis();
        if (user == null || date == null || time == null) {
            throw new IllegalArgumentException("参数不能为NULL");
        }
        if (user.getUsername() == null || user.getUsername().trim().equals("") ||
                name == null || name.trim().equals("")) {
            throw new IllegalArgumentException("参数不能为NULL");
        }
        if (!(user.getUsername().length() <= 10 && user.getUsername().length() >= 3)) {
            throw new IllegalArgumentException("长度不合法");
        }
        if (!(user.getPassword().length() <= 10 && user.getPassword().length() >= 5)) {
            throw new IllegalArgumentException("长度不合法");
        }
        if (!(users.size() <= 20 && users.size() >= 0)) {
            throw new IllegalArgumentException("长度不合法");
        }
        System.out.println("代码参数校验完成:" + (System.currentTimeMillis() - start) + "ms");
        return "SUCCESS";
    }
}
