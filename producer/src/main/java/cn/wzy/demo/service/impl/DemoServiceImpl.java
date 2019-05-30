package cn.wzy.demo.service.impl;

import cn.wzy.demo.service.DemoService;
import org.springframework.stereotype.Service;

@Service
public class DemoServiceImpl implements DemoService {
  @Override
  public String test(String name) {
    System.out.println("收到请求，name：" + name);
    return "hello " + name;
  }
}
