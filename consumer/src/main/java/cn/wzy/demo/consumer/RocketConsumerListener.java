package cn.wzy.demo.consumer;

import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.common.message.MessageExt;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;
import java.util.List;

@Component
public class RocketConsumerListener implements MessageListenerConcurrently {

  @Override
  public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> list, ConsumeConcurrentlyContext consumeConcurrentlyContext) {
    System.out.println("消息长度：" + list.size());
    System.out.println("data:" + new String(list.get(0).getBody(), StandardCharsets.UTF_8));
    return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
  }
}
