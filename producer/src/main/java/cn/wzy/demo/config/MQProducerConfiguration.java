package cn.wzy.demo.config;

import org.apache.rocketmq.client.exception.MQClientException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.Bean;

//@SpringBootConfiguration
public class MQProducerConfiguration {
  /**
   * 发送同一类消息的设置为同一个group，保证唯一,默认不需要设置，rocketmq会使用ip@pid(pid代表jvm名字)作为唯一标示
   */
  @Value("${rocketmq.producer.groupName}")
  private String groupName;
  @Value("${rocketmq.producer.namesrvAddr}")
  private String namesrvAddr;
  /**
   * 消息最大大小，默认4M
   */
  @Value("${rocketmq.producer.maxMessageSize}")
  private Integer maxMessageSize;
  /**
   * 消息发送超时时间，默认3秒
   */
  @Value("${rocketmq.producer.sendMsgTimeout}")
  private Integer sendMsgTimeout;
  /**
   * 消息发送失败重试次数，默认2次
   */
  @Value("${rocketmq.producer.retryTimesWhenSendFailed}")
  private Integer retryTimesWhenSendFailed;

  @Bean
  public ProducerTemplate getRocketMQProducer() {
    ProducerTemplate producer;
    producer = new ProducerTemplate(this.groupName);
    producer.setNamesrvAddr(this.namesrvAddr);
    if (this.maxMessageSize != null) {
      producer.setMaxMessageSize(this.maxMessageSize);
    }
    if (this.sendMsgTimeout != null) {
      producer.setSendMsgTimeout(this.sendMsgTimeout);
    }
    if (this.retryTimesWhenSendFailed != null) {
      producer.setRetryTimesWhenSendFailed(this.retryTimesWhenSendFailed);
    }
    try {
      producer.start();
    } catch (MQClientException e) {
      e.printStackTrace();
    }
    return producer;
  }
}