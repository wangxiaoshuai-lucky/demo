package cn.wzy.demo.service.impl;

import cn.wzy.demo.model.User;
import cn.wzy.demo.service.DemoService;
import org.springframework.stereotype.Service;

@Service
public class DemoServiceImpl1 implements DemoService {
  @Override
  public String test(User user) {
    return "service1 :hello " + user.getUsername();
  }
}
