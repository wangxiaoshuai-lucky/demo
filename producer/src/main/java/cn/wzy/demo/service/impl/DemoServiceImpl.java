package cn.wzy.demo.service.impl;

import cn.wzy.demo.service.DemoService;
import org.springframework.stereotype.Service;

@Service
public class DemoServiceImpl implements DemoService {
  @Override
  public String test(String name) {
    return "hello " + name;
  }
}
