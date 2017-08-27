package com.sun.rocketmq;

import java.util.Date;

import com.alibaba.rocketmq.client.exception.MQBrokerException;
import com.alibaba.rocketmq.client.exception.MQClientException;
import com.alibaba.rocketmq.client.producer.DefaultMQProducer;
import com.alibaba.rocketmq.client.producer.SendResult;
import com.alibaba.rocketmq.common.TopicConfig;
import com.alibaba.rocketmq.common.message.Message;
import com.alibaba.rocketmq.remoting.exception.RemotingException;

public class Producer {

	public static void main(String[] args) throws MQClientException {
		DefaultMQProducer producer = new DefaultMQProducer("rmq-group");
		producer.setNamesrvAddr("100.76.121.204:9876");
		producer.setInstanceName("rmq-instance");
		producer.createTopic("tagA", "TopicA-test", 4);
		try {
			producer.start();
		} catch (MQClientException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		TopicConfig config = new TopicConfig();
		/*config.setTopicName("TopicA-test");*/
		String topic = config.getTopicName();
		System.out.println(topic);
		
		for(int i = 0;i<3;i++){
				Message msg = new Message(
						topic,
						"tagA",
						"msg"+i,
						(new Date() + " Hello RocketMQ,QuickStart" + i).getBytes()
						);
				SendResult result;
				try {
					result = producer.send(msg);
					System.out.println(result.getMsgId() +"," + result.getSendStatus());
				} catch (MQClientException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (RemotingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (MQBrokerException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
		}
		
		producer.shutdown();
		
	}

}
