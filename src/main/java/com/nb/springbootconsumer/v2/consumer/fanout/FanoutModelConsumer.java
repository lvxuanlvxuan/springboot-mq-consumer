package com.nb.springbootconsumer.v2.consumer.fanout;

import com.nb.springbootconsumer.vo.OrderVO;
import com.nb.springbootrabbitmq.v2.constance.FanoutModelConstance;
import com.rabbitmq.client.Channel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @Author: lvxuan
 * @program:
 * @Date: 2022/7/3 10:58
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
public class FanoutModelConsumer {

    @RabbitListener(queues = FanoutModelConstance.FANOUT_MODEL_QUEUE)
    public void recieveMessageFirst(OrderVO vo,
                                    Message message,
                                    Channel channel) {
        log.info("fanout_model_queue接收到消息：{}", vo);
    }

    @RabbitListener(queues = FanoutModelConstance.FANOUT_MODEL_QUEUE_SECOND)
    public void recieveMessageSecond(OrderVO vo,
                                     Message message,
                                     Channel channel) {
        log.info("fanout_model_queue_second接收到消息，{}", vo);
    }
}
