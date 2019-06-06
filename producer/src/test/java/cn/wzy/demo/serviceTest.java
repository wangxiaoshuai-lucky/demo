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
import java.util.regex.Pattern;

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


    public static void main(String[] args) {
        System.out.println(Pattern.matches("[a-zA-Z0-9]{5,20}$", "***999"));
    }

    @Test
    public void test1() {
        User user = new User();
        user.setPassword("pwd222");
        user.setUsername("wzy22");
        System.out.println(userServiceImpl.method1(
                user,
                Arrays.asList(null, null, null),
                new Date(),
                "***999",
                System.currentTimeMillis(),
                12,
                166.3));
    }

}
