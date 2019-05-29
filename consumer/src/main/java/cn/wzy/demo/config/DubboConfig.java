package cn.wzy.demo.config;


import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:application.properties")
@ImportResource({"classpath:dubbo/consumer.xml"})
public class DubboConfig {
}
