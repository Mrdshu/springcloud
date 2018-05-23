package test.wsz.springcloud.rabbitmq;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

;import java.util.Date;

/**
 * 〈〉
 *
 * @author shuzheng_wang
 * @create 2018/5/23
 */
@Component
public class Sender {
    @Autowired
    private AmqpTemplate rabbitTemplate;

    public void send(){
        String context = "hello "+ new Date();
        System.out.println("Sender :" + context);

        rabbitTemplate.convertAndSend("hello", context);
    }
}
