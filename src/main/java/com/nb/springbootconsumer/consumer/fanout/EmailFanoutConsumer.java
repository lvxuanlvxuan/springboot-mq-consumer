package com.nb.springbootconsumer.consumer.fanout;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

/**
 * @Author: nb
 * @Date: 2021/3/21 9:43
 * @Version 1.0
 */
@Slf4j
@Component
@RabbitListener(queues = "fanout.queue.email")
public class EmailFanoutConsumer {

    @RabbitHandler
    public void recieveMessgae(@Payload byte[] msgBytes){
        String message=new String(msgBytes);
        if(message!=null){
            JSONObject jsonObject = JSONObject.parseObject(message);
            log.info("邮件服务收到一条数据：{}",jsonObject);
        }
    }
}
