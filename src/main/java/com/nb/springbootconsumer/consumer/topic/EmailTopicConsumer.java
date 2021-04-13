package com.nb.springbootconsumer.consumer.topic;

import cn.hutool.core.util.StrUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

/**
 * @Author: nb
 * @Date: 2021/3/21 20:58
 * @Version 1.0
 */
@Slf4j
@Component
@RabbitListener(bindings = @QueueBinding(
        value = @Queue(value = "topic.queue.email",durable = "true",autoDelete = "false"),
        exchange = @Exchange(value = "topic_order_exchange",type = ExchangeTypes.TOPIC,ignoreDeclarationExceptions = "true"),
        key = "topic.order.exchange.email.*"
))
public class EmailTopicConsumer {

    @RabbitHandler
    public void recieveMessage(@Payload byte[] msgBytes){
        String message=new String(msgBytes);
        if(StrUtil.isNotEmpty(message)){
            JSONObject jsonObject = JSON.parseObject(message);
            log.info("topic 模式下email服务接收到一条消息：{}",jsonObject);
        }
    }

}
