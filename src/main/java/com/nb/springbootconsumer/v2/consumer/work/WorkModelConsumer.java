package com.nb.springbootconsumer.v2.consumer.work;

import com.nb.springbootrabbitmq.v2.constance.WorkModelConstance;
import com.nb.springbootrabbitmq.vo.OrderVO;
import com.rabbitmq.client.Channel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * @Author: lvxuan
 * @program:
 * @Date: 2022/7/1 16:58
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
public class WorkModelConsumer {

    @RabbitListener(queues = WorkModelConstance.WORK_MODEL_QUEUE)
    public void recieveMessageFirst(OrderVO vo,
                                    Message message,
                                    Channel channel) throws IOException {
        /**
         * channel.basicQos(1); 消费完一条再取一条
         * 如果没写这个则默认所有消费者均分消息
         */
        channel.basicQos(1);
        log.info("work_model_queue_1接收到消息：{}", vo);
    }

    @RabbitListener(queues = WorkModelConstance.WORK_MODEL_QUEUE)
    public void recieveMessageSecond(OrderVO vo,
                                     Message message,
                                     Channel channel) throws IOException {
        channel.basicQos(1);
        log.info("work_model_queue_2接收到消息：{}", vo);
    }

    @RabbitListener(queues = WorkModelConstance.WORK_MODEL_QUEUE)
    public void recieveMessageThird(OrderVO vo,
                                    Message message,
                                    Channel channel) throws IOException {
        channel.basicQos(1);
        log.info("work_model_queue_3接收到消息：{}", vo);
    }
}
