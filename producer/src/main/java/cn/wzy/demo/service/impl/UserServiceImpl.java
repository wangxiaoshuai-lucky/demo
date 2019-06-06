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
            notNull = {"user","users"},
            sizeLimit = {"user.username [3,10]", "users [1,20]"},
            regex = {"user.username=>^[a-zA-Z0-9]{5,20}$"},
            numberLimit = {"count [1, 9999]"}
    )
    public String method1(User user, List<User> users, Date date, String name, Long time, Integer count, Double price) {
        return "SUCCESS";
    }
}
