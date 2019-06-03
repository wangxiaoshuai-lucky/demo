package cn.wzy.demo.config;

import cn.wzy.demo.Interceptor.DubboTagInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @ClassName MvcConfiguration
 * @Author WangZY
 * @Date 2019/6/3 14:25
 * @Version 1.0
 **/
@Configuration
public class MvcConfiguration implements WebMvcConfigurer {


  @Override
  public void addInterceptors(InterceptorRegistry registry) {
    registry.addInterceptor(new DubboTagInterceptor()).addPathPatterns("/**");
  }
}
