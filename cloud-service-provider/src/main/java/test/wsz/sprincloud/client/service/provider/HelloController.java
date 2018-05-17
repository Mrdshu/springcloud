package test.wsz.sprincloud.client.service.provider;

import com.netflix.appinfo.EurekaInstanceConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

;

/**
 * 〈〉
 *
 * @author shuzheng_wang
 * @create 2018/4/24
 */
@RestController
public class HelloController {
    protected Logger logger = LoggerFactory.getLogger(HelloController.class);

    @Autowired
    private EurekaInstanceConfig eurekaInstanceConfig;


    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String hello() {
        logger.info("hello, host:{}, service_id:{}", eurekaInstanceConfig.getHostName(false), eurekaInstanceConfig.getInstanceId());

        return "hello, spring-cloud:"+eurekaInstanceConfig.getInstanceId();
    }

    @RequestMapping(value = "/hello4", method = RequestMethod.GET)
    public String hello2(String name) {

        return "hello, "+name+ ",spring-cloud:"+eurekaInstanceConfig.getInstanceId();
    }
}
