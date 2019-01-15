package com.example.demo;

import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Date;

@Component
//@RabbitListener(queues = "helloObj")
public class HelloObjectReceiver {

    @RabbitHandler
    public void process(MessageObj hello,Channel channel, Message message) throws IOException {
        System.out.println("HelloObjectReceiver收到  : " + hello.toString() +"收到时间"+new Date());
        try {
            //告诉服务器收到这条消息 已经被我消费了 可以在队列删掉 这样以后就不会再发了 否则消息服务器以为这条消息没处理掉 后续还会在发
            int i=1/0;
            channel.basicAck(message.getMessageProperties().getDeliveryTag(),true);
            System.out.println("HelloObjectReceiver 确认回执 success");
        } catch (Exception e) {
            e.printStackTrace();
            //丢弃这条消息
            channel.basicNack(message.getMessageProperties().getDeliveryTag(), false,false);
            System.out.println("HelloObjectReceiver 确认回执 fild");
        }

    }
}