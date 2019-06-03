package cn.wzy.demo.filter;

import org.apache.dubbo.common.Constants;
import org.apache.dubbo.rpc.*;

/**
 * @ClassName TagFilter
 * @Author WangZY
 * @Date 2019/6/3 18:04
 * @Version 1.0
 **/
public class TagFilter implements Filter {
  @Override
  public Result invoke(Invoker<?> invoker, Invocation invocation) throws RpcException {
    RpcContext.getContext().setAttachment(Constants.TAG_KEY, "service2");
    return invoker.invoke(invocation);
  }
}
