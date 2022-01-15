package com.nb.springbootconsumer.consumer.direct;

import cn.hutool.core.util.ObjectUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

/**
 * @Author: nb
 * @Date: 2021/4/11 13:54
 * @Version 1.0
 */
@Slf4j
@Component
//@RabbitListener(queuesToDeclare = @Queue("direct.queue.ttl"))
@RabbitListener(queues = "direct.queue.ttl")
public class TtlDirectConsumer {

    @RabbitHandler
    public void recieveMessage(@Payload byte[] msgBytes){
        String message=new String(msgBytes);
        if (ObjectUtil.isNotEmpty(message)){
            JSONObject jsonObject = JSON.parseObject(message);
            log.info("ttl队列接收到一条消息：{}",jsonObject);
        }
    }
}
