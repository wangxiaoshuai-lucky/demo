package cn.wzy.demo.Interceptor;

import org.apache.dubbo.common.Constants;
import org.apache.dubbo.rpc.RpcContext;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @ClassName DubboTagInterceptor
 * @Author WangZY
 * @Date 2019/6/3 14:22
 * @Version 1.0
 **/
public class DubboTagInterceptor implements HandlerInterceptor {
  @Override
  public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
    RpcContext.getContext().setAttachment(Constants.TAG_KEY,"service2");
    return true;
  }
}
