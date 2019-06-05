package cn.wzy.demo.controller;

import cn.wzy.demo.service.DemoService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class TestController {

  @Resource
  private DemoService demoServiceImpl1;

    @RequestMapping("/send")
    public String send() {
        return "ok";
    }
}
