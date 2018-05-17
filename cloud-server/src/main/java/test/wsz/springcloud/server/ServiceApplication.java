package test.wsz.springcloud.server;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

;

/**
 * 〈spring-cloud-application〉
 *
 * @author shuzheng_wang
 * @create 2018/4/23
 */
@EnableEurekaServer
@SpringBootApplication
public class ServiceApplication {

    public static void main(String[] args) {
        new SpringApplicationBuilder(ServiceApplication.class).web(true).run(args);
    }
}
