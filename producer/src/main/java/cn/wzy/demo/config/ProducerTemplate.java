package cn.wzy.demo.config;

import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.common.RemotingHelper;
import org.apache.rocketmq.remoting.exception.RemotingException;

import java.io.UnsupportedEncodingException;



public class ProducerTemplate extends DefaultMQProducer {


  public ProducerTemplate(String name) {
    super(name);
  }

  public void send(String topic, String tag, Object data) {
    try {
      Message msg = new Message(topic, tag, data.toString().getBytes(RemotingHelper.DEFAULT_CHARSET));
      super.send(msg);
    } catch (UnsupportedEncodingException e) {
      e.printStackTrace();
    } catch (MQClientException e) {
      e.printStackTrace();
    } catch (InterruptedException e) {
      e.printStackTrace();
    } catch (RemotingException e) {
      e.printStackTrace();
    } catch (MQBrokerException e) {
      e.printStackTrace();
    }
  }
}
