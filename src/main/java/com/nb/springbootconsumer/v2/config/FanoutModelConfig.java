package com.nb.springbootconsumer.v2.config;

import com.nb.springbootrabbitmq.v2.constance.FanoutModelConstance;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: lvxuan
 * @program:
 * @Date: 2022/7/3 15:47
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
@Configuration
public class FanoutModelConfig {

    @Bean
    public Queue fanoutModelQueue() {
        /**
         * 1.队列
         * 2.是否持久化数据
         * 3.是否排他
         * 4.是否自动删除
         */
        return new Queue(FanoutModelConstance.FANOUT_MODEL_QUEUE, true, false, false);
    }

    @Bean
    public Queue fanoutModelQueueSecond() {
        /**
         * 1.队列
         * 2.是否持久化数据
         * 3.是否排他
         * 4.是否自动删除
         */
        return new Queue(FanoutModelConstance.FANOUT_MODEL_QUEUE_SECOND, true, false, false);
    }

    @Bean
    public FanoutExchange fanoutModelExchange() {
        /**
         * 1.交换机
         * 2.是否持久化
         * 3.是否自动删除
         */
        return new FanoutExchange(FanoutModelConstance.FANOUT_MODEL_EXCHANGE, true, false);
    }

    @Bean
    public Binding fanoutModelBinding() {
        return BindingBuilder.bind(fanoutModelQueue()).to(fanoutModelExchange());
    }

    @Bean
    public Binding fanoutModelBindingSecond() {
        return BindingBuilder.bind(fanoutModelQueueSecond()).to(fanoutModelExchange());
    }
}
