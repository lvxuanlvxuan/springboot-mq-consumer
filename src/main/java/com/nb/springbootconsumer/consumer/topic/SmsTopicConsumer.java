package com.nb.springbootconsumer.consumer.topic;

import com.alibaba.fastjson.JSON;
import com.nb.springbootconsumer.vo.OrderVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

/**
 * @Author: nb
 * @Date: 2021/3/21 20:41
 * @Version 1.0
 */
@Slf4j
@Component
public class SmsTopicConsumer {

    @RabbitListener(containerFactory = "SMS_CONTAINER_FACTORY",
            bindings = @QueueBinding(
            value = @Queue(value = "topic.queue.sms",durable = "true",autoDelete = "false"),
            exchange = @Exchange(value = "topic_order_exchange",type = ExchangeTypes.TOPIC,ignoreDeclarationExceptions = "true"),
            key = "topic.order.exchange.sms.*"
    ))
    public void recieveMessage(@Payload OrderVO orderVO){
        System.out.println(JSON.toJSONString(orderVO));

//        String message=new String(msgBytes);
//        if(message!=null){
//            JSONObject jsonObject = JSON.parseObject(message);
//            log.info("topic 模式下sms服务接收到一条消息：{}",jsonObject);
//        }
    }
}
