package cn.wzy.demo;

import cn.wzy.demo.model.User;
import cn.wzy.demo.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.Date;

/**
 * @ClassName serviceTest
 * @Author WangZY
 * @Date 2019/6/5 9:47
 * @Version 1.0
 **/
@SpringBootTest
@RunWith(SpringRunner.class)
public class serviceTest {

    @Resource
    private UserService userServiceImpl;


    @Test
    public void test1() {
        User user = new User();
        user.setPassword("pwd222");
        user.setUsername("wzy22");
        System.out.println(userServiceImpl.method1(
                user,
                null,
                new Date(),
                "username",
                System.currentTimeMillis()));
    }

    @Test
    public void test2() {
        User user = new User();
        user.setPassword("pwd");
        user.setUsername("wzy");
        System.out.println(userServiceImpl.method1(
                user,
                Arrays.asList(null, null, null),
                new Date(),
                "username",
                System.currentTimeMillis()));
    }

    @Test
    public void test3() {
        User user = new User();
        user.setPassword("pwd222");
        user.setUsername("");
        System.out.println(userServiceImpl.method1(
                user,
                Arrays.asList(null, null, null),
                new Date(),
                "username",
                System.currentTimeMillis()));
    }

    @Test
    public void test4() {
        User user = new User();
        user.setPassword("pwd222");
        user.setUsername("wzy");
        userServiceImpl.method1(
                user,
                Arrays.asList(null, null, null),
                new Date(),
                "username",
                System.currentTimeMillis());
        for (int i = 0; i < 20; i++) {
            System.out.println(userServiceImpl.method1(
                    user,
                    Arrays.asList(null, null, null),
                    new Date(),
                    "username",
                    System.currentTimeMillis()));
        }
    }
}
