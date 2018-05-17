package test.wsz.sprincloud.client.service.provider;

import com.netflix.appinfo.EurekaInstanceConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;
import test.wsz.springcloud.service.api.HelloService;

;

/**
 * 〈〉
 *
 * @author shuzheng_wang
 * @create 2018/5/13
 */
@RestController
public class RefactorHelloController implements HelloService {
    @Autowired
    private EurekaInstanceConfig eurekaInstanceConfig;

    @Override
    public String hello3() {
        return "hello, spring-cloud:"+eurekaInstanceConfig.getInstanceId();
    }

    @Override
    public String hello4(@RequestHeader("name") String name) {
        return "hello, "+name+ ",spring-cloud:"+eurekaInstanceConfig.getInstanceId();
    }
}
