package com.nb.springbootconsumer.consumer.direct;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.rabbitmq.client.Channel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * @Author: nb
 * @Date: 2021/3/21 12:09
 * @Version 1.0
 */
@Slf4j
@Component
@RabbitListener(queues = "direct.queue.sms")
public class SmsDirectConsumer {



    @RabbitHandler
    public void recieveMessage(@Payload byte[] msgBytes,
                               Channel channel,
                               Message message) throws IOException {
        String msg=new String(msgBytes);
        if(msg!=null){
            try {
                JSONObject jsonObject = JSON.parseObject(msg);
                log.info("direct模式下短信服务消费一条数据：{}",jsonObject);
                int a=1/0;
                channel.basicAck(message.getMessageProperties().getDeliveryTag(),false);
            } catch (Exception e) {
                if(message.getMessageProperties().getRedelivered()){
                    log.error("sms消息已重复消费失败，拒绝重新入队！");
                    channel.basicReject(message.getMessageProperties().getDeliveryTag(),false);
                }else {
                    log.info("sms消息处理失败，将再次放入队列！");
                    channel.basicNack(message.getMessageProperties().getDeliveryTag(),false,true);
                }
            }
        }
    }
}
