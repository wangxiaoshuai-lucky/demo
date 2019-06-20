package cn.wzy.demo.controller;

import cn.wzy.demo.service.DemoService;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class TestController {

    @Resource
    private DemoService demoServiceImpl1;

    @RequestMapping("/send")
    @SentinelResource(value = "send", blockHandler = "exceptionHandler")
    public String send() {
        return "ok";
    }

    public String exceptionHandler(BlockException e) {
        e.printStackTrace();
        return "error";
    }
}
