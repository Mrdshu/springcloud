package test.wsz.springcloud.rabbitmq;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

;

/**
 * 〈spring-cloud-application〉
 *
 * @author shuzheng_wang
 * @create 2018/4/23
 */
@SpringBootApplication
public class RabbitApplication {

    public static void main(String[] args) {
        new SpringApplicationBuilder(RabbitApplication.class).run(args);
    }
}
