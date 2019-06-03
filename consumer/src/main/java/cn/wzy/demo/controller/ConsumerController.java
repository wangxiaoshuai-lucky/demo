package cn.wzy.demo.controller;


import cn.wzy.demo.model.User;
import cn.wzy.demo.service.DemoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class ConsumerController {

  @Resource
  private DemoService service;


  @GetMapping("/test.do")
  public String test(User user){
    String res =  service.test(user);
    return res;
  }
}
