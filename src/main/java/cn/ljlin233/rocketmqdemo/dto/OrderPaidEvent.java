package cn.ljlin233.rocketmqdemo.dto;

import java.io.Serializable;
import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author lvjinlin@yunrong.cn
 * @version V2.1
 * @date 2019/7/23 9:11
 * @since 2.1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderPaidEvent implements Serializable {

    private String orderId;

    private BigDecimal paidMoney;
}
