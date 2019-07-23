package cn.ljlin233.rocketmqdemo.consumer;

import org.apache.rocketmq.spring.starter.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.starter.core.RocketMQListener;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

/**
 * @author lvjinlin@yunrong.cn
 * @version V2.1
 * @date 2019/7/23 9:33
 * @since 2.1.0
 */
@Slf4j
@Service
@RocketMQMessageListener(topic = "string-topic", consumerGroup = "string_consumer")
public class StringConsumer implements RocketMQListener<String> {

    @Override
    public void onMessage(String message) {
        log.info("------- StringConsumer received: {}", message);
    }
}
