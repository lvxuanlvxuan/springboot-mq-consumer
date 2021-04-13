package com.nb.springbootconsumer.consumer.direct;

import cn.hutool.core.util.ObjectUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

/**
 * @Author: nb
 * @Date: 2021/4/11 22:19
 * @Version 1.0
 */
@Slf4j
@Component
//@RabbitListener(queuesToDeclare = @Queue("direct.queue.test"))
@RabbitListener(queues = "direct.queue.test")
public class TestDirectConsumer {


    @RabbitHandler
    public void recieveMessage(@Payload byte[] msg){
        String message=new String(msg);
        if(ObjectUtil.isNotEmpty(message)){
            log.info("test队列收到一条消息！:{}",message);

        }
    }
}
