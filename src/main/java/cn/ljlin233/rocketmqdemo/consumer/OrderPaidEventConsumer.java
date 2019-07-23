package cn.ljlin233.rocketmqdemo.consumer;

import org.apache.rocketmq.spring.starter.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.starter.core.RocketMQListener;
import org.springframework.stereotype.Service;

import cn.ljlin233.rocketmqdemo.dto.OrderPaidEvent;
import lombok.extern.slf4j.Slf4j;

/**
 * @author lvjinlin@yunrong.cn
 * @version V2.1
 * @date 2019/7/23 9:34
 * @since 2.1.0
 */
@Slf4j
@Service
@RocketMQMessageListener(topic = "order-paid-topic", consumerGroup = "order-paid-consumer")
public class OrderPaidEventConsumer implements RocketMQListener<OrderPaidEvent> {

    @Override
    public void onMessage(OrderPaidEvent orderPaidEvent) {
        log.info("------- OrderPaidEventConsumer received: {}", orderPaidEvent);
    }
}
