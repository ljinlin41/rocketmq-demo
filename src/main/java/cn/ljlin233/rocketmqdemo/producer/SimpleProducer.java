package cn.ljlin233.rocketmqdemo.producer;

import java.math.BigDecimal;

import org.apache.rocketmq.spring.starter.core.RocketMQTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.ljlin233.rocketmqdemo.dto.OrderPaidEvent;

/**
 * @author lvjinlin@yunrong.cn
 * @version V2.1
 * @date 2019/7/23 9:50
 * @since 2.1.0
 */
@RestController
public class SimpleProducer {

    @Autowired
    private RocketMQTemplate rocketMQTemplate;

    @GetMapping("/produce")
    public String produceMessage() {
        System.out.println("<========  生产者启动  ==========>");
        // send string
        rocketMQTemplate.convertAndSend("string-topic", "Hello, World!");

        // send string with spring Message
        rocketMQTemplate.send("string-topic", MessageBuilder.withPayload("Hello, World! I'm from spring message").build());

        // send user-defined object
        rocketMQTemplate.convertAndSend("order-paid-topic", new OrderPaidEvent("T_001", new BigDecimal("88.00")));

        // send message with special tag
        rocketMQTemplate.convertAndSend("message-ext-topic:tag0", "I'm from tag0"); //not be consume
        rocketMQTemplate.convertAndSend("message-ext-topic:tag1", "I'm from tag1");

        return "create a message";
    }

}
