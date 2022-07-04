package com.nb.springbootconsumer.v2.config;

import com.nb.springbootrabbitmq.v2.constance.DirectModelConstance;
import org.springframework.amqp.core.AcknowledgeMode;
import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.boot.autoconfigure.amqp.SimpleRabbitListenerContainerFactoryConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

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
@Configuration
public class DirectModelConfig {

    @Bean(DirectModelConstance.DIRECT_MODEL_CONTAINER_FACTORY)
    public SimpleRabbitListenerContainerFactory getSimpleRabbitListenerContainerFactory(SimpleRabbitListenerContainerFactoryConfigurer configurer,
                                                                                        ConnectionFactory connectionFactory) {
        SimpleRabbitListenerContainerFactory factory = new SimpleRabbitListenerContainerFactory();
        /**
         * 消费者数量类似核心线程数
         */

        /**
         * 一个消费者一次最多接收的消息数量
         */
        factory.setPrefetchCount(100);
        /**
         * 设置消息手动确认
         * MANUAL:需要手动进行确认，如遇到异常会重新入队消息状态为unack一直堆积
         * NONE:不做确认操作
         * AUTO:若无异常则自动签收，有异常则会不断的入队
         */
        factory.setAcknowledgeMode(AcknowledgeMode.AUTO);
        configurer.configure(factory, connectionFactory);
        return factory;
    }
}
