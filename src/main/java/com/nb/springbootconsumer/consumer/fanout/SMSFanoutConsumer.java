package com.nb.springbootconsumer.consumer.fanout;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.nb.springbootconsumer.vo.OrderVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

/**
 * @Author: nb
 * @Date: 2021/3/20 22:27
 * @Version 1.0
 */
@Slf4j
@Component
@RabbitListener(queues = "fanout.queue.sms")
public class SMSFanoutConsumer {

    @RabbitHandler
    public void recieveMessage(@Payload byte[] msgBytes) {
        String message = new String(msgBytes);
        if (message != null) {
            JSONObject jsonObject = JSONObject.parseObject(message);
            log.info("短信服务消费到一条数据：{}", jsonObject);
            OrderVO orderVO = JSON.toJavaObject(jsonObject, OrderVO.class);
        }
    }
}
