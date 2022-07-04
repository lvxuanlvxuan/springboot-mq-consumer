package com.nb.springbootconsumer.v2.consumer.direct;

import com.nb.springbootconsumer.vo.OrderVO;
import com.nb.springbootrabbitmq.v2.constance.DirectModelConstance;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
import com.rabbitmq.client.Channel;

import java.io.IOException;


/**
 * @Author: lvxuan
 * @program:
 * @Date: 2022/7/4 21:38
 * @Version: 1.0
 * @motto: 而后乃将图南
 * @Description: des
 * ░░░░░░░░░░░░░░░░░░░░░░░░▄░░
 * ░░░░░░░░░▐█░░░░░░░░░░░▄▀▒▌░
 * ░░░░░░░░▐▀▒█░░░░░░░░▄▀▒▒▒▐
 * ░░░░░░░▐▄▀▒▒▀▀▀▀▄▄▄▀▒▒▒▒▒▐
 * ░░░░░▄▄▀▒░▒▒▒▒▒▒▒▒▒█▒▒▄█▒▐
 * ░░░▄▀▒▒▒░░░▒▒▒░░░▒▒▒▀██▀▒▌
 * ░░▐▒▒▒▄▄▒▒▒▒░░░▒▒▒▒▒▒▒▀▄▒▒
 * ░░▌░░▌█▀▒▒▒▒▒▄▀█▄▒▒▒▒▒▒▒█▒▐
 * ░▐░░░▒▒▒▒▒▒▒▒▌██▀▒▒░░░▒▒▒▀▄
 * ░▌░▒▄██▄▒▒▒▒▒▒▒▒▒░░░░░░▒▒▒▒
 * ▀▒▀▐▄█▄█▌▄░▀▒▒░░░░░░░░░░▒▒▒
 * You are not expected to understand this
 */
@Slf4j
@Component
public class DirectModelConsumer {

    @RabbitListener(containerFactory = DirectModelConstance.DIRECT_MODEL_CONTAINER_FACTORY,
            bindings = @QueueBinding(
                    value = @Queue(value = DirectModelConstance.DIRECT_MODEL_QUEUE, durable = "true", autoDelete = "false"),
                    exchange = @Exchange(value = DirectModelConstance.DIRECT_MODEL_EXCHANGE, type = ExchangeTypes.DIRECT, durable = "true", autoDelete = "false", ignoreDeclarationExceptions = "true"),
                    key = DirectModelConstance.DIRECT_MODEL_KEY
            ))
    public void recieveMessage(OrderVO vo,
                               Message message,
                               Channel channel) throws IOException {
        log.info("【direct_model_queue接收到一条消息】:{}", vo);

        int i = 11;
        if (i > 10) {
            /**
             * 消息id
             * 是否批量确认（确认之前堆积的消息）
             */
            int a = i / 0;
//            channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
        } else {

            /**
             * basicNack与basicReject都可以实现不确认消息的功能，但是basicNack比basicReject多了批量操作的功能
             * 二者在遇到异常的情况下不起作用
             */
            /**
             * 消息id
             * 是否批量nack
             * 是否重新入队
             */
//            channel.basicNack(message.getMessageProperties().getDeliveryTag(), false, true);
            /**
             * 消息id
             * 是否重新入队
             */
            channel.basicReject(message.getMessageProperties().getDeliveryTag(), false);
        }


    }
}
