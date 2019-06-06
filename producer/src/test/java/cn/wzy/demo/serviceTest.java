package cn.wzy.demo;

import cn.wzy.demo.model.User;
import cn.wzy.demo.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

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

    @Autowired
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
    public void test4() throws InterruptedException {
        User user = new User();
        user.setPassword("pwd222");
        user.setUsername("wzy");
        for (int i = 0; i < 1001; i++) {
//            Thread.sleep(500);
            System.out.println(userServiceImpl.method1(
                    user,
                    Arrays.asList(null, null, null),
                    new Date(),
                    "username",
                    System.currentTimeMillis()));
        }
    }
}
