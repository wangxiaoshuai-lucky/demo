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
        System.out.println("权限校验完成:" + (System.currentTimeMillis() - time) + "ms");
        return "SUCCESS";
    }
}
