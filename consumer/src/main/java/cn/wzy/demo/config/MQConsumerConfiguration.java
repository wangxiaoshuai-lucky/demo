package cn.wzy.demo.config;

import cn.wzy.demo.consumer.RocketConsumerListener;
import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.common.consumer.ConsumeFromWhere;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.Bean;

@SpringBootConfiguration
public class MQConsumerConfiguration {
  @Value("${rocketmq.consumer.namesrvAddr}")
  private String namesrvAddr;
  @Value("${rocketmq.consumer.groupName}")
  private String groupName;
  @Value("${rocketmq.consumer.consumeThreadMin}")
  private int consumeThreadMin;
  @Value("${rocketmq.consumer.consumeThreadMax}")
  private int consumeThreadMax;
  @Value("${rocketmq.consumer.topics}")
  private String topics;
  @Value("${rocketmq.consumer.consumeMessageBatchMaxSize}")
  private int consumeMessageBatchMaxSize;
  @Autowired
  private RocketConsumerListener mqMessageListenerProcessor;

  @Bean
  public DefaultMQPushConsumer getRocketMQConsumer() {
    DefaultMQPushConsumer consumer = new DefaultMQPushConsumer(groupName);
    consumer.setNamesrvAddr(namesrvAddr);
    consumer.setConsumeThreadMin(consumeThreadMin);
    consumer.setConsumeThreadMax(consumeThreadMax);
    consumer.registerMessageListener(mqMessageListenerProcessor);
    consumer.setConsumeFromWhere(ConsumeFromWhere.CONSUME_FROM_LAST_OFFSET);
    consumer.setConsumeMessageBatchMaxSize(consumeMessageBatchMaxSize);
    try {
      String[] topicTagsArr = topics.split(";");
      for (String topicTags : topicTagsArr) {
        String[] topicTag = topicTags.split("~");
        consumer.subscribe(topicTag[0], topicTag[1]);
      }
      consumer.start();
    } catch (MQClientException e) {
      e.printStackTrace();
    }
    return consumer;
  }
}