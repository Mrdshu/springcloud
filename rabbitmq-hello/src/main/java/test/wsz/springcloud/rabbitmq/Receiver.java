package test.wsz.springcloud.rabbitmq;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

;

/**
 * 〈〉
 *
 * @author shuzheng_wang
 * @create 2018/5/23
 */
@Component
@RabbitListener(queues="hello")
public class Receiver {

    @RabbitHandler
    public void process(String hello){
        System.out.println("Receiver: "+ hello);
    }
}
