package cn.wzy.demo.controller;

import cn.wzy.demo.config.ProducerTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

  @Autowired
  private ProducerTemplate producer;

  @RequestMapping("/send")
  public String send() {
    producer.send("DemoTopic", "*", "hello");
    return "ok";
  }
}
