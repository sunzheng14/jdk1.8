package com.sun.rocketmq;

import java.util.List;

import com.alibaba.rocketmq.client.consumer.DefaultMQPushConsumer;
import com.alibaba.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import com.alibaba.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import com.alibaba.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import com.alibaba.rocketmq.client.exception.MQClientException;
import com.alibaba.rocketmq.common.message.MessageExt;

public class Consumer {
	public static void main(String[] args) throws MQClientException {
		DefaultMQPushConsumer consumer = new DefaultMQPushConsumer("rmq-group");
		consumer.setNamesrvAddr("100.76.121.204:9876");
        consumer.setInstanceName("rmq-instance");
        consumer.subscribe("TopicA-test", "tagA");
        
        consumer.registerMessageListener(new MessageListenerConcurrently() {
			@Override
			public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> msgs,
					ConsumeConcurrentlyContext context) {
				for(MessageExt msg : msgs){
					System.out.println(msg.getBody().toString());
				}
				return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
			}
		});
        
        
	}
}
